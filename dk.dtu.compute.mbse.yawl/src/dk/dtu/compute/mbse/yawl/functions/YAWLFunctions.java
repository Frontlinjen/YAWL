package dk.dtu.compute.mbse.yawl.functions;

import java.util.HashSet;
import java.util.Set;

import org.pnml.tools.epnk.pnmlcoremodel.Node;
import org.pnml.tools.epnk.pnmlcoremodel.PlaceNode;
import org.pnml.tools.epnk.pnmlcoremodel.RefPlace;
import org.pnml.tools.epnk.pnmlcoremodel.RefTransition;
import org.pnml.tools.epnk.pnmlcoremodel.TransitionNode;

import dk.dtu.compute.mbse.yawl.AType;
import dk.dtu.compute.mbse.yawl.Arc;
import dk.dtu.compute.mbse.yawl.ArcType;
import dk.dtu.compute.mbse.yawl.PType;
import dk.dtu.compute.mbse.yawl.Place;
import dk.dtu.compute.mbse.yawl.PlaceType;
import dk.dtu.compute.mbse.yawl.TType;
import dk.dtu.compute.mbse.yawl.Transition;
import dk.dtu.compute.mbse.yawl.TransitionType;

/**
 * @author Thomas and Mikkel
 */

public class YAWLFunctions {

	public static AType getType(Arc arc){
		if(arc instanceof Arc){
			arc = (Arc) arc;
			ArcType a = arc.getArcType();
			if(a != null && a.getText() != null){
				return a.getText();
			}
		}
		return AType.NORMAL;
	}
	
	public static boolean isResetArc(Arc arc){
		return getType(arc) == AType.RESET;
	}


	public static Place resolve(PlaceNode place){
		if(place instanceof Place) {
			return (Place) place;
		} else if (place instanceof RefPlace){
			RefPlace refNode = (RefPlace) place;
			Set<RefPlace> visited = new HashSet<RefPlace>();//For circular detection
			while(!visited.contains(refNode)){
				visited.add(refNode);
				PlaceNode reference = refNode.getRef();
				if(reference instanceof RefPlace){
					refNode = (RefPlace) reference;
				}
				else if(reference instanceof Place)
				{
					return (Place)reference;
				}
				else{
					return null;
				}
				
			}
		}
		return null;
	}
	
	public static Transition resolve(TransitionNode trans){
		if(trans instanceof Transition) {
			return (Transition) trans;
		} else if (trans instanceof RefTransition){
			RefTransition refNode = (RefTransition) trans;
			Set<RefTransition> visited = new HashSet<RefTransition>();//For circular detection
			while(!visited.contains(refNode)){
				visited.add(refNode);
				TransitionNode reference = refNode.getRef();
				if(reference instanceof RefTransition){
					refNode = (RefTransition) reference;
					continue;
				}
				else if(reference instanceof Transition)
				{
					return (Transition)reference;
				}
				else{
					return null;
				}
				
			}
		}
		return null;
	}
	public static Node resolve(Node node){
		if(node instanceof TransitionNode){
			return resolve((TransitionNode) node);
		}
		else if(node instanceof PlaceNode) {
			return resolve((PlaceNode) node);
		}
		return null;
	}
	
	
	
	public static PType getType(Place pla){
		if(pla instanceof Place){
			pla = (Place) pla;
			PlaceType p = pla.getType();
			if(p != null && p.getText() != null){
				return p.getText();
			}
		}
		return PType.NORMAL;
	}
	
	public static TType getJoinType(Transition tra){
			TransitionType t = tra.getJoinType();
			if(t != null && t.getText() != null){
				return t.getText();
			}
		return null;
	}
	
	public static TType getSplitType(Transition tra){
			TransitionType t = tra.getSplitType();
			if(t != null && t.getText() != null){
				return t.getText();
			}
		return null;
	}
	
	
	
}
