package english;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {

	static JPanel contentPane;
	static JPanel centerPanel; //login
	static CardLayout layout;  //カードレイアウト
	static ArrayList<QA> qaList;
	static ArrayList<String> selfAnswerList = new ArrayList<>();
	static int csvNum=1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}




	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);



		centerPanel = new JPanel();
		layout = new CardLayout();
		centerPanel.setLayout(layout);
		//↑cardlayout


		DbOperation db = new DbOperation();
		int num = db.dbGetCount();
		int[] array = db.array(num);
		qaList = db.dbGetQA(array);	


		for(QA qa : qaList) {
			System.out.println("============");
			System.out.println(qa.toString());
		}



		centerPanel.add(new MainPanel(), "MAIN");
		centerPanel.add(new SubPanel(), "START");
		centerPanel.add(new ResultPanel(), "RESULT");


		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(centerPanel, BorderLayout.CENTER);


		JPanel topPanel = new TopPanel();
		contentPane.add(topPanel,BorderLayout.NORTH);
		
		
		JPanel downPanel = new DownPanel();
		contentPane.add(downPanel, BorderLayout.SOUTH);
		
		
		


	}
}	
