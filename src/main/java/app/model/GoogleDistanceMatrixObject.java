package app.model;

import java.util.List;

public class GoogleDistanceMatrixObject {

	private List<String> destination_addresses;
	private List<String> origin_addresses;
	private List<Rows> rows;
	
	public int getDistanceAtPosition(int i, int j) {
		return this.rows.get(i).elements.get(j).distance.value;
	}
	
	private class Rows {
		private List<Element> elements;
	}
	
	private class Element {
		private TexVal distance;
		private TexVal duration;
		private String status;
	}
	
	private class TexVal {
		private String text;
		private int value;
	}
}