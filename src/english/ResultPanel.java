package english;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ResultPanel extends JPanel {
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public ResultPanel() {
		setLayout(new BorderLayout(0, 0));
		textField = new JTextField("正解数："+QuestionButtonPanel.correctCount);
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setBorder(null);
		add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\3030855\\Desktop\\mikan.jpg"));
		add(lblNewLabel, BorderLayout.CENTER);
		QuestionButtonPanel.correctCount = 0;
		QuestionButtonPanel.count = 0;
	}

}
