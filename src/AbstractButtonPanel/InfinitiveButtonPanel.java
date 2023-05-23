package AbstractButtonPanel;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import english_01.Frame;
import english_01.QA;
import english_01.QuestionPanel;
import english_01.ResultPanel;
public class InfinitiveButtonPanel extends JPanel implements ActionListener {

	
	//	ArrayList<Integer> list = new ArrayList<>();
	JPanel panelCenter;
	CardLayout layoutCenter;
	JPanel panelSub;
	CardLayout layoutSub;
	ArrayList<QA> list;
	ArrayList<String> selfAnswerList;
	int count;
	int correctCount;
	/**
	 * Create the panel.
	 */
	public InfinitiveButtonPanel(JPanel panelCenter, CardLayout layoutCenter, JPanel panelSub, CardLayout layoutSub, ArrayList<QA> list, ArrayList<String> selfAnswerList, int count) {
		this.panelCenter = panelCenter;
		this.layoutCenter = layoutCenter;
		this.panelSub = panelSub;
		this.layoutSub = layoutSub;
		this.list = list;
		this.selfAnswerList = selfAnswerList;
		this.count = count;
		

		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton_1 = new JButton("名詞的用法");
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);		
		btnNewButton_1.setActionCommand("名詞的用法");

		JButton btnNewButton_2 = new JButton("形容詞的用法");
		add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);		
		btnNewButton_2.setActionCommand("形容詞的用法");

		JButton btnNewButton_3 = new JButton("副詞的用法");
		add(btnNewButton_3);
		btnNewButton_3.addActionListener(this);		
		btnNewButton_3.setActionCommand("副詞的用法");

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//自分の答えをリストに追加
		selfAnswerList.add(e.getActionCommand());
		//正解・不正解の判定
		if( list.get(count).getAnswer().equals( e.getActionCommand())) {
			correctCount++;
		}

		System.out.println("correctCount:"+correctCount);

		if(count<=3) {
			this.count++;
			panelSub.add(new QuestionPanel(list, count), "panel");
			layoutSub.show(panelSub, "panel");
			System.out.println("count:"+this.count);
			//
		} else {
			panelCenter.add(new ResultPanel(correctCount), "result");
			layoutCenter.show(panelCenter, "result");
			System.out.println("correctCount:"+correctCount);
			//
			Frame.csvNum++;
			//CSV	
			String unit = "不定詞";
			csv.CsvWriter.exportCsv(list, selfAnswerList, correctCount, Frame.csvNum, unit);
			//「START」ボタンを押下可能に	
			english_01.BottomButton.setStateButton();
			
			//今回の問題の自分の答えを表示
			System.out.println("=====自分の答え=======");
			for(String answer : selfAnswerList) {
				System.out.println(answer);
			}


		}


		//		//countをインクリメント(問題数をカウント)
		//		count++;
		//		if(count==5) {
		//			//「START」ボタンを押下可能に
		//			DownPanel.btnNewButton_1.setEnabled(true);			
		//			//DB関係（次の問題を取得）
		//			DbOperation db = new DbOperation();
		//			int num = db.dbGetCount();
		//			int[] array = db.array(num);
		//			Frame.qaList = db.dbGetQA(array);	
		//			//CSV関係
		//			CSV.exportCsv(Frame.qaList, Frame.selfAnswerList, correctCount);
		//
		//			//次の問題の一覧を表示
		//			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		//			for(QA qa : Frame.qaList) {
		//				System.out.println("============");
		//				System.out.println(qa.toString());
		//			}
		//
		//			//今回の問題の自分の答えを表示
		//			System.out.println("=====自分の答え=======");
		//			for(String answer : Frame.selfAnswerList) {
		//				System.out.println(answer);
		//			}
		//
		//			//結果ページを表示
		//			Frame.centerPanel.add(new ResultPanel(), "RESULT");
		//			Frame.layout.show(Frame.centerPanel, "RESULT");
		//			Frame.selfAnswerList.clear();
		//			list.clear();			
		//		} else {
		//			//次の問題のページを表示
		//			Frame.centerPanel.add(new SubPanel(), "Q");
		//			Frame.layout.show(Frame.centerPanel, "Q");
		//		}
	}




	//ゲッター、セッター
	public JPanel getPanelCenter() {
		return panelCenter;
	}


	public void setPanelCenter(JPanel panelCenter) {
		this.panelCenter = panelCenter;
	}


	public CardLayout getLayoutCenter() {
		return layoutCenter;
	}


	public void setLayoutCenter(CardLayout layoutCenter) {
		this.layoutCenter = layoutCenter;
	}


	public JPanel getPanelSub() {
		return panelSub;
	}


	public void setPanelSub(JPanel panelSub) {
		this.panelSub = panelSub;
	}


	public CardLayout getLayoutSub() {
		return layoutSub;
	}


	public void setLayoutSub(CardLayout layoutSub) {
		this.layoutSub = layoutSub;
	}


	public ArrayList<QA> getList() {
		return list;
	}


	public void setList(ArrayList<QA> list) {
		this.list = list;
	}


	public ArrayList<String> getSelfAnswerList() {
		return selfAnswerList;
	}


	public void setSelfAnswerList(ArrayList<String> selfAnswerList) {
		this.selfAnswerList = selfAnswerList;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getCorrectCount() {
		return correctCount;
	}


	public void setCorrectCount(int correctCount) {
		this.correctCount = correctCount;
	}









}
