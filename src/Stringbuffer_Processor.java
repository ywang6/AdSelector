import java.util.HashSet;

/**
 * function: process the Stringbuffer from File_Reader's methods, store the results to 
 * related each dictionary.
 * @author y.wang
 *
 */
public class Stringbuffer_Processor {
	public static void process_input_file(StringBuffer input_buffer)
	{
		String[] each_line = input_buffer.toString().split("\\n");	//split by Enter
		String[] each_column = null;
		int start_time = 0;
		int end_time = 0;
		Ad ad = null;
		Element e = null;
		String place = null;
		HashSet<Ad> ads = new HashSet<Ad>();						//store ads
		if(each_line.length==0)
		{
			System.err.print("error in input_buffer!");
			return;
		}
		for(String line : each_line)
		{
			each_column = line.split(" ");	//split by Space

			if(each_column.length!=4){
				System.err.print("error in each_column!");
				return;
			}
			ad = new Ad();
			ad.setName(each_column[0]);
			ad.setStart_time(Integer.parseInt(each_column[1]));
			ad.setEnd_time(Integer.parseInt(each_column[2]));
			ad.setPlace(each_column[3]);
			ads.add(ad);											//after get ad, put into a set
		}
		/* after we got ad set, we need to put those ads into dictionary based on element(time, place)*/
		for(Ad a : ads)
		{
			start_time = a.getStart_time();
			end_time = a.getEnd_time();
			place = a.getPlace();
			for(int i = start_time; i <= end_time; i++)
			{
				e = new Element();
				e.setTime(i);
				e.setPlace(place);
				if(!Dictionary.getInput().containsKey(e))			//if not exists, create new one
				{
					HashSet<Ad> tmp = new HashSet<Ad>();
					tmp.add(a);
					Dictionary.getInput().put(e, tmp);
				}
				else
				{
					Dictionary.getInput().get(e).add(a);			//if input exists, just add ad into it	
				}
			}
		}
		//System.out.println(Dictionary.getInput().toString());
	}
	public static void process_ad_file(StringBuffer ad_weight)
	{
		String[] each_line = ad_weight.toString().split("\\n");
		String[] each_column = null;
		String name = null;
		int weight = 0;
		if(each_line.length==0)
		{
			System.out.print("ad_file errer");
			return;
		}

		for(String line : each_line)
		{
			each_column = line.split(" ");
			if(each_column.length!=2)
			{
				System.out.println("split ad_weight line errer");
				return;
			}
			name = each_column[0];
			weight = Integer.parseInt(each_column[1]);
			Dictionary.getAd_weight().put(name, weight);
		}
		
	}
	public static void process_place_file(StringBuffer place_weight)
	{
		String[] each_line = place_weight.toString().split("\\n");
		String[] each_column = null;
		String name = null;
		int weight = 0;
		if(each_line.length==0)
		{
			System.out.print("place_file errer");
			return;
		}
		for(String line : each_line)
		{
			each_column = line.split(" ");
			if(each_column.length!=2)
			{
				System.out.println("split place_weight line errer");
				return;
			}
			name = each_column[0];
			weight = Integer.parseInt(each_column[1]);
			Dictionary.getPlace_weight().put(name, weight);
		}
	}
	public static void process_request_file(StringBuffer request)
	{
		String[] each_line = request.toString().split("\\n");
		String[] each_column = null;
		String[] each_place = null;
		int time = 0;
		HashSet<String> places = null;
		
		if(each_line.length==0)
		{
			System.out.print("request_file errer");
			return;
		}
		for(String line : each_line)
		{
			each_column = line.split(" ");
			if(each_column.length!=2)
			{
				System.out.println("split request line errer");
				return;
			}
			time = Integer.parseInt(each_column[0]);
			each_place = each_column[1].split(",");
			places = new HashSet<String>();
			for(String place : each_place){
				places.add(place);
			}
			Dictionary.getRequest().put(time, places);
		}
	}
}
