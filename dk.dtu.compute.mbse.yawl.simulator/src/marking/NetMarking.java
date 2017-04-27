package marking;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.pnml.tools.epnk.pnmlcoremodel.Place;

public class NetMarking {
	
	private Map<Place, Integer> marking;
	
	public NetMarking(){
		marking = new HashMap<Place,Integer>();
	}
	
	public void SetMarking(Place p, int amount)
	{
		if(amount > 0)
			marking.put(p, amount);
		else 
			marking.remove(p);
	}
	
	public int GetMarking(Place p)
	{
		return marking.getOrDefault(p, 0);
	}
	
	public void Increment(Place p, int amount){
		SetMarking(p, GetMarking(p) + amount);
	}
	
	public void Decrement(Place p, int amount){
		SetMarking(p, GetMarking(p) - amount);
	}
	
	public void Add(NetMarking m){
		Iterator it = m.marking.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			int val1 = marking.getOrDefault(pair.getKey(), 0);
			int val2 = (int) pair.getValue();
			if(val1 + val2 > 0)
			{
				marking.put((Place)pair.getKey(), val1 + val2);
			}
			else
			{
				marking.remove(pair.getKey());
			}
		}
	}
	
	public void Subtract(NetMarking m)
	{
		Iterator it = m.marking.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			int val1 = marking.getOrDefault(pair.getKey(), 0);
			int val2 = (int) pair.getValue();
			if(val1 - val2 > 0)
			{
				marking.put((Place)pair.getKey(), val1 - val2);
			}
			else
			{
				marking.remove(pair.getKey());
			}
		}
	}
	
	public boolean GreaterOrEqual(NetMarking m)
	{
		Iterator it = m.marking.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			int val1 = marking.getOrDefault(pair.getKey(), 0);
			int val2 = (int) pair.getValue();
			if(val1 < val2){
				return false;
			}
		}
		return true;
	}
	
	public Collection<Place> GetSupport() {
		return java.util.Collections.unmodifiableCollection(marking.keySet());
	}
	
}
