package application;

import java.util.Collection;

import org.pnml.tools.epnk.annotations.netannotations.NetAnnotation;
import org.pnml.tools.epnk.applications.ApplicationWithUIManager;
import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.pnmlcoremodel.Arc;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;
import org.pnml.tools.epnk.pnmlcoremodel.Transition;

import marking.NetMarking;

public class YAWLSimulator extends ApplicationWithUIManager{

	public YAWLSimulator(PetriNet petrinet) {
		super(petrinet);
	}
	
	public void initializeContents(){
		//TODO Creates the initial annotations of the net on which the application is started.
	}
	
	public NetAnnotation computeAnnotation(NetMarking nm){
		//TODO
		return null;
	}
	
	public NetMarking computeInitialMarking(){
		//TODO
		return null;
	}
	
	public NetMarking computeMarking(){
		//TODO
		return null;
	}
	
	public boolean enabled(FlatAccess fa, NetMarking nm, Transition t){
		//TODO
		return false;
	}
	
	public NetMarking fireTransition(FlatAccess fa, NetMarking n1, Arc selectedInArc, Transition t, Collection<Arc> selectedOutArcs){
		//TODO
		return null;
	}
	
	public FlatAccess getFlatAccess(){
		//TODO
		return null;
	}
	
	public boolean isSavable(){
		//TODO
		return false;
	}
	
	public void shutDown(){
		//TODO
	}
	
}
