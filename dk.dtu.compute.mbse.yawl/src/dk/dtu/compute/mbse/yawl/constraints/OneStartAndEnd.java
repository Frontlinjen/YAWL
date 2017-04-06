package dk.dtu.compute.mbse.yawl.constraints;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;
import org.pnml.tools.epnk.pnmlcoremodel.Place;

import dk.dtu.compute.mbse.yawl.PType;
import dk.dtu.compute.mbse.yawl.YAWLNet;
import dk.dtu.compute.mbse.yawl.functions.YAWLFunctions;

/**
 * This is a constraint saying that there should be only one start place and one end place in a YAWL Net.
 * 
 * @author MikkelLeth
 * @generated NOT
 */

public class OneStartAndEnd extends AbstractModelConstraint{

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject object = ctx.getTarget();
		if(object instanceof YAWLNet) {
			EObject container = object.eContainer();
			if(container instanceof PetriNet) {
				int startCount = 0;
				int endCount = 0;
				Iterator<EObject> iterator = container.eAllContents();
				while (iterator.hasNext()) {
					EObject content = iterator.next();
					if(content instanceof Place) {
						Place place = (Place) content;
						PType type = YAWLFunctions.getType(place);
						if(type.equals(PType.START)) {
							startCount++;
							if(startCount>1){
								break;
							}
						} else if (type.equals(PType.FINISH)) {
							endCount++;
							if (endCount > 1) {
								break;
							}
						}
					}
				}
				if(startCount != 1 || endCount != 1) {
					return ctx.createFailureStatus(new Object[] {container});
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}


