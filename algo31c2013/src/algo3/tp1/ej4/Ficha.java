package algo3.tp1.ej4;

import java.util.List;

public class Ficha {
	int id;
	int filas;
	int columnas;
	int [][] matriz;
	int rotaciones;
	
	public Ficha(int id, int filas, int columnas, int[][] matriz) {
		super();
		this.id = id;
		this.filas = filas;
		this.columnas = columnas;
		this.matriz = matriz;
		this.rotaciones = 0;
	}
	 

	 
	 //Rota la ficha 45°
	 public Ficha rotar_ficha(){
		 
		 int filas_nueva_ficha = this.columnas;
		 int columnas_nueva_ficha = this.filas;
		 int [][] matriz_nueva_ficha = new int[filas_nueva_ficha][columnas_nueva_ficha];
		 Ficha nueva_ficha;
		 int i = 0;
		 int j = this.columnas-1;
		 for (i = 0; i < this.filas; i++) {
			 for (j = this.columnas-1; j >= 0; j--) {
				 matriz_nueva_ficha[filas_nueva_ficha - j -1][i] = this.matriz[i][j];
			 }
		 }
		 nueva_ficha = new Ficha(this.id,filas_nueva_ficha,columnas_nueva_ficha,matriz_nueva_ficha);
		 
		 if (this.rotaciones == 0){
			 this.rotaciones = 3;
		 }else{
			 this.rotaciones -= 1;
		 }
		
		 return nueva_ficha;
	 }
	 
	 
	 public int cantidad_Rotaciones(){
		return this.rotaciones; 
	 }
}