/**
 * 
 */
package algo3.tp1.ej1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import algo3.tp1.ej1.Ej1.Ej1Sol;

/**
 * @author vero
 *
 */
public class Ej1Test {

	@Test
	public void test() {
		Ej1 ej1 = new Ej1();
		int[] tc = { 10, 10, 10, 1, 2 };
		int[] tp = { 1, 9, 30, 5, 30};
		Ej1Sol res = ej1.solve(tc, tp);
		
		for (int i = 0; i < tc.length - 1; i++ ){
			Assert.assertTrue(tp[res.ids[i]-1] >= tp[res.ids[i+1]-1]);
		}
	}
	
	@Ignore
	public void testFromFile() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new FileReader(
				"recursos/tp1/ej1.in"));
		BufferedReader output = new BufferedReader(new FileReader(
				"recursos/tp1/ej1.out"));

		Ej1 ej1 = new Ej1();

		while (true) {
			String line = input.readLine();
			if (line.contains("#")) {
				break;
			}

			int n = Integer.parseInt(line);
			
			// Leo tiempos de llenado
			line = input.readLine();
			String[] fields = line.split(" ");
			int[] tiempos_llenado = new int[n];
			for (int i = 0; i < n; i++){
				tiempos_llenado[i] = Integer.parseInt(fields[i]);
			}

			// Leo tiempos de produccion
			line = input.readLine();
			fields = line.split(" ");
			
			int[] tiempos_produccion = new int[n];
			
			for (int i = 0; i < n; i++){
				tiempos_produccion[i] = Integer.parseInt(fields[i]);
			}

		}
		input.close();
		output.close();

	}



}
