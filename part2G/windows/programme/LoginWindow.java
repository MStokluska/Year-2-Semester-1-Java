package programme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class LoginWindow extends JFrame implements ActionListener {

	private JLabel idLabel, passwordLabel, incorrectIdOrPassword;
	private JTextField idTextField;
	private JPasswordField passwordField;
	private JButton createButton, logInButton, setup;
	private String emptyStringToDoubleCheckPassword;
	private User user;
	private Colors newBackgroundColors;

	public LoginWindow() {
		super("Log In");
		this.setSize(370, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		Container content = this.getContentPane();
		FlowLayout layout = new FlowLayout();
		//finding out dimension of users screen and entering displaying window on the center
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		content.setBackground(new Color(255, 255, 255));
		if (newBackgroundColors.getRed() != 0) {
			content.setBackground(new Color(newBackgroundColors.getRed(), newBackgroundColors.getGreen(),
					newBackgroundColors.getBlue()));
		}
		idLabel = new JLabel("ID");
		passwordLabel = new JLabel("PASSWORD");
		incorrectIdOrPassword = new JLabel("");
		passwordField = new JPasswordField("", 30);
		idTextField = new JTextField("", 30);
		createButton = new JButton("Create User");
		logInButton = new JButton("Log In");
		setup = new JButton("Setup");
		emptyStringToDoubleCheckPassword = ("");
		user = new User();
		content.setLayout(layout);
		content.add(idLabel);
		content.add(idTextField);
		content.add(passwordLabel);
		content.add(passwordField);
		content.add(createButton);
		content.add(logInButton);
		content.add(setup);
		content.add(incorrectIdOrPassword);
		createButton.addActionListener(this);
		logInButton.addActionListener(this);
		setup.addActionListener(this);
		this.setContentPane(content);

	}
//checking if login values are not null
	public void actionPerformed(ActionEvent event) {
		String possibleId = "RandomString";
		String possiblePassword = "RandomString";
		possibleId = idTextField.getText();
		possiblePassword = passwordField.getText();

		if (event.getSource() == createButton) {
			new NumberOfUsers();
		}
		if (event.getSource() == setup) {
			new Setup();
			this.setVisible(false);
		}
		//checking different scenarios if log in button is pressed
		if (event.getSource() == logInButton) {
			if ((possiblePassword.equals(emptyStringToDoubleCheckPassword))
					|| (possibleId.equals(emptyStringToDoubleCheckPassword))) {
				incorrectIdOrPassword.setForeground(Color.RED);
				incorrectIdOrPassword.setText("Incorrect user or password");
			} else if (((possibleId.equals(user.getId1())) && (possiblePassword.equals(user.getPassword1())))
					|| ((possibleId.equals(user.getId2())) && (possiblePassword.equals(user.getPassword2())))
					|| ((possibleId.equals(user.getId3())) && (possiblePassword.equals(user.getPassword3())))) {
				new MainWindow();
				this.setVisible(false);
			} else {
				incorrectIdOrPassword.setForeground(Color.RED);
				incorrectIdOrPassword.setText("Incorrect user or password");
			}
		}
	}

}