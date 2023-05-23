package english_01;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuestionPanel extends JPanel {
	JTextField textField;
	ArrayList<QA> list;
	int count;
	/**
	 * Create the panel.
	 */
	public QuestionPanel(ArrayList<QA> list, int count) {
		this.list = list;
		this.count = count;
		
		
		setLayout(null);
		textField = new JTextField("sentence:"+list.get(count).getSentence());
		add(textField);
		textField.setBounds(0, 0, 450, 300);
		
//		btnNewButton_1.setBounds(230, 130, 91, 21);
		textField.setColumns(100);
		
		
		
		
	}
	
	
	//ゲッター、セッター
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public ArrayList<QA> getList() {
		return list;
	}
	public void setList(ArrayList<QA> list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
//	public QuestionPanel(int count) {
//		this.count = count;
//		
//		
//		setLayout(null);
//		textField = new JTextField("sentence:"+list.get(count));
//		add(textField);
//		textField.setBounds(0, 0, 450, 300);
//		
////		btnNewButton_1.setBounds(230, 130, 91, 21);
//		textField.setColumns(100);
//		
//		
//		
//		
//	}
	
	
}
