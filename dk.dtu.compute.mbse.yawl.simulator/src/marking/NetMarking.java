package marking;

import java.util.HashMap;
import java.util.Map;

import org.pnml.tools.epnk.pnmlcoremodel.Place;

public class NetMarking {
	
	private Map<Place, Integer> marking;
	
	public NetMarking(){
		marking = new HashMap<Place,Integer>();
	}
	
}
