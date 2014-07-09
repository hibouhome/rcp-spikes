/*******************************************************************************
 * Copyright (c) 2010 - 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Lars Vogel <lars.Vogel@gmail.com> - Bug 419770
 *******************************************************************************/
package com.hibouhome.rcp.spikes.databinding.parts;

import javax.annotation.PostConstruct;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.hibouhome.rcp.spikes.emf.stockists.Country;
import com.hibouhome.rcp.spikes.emf.stockists.Region;
import com.hibouhome.rcp.spikes.emf.stockists.Stockist;
import com.hibouhome.rcp.spikes.emf.stockists.Stockists;
import com.hibouhome.rcp.spikes.emf.stockists.StockistsPackage;
import com.hibouhome.rcp.spikes.emf.stockists.util.StockistsAdapterFactory;

public class StockistsPart {

	private final Stockists stockists;
	private final EditingDomain editingDomain;

	private ListViewer countriesListViewer;
	private ListViewer regionsListViewer;
	private ListViewer stockistsListViewer;

	public StockistsPart() {
		stockists = StockistsBuilder.build();
		editingDomain = new AdapterFactoryEditingDomain(new StockistsAdapterFactory(), new BasicCommandStack());
	}

	@PostConstruct
	public void createComposite(final Composite parent) {
		parent.setLayout(new GridLayout(3, false));
		// initialise list viewers
		createCountriesListViewer(parent);
		createRegionsListViewer(parent);
		createStockistsListViewer(parent);
		// add selection listeners
		addCountrySelectionListener();
		addRegionSelectionListener();
		// add mouse listeners
		addCountriesMouseListener(parent);
		addRegionsMouseListener(parent);
		addStockistsMouseListener(parent);
	}

	private void createCountriesListViewer(final Composite parent) {
		countriesListViewer = new ListViewer(parent);
		countriesListViewer.getList().setLayoutData(new GridData(60, 300));
		countriesListViewer.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(final Object element) {
				return ((Country) element).getName();
			}
		});
		countriesListViewer.setContentProvider(new ObservableListContentProvider());
		final IEMFListProperty countriesProperty = EMFProperties.list(StockistsPackage.Literals.STOCKISTS__COUNTRIES);
		countriesListViewer.setInput(countriesProperty.observe(stockists));
	}

	private void createRegionsListViewer(final Composite parent) {
		regionsListViewer = new ListViewer(parent);
		regionsListViewer.getList().setLayoutData(new GridData(120, 300));
		regionsListViewer.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(final Object element) {
				return ((Region) element).getName();
			}
		});
		regionsListViewer.setContentProvider(new ObservableListContentProvider());
	}

	private void createStockistsListViewer(final Composite parent) {
		stockistsListViewer = new ListViewer(parent);
		stockistsListViewer.getList().setLayoutData(new GridData(180, 300));
		stockistsListViewer.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(final Object element) {
				return ((Stockist) element).getName();
			}
		});
		stockistsListViewer.setContentProvider(new ObservableListContentProvider());
	}

	private void addCountrySelectionListener() {
		final IObservableValue selectedCountry = ViewerProperties.singleSelection().observe(countriesListViewer);
		selectedCountry.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(final ValueChangeEvent evt) {
				final Country country = (Country) evt.diff.getNewValue();
				final IEMFListProperty regionsProperty = EMFProperties.list(StockistsPackage.Literals.COUNTRY__REGIONS);
				final IObservableList regionsObservableList = regionsProperty.observe(country);
				regionsListViewer.setInput(regionsObservableList);
				stockistsListViewer.setInput(null);
			}
		});
	}

	private void addRegionSelectionListener() {
		final IObservableValue selectedRegion = ViewerProperties.singleSelection().observe(regionsListViewer);
		selectedRegion.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(final ValueChangeEvent evt) {
				final Region region = (Region) evt.diff.getNewValue();
				final IEMFListProperty stockistsProperty = EMFProperties
						.list(StockistsPackage.Literals.REGION__STOCKISTS);
				stockistsListViewer.setInput(stockistsProperty.observe(region));
			}
		});
	}

	private void addCountriesMouseListener(final Composite parent) {
		countriesListViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(final DoubleClickEvent evt) {
				final IStructuredSelection selection = (IStructuredSelection) countriesListViewer.getSelection();
				final Country country = (Country) selection.getFirstElement();
				final NameDialog dialog = new NameDialog(parent.getShell(), country.getName());
				if (dialog.open() == Window.OK) {
					setName(country, dialog.getName());
				}
			}
		});
	}

	private void addRegionsMouseListener(final Composite parent) {
		regionsListViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(final DoubleClickEvent evt) {
				final IStructuredSelection selection = (IStructuredSelection) regionsListViewer.getSelection();
				final Region region = (Region) selection.getFirstElement();
				final NameDialog dialog = new NameDialog(parent.getShell(), region.getName());
				if (dialog.open() == Window.OK) {
					setName(region, dialog.getName());
				}
			}
		});
	}

	private void addStockistsMouseListener(final Composite parent) {
		stockistsListViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(final DoubleClickEvent evt) {
				final IStructuredSelection selection = (IStructuredSelection) stockistsListViewer.getSelection();
				final Stockist stockist = (Stockist) selection.getFirstElement();
				final NameDialog dialog = new NameDialog(parent.getShell(), stockist.getName());
				if (dialog.open() == Window.OK) {
					setName(stockist, dialog.getName());
				}
			}
		});
	}

	private void setName(final Country country, final String name) {
		final Command command = SetCommand.create(editingDomain, country, StockistsPackage.eINSTANCE.getCountry_Name(),
				name);
		editingDomain.getCommandStack().execute(command);
		countriesListViewer.refresh();
	}

	private void setName(final Region region, final String name) {
		final Command command = SetCommand.create(editingDomain, region, StockistsPackage.eINSTANCE.getRegion_Name(),
				name);
		editingDomain.getCommandStack().execute(command);
		regionsListViewer.refresh();
	}

	private void setName(final Stockist stockist, final String name) {
		final Command command = SetCommand.create(editingDomain, stockist,
				StockistsPackage.eINSTANCE.getStockist_Name(), name);
		editingDomain.getCommandStack().execute(command);
		stockistsListViewer.refresh();
	}
}