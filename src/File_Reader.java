import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Read test files, input.txt from desktop and save the result to a Stringbuffer.
 * 
 * Yu Wang
 * 08/21/2013 
 */
public class File_Reader {
	/**
	 * readFile()
	 * function: read different files to different Stringbuffers, then process them 
	 * to different dictionaries for future use
	 * include: read_input_file(),read_ad_file(),read_place_file(),read_request_file()
	 * 
	 */
	public final static String input_file = "C:\\Users\\yu wang\\Desktop\\test\\input.txt";
	public final static String ad_file = "C:\\Users\\yu wang\\Desktop\\test\\ad.txt";
	public final static String place_file = "C:\\Users\\yu wang\\Desktop\\test\\place.txt";
	public final static String request_file = "C:\\Users\\yu wang\\Desktop\\test\\request.txt";
	static StringBuffer input_buffer = new StringBuffer();			//for store input.txt
	static StringBuffer adWeight_buffer = new StringBuffer();		//for store ad.txt
	static StringBuffer locationWeight_buffer = new StringBuffer();//for store location.txt
	static StringBuffer request_buffer = new StringBuffer();		//for store request.txt
	
	public static void readFile()
	{
		/* just read file*/
		read_input_file();
		read_ad_file();
		read_place_file();
		read_request_file();
		
		/* process data, store results into dictionary*/
		Stringbuffer_Processor.process_input_file(input_buffer);
		Stringbuffer_Processor.process_ad_file(adWeight_buffer);
		Stringbuffer_Processor.process_place_file(locationWeight_buffer);
		Stringbuffer_Processor.process_request_file(request_buffer);
	}
	
	/**
	 *  sub-functions of readFile() in charge of different read files.
	 */
	
	/* read input.txt file*/
	public static void read_input_file()
	{
		FileReader fr = null;
		BufferedReader br = null;
		String line = null;
		try {
			fr = new FileReader(input_file);
			br = new BufferedReader(fr);
		} catch(Exception e){
			System.out.print("file error!");
		}
		try {
			line = br.readLine();
			while(line!=null)
			{
				//System.out.println(line);
				input_buffer.append(line);
				input_buffer.append("\n");
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* read ad.txt file*/
	public static void read_ad_file()
	{
		FileReader fr = null;
		BufferedReader br = null;
		String line = null;
		try {
			fr = new FileReader(ad_file);
			br = new BufferedReader(fr);
		} catch(Exception e){
			System.out.print("file error!");
		}
		try {
			line = br.readLine();
			while(line!=null)
			{
				//System.out.println(line);
				adWeight_buffer.append(line);
				adWeight_buffer.append("\n");
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* read place.txt file*/
	public static void read_place_file()
	{
		FileReader fr = null;
		BufferedReader br = null;
		String line = null;
		try {
			fr = new FileReader(place_file);
			br = new BufferedReader(fr);
		} catch(Exception e){
			System.out.print("file error!");
		}
		try {
			line = br.readLine();
			while(line!=null)
			{
				//System.out.println(line);
				locationWeight_buffer.append(line);
				locationWeight_buffer.append("\n");
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* read request.txt file, since it is the last file, we need to close the BufferedReader adn FileReader*/
	public static void read_request_file()
	{
		FileReader fr = null;
		BufferedReader br = null;
		String line = null;
		try {
			fr = new FileReader(request_file);
			br = new BufferedReader(fr);
		} catch(Exception e){
			System.out.print("file error!");
		}
		try {
			line = br.readLine();
			while(line!=null)
			{
				//System.out.println(line);
				request_buffer.append(line);
				request_buffer.append("\n");
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
