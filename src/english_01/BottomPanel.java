package english_01;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class BottomPanel extends JPanel {

	
	public BottomPanel(JPanel panel, CardLayout layout) {
		BottomButton btn = new BottomButton(panel, layout);
		add(btn);
	}
	
}
