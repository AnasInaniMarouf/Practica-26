package billete;

import java.awt.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		Vista vista = new Vista();
		BilleteTren billete = new BilleteTren(10, 10, 10, 10, null);
		
		Controlador ctr = new Controlador(vista, billete);
		vista.control(ctr);
		
		vista.setPreferredSize(new Dimension(600, 400));
		vista.pack();
		vista.setResizable(false);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
