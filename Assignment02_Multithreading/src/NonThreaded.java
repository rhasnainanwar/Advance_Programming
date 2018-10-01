import java.util.ArrayList;
import java.util.HashMap;

public class NonThreaded implements FrequencyHist {
	
	@Override
	public HashMap<Character, Integer> findFreq(ArrayList<String> source){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(String para: source) {
			for(char character: para.toCharArray()) {
				try {
					map.put(character, map.get(character) + 1);
				}
				catch (NullPointerException e){
					map.put(character, 1);
				}
			}
		}
		
		return map;
	}
}
