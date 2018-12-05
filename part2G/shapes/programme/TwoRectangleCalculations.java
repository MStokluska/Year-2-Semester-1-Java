package programme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
//calculations that can be performed when two rectangles are selected
public class TwoRectangleCalculations extends JFrame implements ActionListener {
	private Colors newBackgroundColors;
	private JLabel lenghtLabel, heightLabel, lenghtLabel2, heightLabel2, calculateLabel;
	private JTextField lenghtField, heightField, lenghtField2, heightField2;
	private JCheckBox calculateArea, calculatePerimeter, checkIfEqual;
	private JButton calculateButton, backButton;
	private JTextArea resultArea;
	private int lenght, height, lenght2, height2;
	private Rectangle newRectangle, newRectangle2;
	private String result, result2, equality;

	public TwoRectangleCalculations() {
		super("Two Rectangle Calculations");
		this.setSize(350, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		Container content = this.getContentPane();
		FlowLayout layout = new FlowLayout();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		newBackgroundColors = new Colors();
		content.setBackground(new Color(255, 255, 255));
		if (newBackgroundColors.getRed() != 0) {
			content.setBackground(new Color(newBackgroundColors.getRed(), newBackgroundColors.getGreen(),
					newBackgroundColors.getBlue()));
		}
		lenghtLabel = new JLabel("Lenght of First Rectangle: ");
		lenghtField = new JTextField("", 20);
		heightLabel = new JLabel("Height of First Rectangle: ");
		heightField = new JTextField("", 20);
		lenghtLabel2 = new JLabel("Lenght of Second Rectangle: ");
		lenghtField2 = new JTextField("", 20);
		heightLabel2 = new JLabel("Height of Second Rectangle: ");
		heightField2 = new JTextField("", 20);
		calculateLabel = new JLabel("Choose functions: ");
	calculateArea = new JCheckBox("Calculate Area");
		calculatePerimeter = new JCheckBox("Calculate Perimeter");
		checkIfEqual = new JCheckBox("Check if First Rectangle is Equal to Second Rectangle");
		calculateButton = new JButton("Calculate");
		resultArea = new JTextArea("", 3, 30);
		backButton = new JButton("Back");

		content.setLayout(layout);
		content.add(lenghtLabel);
		content.add(lenghtField);
		content.add(heightLabel);
		content.add(heightField);
		content.add(lenghtLabel2);
		content.add(lenghtField2);
		content.add(heightLabel2);
		content.add(heightField2);
		content.add(calculateLabel);
		content.add(calculateArea);
		content.add(calculatePerimeter);
		content.add(checkIfEqual);
		content.add(calculateButton);
		content.add(resultArea);
		content.add(backButton);
		calculateButton.addActionListener(this);
		backButton.addActionListener(this);
		this.setContentPane(content);

	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == calculateButton) {
			lenght = Integer.parseInt(lenghtField.getText());
			height = Integer.parseInt(heightField.getText());
			lenght2 = Integer.parseInt(lenghtField2.getText());
			height2 = Integer.parseInt(heightField2.getText());
			newRectangle = new Rectangle(lenght, height);
			newRectangle2 = new Rectangle(lenght2, height2);
			result = "Your first rectangle ";
			result2 = "\nYour second rectangle";
			equality = " \nRectangles are ";
			if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected()) && (checkIfEqual.isSelected())) {
				if (newRectangle.areYouEqualTo(newRectangle2)) {
					equality = equality + "equal";
				} else {
					equality = equality + "not equal";
				}
				result = result + "area is " + newRectangle.calculateArea() + " and perimeter is "
						+ newRectangle.calculatePerimeter();
				result2 = result2 + " area is " + newRectangle2.calculateArea() + " and perimeter is "
						+ newRectangle2.calculatePerimeter();
				resultArea.setText(result + result2 + equality);
			} else if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected())) {
				result = result + "area is " + newRectangle.calculateArea() + " and perimeter is "
						+ newRectangle.calculatePerimeter();
				result2 = result2 + " area is " + newRectangle2.calculateArea() + " and perimeter is "
						+ newRectangle2.calculatePerimeter();
				resultArea.setText(result + result2);
			}

			else if (calculatePerimeter.isSelected() && checkIfEqual.isSelected()) {
				if (newRectangle.areYouEqualTo(newRectangle2)) {
					equality = equality + "equal";
				} else {
					equality = equality + "not equal";
				}
				result = result + "perimeter is " + newRectangle.calculatePerimeter();
				result2 = result2 + " perimeter is " + newRectangle2.calculatePerimeter();
				resultArea.setText(result + result2 + equality);
			} else if (calculateArea.isSelected() && checkIfEqual.isSelected()) {
				if (newRectangle.areYouEqualTo(newRectangle2)) {
					equality = equality + "equal";
				} else {
					equality = equality + "not equal";
				}
				result = result + "area is " + newRectangle.calculateArea();
				result2 = result2 + " area is " + newRectangle2.calculateArea();
				resultArea.setText(result + result2 + equality);
			} else if (calculateArea.isSelected()) {
				result = result + "area is " + newRectangle.calculateArea();
				result2 = result2 + " area is " + newRectangle2.calculateArea();
				resultArea.setText(result + result2);
			} else if (calculatePerimeter.isSelected()) {
				result = result + "perimeter is " + newRectangle.calculatePerimeter();
				result2 = result2 + " perimeter is " + newRectangle2.calculatePerimeter();
				resultArea.setText(result + result2);
			} else if (checkIfEqual.isSelected()) {
				if (newRectangle.areYouEqualTo(newRectangle2)) {
					equality = equality + "equal";
				} else {
					equality = equality + "not equal";
				}
				resultArea.setText(equality);
			}
		} else if (event.getSource() == backButton) {
			new MainWindow();
			this.setVisible(false);
		}
	}
}
