package com.hibouhome.rcp.spikes.dnd;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;

/**
 * 
 * @author Jonathan Wright
 *
 */
public class DropListener extends DropTargetAdapter {

	private final LocalStructuredSelectionTransfer transfer = LocalStructuredSelectionTransfer.getTransfer();
	private final ListViewer viewer;
	private final List<String> modelData;

	public DropListener(final ListViewer viewer, final List<String> modelData) {
		this.viewer = viewer;
		this.modelData = modelData;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void drop(final DropTargetEvent evt) {
		if (transfer.isSupportedType(evt.currentDataType)) {
			final IStructuredSelection selection = transfer.getSelection();
			final int itemIndex = getItemIndex(evt);
			if (isDragAndDropWithinSameList(evt)) {
				// we're moving elements within the same list so we have to remove them here before
				// adding them back them to the model
				modelData.removeAll(selection.toList());
				// set the operation performed to 'none' so the drag listener doesn't attempt to
				// remove the elements from the source list
				evt.detail = DND.DROP_NONE;
			} else {
				// set the operation performed to 'move' as we're moving elements from a different
				// list
				evt.detail = DND.DROP_MOVE;
			}
			modelData.addAll(itemIndex, selection.toList());
			viewer.setInput(modelData);
		}
	}

	private boolean isDragAndDropWithinSameList(final DropTargetEvent evt) {
		final Control sourceControl = transfer.getDragSource().getControl();
		final Control targetControl = ((DropTarget) evt.getSource()).getControl();
		return targetControl.equals(sourceControl);
	}

	private int getItemIndex(final DropTargetEvent evt) {
		final org.eclipse.swt.widgets.List list = viewer.getList();
		final Point point = list.toControl(evt.x, evt.y);
		final int itemHeight = list.getItemHeight();
		final int itemIndex = (int) Math.floor((double) point.y / itemHeight);
		if (itemIndex > list.getItemCount()) {
			return list.getItemCount();
		}
		return itemIndex;
	}
}
