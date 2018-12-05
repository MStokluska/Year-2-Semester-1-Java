package programme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//window that pops up if 1 user is selected.
public class User1 extends JFrame implements ActionListener {
	private JLabel userName, userPassword;
	private JTextField userNameField, userPasswordField;
	private JButton generateButton, backButton;
	private User userOne;

	public User1() {
		super("Enter Details");
		this.setSize(700, 120);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		Container content = this.getContentPane();
		FlowLayout layout = new FlowLayout();
		Colors newBackgroundColors = new Colors();
		content.setBackground(new Color(255, 255, 255));
		if (newBackgroundColors.getRed() != 0) {
			content.setBackground(new Color(newBackgroundColors.getRed(), newBackgroundColors.getGreen(),
					newBackgroundColors.getBlue()));
		}
		userName = new JLabel("User Name");
		userNameField = new JTextField("", 20);
		userPassword = new JLabel("User Password");
		userPasswordField = new JTextField("", 20);
		generateButton = new JButton("Generate");
		backButton = new JButton("Back");
		userOne = new User();
		content.setLayout(layout);
		content.add(userName);
		content.add(userNameField);
		content.add(userPassword);
		content.add(userPasswordField);
		content.add(generateButton);
		content.add(backButton);
		generateButton.addActionListener(this);
		backButton.addActionListener(this);
		this.setContentPane(content);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == generateButton) {
			userOne.setUserId1(userNameField.getText());
			userOne.setPassword1(userPasswordField.getText());
			this.setVisible(false);
		}
		if (event.getSource() == backButton) {
			this.setVisible(false);
			new NumberOfUsers();
		}
	}
}
