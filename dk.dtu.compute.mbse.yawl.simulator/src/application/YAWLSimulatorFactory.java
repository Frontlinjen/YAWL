package application;

import org.pnml.tools.epnk.applications.ApplicationFactory;
import org.pnml.tools.epnk.applications.ApplicationWithUIManager;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;

public class YAWLSimulatorFactory extends ApplicationFactory{

	public YAWLSimulatorFactory(){
		super();
	}
	
	@Override
	public String getName() {
		return "YAWL Simulator gruppe 9";
	}

	@Override
	public String getDescription() {
		return "A YAWL Simulator made for the exam un the course 'Modelbase Software Engineering'.";
	}

	@Override
	public boolean isApplicable(PetriNet net) {
		// TODO
		return false;
	}

	@Override
	public ApplicationWithUIManager startApplication(PetriNet net) {
		// TODO Auto-generated method stub
		return null;
	}

}
