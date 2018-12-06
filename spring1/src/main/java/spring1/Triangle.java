package spring1;

import java.util.Date;

public class Triangle {
	
	private String type;
	private float dimensions;
	private Date doc;
	
	public Date getDoc() {
		return doc;
	}
	
	public void setDoc(Date doc) {
		this.doc = doc;
	}
	
	public float getDimensions() {
		return dimensions;
	}
	public void setDimensions(float diemensions) {
		this.dimensions = diemensions;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public void draw() {
		System.out.println(getType() + " Triangle Drawn with each side of length " + getDimensions() + ". Created on " + getDoc());
	}
}
