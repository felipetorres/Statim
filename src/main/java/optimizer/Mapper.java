package optimizer;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

	private static List<Coordenada> coordenadas = new ArrayList<Coordenada>();
	
	public static int map(Coordenada coordenada) {
		if(!coordenadas.contains(coordenada)) {
			coordenadas.add(coordenada);
		}
		return coordenadas.indexOf(coordenada);
	}
	
	public static List<Coordenada> getMap() {
		List<Coordenada> defensiveCopy = new ArrayList<Coordenada>(coordenadas);
		return defensiveCopy;
	}
	
	public static Coordenada get(int index) {
		return coordenadas.get(index);
	}
	
	public static int size() {
		return coordenadas.size();
	}
}
