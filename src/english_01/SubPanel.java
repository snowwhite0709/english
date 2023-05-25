package english_01;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class SubPanel extends JPanel {
	JPanel panelCenter;
	CardLayout layoutCenter;
	JPanel panelSub;
	CardLayout layoutSub;
	ArrayList<QA> list;
	ArrayList<String> selfAnswerList;	
	int count = 0;
	int csvNum;
	String unit;
	
	public SubPanel(JPanel panelCenter, CardLayout layoutCenter, ArrayList<QA> list, ArrayList<String> selfAnswerList, String unit) {
		this.panelCenter = panelCenter;
		this.layoutCenter = layoutCenter;
		this.list = list;
		this.selfAnswerList = selfAnswerList;
		setLayout(new BorderLayout(0, 0));
		this.unit = unit;
		
		panelSub = new JPanel();
		layoutSub = new CardLayout();
		panelSub.setLayout(layoutSub);;
		panelSub.add(new QuestionPanel(list, count));
		
		add(panelSub, BorderLayout.CENTER);
		
		switch(this.unit) {
		case "sentence":
			AbstractButtonPanel.SentenceButtonPanel sentenceBtn = new AbstractButtonPanel.SentenceButtonPanel(this.panelCenter, this.layoutCenter, this.panelSub, this.layoutSub, this.list, this.selfAnswerList, count);
			add(sentenceBtn, BorderLayout.SOUTH);
			break;
		case "infinitive":
			AbstractButtonPanel.InfinitiveButtonPanel infinitiveBtn = new AbstractButtonPanel.InfinitiveButtonPanel(this.panelCenter, this.layoutCenter, this.panelSub, this.layoutSub, this.list, this.selfAnswerList, count);
			add(infinitiveBtn, BorderLayout.SOUTH);
			break;
		case "infinitiveVSgerund":
			AbstractButtonPanel.InfinitiveVsGerundButtonPanel infinitiveVSgerundBtn = new AbstractButtonPanel.InfinitiveVsGerundButtonPanel(this.panelCenter, this.layoutCenter, this.panelSub, this.layoutSub, this.list, this.selfAnswerList, count);
			add(infinitiveVSgerundBtn, BorderLayout.SOUTH);
			break;
		}
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
}	