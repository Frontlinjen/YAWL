/**
 */
package dk.dtu.compute.mbse.yawl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dk.dtu.compute.mbse.yawl.Arc#getArcType <em>Arc Type</em>}</li>
 * </ul>
 *
 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getArc()
 * @model
 * @generated
 */
public interface Arc extends org.pnml.tools.epnk.pnmlcoremodel.Arc {
	/**
	 * Returns the value of the '<em><b>Arc Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arc Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arc Type</em>' containment reference.
	 * @see #setArcType(ArcType)
	 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getArc_ArcType()
	 * @model containment="true"
	 * @generated
	 */
	ArcType getArcType();

	/**
	 * Sets the value of the '{@link dk.dtu.compute.mbse.yawl.Arc#getArcType <em>Arc Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arc Type</em>' containment reference.
	 * @see #getArcType()
	 * @generated
	 */
	void setArcType(ArcType value);

} // Arc
