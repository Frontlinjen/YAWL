/**
 */
package dk.dtu.compute.mbse.yawl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dk.dtu.compute.mbse.yawl.Place#getPlaceType <em>Place Type</em>}</li>
 * </ul>
 *
 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getPlace()
 * @model
 * @generated
 */
public interface Place extends org.pnml.tools.epnk.pnmlcoremodel.Place {
	/**
	 * Returns the value of the '<em><b>Place Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Place Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Place Type</em>' containment reference.
	 * @see #setPlaceType(PlaceType)
	 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getPlace_PlaceType()
	 * @model containment="true"
	 * @generated
	 */
	PlaceType getPlaceType();

	/**
	 * Sets the value of the '{@link dk.dtu.compute.mbse.yawl.Place#getPlaceType <em>Place Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Place Type</em>' containment reference.
	 * @see #getPlaceType()
	 * @generated
	 */
	void setPlaceType(PlaceType value);

} // Place
