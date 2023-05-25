package english_01;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BottomButton extends JPanel implements ActionListener {
	private JPanel panel ;
	private CardLayout layout;
	static JButton btnNewButton;
	private JButton btnNewButton_1;

	//コンストラクタ(引数２つ)
	public BottomButton(JPanel panel, CardLayout layout) {
		this.panel = panel;
		this.layout = layout;

		btnNewButton = new JButton("ENTER");
		add(btnNewButton);
		btnNewButton.addActionListener(this);		
		btnNewButton.setActionCommand("ENTER");
		btnNewButton.setEnabled(true);

		btnNewButton_1 = new JButton("CLOSE");
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);		
		btnNewButton_1.setActionCommand("CLOSE");
	}


	//コンストラクタ(引数梨)
	public BottomButton() {
		btnNewButton = new JButton("ENTER");
		add(btnNewButton);
		btnNewButton.addActionListener(this);		
		btnNewButton.setActionCommand("ENTER");
		btnNewButton.setEnabled(true);

		btnNewButton_1 = new JButton("CLOSE");
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);		
		btnNewButton_1.setActionCommand("CLOSE");
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("ENTER")) {
			btnNewButton.setEnabled(false);
			layout.show(panel, "select");
		} else if(cmd.equals("CLOSE")) {
			Component c = (Component)e.getSource();
			Window w = SwingUtilities.getWindowAncestor(c);
			w.dispose();
		}
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
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}
	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}
	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}
	public static void setStateButton() {
		btnNewButton.setEnabled(true);
	}


}
