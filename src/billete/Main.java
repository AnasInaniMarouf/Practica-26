package billete;

import java.awt.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		Vista vista = new Vista();
		
		vista.setPreferredSize(new Dimension(600, 400));
		vista.pack();
		vista.setResizable(false);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
