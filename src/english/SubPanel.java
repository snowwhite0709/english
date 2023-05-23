package english;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class SubPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SubPanel() {
		setLayout(new BorderLayout(0, 0));
		
		//問題文表示パネル
		JPanel qp = new QuestionPanel();
		add(qp, BorderLayout.CENTER);
		
		//選択ボタン表示パネル
		JPanel qbp = new QuestionButtonPanel();
		add(qbp, BorderLayout.SOUTH);

	}
}
