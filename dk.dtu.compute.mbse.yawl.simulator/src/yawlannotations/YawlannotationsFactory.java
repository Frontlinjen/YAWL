/**
 */
package yawlannotations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see yawlannotations.YawlannotationsPackage
 * @generated
 */
public interface YawlannotationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	YawlannotationsFactory eINSTANCE = yawlannotations.impl.YawlannotationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Enabled Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enabled Transition</em>'.
	 * @generated
	 */
	EnabledTransition createEnabledTransition();

	/**
	 * Returns a new object of class '<em>Selected Arc</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Selected Arc</em>'.
	 * @generated
	 */
	SelectedArc createSelectedArc();

	/**
	 * Returns a new object of class '<em>Marking</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Marking</em>'.
	 * @generated
	 */
	Marking createMarking();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	YawlannotationsPackage getYawlannotationsPackage();

} //YawlannotationsFactory
