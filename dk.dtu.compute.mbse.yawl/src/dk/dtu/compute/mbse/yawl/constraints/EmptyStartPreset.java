package dk.dtu.compute.mbse.yawl.constraints;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;

import dk.dtu.compute.mbse.yawl.PType;
import dk.dtu.compute.mbse.yawl.Place;
import dk.dtu.compute.mbse.yawl.YAWLNet;
import dk.dtu.compute.mbse.yawl.functions.YAWLFunctions;

public class EmptyStartPreset extends AbstractModelConstraint{

	@Override
	public IStatus validate(IValidationContext ctx) {
			EObject object = ctx.getTarget();
			if(object instanceof YAWLNet) {
				EObject container = object.eContainer();
				if(container instanceof PetriNet) {
					Iterator<EObject> iterator = container.eAllContents();
					while (iterator.hasNext()) {
						EObject content = iterator.next();
						if(content instanceof Place){
							Place place = (Place) content;
							PType type = YAWLFunctions.getType((dk.dtu.compute.mbse.yawl.Place)place);
							if(type.equals(PType.START)){
								if(place.getIn() != null){
									return ctx.createFailureStatus(new Object[] {container});
								}
							}
						}
					}
				}
			}
			return ctx.createSuccessStatus();
	}
	
	
	
}
