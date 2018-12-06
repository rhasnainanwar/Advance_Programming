package spring1;

import java.util.List;

public class Triangle1 {
	
	private String type;
	private List<Float> dimensions;
	
	public List<Float> getDimensions() {
		return dimensions;
	}
	public void setDimensions(List<Float> dimensions) {
		this.dimensions = dimensions;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public void draw() {
		System.out.println(getType() + " Triangle1 Drawn with dimensions " + getDimensions().toString() );
	}
}
