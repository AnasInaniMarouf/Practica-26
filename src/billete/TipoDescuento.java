package billete;

public enum TipoDescuento {

	MENOR_7(100), MENOR_12(50), MENOR_18(25), UNIVERSITARIO(40), MAYOR_65(25), DESEMPLEADO(10);
	
	private int descuento;
	
	TipoDescuento(int i) {
		
		i = this.descuento;
	}

	public int getDescuento() {
		
		return descuento;
	}	
	
	
}
