package com.hibouhome.rcp.spikes.visiblewhen.handlers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;

public class PerspectivePropertyTester extends PropertyTester {

	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		final MPerspective perspective = (MPerspective) receiver;
		return perspective.getElementId().equals(expectedValue);
	}
}
