/**
 * Main function to control different functions.
 * @author y.wang
 *
 */
public class MainFunction {

	public static void main(String[] args) {
		File_Reader.readFile();
		//BiggestFirst.biggestFirst();
		DFS d = new DFS();
		d.enumurationRecursive();
	}

}
