/**
 */
package dk.dtu.compute.mbse.yawl.impl;

import dk.dtu.compute.mbse.yawl.YAWLNet;
import dk.dtu.compute.mbse.yawl.YawlPackage;

import org.eclipse.emf.ecore.EClass;

import org.pnml.tools.epnk.pnmlcoremodel.impl.PetriNetTypeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>YAWL Net</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class YAWLNetImpl extends PetriNetTypeImpl implements YAWLNet {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @author Mikkel & Thomas
	 */
	public YAWLNetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YawlPackage.Literals.YAWL_NET;
	}
	/**
	 * @generated NOT
	 * @author s153073@student.dtu.dk & s154174@student.dtu.dk
	 */
	@Override
	public String toString() {
		return "http://se.compute.dtu.dk/mbse/yawl";
	}

} //YAWLNetImpl
