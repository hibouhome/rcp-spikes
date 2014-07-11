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
package com.hibouhome.rcp.spikes.partvisibility;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class SimplePart {

	private Text txtInput;

	@PostConstruct
	public void createComposite(final Composite parent) {
		parent.setLayout(new GridLayout(2, false));

		final Label lbl = new Label(parent, SWT.NONE);
		lbl.setText("Hello World!");
		txtInput = new Text(parent, SWT.BORDER);
	}

	@Focus
	public void setFocus() {
		txtInput.setFocus();
	}
}