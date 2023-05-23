package english_01;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TopPanel extends JPanel {
	private JTextField txtEnglishTest;


	/**
	 * Create the panel.
	 */
	public TopPanel() {		
		txtEnglishTest = new JTextField();
		txtEnglishTest.setText("English Test");
		txtEnglishTest.setEditable(false);  //テキスト編集不可
		txtEnglishTest.setHorizontalAlignment(JTextField.CENTER);  //テキストを中央揃え
		txtEnglishTest.setBorder(null);  //枠線を消す
		add(txtEnglishTest);
		txtEnglishTest.setColumns(100);
		

	}

}
