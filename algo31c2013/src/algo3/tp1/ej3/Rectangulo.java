package algo3.tp1.ej3;

public class Rectangulo {
	Punto origen;
	int b;
	int h;
	public Rectangulo(Punto origen, int b, int h) {
		super();
		this.origen = origen;
		this.b = b;
		this.h = h;
	}
	
	public boolean contains(Punto p) {
		if (origen.x > p.x) return false;
		if (origen.x + b < p.x) return false;
		
		if (origen.y > p.y) return false;
		if (origen.y + h < p.y) return false;
		
		return true;
	}
}
