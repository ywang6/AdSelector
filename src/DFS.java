import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;


public class DFS {
	
	public HashSet<HashSet<Ad>> res;
	public int maxWeight;
	DFS()
	{
		res = new HashSet<HashSet<Ad>>();
		maxWeight = 0;
	}
	/*
	 * enumeration recursive way.
	 */
	public void enumurationRecursive()
	{
		int i = 0;											// get next place index
		HashSet<Ad> buff = new HashSet<Ad>();
		for(int time : Dictionary.getRequest().keySet())
		{
			System.out.println(res.toString());
			
			System.out.println("________________________________________");
			dfs(time, buff, i);
			System.out.println(res.toString());
			
			System.out.println("******************************");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++");
		//print();
	}
	/*
	 *  dfs for each time spot.
	 */
	public void dfs(int time, HashSet<Ad> buff, int i)
	{
		
		if(buff.size() == Dictionary.getRequest().get(time).size())	//buff is full
		{
			//System.out.println(res.toString());
			 res.add(buff);
				//System.out.println(maxTmp.toString());
			 return;
		}
		Element e = new Element();
		e.setTime(time);
		String place = getNextPlace(time, i);
		e.setPlace(place);

		for(Ad ad : toArrayList(Dictionary.getInput().get(e)))
		{
			if(i<Dictionary.getRequest().get(time).size()){
				buff.add(ad);
				//System.out.println(buff.size() + " " + i);
				dfs(time, buff, ++i);
				buff.remove(ad);
				i--;
				//System.out.println("---" + buff.size() + " " + i);
			}
		}
	}
	/*
	 *  get Next place according to time
	 */
	public String getNextPlace(int time, int i)
	{
		return sortedArrayList(time).get(i);
	}
	/* sort request based on place weight, return the sorted place list */
	public ArrayList<String> sortedArrayList(int time)
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
	
	/*
	 *  get each hashset's total ad weight
	 */
	public int getWeight(HashSet<Ad> buff)
	{
		int weight = 0;
		for(Ad ad : buff)
		{
			weight = weight + Dictionary.getPlace_weight().get(ad.getPlace())*Dictionary.getAd_weight().get(ad.getName());
		}
		return weight;
	}
	/*
	 * print result set.
	 */
	public void print()
	{
		for(HashSet<Ad> hs : res)
		{
			System.out.println("time spot");
			for(Ad ad : hs)
			{
				System.out.println(ad);
			}
		}
	}
	/*
	 *  transfer hashset to sorted arraylist
	 */
	public ArrayList<Ad> toArrayList(HashSet<Ad> adSet)
	{
		ArrayList<Ad> adList = new ArrayList<Ad>();
		/* comparator function*/
		Comparator<Ad> comparator = new Comparator<Ad>(){
			public int compare(Ad ad1, Ad ad2)
			{
				if(Dictionary.getAd_weight().get(ad1)!=Dictionary.getAd_weight().get(ad2))
				{
					return Dictionary.getAd_weight().get(ad1) - Dictionary.getAd_weight().get(ad2);
				}
				else
					return 0;
			}
		};
		for(Ad ad : adSet)
		{
			adList.add(ad);
		}
		Collections.sort(adList,comparator);
		return adList;
	}
}
