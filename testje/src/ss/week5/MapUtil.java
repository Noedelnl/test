package ss.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Class MapUtils.
 * @author saulv
 *
 */
public class MapUtil {
	
	/**
	 * Returns true if a map passed as a parameter is an injection.
	 * Only returns true if there are no duplicate values in the map,
	 * since duplicates would mean that a value had more than one key.
	 * @param map
	 * @return boolean
	 */
	/*@ ensures \forall K x, y; map.keySet().contains(x) && map.keySet().contains(y); x != y ==>
	 map.get(x) != map.get(y);
	 @*/
	public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        Iterator<V> values = map.values().iterator();
        ArrayList<V> list = new ArrayList<V>();
        while(values.hasNext()) {
        	V current = values.next();
        	if(!list.contains(current)) {
        		list.add(current);
        	}
        }
        return list.size() == map.keySet().size();
    }
    
	/**
	 * Returns true if a parameter map is surjective on a certain range.
	 * Only returns true when every value in range occurs on the map,
	 * as this would mean that there are no values without keys.
	 * @param map
	 * @param range
	 * @return boolean
	 */
	//@ ensures \forall V x; range.contains(x); map.values().contains(x); 
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        Iterator<V> values = range.iterator();
        while(values.hasNext()) {
        	if(!map.containsValue(values.next())) {
        		return false;
        	}
        }
        return true;
    }
    
    /**
     * Returns an inverted parameter map, with values and their keys in a single entry.
     * @param map
     * @return inverted map
     */
    //@ ensures \forall V x; map.values().contains(x); \result.keySet().contains(x);
    //@ ensures \forall K x; \result.keySet().contains(x); \result.get(map.get(x)).contains(x);
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
	    Map<V, Set<K>> res = new HashMap<V, Set<K>>();
		Iterator<V> values = map.values().iterator();
	    while(values.hasNext()) {
	    	V currentV = values.next();
	    	Iterator<K> keys = map.keySet().iterator();
	    	Set<K> vKeys = new HashSet<K>();
	    	while(keys.hasNext()) {
	    		K currentK = keys.next();
	    		if(map.get(currentK).equals(currentV)) {
	    			vKeys.add(currentK);
	    		}
	    	}
	    	res.put(currentV, vKeys);
	    }
    	return res;
	}
    
    /**
     * Returns an inverted parameter map if it is both injective and surjective.
     * @param map
     * @return inverted (or empty) map
     */
    //@ ensures \forall K x; map.keySet().contains(x); \result.values().contains(x);
    //@ ensures \forall V x; map.values().contains(x); \result.keySet().contains(x);
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        Map<V, K> res = new HashMap<V, K>();
        Set<V> range = new HashSet<V>();
        Iterator<V> values = map.values().iterator();
        Iterator<K> keys = map.keySet().iterator();
        while(values.hasNext()) {
        	range.add(values.next());
        }
        values = map.values().iterator();
        
		if(isOneOnOne(map) && isSurjectiveOnRange(map, range)) {
			while(values.hasNext()) {
				res.put(values.next(), keys.next());
			}
		}
		return res;
	}
	
	/**
	 * Returns true if two maps are compatible.
	 * Only returns true if, for every key on map 1, there is a
	 * key on map 2 with the value of the key on map 1.
	 * @param f - map 1
	 * @param g - map 2
	 * @return boolean
	 */
	//@ ensures \forall V x; f.values().contains(x); g.keySet().contains(x);
	//@ ensures \forall V x; g.keySet().contains(x); f.values().contains(x);
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
		Iterator<V> values = f.values().iterator();
        while(values.hasNext()) {
        	if(!g.containsKey(values.next())) {
        		return false;
        	}
        }
        return true;
	}
	
	/**
	 * Returns a composed map if the provided maps are compatible.
	 * Returns a composed map, with the keys of map 1 and the values of map 2.
	 * @param f - map 1
	 * @param g - map 2
	 * @return composed (or empty) map
	 */
	//@ ensures \forall K x; f.keySet().contains(x); \result.keySet().contains(x);
	//@ ensures \forall W x; g.values().contains(x); \result.values().contains(x);
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        Map<K, W> res = new HashMap<K, W>();
        if(compatible(f, g)) {
            Iterator<K> keys = f.keySet().iterator();
        	while(keys.hasNext()) {
        		K current = keys.next();
        		res.put(current, g.get(f.get(current)));
        	}
        }
        return res;
	}
}
