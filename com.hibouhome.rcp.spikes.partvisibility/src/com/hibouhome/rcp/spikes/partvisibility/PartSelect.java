package com.hibouhome.rcp.spikes.partvisibility;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public class PartSelect {

	@Inject
	private EPartService partService;
	@Inject
	private EModelService modelService;
	@Inject
	private MApplication application;

	@PostConstruct
	public void createComposite(final Composite parent) {
		final Combo select = new Combo(parent, SWT.SINGLE);
		final String[] items = { "1", "2", "3" };
		select.setItems(items);
		select.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(final SelectionEvent evt) {
				final String id = "simplepart." + select.getSelectionIndex();
				showPart(id);
			}
		});
	}

	private void showPart(final String id) {
		final MPartStack partstack = (MPartStack) modelService.find("simplepartstack", application);
		final MPart part = partService.showPart(id, PartState.ACTIVATE);
		part.setVisible(true);
		partstack.setSelectedElement(part);
	}
}
