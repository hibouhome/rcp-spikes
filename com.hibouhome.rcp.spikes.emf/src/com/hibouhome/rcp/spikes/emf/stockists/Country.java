/**
 */
package com.hibouhome.rcp.spikes.emf.stockists;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Country</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.hibouhome.rcp.spikes.emf.stockists.Country#getName <em>Name</em>}</li>
 *   <li>{@link com.hibouhome.rcp.spikes.emf.stockists.Country#getRegions <em>Regions</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.hibouhome.rcp.spikes.emf.stockists.StockistsPackage#getCountry()
 * @model
 * @generated
 */
public interface Country extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.hibouhome.rcp.spikes.emf.stockists.StockistsPackage#getCountry_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.hibouhome.rcp.spikes.emf.stockists.Country#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Regions</b></em>' reference list.
	 * The list contents are of type {@link com.hibouhome.rcp.spikes.emf.stockists.Region}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regions</em>' reference list.
	 * @see com.hibouhome.rcp.spikes.emf.stockists.StockistsPackage#getCountry_Regions()
	 * @model
	 * @generated
	 */
	EList<Region> getRegions();

} // Country
