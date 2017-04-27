package dk.dtu.compute.mbse.yawl.functions;

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
			ArcType a = (ArcType) arc;
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
			PlaceType p = (PlaceType) pla;
			if(p != null && p.getText() != null){
				return p.getText();
			}
		}
		return PType.NORMAL;
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
