package english_01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainScreenPanel extends JPanel {
	
	public MainScreenPanel() {
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\3030855\\Desktop\\apple.jpg"));
		add(lblNewLabel);
	}

}
