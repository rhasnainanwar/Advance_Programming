import java.util.ArrayList;
import java.util.HashMap;

public class Threaded implements FrequencyHist {
	
	@Override
	public HashMap<Character, Integer> findFreq(ArrayList<String> source){
		
		int length = source.size();
		Worker[] workers = new Worker[length];
		int curr = 0;
		
		for(String para: source) {
			workers[curr] = new Worker(para);
			workers[curr].start();
			curr++;
		}
		
		for(int i = 0; i < length; i++) {
			try {
				workers[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
		
		for(int i = 0; i < length; i++) 
			for(char key: workers[i].map.keySet()) {
				try {
					freq.put(key, freq.get(key) + workers[i].map.get(key));
				}
				catch (NullPointerException e){
					freq.put(key, workers[i].map.get(key));
				}
			}
		
		
		return freq;
	}
}
