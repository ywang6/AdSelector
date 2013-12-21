import java.util.HashSet;
import java.util.Hashtable;
/**
 * Store input files data into dictionary data structure for future use
 * Since We do not need Setter method for set data, we can simply use Dictionary.getInput.put(?,?);
 * @author y.wang
 *
 */
public class Dictionary {
	public static Hashtable<Element, HashSet<Ad>> input = new Hashtable<Element, HashSet<Ad>>();
	public static Hashtable<String, Integer> ad_weight = new Hashtable<String, Integer>();
	public static Hashtable<String, Integer> place_weight = new Hashtable<String, Integer>();
	public static Hashtable<Integer, HashSet<String>> request = new Hashtable<Integer, HashSet<String>>();
	public static Hashtable<Element, HashSet<Ad>> getInput() {
		return input;
	}
	
	public static Hashtable<String, Integer> getAd_weight() {
		return ad_weight;
	}
	
	public static Hashtable<String, Integer> getPlace_weight() {
		return place_weight;
	}
	
	public static Hashtable<Integer, HashSet<String>> getRequest() {
		return request;
	}
	
}
