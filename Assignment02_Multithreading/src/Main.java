import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		// File name input
		System.out.print("Enter the path of text file here: ");
		BufferedReader input =  new BufferedReader(new InputStreamReader(System.in)); 
		// Reading data using readLine 
		String filename = input.readLine(); 
		
		ArrayList<String> lines = new ArrayList<String>();
		
		// file reading
		BufferedReader reader = new BufferedReader(new FileReader(filename));
	    String line;
	    
	    while ((line = reader.readLine()) != null)
	    {
	    	if(!(line.trim().isEmpty()))
		    	lines.add(line.toLowerCase());
	    }
	    reader.close();
		
		HistogramFactory factory = new HistogramFactory();
		
		factory.setMethod("sequential");
		FrequencyHist histogram = factory.getMethod();
		
		long start = System.currentTimeMillis();
		HashMap<Character, Integer> freq =  histogram.findFreq(lines);
		long end = System.currentTimeMillis() - start;
		
		for(char key: freq.keySet()) {
			System.out.println(key + ": " + freq.get(key));
		}
		System.out.println("Sequential Time: " + end + " msec");
		
		
		factory.setMethod("parallel");
		histogram = factory.getMethod();
		
		start = System.currentTimeMillis();
		freq =  histogram.findFreq(lines);
		end = System.currentTimeMillis() - start;
		
		for(char key: freq.keySet()) {
			System.out.println(key + ": " + freq.get(key));
		}
		System.out.println("Parallel Time: " + end + " msec");
	}

}
