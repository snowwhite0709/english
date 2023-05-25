package english_01;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {
	
	
	
	JPanel contentPane;
	JPanel panel; //
	CardLayout layout;  //カードレイアウト
	public static int csvNum = 0;
	
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

	
	
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//パネル作成・追加
		JPanel top = new TopPanel();
		CenterPanel center = new CenterPanel();
		JPanel bottom = new BottomPanel(center.getPanel(), center.getLayout());
		contentPane.add(top, BorderLayout.NORTH);
		contentPane.add(center.getPanel(), BorderLayout.CENTER);
		contentPane.add(bottom, BorderLayout.SOUTH);
	}

}
