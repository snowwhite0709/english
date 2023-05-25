package english_01;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ResultPanel extends JPanel {
	JTextField textField;

	public ResultPanel(int correctCount) {
		setLayout(new BorderLayout(0, 0));
		textField = new JTextField("正解数："+correctCount);
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setBorder(null);
		add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\3030855\\Desktop\\mikan.jpg"));
		add(lblNewLabel, BorderLayout.CENTER);
	}

}
