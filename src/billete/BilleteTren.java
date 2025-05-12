package billete;

public class BilleteTren {

    private Punto coordsOrigen, coordsDestino;
    private double distancia;
    private TipoDescuento descuento;
    private Vista vista;

    
    public BilleteTren(int origenX, int origenY, int destinoX, int destinoY, TipoDescuento tipo) {
    	
        this.coordsOrigen = new Punto(origenX, origenY);
        this.coordsDestino = new Punto(destinoX, destinoY);
        this.descuento = tipo;
        this.distancia = calcularDistancia();
    }
    
    public BilleteTren() {
    	
    	vista = new Vista();
    	
    	this.coordsOrigen = new Punto(vista.getNumOrigenX(), vista.getNumOrigenY());
    	this.coordsDestino = new Punto(vista.getNumDestinoX(), vista.getNumDestinoY());
    	this.distancia = calcularDistancia();
    }

    private double calcularDistancia() {
    	
        int dX = (int) Math.pow((vista.getNumDestinoX() - vista.getNumOrigenX()), 2);
        int dY = (int) Math.pow(vista.getNumDestinoY() - vista.getNumOrigenY(), 2);
        
        return Math.sqrt(dX + dY);
    }

    public double getPorcentaje() {
    	
        return descuento.getDescuento() / 100.0;
    }

    
    public float calculaPrecio() {
    	
        float precioBase;
        
        if (distancia <= 20) {
        	
            precioBase = (float) (distancia * 0.20);

        } else if (distancia <= 50) {
        	
            precioBase = (float) (distancia * 0.18);
            
        } else {
        	
            precioBase = (float) (distancia * 0.16);
        }

        return (float) (precioBase * (1 - this.getPorcentaje()));
    }


    public String getPrecio() {
    	
        float coste = this.calculaPrecio();
        int euros = (int) coste;
        int centimos = Math.round((coste - euros) * 100);
        
        return euros + "€ con " + centimos + " céntimos";
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
    	
        return "BilleteTren [coordsOrigen=" + coordsOrigen + ", coordsDestino=" + coordsDestino + ", precio=" + getPrecio() + ", distancia=" + distancia + " km]";
    }
}
