package application;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.pnml.tools.epnk.helpers.FlatAccess;

public class NetChangeListener implements Adapter{
	
	private YAWLSimulator sim;
	
	public NetChangeListener(YAWLSimulator sim){
		super();
		this.sim = sim;
	}

	@Override
	public void notifyChanged(Notification notification) {
		String name = sim.getName();
		if(name != null){
			name = "Technical simulator: " + name;
		} else{
			name = "Technical simulator";
		}
		
		FlatAccess flatAccess = sim.flatAccess;
		if(flatAccess != null){
			flatAccess.removeInvalidationListener(this);
			sim.flatAccess = null;
		}
		
		final String label = name;
		Display.getDefault().asyncExec(new Runnable() {
			public void run(){
				if (MessageDialog.openConfirm(null, label, 
						"The underlying net has been modified." + System.lineSeparator() +
						"It is unsafe to continue using the application, and it may show wrong results." + System.lineSeparator() +
						"Do you want stop this application (recommended)?")) {
					sim.dispose();
				}
			}
		});
	}

	@Override
	public Notifier getTarget() {
		return null;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return false;
	}

}
