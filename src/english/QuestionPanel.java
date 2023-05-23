package english;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuestionPanel extends JPanel {
	List list = new List();
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public QuestionPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		textField = new JTextField(Frame.qaList.get(QuestionButtonPanel.count).getSentence());
		add(textField);
		textField.setColumns(100);
	}

}
