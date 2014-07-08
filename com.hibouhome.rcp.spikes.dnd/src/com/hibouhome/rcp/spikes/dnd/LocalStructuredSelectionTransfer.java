package com.hibouhome.rcp.spikes.dnd;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.util.Policy;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.TransferData;

/**
 * Transfer for drag and drop operations within the same instance of Eclipse. Unlike
 * {@link LocalSelectionTransfer} this transfer also holds a reference to the {@link DragSource}
 * 
 * @author Jonathan Wright
 *
 */
public class LocalStructuredSelectionTransfer extends ByteArrayTransfer {

	private static final String TYPE_NAME = "local-structured-selection-transfer-format" + System.currentTimeMillis();
	private static final int TYPE_ID = registerType(TYPE_NAME);
	private static final LocalStructuredSelectionTransfer INSTANCE = new LocalStructuredSelectionTransfer();

	private DragSource dragSource;
	private IStructuredSelection selection;

	/**
	 * Private default constructor to enforce singleton pattern
	 */
	private LocalStructuredSelectionTransfer() {
	}

	public static LocalStructuredSelectionTransfer getTransfer() {
		return INSTANCE;
	}

	@Override
	protected void javaToNative(final Object object, final TransferData transferData) {
		final byte[] check = TYPE_NAME.getBytes();
		super.javaToNative(check, transferData);
	}

	@Override
	protected Object nativeToJava(final TransferData transferData) {
		final Object result = super.nativeToJava(transferData);
		if (isInvalidNativeType(result)) {
			Policy.getLog().log(
					new Status(IStatus.ERROR, Policy.JFACE, IStatus.ERROR,
							"LocalStructuredSelectionTransfer: invalid native type", null));
		}
		return result;
	}

	public DragSource getDragSource() {
		return dragSource;
	}

	public void setDragSource(final DragSource dragSource) {
		this.dragSource = dragSource;
	}

	public IStructuredSelection getSelection() {
		return selection;
	}

	public void setSelection(final IStructuredSelection selection) {
		this.selection = selection;
	}

	@Override
	protected int[] getTypeIds() {
		return new int[] { TYPE_ID };
	}

	@Override
	protected String[] getTypeNames() {
		return new String[] { TYPE_NAME };
	}

	/**
	 * @param result the object returned by super.nativeToJava()
	 * @return <code>true</code> if result is a byte array and the string representation of the byte
	 *         array equals <code>TYPE_NAME</code>
	 */
	private boolean isInvalidNativeType(final Object result) {
		return !(result instanceof byte[]) || !TYPE_NAME.equals(new String((byte[]) result));
	}
}
