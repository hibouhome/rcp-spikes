package com.hibouhome.rcp.spikes.visiblewhen.parts;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public abstract class LabelPart {

	private final String text;

	protected LabelPart(final String text) {
		this.text = text;
	}

	@PostConstruct
	public void createComposite(final Composite parent) {

		final Label lblNewLabel = new Label(parent, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 42, SWT.NORMAL));
		lblNewLabel.setText(text);
	}
}
