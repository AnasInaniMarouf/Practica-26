package billete;

public class Punto {

	private int x, y;
	
	public Punto() {
		
	}
	
	public Punto(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	public double distancia(Punto otroPunto) {
		
		double distanciaX = Math.pow((otroPunto.getX() - this.x), 2);
		double distanciaY = Math.pow((otroPunto.getY() - this.y), 2);
		
		return Math.sqrt((distanciaX) + (distanciaY));
	}
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	@Override
	public String toString() {
		
		return "Punto X: " + this.x + "\nPunto Y: " + this.y;
	}
	
	
}
