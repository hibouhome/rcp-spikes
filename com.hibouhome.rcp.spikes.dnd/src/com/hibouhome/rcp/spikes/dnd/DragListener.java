package com.hibouhome.rcp.spikes.dnd;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;

/**
 * 
 * @author Jonathan Wright
 *
 */
public class DragListener extends DragSourceAdapter {

	private final LocalStructuredSelectionTransfer transfer = LocalStructuredSelectionTransfer.getTransfer();
	private final ListViewer viewer;
	private final List<String> modelData;

	public DragListener(final ListViewer viewer, final List<String> modelData) {
		this.viewer = viewer;
		this.modelData = modelData;
	}

	@Override
	public void dragStart(final DragSourceEvent event) {
		final IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		// only start the drag if at least one element has been selected
		if (selection.isEmpty()) {
			event.doit = false;
		}
	}

	@Override
	public void dragSetData(final DragSourceEvent evt) {
		final IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		transfer.setSelection(selection);
		transfer.setDragSource((DragSource) evt.getSource());
	}

	@Override
	public void dragFinished(final DragSourceEvent evt) {
		if (evt.detail == DND.DROP_MOVE) {
			// the move was successful, remove the selected elements from the model and update the
			// list viewer
			final IStructuredSelection selection = transfer.getSelection();
			modelData.removeAll(selection.toList());
			viewer.setInput(modelData);
		}
	}
}
