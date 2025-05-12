package billete;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Vista extends JFrame{
	
	private static final long serialVersionUID = -5475590636657249833L;
	
	private JLabel titulo, X1, Y1, X2, Y2;
	private int numOrigenX = 0, numOrigenY = 0, numDestinoX = 0, numDestinoY = 0;
	private JLabel coordsOrigen, coordsDestino, tipoDescuento, descuentoAplicar, distancia, precioBillete;
	private JTextField origenX, origenY, destinoX, destinoY;
	JComboBox<TipoDescuento> descuentos;
	private JCheckBox billeteFamiliar;
	private JButton calcular, cancelar, vender;
	private int porcentaje = 0, precio = 0;
	private double kilometros = 0;
	
	
	public Vista() {
		
		super("Venta de billetes de tren");
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		panelPrincipal.setBorder(new EmptyBorder(20, 30, 20, 30));
		
		this.getContentPane().add(panelPrincipal);
		
		//
		panelPrincipal.add(this.preparaPanelTitulo());
		panelPrincipal.add(this.preparaPanelCoordenadas());
		panelPrincipal.add(this.preparaPanelDescuentos());
		panelPrincipal.add(this.preparaPanelCalculos());
		panelPrincipal.add(this.preparaPanelBotones());
	}
	
	private JPanel preparaPanelTitulo() {
		
		this.titulo = new JLabel("VENTA DE BILLETES DE TREN");
		
		Font fuenteTitulo = new Font("Times New Roman", Font.BOLD, 20);
		titulo.setFont(fuenteTitulo);
		
		JPanel panel = new JPanel();
		
		panel.add(titulo);
		
		return panel;
	}
	
	private JPanel preparaPanelCoordenadas() {
		
		this.coordsOrigen = new JLabel("Coordenadas de origen: ");
		this.X1 = new JLabel("X");
		this.origenX = new JTextField(this.numOrigenX + "");
		this.Y1 = new JLabel("Y");
		this.origenY = new JTextField(this.numOrigenY + "");
		this.coordsDestino = new JLabel("Coordenadas de destino: ");
		this.X2 = new JLabel("X");
		this.destinoX = new JTextField(this.numDestinoX + "");
		this.Y2 = new JLabel("Y");
		this.destinoY = new JTextField(this.numDestinoY + "");
		
		origenX.setPreferredSize(new Dimension(40, 20));
		origenY.setPreferredSize(new Dimension(40, 20));
		destinoX.setPreferredSize(new Dimension(40, 20));
		destinoY.setPreferredSize(new Dimension(40, 20));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Indique las coordenadas origen/destino"));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//Norte
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(panel1);
		panel1.add(coordsOrigen);
		panel1.add(X1);
		panel1.add(origenX);
		panel1.add(Y1);
		panel1.add(origenY);
		
		//Sur
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(panel2);
		panel2.add(coordsDestino);
		panel2.add(X2);
		panel2.add(destinoX);
		panel2.add(Y2);
		panel2.add(destinoY);
		
		return panel;
	}
	
	private JPanel preparaPanelDescuentos() {
		
		TipoDescuento [] array = TipoDescuento.values();
		
		this.tipoDescuento = new JLabel("Tipo descuento");
		this.descuentos = new JComboBox<TipoDescuento>(array);
		this.billeteFamiliar = new JCheckBox("Billete familiar");
		this.descuentoAplicar = new JLabel("Descuento a aplicar: " + this.porcentaje + "%");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Posibles descuentos"));
		
		panel.add(tipoDescuento);
		panel.add(descuentos);
		panel.add(billeteFamiliar);
		panel.add(descuentoAplicar);
		
		return panel;
	}
	
	private JPanel preparaPanelCalculos() {
		
		this.distancia = new JLabel("Distancia: "+ this.kilometros + " km");
		this.precioBillete = new JLabel("Precio billete: " + this.precio + " €");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Distancia y precio a pagar"));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel.add(panel1);
		panel1.add(distancia);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel.add(panel2);
		panel2.add(precioBillete);
		
		return panel;
	}
	
	private JPanel preparaPanelBotones() {
		
		this.calcular = new JButton("Calcular");
		this.cancelar = new JButton("Cancelar");
		this.vender = new JButton("Vender billete");
		
		JPanel panel = new JPanel();
		
		panel.add(calcular);
		panel.add(cancelar);
		panel.add(vender);
		
		return panel;
	}
	
	public void control(Controlador ctr) {

		this.billeteFamiliar.addItemListener(ctr);
		this.descuentos.addItemListener(ctr);
		this.calcular.addActionListener(ctr);
		this.cancelar.addActionListener(ctr);
		this.vender.addActionListener(ctr);
	}
	
	
	/*
	 * Metodos getter
	 */
	
	public JCheckBox getBilleteFamiliar() {return billeteFamiliar;}

	public JButton getCalcular() {return calcular;}

	public JButton getCancelar() {return cancelar;}

	public JButton getVender() {return vender;}

	public JLabel getTitulo() {return titulo;}

	public JLabel getDescuentoAplicar() {return descuentoAplicar;}

	public JComboBox<TipoDescuento> getDescuentos() {return descuentos;}

	public int getPorcentaje() {return porcentaje;}
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JLabel getX1() {
		return X1;
	}

	public JLabel getY1() {
		return Y1;
	}

	public JLabel getX2() {
		return X2;
	}

	public JLabel getY2() {
		return Y2;
	}

	public JLabel getCoordsOrigen() {
		return coordsOrigen;
	}

	public JLabel getCoordsDestino() {
		return coordsDestino;
	}

	public JLabel getTipoDescuento() {
		return tipoDescuento;
	}

	public JLabel getDistancia() {
		return distancia;
	}

	public JLabel getPrecioBillete() {
		return precioBillete;
	}

	public JTextField getOrigenX() {
		return origenX;
	}

	public JTextField getOrigenY() {
		return origenY;
	}

	public JTextField getDestinoX() {
		return destinoX;
	}

	public JTextField getDestinoY() {
		return destinoY;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public double getKilometros() {
		return kilometros;
	}

	public int getPrecio() {
		return precio;
	}

	public void setKilometros(double d) {
		this.kilometros = d;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getNumOrigenX() {
		return numOrigenX;
	}

	public int getNumOrigenY() {
		return numOrigenY;
	}

	public int getNumDestinoX() {
		return numDestinoX;
	}

	public int getNumDestinoY() {
		return numDestinoY;
	}

	public void setNumOrigenX(int numOrigenX) {
		this.numOrigenX = numOrigenX;
	}

	public void setNumOrigenY(int numOrigenY) {
		this.numOrigenY = numOrigenY;
	}

	public void setNumDestinoX(int numDestinoX) {
		this.numDestinoX = numDestinoX;
	}

	public void setNumDestinoY(int numDestinoY) {
		this.numDestinoY = numDestinoY;
	}
	
	
	
	
	
	
	
	
	
}
