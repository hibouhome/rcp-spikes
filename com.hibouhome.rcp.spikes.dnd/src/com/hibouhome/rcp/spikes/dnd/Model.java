package com.hibouhome.rcp.spikes.dnd;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple model containing two lists of strings
 * 
 * @author Jonathan Wright
 *
 */
public class Model {

	private final List<String> firstListElements;
	private final List<String> secondListElements;

	public Model(final int nElements) {
		firstListElements = new ArrayList<String>(nElements);
		secondListElements = new ArrayList<String>(nElements);
		for (int i = 0; i < nElements; i++) {
			firstListElements.add("Element-" + i);
			secondListElements.add("Element-" + (i + nElements));
		}
	}

	public List<String> getFirstListElements() {
		return firstListElements;
	}

	public List<String> getSecondListElements() {
		return secondListElements;
	}
}
