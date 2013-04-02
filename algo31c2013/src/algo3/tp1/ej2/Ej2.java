/**
 * 
 */
package algo3.tp1.ej2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author vero
 *
 */
public class Ej2 {
	int solve(int[] sensores, int k) {
		Comparator<Sensor> comparador = new Comparator<Sensor>() {
			@Override
			public int compare(Sensor o1, Sensor o2) {
				if (o1.proxima_medicion < o2.proxima_medicion) {
					return -1;
				} else if (o1.proxima_medicion == o2.proxima_medicion) {
					if (o1.id < o2.id) {
						return -1;
					}
				}
				return 1;
			}
		};
		
		PriorityQueue<Sensor> sensos = new PriorityQueue<Sensor>(sensores.length, comparador);
		
		for (int i = 0; i < sensores.length; i++) {
			Sensor s = new Sensor(i + 1, sensores[i], 0);
			sensos.add(s);
		}
		
		while (k > 1) {
			Sensor s = sensos.poll();
			s.proxima_medicion += s.frecuencia;
			sensos.add(s);
			k --;
		}
		
		return sensos.peek().id;
	}
	
	private class Sensor {
		int id;
		int frecuencia;
		int proxima_medicion;
		
		public Sensor(int id, int frecuencia, int proxima_medicion) {
			super();
			this.id = id;
			this.frecuencia = frecuencia;
			this.proxima_medicion = proxima_medicion;
		}
		
		
	}

}
