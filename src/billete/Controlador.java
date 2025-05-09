package billete;

import java.awt.event.*;

public class Controlador implements ActionListener, ItemListener{

	private Vista vista = new Vista();
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		//if (vista.getDescuentos())
		
		if (e.getSource() == vista.getBilleteFamiliar()) {

			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == vista.getCalcular()) {
			
			
		}
	}

}
