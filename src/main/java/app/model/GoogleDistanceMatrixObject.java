package app.model;

import java.util.List;

public class GoogleDistanceMatrixObject {

	public List<String> destination_addresses;
	public List<String> origin_addresses;
	public List<Rows> rows;
	
	public int getDistanceAtPosition(int i, int j) {
		return this.rows.get(i).elements.get(j).distance.value;
	}
	
	private class Rows {
		public List<Element> elements;
	}
	
	private class Element {
		public TexVal distance;
		public TexVal duration;
		public String status;
		
	}
	
	private class TexVal {
		public String text;
		public int value;
		
	}
}