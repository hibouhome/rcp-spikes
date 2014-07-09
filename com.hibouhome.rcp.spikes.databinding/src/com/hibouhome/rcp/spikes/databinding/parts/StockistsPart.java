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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.hibouhome.rcp.spikes.emf.stockists.Country;
import com.hibouhome.rcp.spikes.emf.stockists.Region;
import com.hibouhome.rcp.spikes.emf.stockists.Stockist;
import com.hibouhome.rcp.spikes.emf.stockists.Stockists;
import com.hibouhome.rcp.spikes.emf.stockists.StockistsPackage;

public class StockistsPart {

	private final Stockists stockists;

	public StockistsPart() {
		stockists = StockistsBuilder.build();
	}

	@PostConstruct
	public void createComposite(final Composite parent) {
		parent.setLayout(new GridLayout(3, false));
		
		// countries
		final ListViewer countriesListViewer = new ListViewer(parent);
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
		
		// regions
		final ListViewer regionsListViewer = new ListViewer(parent);
		regionsListViewer.getList().setLayoutData(new GridData(120, 300));
		regionsListViewer.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(final Object element) {
				return ((Region) element).getName();
			}
		});
		regionsListViewer.setContentProvider(new ObservableListContentProvider());
		
		// stockists
		final ListViewer stockistsListViewer = new ListViewer(parent);
		stockistsListViewer.getList().setLayoutData(new GridData(180, 300));
		stockistsListViewer.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(final Object element) {
				return ((Stockist) element).getName();
			}
		});
		stockistsListViewer.setContentProvider(new ObservableListContentProvider());
		
		// selection listeners
		final IObservableValue selectedCountry = ViewerProperties.singleSelection().observe(countriesListViewer);
		selectedCountry.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(final ValueChangeEvent evt) {
				final Country country = (Country) evt.diff.getNewValue();
				final IEMFListProperty regionsProperty = EMFProperties.list(StockistsPackage.Literals.COUNTRY__REGIONS);
				regionsListViewer.setInput(regionsProperty.observe(country));
				stockistsListViewer.setInput(null);
			}
		});
		final IObservableValue selectedRegion = ViewerProperties.singleSelection().observe(regionsListViewer);
		selectedRegion.addValueChangeListener(new IValueChangeListener() {
			
			@Override
			public void handleValueChange(final ValueChangeEvent evt) {
				final Region region = (Region) evt.diff.getNewValue();
				final IEMFListProperty stockistsProperty = EMFProperties.list(StockistsPackage.Literals.REGION__STOCKISTS);
				stockistsListViewer.setInput(stockistsProperty.observe(region));				
			}
		});
	}
}