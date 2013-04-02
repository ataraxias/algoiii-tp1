package algo3.tp1.ej4;

import java.util.LinkedList;
import java.util.List;

public class Tablero {
	int filas;
	int columnas;
	int [][] matriz;
	int [][] matriz_con_fichas;
	Coordenada proximo_casillero_libre;
	//Lista con las coordenadas donde empieza una ficha
	List<Coordenada> posiciones_ficha;
	
	public Tablero(int filas, int columnas, int[][] matriz) {
		super();
		this.filas = filas;
		this.columnas = columnas;
		this.matriz = matriz;
		this.matriz_con_fichas = new int[this.filas][this.columnas];
		this.proximo_casillero_libre = new Coordenada(0,0);
		this.posiciones_ficha = new LinkedList<>();
		 
	}
	
	//Agrega la ficha f en el tablero
	public Tablero llenar_con_ficha(Ficha f){
		
		 Coordenada prox_pieza = this.proximo_casillero_libre;
		 int h =0;
		 int t= 0;
		 for (h = prox_pieza.X; h < prox_pieza.X  + f.filas; h++) {
			 for (t = prox_pieza.Y; t < prox_pieza.Y  + f.columnas; t++) {
				 this.matriz_con_fichas[h][t] = 1;
				 
			 }
		 }
		 this.posiciones_ficha.add(this.proximo_casillero_libre);
		 this.proximo_casillero_libre = proximo_casillero_libre();
	
		 return this;
	 }
	 
	//Saca la ficha f (que debe ser la ultima ficha agregada) del tablero
	 public Tablero sacar_ficha_de_tablero(Ficha f){
		 
		 Coordenada coord_pieza = this.posiciones_ficha.get(posiciones_ficha.size()-1);
		 
		 int h =0;
		 int t= 0;
		 for (h = coord_pieza.X; h < coord_pieza.X  + f.filas; h++) {
			 for (t = coord_pieza.Y; t < coord_pieza.Y  + f.columnas; t++) {
				 this.matriz_con_fichas[h][t] = 0;
				 
			 }
		 }
		 this.proximo_casillero_libre = proximo_casillero_libre();
		 this.posiciones_ficha.remove(coord_pieza);
		 return this;
	 }

	 // Se fija si la Ficha "ficha" entra en la proxima pieza libre del tablero 
	 public boolean comprobar_ficha(Ficha ficha){
		 
		 Coordenada pieza_libre = this.proximo_casillero_libre;
		 boolean entra_ficha = true;
		 
		 if (this.Comprobar_tamanio_ficha(ficha) ) {
			 for (int h = pieza_libre.X; h < pieza_libre.X + ficha.filas; h++) {
				 for (int t = pieza_libre.Y; t < pieza_libre.Y  + ficha.columnas; t++) {
				 
					 boolean color_incorrecto;
					 boolean ocupado;
				 
					 ocupado = this.matriz_con_fichas[h][t] == 1;
					 color_incorrecto = ficha.matriz[h-pieza_libre.X][t-pieza_libre.Y] != this.matriz[h][t];
				 
					 if (color_incorrecto || ocupado ){
						 t = pieza_libre.Y  + ficha.columnas;
						 h = pieza_libre.X  + ficha.filas;
						 entra_ficha = false;
					 }
				 }
			 }
			 
		 } else {
			 entra_ficha = false;
		 }
		 return entra_ficha;
		 
	 }
	 
	 
	 
	 
	 //comprueba si la ficha f no se "sale" del tablero
	 public boolean Comprobar_tamanio_ficha(Ficha f){
		 
		 Coordenada pieza_libre = this.proximo_casillero_libre;
		 boolean respuesta = false;
		 
		 //Si la ficha No se va del ancho del tablero
		 if (f.columnas <= this.columnas - pieza_libre.X ) {
			 //Si la ficha No se va del alto del tablero
			 if (f.filas <= this.filas - pieza_libre.X){
				 respuesta = true;
			 }
		 }
		 return respuesta;
	 }
	 
	 public Coordenada proximo_casillero_libre(){
		 
		 Coordenada C = new Coordenada(-1,-1);
		 
		 for (int i = 0; i < this.filas; i++) {
			 for (int j = 0; j < this.columnas; j++) {
				 if (this.matriz_con_fichas[i][j] == 0){
					 C = new Coordenada(i,j); 
					 j= this.columnas;
					 i = this.filas;
				 }
			 }
		 }
		 return C;
	 }

}
