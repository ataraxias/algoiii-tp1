/**
 * 
 */
package algo3.tp1.ej1;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author vero
 * 
 */
public class Ej1 {

	Ej1Sol solve(int[] tiempos_llenado, int[] tiempos_produccion) {
		Comparator<Maquina> comparador = new Comparator<Maquina>() {
			@Override
			public int compare(Maquina m1, Maquina m2) {
				if (m1.tiempo_produccion >= m2.tiempo_produccion) {
					return -1;
				}
				return 1;
			}
		};

		List<Maquina> maquinas = new LinkedList<>();

		for (int i = 0; i < tiempos_llenado.length; i++) {
			Maquina m = new Maquina(i + 1, tiempos_llenado[i],
					tiempos_produccion[i]);
			maquinas.add(m);
		}

		Collections.sort(maquinas, comparador);

		int tiempoTotal = calcularTiempoTotal(maquinas);

		int[] result = new int[maquinas.size()];

		int i = 0;
		for (Maquina m : maquinas) {
			result[i] = m.id;
			i += 1;
		}

		Ej1Sol sol = new Ej1Sol(result, tiempoTotal);

		return sol;
	}

	/***
	 * Dada una lista de Máquinas, calcula cuánto tiempo se tardaría en cargar y
	 * procesar todas en ese orden. Este tiempo se calcula suponiendo que cada
	 * máquina empieza a trabajar inmediatemente luego de que se carga, y que
	 * sólo se puede cargar una máquina a la vez.
	 * 
	 * @param maquinas
	 *            Las máquinas a cargar.
	 * @return El tiempo total que tardarían.
	 * @complejidad O(maquinas.size())
	 */
	private int calcularTiempoTotal(List<Maquina> maquinas) {
		int tiempoActual = 0;
		int tiempoProcesamiento = 0;
		int tiempoMaximo = 0;

		for (Maquina m : maquinas) {
			tiempoActual += m.tiempo_llenado;
			tiempoProcesamiento = tiempoActual + m.tiempo_produccion;
			if (tiempoMaximo < tiempoProcesamiento)
				tiempoMaximo = tiempoProcesamiento;
		}
		return tiempoMaximo;
	}

	private class Maquina {
		int id;
		int tiempo_llenado;
		int tiempo_produccion;

		public Maquina(int id, int tiempo_llenado, int tiempo_produccion) {
			super();
			this.id = id;
			this.tiempo_llenado = tiempo_llenado;
			this.tiempo_produccion = tiempo_produccion;
		}
	}

	public class Ej1Sol {
		int[] ids;
		int total;

		public Ej1Sol(int[] ids, int total) {
			super();
			this.ids = ids;
			this.total = total;
		}
	}

}
