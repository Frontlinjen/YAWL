/**
 */
package yawlannotations.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import yawlannotations.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class YawlannotationsFactoryImpl extends EFactoryImpl implements YawlannotationsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static YawlannotationsFactory init() {
		try {
			YawlannotationsFactory theYawlannotationsFactory = (YawlannotationsFactory)EPackage.Registry.INSTANCE.getEFactory(YawlannotationsPackage.eNS_URI);
			if (theYawlannotationsFactory != null) {
				return theYawlannotationsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new YawlannotationsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YawlannotationsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case YawlannotationsPackage.ENABLED_TRANSITION: return createEnabledTransition();
			case YawlannotationsPackage.SELECTED_ARC: return createSelectedArc();
			case YawlannotationsPackage.MARKING: return createMarking();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnabledTransition createEnabledTransition() {
		EnabledTransitionImpl enabledTransition = new EnabledTransitionImpl();
		return enabledTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectedArc createSelectedArc() {
		SelectedArcImpl selectedArc = new SelectedArcImpl();
		return selectedArc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Marking createMarking() {
		MarkingImpl marking = new MarkingImpl();
		return marking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YawlannotationsPackage getYawlannotationsPackage() {
		return (YawlannotationsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static YawlannotationsPackage getPackage() {
		return YawlannotationsPackage.eINSTANCE;
	}

} //YawlannotationsFactoryImpl
