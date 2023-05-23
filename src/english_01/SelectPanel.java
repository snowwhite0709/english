package english_01;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;



public class SelectPanel extends JPanel implements ActionListener{
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	JPanel panel;
	CardLayout layout;
	ArrayList<QA> list;
	private int csvNum;
	String unit;
	/**
	 * Create the panel.
	 */
	public SelectPanel(JPanel panel, CardLayout layout) {
		setLayout(null);
		this.panel = panel;
		this.layout = layout;

		btnNewButton = new JButton("文型");
		btnNewButton.setBounds(130, 130, 91, 21);
		add(btnNewButton);
		btnNewButton.addActionListener(this);		
		btnNewButton.setActionCommand("sentence");
		btnNewButton.setEnabled(true);


		btnNewButton_1 = new JButton("不定詞");
		btnNewButton_1.setBounds(230, 130, 91, 21);
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);		
		btnNewButton_1.setActionCommand("infinitive");
		btnNewButton_1.setEnabled(true);
		
		
		btnNewButton_2 = new JButton("不定詞・動名詞");
		btnNewButton_2.setBounds(130, 230, 91, 21);
		add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);		
		btnNewButton_2.setActionCommand("infinitiveVSgerund");
		btnNewButton_2.setEnabled(true);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		db.DbOperation dbo = new db.DbOperation();
		ArrayList<String> selfAnswerList = new ArrayList<>();
		System.out.println(cmd);
		
//		System.out.println("cmd:"+cmd);
		this.list = dbo.dbGetQuestion(cmd);
		switch(cmd) {
		case "sentence":
//			this.list = dbo.dbGetQuestion(cmd);
			unit = "sentence";
			for(QA qa : this.list) {
				System.out.println( qa.toString() );
			}
			break;
		case "infinitive":
			unit = "infinitive";
//			this.list = dbo.dbGetQuestion(cmd);
			for(QA qa : this.list) {
				System.out.println( qa.toString() );
			}
			break;
		case "infinitiveVSgerund":
			unit = "infinitiveVSgerund";
//			this.list = dbo.dbGetInfinitiveVsGerund(unit);
			for(QA qa : this.list) {
				System.out.println( qa.toString() );
			}
			break;
			
			
		}


		panel.add(new SubPanel(panel, layout, list, selfAnswerList, unit), "sub");
		layout.show(panel, "sub");
		//CenterPanel.layout.show(CenterPanel.panel, "sub");
//
//
//		if(cmd.equals("sentence")) {
//
//
//			//			CenterPanel.layout.show(CenterPanel.panel, "sub");
//
//
//		} else if(cmd.equals("infinitive")) {
//		}
//
//
//		//		CenterPanel.panel.add();
		
		
		
		
		



	}
	
	//ゲッター、セッター
	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public CardLayout getLayout() {
		return layout;
	}

	public void setLayout(CardLayout layout) {
		this.layout = layout;
	}

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

}
