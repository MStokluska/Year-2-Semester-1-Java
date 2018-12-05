package programme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
//calculations when two triangles are selected
public class TwoTriangleCalculations extends JFrame implements ActionListener {
	private Colors newBackgroundColors;
	private JLabel lenghtLabel, heightLabel, lenghtLabel2, heightLabel2, calculateLabel;
	private JTextField lenghtField, heightField, lenghtField2, heightField2;
	private JCheckBox calculateArea, calculatePerimeter, checkIfEqual;
	private JButton calculateButton, backButton;
	private JTextArea resultArea;
	private int lenght, height, lenght2, height2;
	private Triangle newTriangle, newTriangle2;
	private String result, result2, equality;

	public TwoTriangleCalculations() {
		super("Two Triangle Calculations");
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

		JLabel lenghtLabel = new JLabel("Lenght of First Triangle: ");
		JTextField lenghtField = new JTextField("", 20);
		JLabel heightLabel = new JLabel("Height of First Triangle: ");
		JTextField heightField = new JTextField("", 20);
		JLabel lenghtLabel2 = new JLabel("Lenght of Second Triangle: ");
		JTextField lenghtField2 = new JTextField("", 20);
		JLabel heightLabel2 = new JLabel("Height of Second Triangle: ");
		JTextField heightField2 = new JTextField("", 20);
		JLabel calculateLabel = new JLabel("Choose functions: ");
		JCheckBox calculateArea = new JCheckBox("Calculate Area");
		JCheckBox calculatePerimeter = new JCheckBox("Calculate Perimeter");
		JCheckBox checkIfEqual = new JCheckBox("Check if First Triangle is Equal to Second Triangle");
		JButton calculateButton = new JButton("Calculate");
		JTextArea resultArea = new JTextArea("", 3, 30);
		JButton backButton = new JButton("Back");
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
			int lenght = Integer.parseInt(lenghtField.getText());
			int height = Integer.parseInt(heightField.getText());
			int lenght2 = Integer.parseInt(lenghtField2.getText());
			int height2 = Integer.parseInt(heightField2.getText());
			Triangle newTriangle = new Triangle(lenght, height);
			Triangle newTriangle2 = new Triangle(lenght2, height2);
			String result = "Your first Triangle ";
			String result2 = "\nYour second Triangle";
			String equality = " \nTriangles are ";
			if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected()) && (checkIfEqual.isSelected())) {
				if (newTriangle.areYouEqualTo(newTriangle2)) {
					equality = equality + "equal";
				} else {
					equality = equality + "not equal";
				}
				result = result + "area is " + newTriangle.calculateArea() + " and perimeter is "
						+ newTriangle.calculatePerimeter();
				result2 = result2 + " area is " + newTriangle2.calculateArea() + " and perimeter is "
						+ newTriangle2.calculatePerimeter();
				resultArea.setText(result + result2 + equality);
			} else if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected())) {
				result = result + "area is " + newTriangle.calculateArea() + " and perimeter is "
						+ newTriangle.calculatePerimeter();
				result2 = result2 + " area is " + newTriangle2.calculateArea() + " and perimeter is "
						+ newTriangle2.calculatePerimeter();
				resultArea.setText(result + result2);
			}

			else if (calculatePerimeter.isSelected() && checkIfEqual.isSelected()) {
				if (newTriangle.areYouEqualTo(newTriangle2)) {
					equality = equality + "equal";
				} else {
					equality = equality + "not equal";
				}
				result = result + "perimeter is " + newTriangle.calculatePerimeter();
				result2 = result2 + " perimeter is " + newTriangle2.calculatePerimeter();
				resultArea.setText(result + result2 + equality);
			} else if (calculateArea.isSelected() && checkIfEqual.isSelected()) {
				if (newTriangle.areYouEqualTo(newTriangle2)) {
					equality = equality + "equal";
				} else {
					equality = equality + "not equal";
				}
				result = result + "area is " + newTriangle.calculateArea();
				result2 = result2 + " area is " + newTriangle2.calculateArea();
				resultArea.setText(result + result2 + equality);
			} else if (calculateArea.isSelected()) {
				result = result + "area is " + newTriangle.calculateArea();
				result2 = result2 + " area is " + newTriangle2.calculateArea();
				resultArea.setText(result + result2);
			} else if (calculatePerimeter.isSelected()) {
				result = result + "perimeter is " + newTriangle.calculatePerimeter();
				result2 = result2 + " perimeter is " + newTriangle2.calculatePerimeter();
				resultArea.setText(result + result2);
			} else if (checkIfEqual.isSelected()) {
				if (newTriangle.areYouEqualTo(newTriangle2)) {
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
