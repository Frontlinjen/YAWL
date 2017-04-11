package application;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

public class NetChangeListener implements Adapter{
	
	private YAWLSimulator sim;
	
	public NetChangeListener(YAWLSimulator sim){
		super();
		this.sim = sim;
	}

	@Override
	public void notifyChanged(Notification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Notifier getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAdapterForType(Object type) {
		// TODO Auto-generated method stub
		return false;
	}

}
