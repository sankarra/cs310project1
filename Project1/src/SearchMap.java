import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class reads in an input file, and calls FlightMap passing
 * in the input file as an instance of BufferedReader
 * @author Anup Sankarraman
 *
 */
public class SearchMap {

	public SearchMap() 
	{
		
	}
	
	/**
	 * This is the main method where I handle I/O
	 * @param args Input and output file name inputs
	 * @throws IOException I/O exception thrown if wrong input/output file
	 */
	public static void main(String[] args) throws IOException 
	{
		if (args.length != 2)
		{
			System.out.println("Invalid input parameters");
			System.exit(1);
		}
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		
		try
		{
			br = new BufferedReader(new FileReader(args[0]));
//			FlightMap fm = new FlightMap(br, fw);
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Input file could not be found.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try
		{
			File file = new File(args[1]);
			//file.getParentFile().mkdirs();
			pw = new PrintWriter(file);
		}
		catch (IOException ioe)
		{
			System.out.println("Could not write to output file");
		}
		FlightMap fm = new FlightMap(br, pw);
		
		br.close();
		pw.close();
	}
}

