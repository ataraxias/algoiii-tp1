package algo3.tp1.ej3;

import java.util.LinkedList;
import java.util.List;

/**
 */
public class Ej3 {
	int[] solve(Punto[] puntos, int b, int h) {
		
		List<Rectangulo> rectangulos = new LinkedList<>();
		
		for (Punto p : puntos) {
			for (Punto q : puntos) {
				Punto origen = new Punto(Math.min(p.x, q.x), Math.min(p.y, q.y));
				Rectangulo r = new Rectangulo(origen, b, h);
				
				if (r.contains(p) && r.contains(q)) {
					rectangulos.add(r);
				}
			}
		}
		
		Rectangulo maxRect = null;
		int maxPuntos = 0;
		
		for (Rectangulo r : rectangulos) {
			int tmp = contarPuntosContenidos(r, puntos);
			if (tmp > maxPuntos) {
				maxPuntos = tmp;
				maxRect = r;
			}
		}
		
		int[] result = {maxRect.origen.x, maxRect.origen.y, maxPuntos};
		return result;
		
	}
	
	private int contarPuntosContenidos(Rectangulo r, Punto[] puntos) {
		int res = 0;
		for (Punto p : puntos) {
			if (r.contains(p)) {
				res += 1;
			}
		}
		
		return res;
	}
}
