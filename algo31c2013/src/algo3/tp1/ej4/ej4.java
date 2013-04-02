package algo3.tp1.ej4;

import java.util.LinkedList;

import java.util.List;

public class ej4 {
	

	
	Ej4Sol solve(Tablero tablero, List<Ficha> lista_fichas) {
		 List<Integer> solucion = new LinkedList<>();;  
		 List<Integer> mejor_solucion = new LinkedList<>();; 
		 List<Integer> respuesta;
		 
		 respuesta = rellenar_tablero(solucion, tablero , lista_fichas, mejor_solucion );
		 Ej4Sol resp = new Ej4Sol(mejor_solucion, mejor_solucion.size());
		 
		 return resp;
		 
	}
	
	
	 
	List<Integer> rellenar_tablero(List<Integer> solucion, Tablero tablero, List<Ficha> fichas, List<Integer> mejor_solucion)
	 {
		
		 if (tablero.proximo_casillero_libre().Y == -1 && tablero.proximo_casillero_libre().X == -1){
			 if (solucion.size() <= mejor_solucion.size() ) {
				 mejor_solucion = solucion;
				 return mejor_solucion;
			 }
			 
		 } else {
			 List<Ficha> fichas_posibles;
			 fichas_posibles = fichas_que_entran(tablero,fichas);
			 
			 for (int i = 0; i < fichas_posibles.size(); i++) {
				 	Ficha f = fichas_posibles.get(i);
				 	tablero = tablero.llenar_con_ficha(f);
				 	solucion.add(f.id);
				    mejor_solucion = rellenar_tablero(solucion, tablero, quitar_ficha(f,fichas), mejor_solucion );
				    tablero = tablero.sacar_ficha_de_tablero(f);
				    solucion.remove(f);//esto funciona??
				    fichas.add(f);
			
			 }
			 
		 }
		 return mejor_solucion; 
	 }
	 


	 
	 //Comprueba, de la lista de fichas, las que entran en el primer casillero libre del tablero 
	 
	 List<Ficha>  fichas_que_entran(Tablero tablero, List<Ficha>  fichas){
		 
		 List<Ficha> fichas_que_entran = new LinkedList<>();
		 
		 for (int i = 0; i < fichas.size(); i++) {
			 Ficha ficha_actual;
			 ficha_actual =  fichas.get(i);
					 
			 boolean entra_ficha = false;
			 int r = 0;
			
			 //Comprueba si alguna rotación de la ficha entra
			 
			 while(r < 4 && !entra_ficha){
				 entra_ficha = tablero.comprobar_ficha(ficha_actual);
				 ficha_actual = ficha_actual.rotar_ficha();
			}
					 
			if (entra_ficha){
				fichas_que_entran.add(ficha_actual);
			}
		 }
		 return fichas_que_entran;
	 }
	 
	//Quita la ficha f de la lista de fichas 
	  List<Ficha> quitar_ficha(Ficha f, List<Ficha> lista){
		 for (int i = 0; i < lista.size(); i++) {
			 if (f.id == lista.get(i).id){
				 lista.remove(i);
			 }
		 }
		 return lista;
	 }


	public class Ej4Sol {
		List<Integer> piezas;
		int cantidad;
		
		public Ej4Sol(List<Integer> piezas, int cantidad) {
			super();
			this.piezas = piezas;
			this.cantidad = cantidad;
		}


	}

}
