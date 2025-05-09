package billete;

public class Tests {

	public static void main(String[] args) {
		
		TipoDescuento [] array = TipoDescuento.values();
		
		for (TipoDescuento tipo : array) {
			
			System.out.println(tipo);
		}
	}

}
