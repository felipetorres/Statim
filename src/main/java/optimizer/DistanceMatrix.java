package optimizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import app.model.GoogleDistanceMatrixObject;

import com.google.gson.Gson;

public class DistanceMatrix {
	
	private GoogleDistanceMatrixObject matrix;
	private String formatted;

	public DistanceMatrix(List<Coordenada> coordenadas) {
		formatted = this.formatCoordinates(coordenadas);
		this.matrix = this.getMatrixDistance(formatted);
	}
	
	public GoogleDistanceMatrixObject getDistanceMatrix() {
		return matrix;
	}
	
	public String getFormattedCoordinates() {
		return formatted;
	}

	private String formatCoordinates(List<Coordenada> coordenadas) {
		String formatted = "";
		for (Coordenada coordenada : coordenadas) {
			formatted += coordenada.getLatitude() + "," + coordenada.getLongitude() + " ";
		}
		return formatted.trim().replaceAll(" ", "|");
	}

	private GoogleDistanceMatrixObject getMatrixDistance(String coordenadas) {
		URL url;
		try {
			url = new URL("http://maps.googleapis.com/maps/api/distancematrix/json?" +
					"origins=" + coordenadas + "&" +
					"destinations=" + coordenadas + "&" +
					"language=pt-BR" + "&" +
					"sensor=false");

			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
		
			return parseResponseFrom(connection);
		} catch (IOException e) {
		}
		return null;
	}
	
	private GoogleDistanceMatrixObject parseResponseFrom(URLConnection connection)
			throws IOException {
		InputStream inputStream = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		String line, lines = "";
		while((line = reader.readLine()) != null) {
			lines += line;
		}
		return (new Gson()).fromJson(lines, GoogleDistanceMatrixObject.class);
	}
}
