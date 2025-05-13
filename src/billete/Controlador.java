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
			
			int origenX = Integer.parseInt(vista.getOrigenX().getText());
			int origenY = Integer.parseInt(vista.getOrigenY().getText());
			int destinoX = Integer.parseInt(vista.getDestinoX().getText());
			int destinoY = Integer.parseInt(vista.getDestinoY().getText());
			
			billeteTren = new BilleteTren(origenX, origenY, destinoX, destinoY, TipoDescuento.SIN_DESCUENTO);
			
			System.out.println(billeteTren.toString());
			
			int distancia = (int) billeteTren.getDistancia();
			
			vista.getDistancia().setText("Distancia: "+ billeteTren.getDistancia() + " km");
			vista.getPrecioBillete().setText("Precio: " + vista.getPrecio() + " €");
			
			/*
			vista.setNumOrigenX(Integer.parseInt(vista.getOrigenX().getText()));
			vista.setNumOrigenY(Integer.parseInt(vista.getOrigenY().getText()));
			vista.setNumDestinoX(Integer.parseInt(vista.getDestinoX().getText()));
			vista.setNumDestinoY(Integer.parseInt(vista.getDestinoY().getText()));
			
			vista.setKilometros(this.billeteTren.calcularDistancia());
			vista.getDistancia().setText("Distancia: "+ vista.getKilometros() + " km");
			*/
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
