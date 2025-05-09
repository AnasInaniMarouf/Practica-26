package billete;

public class BilleteTren {

	private Punto coordsOrigen, coordsDestino;
	private int precio;
	private double distancia;
	private TipoDescuento descuento, descuento2;
	
	public BilleteTren(int origenX, int origenY, int destinoX, int destinoY, TipoDescuento tipo) {
		
		this.coordsOrigen = new Punto(origenX, origenY);
		this.coordsDestino = new Punto(destinoX, destinoY);
		this.descuento = tipo;
	}

	public double getPorcentaje() {

		switch (this.descuento) {

		case MENOR_7: return 1;

		case MENOR_12: return 0.5;

		case MENOR_18: return 0.25;

		case UNIVERSITARIO: return 0.40;

		case MAYOR_65: return 0.25;

		case DESEMPLEADO: return 0.1;

		default: return 0;
		}
	}
	
	public float calculaPrecio() {
		
		float precio, kilometros = 0;
		
		if ((kilometros > 0) && (kilometros <= 20)) {
			
			precio = kilometros * 20;
			
		} else if (kilometros <= 50) {
			
			precio = kilometros * 18;
			
		} else {
			
			precio = kilometros * 16;
		}
		
		return (float) (precio - (precio * (descuento2.getDescuento() / 100)));
	}
	
	public void deglosar() {
		
		
	}
	
	

	public Punto getCoordsOrigen() {
		return coordsOrigen;
	}

	public Punto getCoordsDestino() {
		return coordsDestino;
	}

	public double getDistancia() {
		return distancia;
	}

	public TipoDescuento getDescuento() {
		return descuento;
	}

	@Override
	public String toString() {
		return "BilleteTren [coordsOrigen=" + coordsOrigen + ", coordsDestino=" + coordsDestino + ", precio=" + precio
				+ ", distancia=" + distancia + "]";
	}
	
	public String getPrecio() {
		
		float coste = this.calculaPrecio();
		
		int parteEntera = (int) coste;
		
		int parteDecimal = Math.round(coste - parteEntera) * 100;
		
		if (parteEntera == coste) {
			
			return "";
			
		} else if (parteDecimal == coste) {
			
			return "";
		}
		
		else return "";
		
	}
	
	
}
