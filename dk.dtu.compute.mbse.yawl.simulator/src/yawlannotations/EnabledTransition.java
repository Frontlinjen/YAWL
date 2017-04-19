/**
 */
package yawlannotations;

import org.eclipse.emf.common.util.EList;

import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;

import org.pnml.tools.epnk.pnmlcoremodel.Transition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enabled Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link yawlannotations.EnabledTransition#getResolved <em>Resolved</em>}</li>
 *   <li>{@link yawlannotations.EnabledTransition#getOutArcs <em>Out Arcs</em>}</li>
 *   <li>{@link yawlannotations.EnabledTransition#getInArcs <em>In Arcs</em>}</li>
 * </ul>
 *
 * @see yawlannotations.YawlannotationsPackage#getEnabledTransition()
 * @model extendedMetaData="name='ObjectAnnotation'"
 * @generated
 */
public interface EnabledTransition extends ObjectAnnotation {
	/**
	 * Returns the value of the '<em><b>Resolved</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved</em>' reference.
	 * @see #setResolved(EnabledTransition)
	 * @see yawlannotations.YawlannotationsPackage#getEnabledTransition_Resolved()
	 * @model
	 * @generated
	 */
	EnabledTransition getResolved();

	/**
	 * Sets the value of the '{@link yawlannotations.EnabledTransition#getResolved <em>Resolved</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved</em>' reference.
	 * @see #getResolved()
	 * @generated
	 */
	void setResolved(EnabledTransition value);

	/**
	 * Returns the value of the '<em><b>Out Arcs</b></em>' reference list.
	 * The list contents are of type {@link yawlannotations.SelectedArc}.
	 * It is bidirectional and its opposite is '{@link yawlannotations.SelectedArc#getSourceTransition <em>Source Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Arcs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Arcs</em>' reference list.
	 * @see yawlannotations.YawlannotationsPackage#getEnabledTransition_OutArcs()
	 * @see yawlannotations.SelectedArc#getSourceTransition
	 * @model opposite="sourceTransition"
	 * @generated
	 */
	EList<SelectedArc> getOutArcs();

	/**
	 * Returns the value of the '<em><b>In Arcs</b></em>' reference list.
	 * The list contents are of type {@link yawlannotations.SelectedArc}.
	 * It is bidirectional and its opposite is '{@link yawlannotations.SelectedArc#getTargetTransition <em>Target Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Arcs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Arcs</em>' reference list.
	 * @see yawlannotations.YawlannotationsPackage#getEnabledTransition_InArcs()
	 * @see yawlannotations.SelectedArc#getTargetTransition
	 * @model opposite="targetTransition"
	 * @generated
	 */
	EList<SelectedArc> getInArcs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Transition getTransition();

} // EnabledTransition
