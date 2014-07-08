package com.hibouhome.rcp.spikes.dnd;

import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * UI
 * 
 * @author Jonathan Wright
 *
 */
public class ListPart {

	private final Transfer[] transferTypes;

	public ListPart() {
		transferTypes = new Transfer[] { LocalStructuredSelectionTransfer.getTransfer() };
	}

	@PostConstruct
	public void createComposite(final Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		final Model model = new Model(10);
		addList(parent, model.getFirstListElements());
		addList(parent, model.getSecondListElements());
	}

	private void addList(final Composite parent, final List<String> modelData) {
		final ListViewer viewer = new ListViewer(parent, SWT.SINGLE);
		viewer.getList().setLayoutData(new GridData(100, 400));
		viewer.setContentProvider(ArrayContentProvider.getInstance());
		viewer.setInput(modelData.toArray());
		viewer.addDragSupport(DND.DROP_MOVE, transferTypes, new DragListener(viewer, modelData));
		viewer.addDropSupport(DND.DROP_MOVE, transferTypes, new DropListener(viewer, modelData));
	}
}
