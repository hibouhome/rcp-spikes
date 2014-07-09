/**
 */
package com.hibouhome.rcp.spikes.emf.stockists;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.hibouhome.rcp.spikes.emf.stockists.StockistsFactory
 * @model kind="package"
 * @generated
 */
public interface StockistsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "stockists";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.hibouhome.com/spikes/stockists";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "s";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StockistsPackage eINSTANCE = com.hibouhome.rcp.spikes.emf.stockists.impl.StockistsPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.hibouhome.rcp.spikes.emf.stockists.impl.CountryImpl <em>Country</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.CountryImpl
	 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.StockistsPackageImpl#getCountry()
	 * @generated
	 */
	int COUNTRY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Regions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY__REGIONS = 1;

	/**
	 * The number of structural features of the '<em>Country</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Country</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.hibouhome.rcp.spikes.emf.stockists.impl.RegionImpl <em>Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.RegionImpl
	 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.StockistsPackageImpl#getRegion()
	 * @generated
	 */
	int REGION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Stockists</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__STOCKISTS = 1;

	/**
	 * The number of structural features of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.hibouhome.rcp.spikes.emf.stockists.impl.StockistImpl <em>Stockist</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.StockistImpl
	 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.StockistsPackageImpl#getStockist()
	 * @generated
	 */
	int STOCKIST = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCKIST__NAME = 0;

	/**
	 * The number of structural features of the '<em>Stockist</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCKIST_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Stockist</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCKIST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.hibouhome.rcp.spikes.emf.stockists.impl.StockistsImpl <em>Stockists</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.StockistsImpl
	 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.StockistsPackageImpl#getStockists()
	 * @generated
	 */
	int STOCKISTS = 3;

	/**
	 * The feature id for the '<em><b>Countries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCKISTS__COUNTRIES = 0;

	/**
	 * The number of structural features of the '<em>Stockists</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCKISTS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Stockists</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOCKISTS_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link com.hibouhome.rcp.spikes.emf.stockists.Country <em>Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Country</em>'.
	 * @see com.hibouhome.rcp.spikes.emf.stockists.Country
	 * @generated
	 */
	EClass getCountry();

	/**
	 * Returns the meta object for the attribute '{@link com.hibouhome.rcp.spikes.emf.stockists.Country#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.hibouhome.rcp.spikes.emf.stockists.Country#getName()
	 * @see #getCountry()
	 * @generated
	 */
	EAttribute getCountry_Name();

	/**
	 * Returns the meta object for the reference list '{@link com.hibouhome.rcp.spikes.emf.stockists.Country#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Regions</em>'.
	 * @see com.hibouhome.rcp.spikes.emf.stockists.Country#getRegions()
	 * @see #getCountry()
	 * @generated
	 */
	EReference getCountry_Regions();

	/**
	 * Returns the meta object for class '{@link com.hibouhome.rcp.spikes.emf.stockists.Region <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Region</em>'.
	 * @see com.hibouhome.rcp.spikes.emf.stockists.Region
	 * @generated
	 */
	EClass getRegion();

	/**
	 * Returns the meta object for the attribute '{@link com.hibouhome.rcp.spikes.emf.stockists.Region#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.hibouhome.rcp.spikes.emf.stockists.Region#getName()
	 * @see #getRegion()
	 * @generated
	 */
	EAttribute getRegion_Name();

	/**
	 * Returns the meta object for the reference list '{@link com.hibouhome.rcp.spikes.emf.stockists.Region#getStockists <em>Stockists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stockists</em>'.
	 * @see com.hibouhome.rcp.spikes.emf.stockists.Region#getStockists()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_Stockists();

	/**
	 * Returns the meta object for class '{@link com.hibouhome.rcp.spikes.emf.stockists.Stockist <em>Stockist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stockist</em>'.
	 * @see com.hibouhome.rcp.spikes.emf.stockists.Stockist
	 * @generated
	 */
	EClass getStockist();

	/**
	 * Returns the meta object for the attribute '{@link com.hibouhome.rcp.spikes.emf.stockists.Stockist#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.hibouhome.rcp.spikes.emf.stockists.Stockist#getName()
	 * @see #getStockist()
	 * @generated
	 */
	EAttribute getStockist_Name();

	/**
	 * Returns the meta object for class '{@link com.hibouhome.rcp.spikes.emf.stockists.Stockists <em>Stockists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stockists</em>'.
	 * @see com.hibouhome.rcp.spikes.emf.stockists.Stockists
	 * @generated
	 */
	EClass getStockists();

	/**
	 * Returns the meta object for the reference list '{@link com.hibouhome.rcp.spikes.emf.stockists.Stockists#getCountries <em>Countries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Countries</em>'.
	 * @see com.hibouhome.rcp.spikes.emf.stockists.Stockists#getCountries()
	 * @see #getStockists()
	 * @generated
	 */
	EReference getStockists_Countries();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StockistsFactory getStockistsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.hibouhome.rcp.spikes.emf.stockists.impl.CountryImpl <em>Country</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.CountryImpl
		 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.StockistsPackageImpl#getCountry()
		 * @generated
		 */
		EClass COUNTRY = eINSTANCE.getCountry();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COUNTRY__NAME = eINSTANCE.getCountry_Name();

		/**
		 * The meta object literal for the '<em><b>Regions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNTRY__REGIONS = eINSTANCE.getCountry_Regions();

		/**
		 * The meta object literal for the '{@link com.hibouhome.rcp.spikes.emf.stockists.impl.RegionImpl <em>Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.RegionImpl
		 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.StockistsPackageImpl#getRegion()
		 * @generated
		 */
		EClass REGION = eINSTANCE.getRegion();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGION__NAME = eINSTANCE.getRegion_Name();

		/**
		 * The meta object literal for the '<em><b>Stockists</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__STOCKISTS = eINSTANCE.getRegion_Stockists();

		/**
		 * The meta object literal for the '{@link com.hibouhome.rcp.spikes.emf.stockists.impl.StockistImpl <em>Stockist</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.StockistImpl
		 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.StockistsPackageImpl#getStockist()
		 * @generated
		 */
		EClass STOCKIST = eINSTANCE.getStockist();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOCKIST__NAME = eINSTANCE.getStockist_Name();

		/**
		 * The meta object literal for the '{@link com.hibouhome.rcp.spikes.emf.stockists.impl.StockistsImpl <em>Stockists</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.StockistsImpl
		 * @see com.hibouhome.rcp.spikes.emf.stockists.impl.StockistsPackageImpl#getStockists()
		 * @generated
		 */
		EClass STOCKISTS = eINSTANCE.getStockists();

		/**
		 * The meta object literal for the '<em><b>Countries</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STOCKISTS__COUNTRIES = eINSTANCE.getStockists_Countries();

	}

} //StockistsPackage
