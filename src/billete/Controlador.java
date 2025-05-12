package billete;

import java.awt.event.*;

public class Controlador implements ActionListener, ItemListener{

	private Vista vista;
	private BilleteTren billeteTren;
	
	public Controlador (Vista v, BilleteTren b) {
		
		this.vista = v;
		this.billeteTren = b;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if (e.getSource() == vista.getBilleteFamiliar() || e.getSource() == vista.getDescuentos()) {

			TipoDescuento selected = (TipoDescuento) vista.getDescuentos().getSelectedItem();
			
	        int descuentoBase = selected.getDescuento();
	        int descuentoTotal = vista.getBilleteFamiliar().isSelected() ? descuentoBase + 25 : descuentoBase;

	        vista.setPorcentaje(descuentoTotal);
	        vista.getDescuentoAplicar().setText("Descuento a aplicar: " + vista.getPorcentaje() + "%");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == vista.getCalcular()) {
			
			vista.setKilometros(this.billeteTren.getDistancia());
			vista.getDistancia().setText("Distancia: "+ vista.getKilometros() + " km");
		}
		
		if (e.getSource() == vista.getCancelar()) {
			
			vista.getBilleteFamiliar().setSelected(false);
			
			vista.setPorcentaje(0);
			vista.getDescuentoAplicar().setText("Descuento a aplicar: " + vista.getPorcentaje() + "%");
			
			vista.getOrigenX().setText("0");
			vista.getOrigenY().setText("0");
			vista.getDestinoX().setText("0");
			vista.getDestinoY().setText("0");
			
			
			
			vista.setKilometros(0);
			vista.getDistancia().setText("Distancia: "+ vista.getKilometros() + " km");
			
			vista.setPrecio(0);
			vista.getPrecioBillete().setText("Precio billete: " + vista.getPrecio() + " €");
		}
	}

}
