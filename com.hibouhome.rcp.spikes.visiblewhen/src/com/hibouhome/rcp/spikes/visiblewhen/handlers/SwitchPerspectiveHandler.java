package com.hibouhome.rcp.spikes.visiblewhen.handlers;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class SwitchPerspectiveHandler {

	@Inject
	private MApplication application;
	@Inject
	private EModelService modelService;
	@Inject
	private EPartService partService;

	@Execute
	public void execute(@Named("com.hibouhome.parameter.perspectiveId") final String id) {
		final MPerspectiveStack perspectiveStack = (MPerspectiveStack) modelService.find(
				"com.hibouhome.perspectiveStack", application);
		final MPerspective perspective = (MPerspective) modelService.find(id, perspectiveStack);
		partService.switchPerspective(perspective);
	}
}
