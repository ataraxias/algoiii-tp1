package algo3.tp1.ej2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class Ej2Test {

	@Test
	public void test() {
		Ej2 ej2 = new Ej2();
		int[] sensores = { 2, 3 };

		Assert.assertEquals(1, ej2.solve(sensores, 6));
	}

	@Test
	public void testFromFile() throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new FileReader(
				"recursos/tp1/ej1.in"));
		BufferedReader output = new BufferedReader(new FileReader(
				"recursos/tp1/ej1.out"));

		Ej2 ej2 = new Ej2();

		while (true) {
			String line = input.readLine();
			if (line.contains("#")) {
				break;
			}

			int expected = Integer.parseInt(output.readLine());
			String[] fields = line.split(" ");
			int n = Integer.parseInt(fields[0]);
			int k = Integer.parseInt(fields[1]);

			int[] sensors = new int[n];
			/*
			 * Fields[0] = n y fields[1] = k, el resto son los números que nos
			 * interesan.
			 */
			for (int i = 0; i < n; i++) {
				sensors[i] = Integer.parseInt(fields[i + 2]);
			}
			Assert.assertEquals(expected, ej2.solve(sensors, k));
		}

	}

}
