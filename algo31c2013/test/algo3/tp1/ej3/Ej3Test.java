package algo3.tp1.ej3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class Ej3Test {

	@Test
	public void testFromFile() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new FileReader(
				"recursos/tp1/ej3.in"));
		BufferedReader output = new BufferedReader(new FileReader(
				"recursos/tp1/ej3.out"));
		BufferedReader outputBruto = new BufferedReader(new FileReader(
				"recursos/tp1/ej3.bruteforce.out"));

		Ej3 ej3 = new Ej3();

		while (true) {
			String line = input.readLine();
			if (line.contains("#")) {
				break;
			}

			String parsed[] = line.split(" ");
			int n = Integer.parseInt(parsed[0]);
			int b = Integer.parseInt(parsed[1]);
			int h = Integer.parseInt(parsed[2]);

			line = input.readLine();
			parsed = line.split(" ");

			Punto[] puntos = new Punto[n];
			for (int i = 0; i < parsed.length; i += 2) {
				int x = Integer.parseInt(parsed[i]);
				int y = Integer.parseInt(parsed[i + 1]);

				puntos[i / 2] = new Punto(x, y);
			}

			line = output.readLine();
			parsed = line.split(" ");
			int expected = Integer.parseInt(parsed[2]);

			int res[] = ej3.solve(puntos, b, h);
			Punto rect = new Punto(res[0], res[1]);
			Assert.assertEquals(expected, res[2]);

			line = outputBruto.readLine();
			parsed = line.split(" ");
			Set<Punto> soluciones = new HashSet<Punto>();
			for (int i = 0; i < parsed.length; i += 2) {
				int x = Integer.parseInt(parsed[i]);
				int y = Integer.parseInt(parsed[i + 1]);
				soluciones.add(new Punto(x, y));
			}

			Assert.assertTrue(soluciones.contains(rect));
		}
	}

	@Test
	public void test() {
		Punto[] puntos = new Punto[5];
		puntos[0] = new Punto(1, 1);
		puntos[1] = new Punto(3, 3);
		puntos[2] = new Punto(5, 1);
		puntos[3] = new Punto(5, 5);
		puntos[4] = new Punto(6, 3);
		Ej3 ej3 = new Ej3();

		int[] res = ej3.solve(puntos, 5, 5);
		Assert.assertEquals(5, res[2]);
		Assert.assertEquals(1, res[1]);
		Assert.assertEquals(1, res[0]);

		res = ej3.solve(puntos, 1, 2);
		Assert.assertEquals(2, res[2]);
		res = ej3.solve(puntos, 1, 1);
		Assert.assertEquals(1, res[2]);

		res = ej3.solve(puntos, 3, 1);
		Assert.assertEquals(2, res[2]);
		Assert.assertEquals(3, res[1]);
		Assert.assertEquals(3, res[0]);
	}

}
