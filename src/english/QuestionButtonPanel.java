package english;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class QuestionButtonPanel extends JPanel implements ActionListener{
	static int count = 0;
	static int answerCount = 0;
	static int correctCount = 0;
	
	ArrayList<Integer> list = new ArrayList<>();
	/**
	 * Create the panel.
	 */
	public QuestionButtonPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton_1 = new JButton("1");
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);		
		btnNewButton_1.setActionCommand("1");

		JButton btnNewButton_2 = new JButton("2");
		add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);		
		btnNewButton_2.setActionCommand("2");
				
		JButton btnNewButton_3 = new JButton("3");
		add(btnNewButton_3);
		btnNewButton_3.addActionListener(this);		
		btnNewButton_3.setActionCommand("3");
		
		JButton btnNewButton_4 = new JButton("4");
		add(btnNewButton_4);
		btnNewButton_4.addActionListener(this);		
		btnNewButton_4.setActionCommand("4");
		
		JButton btnNewButton_5 = new JButton("5");
		add(btnNewButton_5);
		btnNewButton_5.addActionListener(this);		
		btnNewButton_5.setActionCommand("5");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//自分の答えをリストに追加
		Frame.selfAnswerList.add(e.getActionCommand());
		
		//正解・不正解の判定
		if( Frame.qaList.get(count).getAnswer().equals( e.getActionCommand())) {
			correctCount++;
		}
		
		//countをインクリメント(問題数をカウント)
		count++;
		if(count==5) {
			//「START」ボタンを押下可能に
			DownPanel.btnNewButton_1.setEnabled(true);			
			//DB関係（次の問題を取得）
			DbOperation db = new DbOperation();
			int num = db.dbGetCount();
			int[] array = db.array(num);
			Frame.qaList = db.dbGetQA(array);	
			//CSV関係
			CSV.exportCsv(Frame.qaList, Frame.selfAnswerList, correctCount);
			
			//次の問題の一覧を表示
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			for(QA qa : Frame.qaList) {
				System.out.println("============");
				System.out.println(qa.toString());
			}
			
			//今回の問題の自分の答えを表示
			System.out.println("=====自分の答え=======");
			for(String answer : Frame.selfAnswerList) {
				System.out.println(answer);
			}
			
			//結果ページを表示
			Frame.centerPanel.add(new ResultPanel(), "RESULT");
			Frame.layout.show(Frame.centerPanel, "RESULT");
			Frame.selfAnswerList.clear();
			list.clear();			
		} else {
			//次の問題のページを表示
			Frame.centerPanel.add(new SubPanel(), "Q");
			Frame.layout.show(Frame.centerPanel, "Q");
		}
	}
	
	
	
}
