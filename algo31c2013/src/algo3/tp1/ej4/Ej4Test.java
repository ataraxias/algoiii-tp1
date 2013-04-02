/**
 * 
 */
package algo3.tp1.ej4;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import algo3.tp1.ej4.ej4.Ej4Sol;


/**
 * @author romina
 *
 */
public class Ej4Test {
	
	public static void main(String args[]) {
		try{
			BufferedWriter output = new BufferedWriter(new FileWriter(
				"/home/shevek/Dropbox/algoiii/algo31c2013/src/algo3/tp1/ej4/ej4.txt"));
			
			PrintWriter wr = new PrintWriter(output);  
			
	
			int[][] matriz_tablero = { {1,0,0}, {0,1,0},{0,0,1},{0,0,1} };
			int[][] fichas_ocupadas ={ {0,0,0}, {0,0,0},{0,0,0},{0,0,0} };
			Tablero tablero = new Tablero(matriz_tablero.length, matriz_tablero[0].length, matriz_tablero);
	
	
			int[][] ficha_1 = {{1},{0}};
			int[][] ficha_2 = {{1},{0},{0},{0}};
			int[][] ficha_3 = {{0},{0}};
			int[][] ficha_4 = {{0,0},{1,0},{0,1},{0,1}};
			int[][] ficha_5 = {{0}};
			
			Ficha f_1 = new Ficha(1,ficha_1.length, ficha_1[0].length,ficha_1);
			Ficha f_2 = new Ficha(2,ficha_2.length, ficha_2[0].length,ficha_2);
			Ficha f_3 = new Ficha(3,ficha_3.length, ficha_3[0].length,ficha_3);
			Ficha f_4 = new Ficha(4,ficha_4.length, ficha_4[0].length,ficha_4);
			Ficha f_5 = new Ficha(5,ficha_5.length, ficha_5[0].length,ficha_5);
	
			List<Ficha> lista_fichas = new LinkedList<>();
			lista_fichas.add(f_1);
			lista_fichas.add(f_2);
			lista_fichas.add(f_3);
			lista_fichas.add(f_4);
			lista_fichas.add(f_5);
			
			//imprimir_tablero:
			int elem;
			char c;
			for (int i = 0; i < tablero.filas; i++) {
				for (int j = 0; j < tablero.columnas; j++) {
					if (tablero.matriz[i][j] == 0){
						wr.write("0");
					}else{
						wr.write("1");
					}
					if (j == tablero.columnas -1){
						wr.println();
					}else{
						wr.write(" ");
					}
				
				}
			}
			wr.println();
			// comprobar fichas {1,2,3,4,5}
			
			wr.write("Primer casillero Libre:" + " (" + tablero.proximo_casillero_libre.X + "," + 
			          tablero.proximo_casillero_libre.Y + ")");
			
			wr.println();
			
			for (int i = 0; i < lista_fichas.size(); i++) {
				Ficha f = lista_fichas.get(i);
				if (tablero.comprobar_ficha(f)){
					wr.write("La ficha " + f.id + " entra");
					wr.println();
				}
			}
			wr.println();
			
			//Agregar Ficha 1
			
			tablero.llenar_con_ficha(f_1);
			
			wr.write("Primer casillero Libre:" + " (" + tablero.proximo_casillero_libre.X + "," + 
			          tablero.proximo_casillero_libre.Y + ")");
			
			wr.println();
			
			wr.write("TABLERO CON FICHA 1");	
			wr.println();
				//imprimir_tablero:
			for (int i = 0; i < tablero.filas; i++) {
			for (int j = 0; j < tablero.columnas; j++) {
					if (tablero.matriz_con_fichas[i][j] == 0){
						wr.write("0");
					}else{
						wr.write("1");
					}
					if (j == tablero.columnas -1){
						wr.println();
					}else{
						wr.write(" ");
					}
				
				}
			}
			
			
			wr.println();
			// comprobar fichas {2,3,4,5}
			
			wr.write("Primer casillero Libre:" + " (" + tablero.proximo_casillero_libre.X + "," + 
			          tablero.proximo_casillero_libre.Y + ")");
			
			wr.println();
			
			lista_fichas.remove(f_1);
			
			for (int i = 0; i < lista_fichas.size(); i++) {
				Ficha f = lista_fichas.get(i);
				if (tablero.comprobar_ficha(f)){
					wr.write("La ficha " + f.id + " entra");
					wr.println();
				}
			}
			wr.println();
			

			//Agregar Ficha 4
			
			tablero.llenar_con_ficha(f_4);
			
			wr.write("Primer casillero Libre:" + " (" + tablero.proximo_casillero_libre.X + "," + 
			          tablero.proximo_casillero_libre.Y + ")");
			
			wr.println();
			
			wr.write("TABLERO CON FICHAS 1,4");	
			wr.println();
				//imprimir_tablero:
			for (int i = 0; i < tablero.filas; i++) {
			for (int j = 0; j < tablero.columnas; j++) {
					if (tablero.matriz_con_fichas[i][j] == 0){
						wr.write("0");
					}else{
						wr.write("1");
					}
					if (j == tablero.columnas -1){
						wr.println();
					}else{
						wr.write(" ");
					}
				
				}
			}
			wr.println();
			
			// comprobar fichas {2,3,5}
			
			wr.write("Primer casillero Libre:" + " (" + tablero.proximo_casillero_libre.X + "," + 
			          tablero.proximo_casillero_libre.Y + ")");
			
			wr.println();
			
			lista_fichas.remove(f_4);
			
			for (int i = 0; i < lista_fichas.size(); i++) {
				Ficha f = lista_fichas.get(i);
				if (tablero.comprobar_ficha(f)){
					wr.write("La ficha " + f.id + " entra");
					wr.println();
				}
			}
			wr.println();
			
			//Agregar Ficha 3
			
			tablero.llenar_con_ficha(f_3);
			
			wr.write("Primer casillero Libre:" + " (" + tablero.proximo_casillero_libre.X + "," + 
			          tablero.proximo_casillero_libre.Y + ")");
			
			wr.println();
			
			wr.write("TABLERO CON FICHAS 1,4,3");	
			wr.println();
				//imprimir_tablero:
			for (int i = 0; i < tablero.filas; i++) {
			for (int j = 0; j < tablero.columnas; j++) {
					if (tablero.matriz_con_fichas[i][j] == 0){
						wr.write("0");
					}else{
						wr.write("1");
					}
					if (j == tablero.columnas -1){
						wr.println();
					}else{
						wr.write(" ");
					}
				
				}
			}
			wr.println();
			
			//quitar casillero 3
			
			tablero.sacar_ficha_de_tablero(f_3);
			
			wr.write("Primer casillero Libre:" + " (" + tablero.proximo_casillero_libre.X + "," + 
			          tablero.proximo_casillero_libre.Y + ")");
			
			wr.println();
			
			wr.write("TABLERO CON FICHAS 1,4");	
			wr.println();
				//imprimir_tablero:
			for (int i = 0; i < tablero.filas; i++) {
			for (int j = 0; j < tablero.columnas; j++) {
					if (tablero.matriz_con_fichas[i][j] == 0){
						wr.write("0");
					}else{
						wr.write("1");
					}
					if (j == tablero.columnas -1){
						wr.println();
					}else{
						wr.write(" ");
					}
				
				}
			}
		/*	wr.println();
			//Comprobar fichas rotadas
			//imprimir_ficha:
			for (int i = 0; i < f_1.filas; i++) {
			for (int j = 0; j < f_1.columnas; j++) {
					if (f_1.matriz[i][j] == 0){
						wr.write("0");
					}else{
						wr.write("1");
					}
					if (j == f_1.columnas -1){
						wr.println();
					}else{
						wr.write(" ");
					}
				
				}
			}
			wr.println();
			
			f_1 = f_1.rotar_ficha();
			
			//imprimir_ficha:
			for (int i = 0; i < f_1.filas; i++) {
			for (int j = 0; j < f_1.columnas; j++) {
					if (f_1.matriz[i][j] == 0){
						wr.write("0");
					}else{
						wr.write("1");
					}
					if (j == f_1.columnas -1){
						wr.println();
					}else{
						wr.write(" ");
					}
				
				}
			}
			
			wr.println();
			f_1 = f_1.rotar_ficha();
			//imprimir_ficha:
			for (int i = 0; i < f_1.filas; i++) {
			for (int j = 0; j < f_1.columnas; j++) {
					if (f_1.matriz[i][j] == 0){
						wr.write("0");
					}else{
						wr.write("1");
					}
					if (j == f_1.columnas -1){
						wr.println();
					}else{
						wr.write(" ");
					}
				
				}
			}
			
			wr.println();
			f_1 = f_1.rotar_ficha();
			//imprimir_ficha:
			for (int i = 0; i < f_1.filas; i++) {
			for (int j = 0; j < f_1.columnas; j++) {
					if (f_1.matriz[i][j] == 0){
						wr.write("0");
					}else{
						wr.write("1");
					}
					if (j == f_1.columnas -1){
						wr.println();
					}else{
						wr.write(" ");
					}
				
				}
			}
			
			wr.println();
			*/
			
			wr.println();
			//Comprobar fichas rotadas f_4
			//imprimir_ficha:
			for (int i = 0; i < f_4.filas; i++) {
			for (int j = 0; j < f_4.columnas; j++) {
					if (f_4.matriz[i][j] == 0){
						wr.write("0");
					}else{
						wr.write("1");
					}
					if (j == f_4.columnas -1){
						wr.println();
					}else{
						wr.write(" ");
					}
				
				}
			}
			wr.println();
			
			f_4 = f_4.rotar_ficha();
			
			//imprimir_ficha:
			for (int i = 0; i < f_4.filas; i++) {
			for (int j = 0; j < f_4.columnas; j++) {
					if (f_4.matriz[i][j] == 0){
						wr.write("0");
					}else{
						wr.write("1");
					}
					if (j == f_4.columnas -1){
						wr.println();
					}else{
						wr.write(" ");
					}
				
				}
			}
			
			f_4 = f_4.rotar_ficha();
			
			//imprimir_ficha:
			for (int i = 0; i < f_4.filas; i++) {
			for (int j = 0; j < f_4.columnas; j++) {
					if (f_4.matriz[i][j] == 0){
						wr.write("0");
					}else{
						wr.write("1");
					}
					if (j == f_4.columnas -1){
						wr.println();
					}else{
						wr.write(" ");
					}
				
				}
			}
			
			f_4 = f_4.rotar_ficha();
			
			//imprimir_ficha:
			for (int i = 0; i < f_4.filas; i++) {
			for (int j = 0; j < f_4.columnas; j++) {
					if (f_4.matriz[i][j] == 0){
						wr.write("0");
					}else{
						wr.write("1");
					}
					if (j == f_4.columnas -1){
						wr.println();
					}else{
						wr.write(" ");
					}
				
				}
			}
			
			wr.println();
			
			output.close();
			wr.close();
			
			
		
	 	}catch(Exception e){
		   System.out.println(e);
		}
	}
	

	
	
	

}
