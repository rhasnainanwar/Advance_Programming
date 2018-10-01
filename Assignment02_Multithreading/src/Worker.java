import java.util.HashMap;

public class Worker extends Thread {
	private String str;
	public HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	
	// constructor
	public Worker(String hay) {
		this.str = hay;
	}

	@Override
	public void run() {	
		for(char character: str.toCharArray()) {
			try {
				map.put(character, map.get(character) + 1);
			}
			catch (NullPointerException e){
				map.put(character, 1);
			}
		}
			
	}
}
