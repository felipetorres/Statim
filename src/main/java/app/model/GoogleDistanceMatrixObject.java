package app.model;

import java.util.ArrayList;
import java.util.List;

import optimizer.Coordenada;

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
	
	public List<Coordenada> getCoordinates() {
		List<Coordenada> coordenadas = new ArrayList<Coordenada>();
		
		for (String c : this.origin_addresses) {
			String[] latLng = c.replaceAll("\"", "").split(",");
			Double latitude = Double.valueOf(latLng[0]);
			Double longitude = Double.valueOf(latLng[1]);
			
			coordenadas.add(new Coordenada(latitude, longitude));
		}
		return coordenadas;
	}
	
	public int getDimension() {
		return this.origin_addresses.size();
	}
}