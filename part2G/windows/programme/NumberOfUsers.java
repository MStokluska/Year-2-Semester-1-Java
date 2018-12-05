package programme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberOfUsers extends JFrame implements ActionListener {
	private int amountOfUsers;
	private JLabel numberOfUsersLabel;
	private JComboBox amountOfUserCombo;
	private JButton nextButton, backButton;

	public NumberOfUsers() {
		super("Select Number Of Users");
		this.setSize(570, 120);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		Container content = this.getContentPane();
		FlowLayout layout = new FlowLayout();
		//setting up background color
		Colors newBackgroundColors = new Colors();
		content.setBackground(new Color(255, 255, 255));
		if (newBackgroundColors.getRed() != 0) {
			content.setBackground(new Color(newBackgroundColors.getRed(), newBackgroundColors.getGreen(),
					newBackgroundColors.getBlue()));
		}
		numberOfUsersLabel = new JLabel("Number of Users");
		amountOfUserCombo = new JComboBox();
		nextButton = new JButton("Next");
		backButton = new JButton("Back");
		content.setLayout(layout);
		amountOfUserCombo.addItem("1");
		amountOfUserCombo.addItem("2");
		amountOfUserCombo.addItem("3");
		content.add(amountOfUserCombo);
		content.add(nextButton);
		content.add(backButton);
		nextButton.addActionListener(this);
		backButton.addActionListener(this);
		this.setContentPane(content);
	}

	public void actionPerformed(ActionEvent event) {
		String totalAmountOfUsers = amountOfUserCombo.getSelectedItem().toString();
		amountOfUsers = Integer.parseInt(totalAmountOfUsers);
//selection dependent on no of users to register selected.
		if (event.getSource() == nextButton) {
			if (amountOfUsers == 1) {
				new User1();
				this.setVisible(false);
			}
			if (amountOfUsers == 2) {
				new User2();
				this.setVisible(false);
			}
			if (amountOfUsers == 3) {
				new User3();
				this.setVisible(false);
			}
		}
		if (event.getSource() == backButton) {
			this.setVisible(false);
		}
	}
}
