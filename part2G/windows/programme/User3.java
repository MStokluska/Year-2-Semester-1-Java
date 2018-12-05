package programme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//window that pops up when 3 users are selected from NumberOfUsers class.
public class User3 extends JFrame implements ActionListener {
	private int amountOfUsers;
	private JLabel userName, userPassword, userName2, userPassword2, userName3, userPassword3;
	private JTextField userPasswordField, userNameField2, userNameField, userPasswordField2, userNameField3,
			userPasswordField3;
	private JButton generateButton, backButton;
	private User newUser;

	public User3() {
		super("Enter Details");
		this.setSize(700, 160);
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
		content.setLayout(layout);
		userName = new JLabel("1. User Name");
		userNameField = new JTextField("", 20);
		userPassword = new JLabel("1. User Password");
		userPasswordField = new JTextField("", 20);
		userName2 = new JLabel("2. User Name");
		userNameField2 = new JTextField("", 20);
		userPassword2 = new JLabel("2. User Password");
		userPasswordField2 = new JTextField("", 20);
		userName3 = new JLabel("3. User Name");
		userNameField3 = new JTextField("", 20);
		userPassword3 = new JLabel("3. User Password");
		userPasswordField3 = new JTextField("", 20);
		generateButton = new JButton("Generate");
		backButton = new JButton("Back");
		newUser = new User();
		content.add(userName);
		content.add(userNameField);
		content.add(userPassword);
		content.add(userPasswordField);
		content.add(userName2);
		content.add(userNameField2);
		content.add(userPassword2);
		content.add(userPasswordField2);
		content.add(userName3);
		content.add(userNameField3);
		content.add(userPassword3);
		content.add(userPasswordField3);
		content.add(generateButton);
		content.add(backButton);
		generateButton.addActionListener(this);
		backButton.addActionListener(this);
		this.setContentPane(content);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == generateButton) {
			newUser.setUserId1(userNameField.getText());
			newUser.setPassword1(userPasswordField.getText());
			newUser.setUserId2(userNameField2.getText());
			newUser.setPassword2(userPasswordField2.getText());
			newUser.setUserId3(userNameField3.getText());
			newUser.setPassword3(userPasswordField3.getText());
			this.setVisible(false);
		}
		if (event.getSource() == backButton) {
			this.setVisible(false);
			new NumberOfUsers();
		}
	}
}
