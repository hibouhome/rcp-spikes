package com.hibouhome.rcp.spikes.databinding.parts;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class NameDialog extends Dialog {

	private Text nameField;
	private String name;

	protected NameDialog(final Shell parentShell, final String name) {
		super(parentShell);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	protected void configureShell(final Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Edit name");
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite container = (Composite) super.createDialogArea(parent);
		nameField = new Text(container, SWT.BORDER);
		nameField.setText(name);
		final GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		return container;
	}

	@Override
	protected void okPressed() {
		name = nameField.getText().trim();
		super.okPressed();
	}
}
