/**
 */
package dk.dtu.compute.mbse.yawl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dk.dtu.compute.mbse.yawl.Transition#getJType <em>JType</em>}</li>
 *   <li>{@link dk.dtu.compute.mbse.yawl.Transition#getSType <em>SType</em>}</li>
 * </ul>
 *
 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends org.pnml.tools.epnk.pnmlcoremodel.Transition {
	/**
	 * Returns the value of the '<em><b>JType</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>JType</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>JType</em>' containment reference.
	 * @see #setJType(TransitionType)
	 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getTransition_JType()
	 * @model containment="true"
	 * @generated
	 */
	TransitionType getJType();

	/**
	 * Sets the value of the '{@link dk.dtu.compute.mbse.yawl.Transition#getJType <em>JType</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>JType</em>' containment reference.
	 * @see #getJType()
	 * @generated
	 */
	void setJType(TransitionType value);

	/**
	 * Returns the value of the '<em><b>SType</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SType</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SType</em>' containment reference.
	 * @see #setSType(TransitionType)
	 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getTransition_SType()
	 * @model containment="true"
	 * @generated
	 */
	TransitionType getSType();

	/**
	 * Sets the value of the '{@link dk.dtu.compute.mbse.yawl.Transition#getSType <em>SType</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SType</em>' containment reference.
	 * @see #getSType()
	 * @generated
	 */
	void setSType(TransitionType value);

} // Transition
