import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
/**
 * Greedy algorithm, but this question is obviously NPC, so this is may not be 100% correct, but at lease solve most of 
 * the situations, especially when there is no duclicate ads in the same time.
 * @author y.wang
 *
 */
public class BiggestFirst {
	public static void biggestFirst()
	{
		Element ele = null;
		HashSet<Ad> resForOnePlace = null;
		HashSet<HashSet<Ad>> result = new HashSet<HashSet<Ad>>();
		Ad BiggestWeightAd = null;
		HashSet<Ad> lastVisit = new HashSet<Ad>();									// record the name of last ad
		for(int time : Dictionary.getRequest().keySet())
		{
			resForOnePlace = new HashSet<Ad>();
			for(String place : sortRequest(time))
			{
				ele = new Element();
				ele.setTime(time);
				ele.setPlace(place);
				BiggestWeightAd = pickBiggestWeightAd(ele, lastVisit);
				resForOnePlace.add(BiggestWeightAd);
				lastVisit.add(BiggestWeightAd);
			}
			result.add(resForOnePlace);
			lastVisit = new HashSet<Ad>();
		}
		print(result);
	}
	
	
	/* sort request based on place weight, return the sorted place list */
	public static ArrayList<String> sortRequest(int time)
	{
		ArrayList<String> ar = new ArrayList<String>();
		/* comparator function*/
		Comparator<String> comparator = new Comparator<String>(){
			public int compare(String place1, String place2)
			{
				if(Dictionary.getPlace_weight().get(place1)!=Dictionary.getPlace_weight().get(place2))
				{
					return Dictionary.getPlace_weight().get(place2)-Dictionary.getPlace_weight().get(place1);
				}
				else
					return 0;
			}
		};
		for(String place : Dictionary.getRequest().get(time))
		{
			ar.add(place);
		}
		Collections.sort(ar,comparator);
		return ar;
	}
	/* pick biggest weight ad */
	public static Ad pickBiggestWeightAd(Element ele, HashSet<Ad> lastVisit)
	{
		int maxWeight = 0;
		Ad maxWeightAd = null;
		/* check if dictionary has the same ad and use sameAd to flag it */
		
		for(Ad ad : Dictionary.getInput().get(ele))
		{
			if(lastVisit.contains(ad))
				continue;
			if(Dictionary.getAd_weight().get(ad.getName())>=maxWeight)
			{
				maxWeight = Dictionary.getAd_weight().get(ad.getName());
				maxWeightAd = ad;
			}
		}
		if(maxWeightAd==null)
		{
			System.err.println("do not have biggest weight ad");
		}
		return maxWeightAd;
	}
	/*
	 * print result set.
	 */
	public static void print(HashSet<HashSet<Ad>> result)
	{
		for(HashSet<Ad> hs : result)
		{
			System.out.println("time spot");
			for(Ad ad : hs)
			{
				System.out.println(ad);
			}
		}
	}
}
