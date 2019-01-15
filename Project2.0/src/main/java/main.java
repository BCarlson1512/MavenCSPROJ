import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Frame;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JFrame {
	
	
	// protected strings that store the player names, p1 and p2 are placeholders for now
	protected String player1Name = "p1";
	protected String player2Name = "p2";
	
	
	public main() {
		
		
		
		
		
		JButton InstructionsBtn = new JButton("Instructions");
		InstructionsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 InstructionsWindow w = new InstructionsWindow();
			 w.setBounds(100, 100, 400, 500);
			 w.setVisible(true);
			}
		});
		
		JButton button = new JButton("New button");
		
		JButton PlayBtn = new JButton("Play");
		PlayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			GameScreen g = new GameScreen();
			g.setBounds(100,100, 600, 600);
			g.setVisible(true);
			
			
			}
		});
		
		JButton ExitBtn = new JButton("Exit");
		ExitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				System.exit(0);
				
			}
		});
		
		JLabel lblInsertGraphics = new JLabel("Insert Graphics");
		
		JLabel lblMainMenu = new JLabel("Main menu");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(InstructionsBtn)
								.addComponent(button))
							.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
							.addComponent(lblInsertGraphics)
							.addGap(84)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(PlayBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(ExitBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMainMenu)
							.addGap(191))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMainMenu)
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(InstructionsBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(PlayBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblInsertGraphics)
								.addComponent(ExitBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))))
		);
		getContentPane().setLayout(groupLayout);
	}

	public static void createBoard() { // one of few intialize functions
		
	}
	
	public static void restart(){ // reset function for replayability 
		
	}
	
	public static void draw() { //creates the frame - eclipse doesnt autocreate this method
			try {
				

				main frame = new main();
				frame.setBounds(100, 100, 450, 400);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	

	public static void main(String[] args) {
		draw();
		

		
	}
}
