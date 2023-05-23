package english;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DownPanel extends JPanel implements ActionListener {
	static JButton btnNewButton_1;
	private JButton btnNewButton_2;
	static ArrayList<QA> qaList;
	static int startCount = 0;

	public int getStartCount() {
		return startCount;
	}




	/**
	 * Create the panel.
	 */
	public DownPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton_1 = new JButton("START");
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);		
		btnNewButton_1.setActionCommand("START");
		btnNewButton_1.setEnabled(true);
		
		btnNewButton_2 = new JButton("CLOSE");
		add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);		
		btnNewButton_2.setActionCommand("CLOSE");
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("START")) {
			btnNewButton_1.setEnabled(false);
		} else if(cmd.equals("CLOSE")) {
			Component c = (Component)e.getSource();
			Window w = SwingUtilities.getWindowAncestor(c);
			w.dispose();
		}
		Frame.layout.show(Frame.centerPanel, cmd);
		
	}

}
