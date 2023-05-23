package english_01;

import java.awt.CardLayout;

import javax.swing.JPanel;



public class CenterPanel extends JPanel {
	private JPanel panel ;
	private CardLayout layout;

	
	public CenterPanel() {
		//this.btnNewButton = btnNewButton;
		//cardlayout
		panel = new JPanel();
		layout = new CardLayout();
		panel.setLayout(layout);
		
		panel.add(new MainScreenPanel(), "MAIN");
		panel.add(new SelectPanel(panel, layout), "select");
		
		
	}
	
	
	
	
	//ゲッター、セッター
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public CardLayout getLayout() {
		return layout;
	}
	public void setLayout(CardLayout layout) {
		this.layout = layout;
	}



}
