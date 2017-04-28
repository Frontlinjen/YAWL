package dk.dtu.compute.mbse.yawl.functions;

import java.util.HashSet;
import java.util.Set;

import org.pnml.tools.epnk.pnmlcoremodel.Node;
import org.pnml.tools.epnk.pnmlcoremodel.PlaceNode;
import org.pnml.tools.epnk.pnmlcoremodel.RefPlace;
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
	
	
	public static PType getType(Place pla){
		if(pla instanceof Place){
			pla = (Place) pla;
			PlaceType p = pla.getPlaceType();
			if(p != null && p.getText() != null){
				return p.getText();
			}
		}
		return PType.NORMAL;
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
	
	public static Node resolve(Node node){
		if(node instanceof TransitionNode){
			return resolve((TransitionNode) node);
		}
		else if(node instanceof PlaceNode) {
			return resolve((PlaceNode) node);
		}
		return null;
	}
	
	public static TType getJoinType(Transition tra){
		if(tra instanceof Transition){
			tra = (Transition) tra;
			TransitionType t = (TransitionType) tra;
			if(t != null && t.getText() != null){
				return t.getText();
			}
		}
		return TType.OR;
	}
	
	public static TType getSplitType(Transition tra){
		if(tra instanceof Transition){
			tra = (Transition) tra;
			TransitionType t = (TransitionType) tra;
			if(t != null && t.getText() != null){
				return t.getText();
			}
		}
		return TType.OR;
	}
	
	
	
}
