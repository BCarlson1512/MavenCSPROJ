import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Frame;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class main extends JFrame {
	
	
	// protected strings that store the player names, p1 and p2 are placeholders for now
	public static int playerChoice = 0;
	
	public main() {
		final JButton PlayBtn = new JButton("Play");
		PlayBtn.setEnabled(false);
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
		
		
		JLabel lblMainMenu = new JLabel("Main menu");
		final JLabel Todolbl = new JLabel("To activate play button:");

		final JLabel lblReadInstructions = new JLabel("Read Instructions");
		
		final JLabel lblChoosePokemon = new JLabel("Choose Starting Pokemon");
		
		final JButton btnLapis = new JButton("Lapis");
		btnLapis.setEnabled(false);
		btnLapis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			// set the pokemon choice variable to choice 1
				System.out.println(playerChoice);
				playerChoice = 1;
				
				System.out.println(playerChoice);
				// hide to do list variables, enable playability
				Todolbl.setVisible(false);
				lblChoosePokemon.setVisible(false);
				PlayBtn.setEnabled(true);
			}
		});
		btnLapis.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		final JButton btnElement = new JButton("Element");
		btnElement.setEnabled(false);
		btnElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set the pokemon choice variable to choice 2
				playerChoice = 2;
				
				// hide to do list variables, enable playability
				Todolbl.setVisible(false);
				lblChoosePokemon.setVisible(false);
				PlayBtn.setEnabled(true);
			}
		});
		btnElement.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		final JButton btnHavoc = new JButton("Havoc");
		btnHavoc.setEnabled(false);
		btnHavoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set the pokemon choice variable to choice 3
				playerChoice = 3;
				
				// hide to do list variables, enable playability
				Todolbl.setVisible(false);
				lblChoosePokemon.setVisible(false);
				PlayBtn.setEnabled(true);
			
			}
		});
		btnHavoc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		final JButton btnVirus = new JButton("Virus");
		btnVirus.setEnabled(false);
		btnVirus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				// set the pokemon choice variable to choice 5
				playerChoice = 5;
				
				// hide to do list variables, enable playability
				Todolbl.setVisible(false);
				lblChoosePokemon.setVisible(false);
				PlayBtn.setEnabled(true);
			}
		});
		btnVirus.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		final JButton btnPlexi = new JButton("Plexi");
		btnPlexi.setEnabled(false);
		btnPlexi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set the pokemon choice variable to choice 4
				playerChoice = 4;
				
				// hide to do list variables, enable playability
				Todolbl.setVisible(false);
				lblChoosePokemon.setVisible(false);
				PlayBtn.setEnabled(true);
			}
		});
		
		JButton InstructionsBtn = new JButton("Instructions");
		
		InstructionsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 InstructionsWindow w = new InstructionsWindow();
			 w.setBounds(100, 100, 400, 500);
			 w.setVisible(true);
			 
			 btnElement.setEnabled(true);
			 btnHavoc.setEnabled(true);
			 btnVirus.setEnabled(true);
			 btnPlexi.setEnabled(true);
			 btnLapis.setEnabled(true);
			 
			 lblReadInstructions.setVisible(false);
			}
		});
		
		btnPlexi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(InstructionsBtn)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Todolbl, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
									.addGap(117))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(112)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblReadInstructions)
										.addComponent(lblChoosePokemon))
									.addGap(77)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(ExitBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(PlayBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)))
							.addGap(49))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMainMenu)
							.addGap(191))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnLapis, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnElement, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnHavoc, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addComponent(btnPlexi, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnVirus, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 49, GroupLayout.PREFERRED_SIZE)))
					.addGap(92))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMainMenu)
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Todolbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(PlayBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
						.addComponent(InstructionsBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblReadInstructions)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblChoosePokemon))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ExitBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLapis)
						.addComponent(btnElement)
						.addComponent(btnHavoc))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPlexi)
						.addComponent(btnVirus))
					.addGap(44))
		);
		getContentPane().setLayout(groupLayout);
	}


	
	
	
	public static void draw() { //creates the frame 
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
