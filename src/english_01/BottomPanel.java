package english_01;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class BottomPanel extends JPanel {
//	private JPanel panel;
//	private CardLayout layout;
	/**
	 * Create the panel.
	 */
	public BottomPanel(JPanel panel, CardLayout layout) {
//		this.panel = panel;
//		this.layout = layout;
		BottomButton btn = new BottomButton(panel, layout);
		add(btn);

		
		
	}
	
//	public BottomPanel() {
//		BottomButton btn = new BottomButton(panel, layout);
//		add(btn);
//
//		
//		
//	}
}
