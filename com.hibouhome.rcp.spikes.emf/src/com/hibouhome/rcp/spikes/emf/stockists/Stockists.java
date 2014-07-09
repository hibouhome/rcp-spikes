/**
 */
package com.hibouhome.rcp.spikes.emf.stockists;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stockists</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.hibouhome.rcp.spikes.emf.stockists.Stockists#getCountries <em>Countries</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.hibouhome.rcp.spikes.emf.stockists.StockistsPackage#getStockists()
 * @model
 * @generated
 */
public interface Stockists extends EObject {
	/**
	 * Returns the value of the '<em><b>Countries</b></em>' reference list.
	 * The list contents are of type {@link com.hibouhome.rcp.spikes.emf.stockists.Country}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Countries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Countries</em>' reference list.
	 * @see com.hibouhome.rcp.spikes.emf.stockists.StockistsPackage#getStockists_Countries()
	 * @model
	 * @generated
	 */
	EList<Country> getCountries();

} // Stockists
