import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InstructionsWindow extends JFrame {
	
	String [] instructionsText = new String[5];{
		instructionsText[0] = "Game Rules 1: \n"
				+ "\n"
				+ "\n"
				+ "This game is like chess but with a twist \n"
				+ "\n"
				+ "You move your players until you try to contest  \n"
				+ "a square, at that point it becomes a battle  \n"
				+ "for who keeps their piece \n"
				+ "\n"
				+ "To win the game, you need to clear the board of AI pokemon\n"
				+ "\n"
				+ "Losing is caused when your pokemon dies\n"
				+ "\n"
				+ "";
		
	instructionsText[1] = "Game Rules 2: \n"
			+ "Each Pokemon has its own unique strengths/weaknesses, choose wisely \n"
			+ "\n"
			+ "Custom pokemon coming soon"
			+ "\n"
			+ "Click Button to go to page 3" ;
	
	instructionsText[2] = "Game Rules 3: \n"
			+ "Frequently Asked Questions:"
			+ "\n"
			+ ""
			+ "" ;
	
	}
	
	
	
	public InstructionsWindow() {
		
		JTextArea instructionsArea = new JTextArea();
		
		instructionsArea.setText(instructionsText[0]);
		
		JLabel lblInstructions = new JLabel("Instructions");
		lblInstructions.setFont(new Font("Lucida Sans", Font.BOLD, 17));
		
		JButton Close = new JButton("Close Window");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose(); // closes window
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addComponent(lblInstructions))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(instructionsArea, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(Close)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addComponent(lblInstructions)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(instructionsArea, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Close)
					.addGap(95))
		);
		getContentPane().setLayout(groupLayout);
	}
}
