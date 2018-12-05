package programme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

//calculations performed when 2 circles are selected
public class TwoCircleCalculations extends JFrame implements ActionListener {
	private Colors newBackgroundColors;
	private JLabel radiusLabel, radiusLabel2, calculateLabel;
	private JTextField radiusField, radiusField2;
	private JCheckBox calculateArea, calculatePerimeter, checkIfEqual;
	private JButton calculateButton, backButton;
	private JTextArea resultArea;
	private double radius1, radius2;
	private Circle newCircle, newCircle2;
	private String result, result2;
	private String equality;

	public TwoCircleCalculations() {
		super("Two Circle Calculations");
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

		radiusLabel = new JLabel("Radius of First Circle: ");
		radiusField = new JTextField("", 20);
		radiusLabel2 = new JLabel("Radius of Second Circle: ");
		radiusField2 = new JTextField("", 20);
		calculateLabel = new JLabel("Choose functions: ");
		calculateArea = new JCheckBox("Calculate Area");
		calculatePerimeter = new JCheckBox("Calculate Perimeter");
		checkIfEqual = new JCheckBox("Check if First Circle is Equal to Second Circle");
		calculateButton = new JButton("Calculate");
		resultArea = new JTextArea("", 3, 30);
		backButton = new JButton("Back");
		content.setLayout(layout);
		content.add(radiusLabel);
		content.add(radiusField);
		content.add(radiusLabel2);
		content.add(radiusField2);
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
			radius1 = Double.parseDouble(radiusField.getText());
			radius2 = Double.parseDouble(radiusField2.getText());
			newCircle = new Circle(radius1);
			newCircle2 = new Circle(radius2);
			result = "Your first Circle ";
			result2 = "\nYour second Circle";
			equality = " \nCircles are ";
			if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected()) && (checkIfEqual.isSelected())) {
				if (newCircle.areYouEqualTo(newCircle2)) {
					equality = equality + "equal";
				} else {
					equality = equality + "not equal";
				}
				result = result + "area is " + newCircle.calculateArea() + " and perimeter is "
						+ newCircle.calculatePerimeter();
				result2 = result2 + " area is " + newCircle2.calculateArea() + " and perimeter is "
						+ newCircle2.calculatePerimeter();
				resultArea.setText(result + result2 + equality);
			} else if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected())) {
				result = result + "area is " + newCircle.calculateArea() + " and perimeter is "
						+ newCircle.calculatePerimeter();
				result2 = result2 + " area is " + newCircle2.calculateArea() + " and perimeter is "
						+ newCircle2.calculatePerimeter();
				resultArea.setText(result + result2);
			}

			else if (calculatePerimeter.isSelected() && checkIfEqual.isSelected()) {
				if (newCircle.areYouEqualTo(newCircle2)) {
					equality = equality + "equal";
				} else {
					equality = equality + "not equal";
				}
				result = result + "perimeter is " + newCircle.calculatePerimeter();
				result2 = result2 + " perimeter is " + newCircle2.calculatePerimeter();
				resultArea.setText(result + result2 + equality);
			} else if (calculateArea.isSelected() && checkIfEqual.isSelected()) {
				if (newCircle.areYouEqualTo(newCircle2)) {
					equality = equality + "equal";
				} else {
					equality = equality + "not equal";
				}
				result = result + "area is " + newCircle.calculateArea();
				result2 = result2 + " area is " + newCircle2.calculateArea();
				resultArea.setText(result + result2 + equality);
			} else if (calculateArea.isSelected()) {
				result = result + "area is " + newCircle.calculateArea();
				result2 = result2 + " area is " + newCircle2.calculateArea();
				resultArea.setText(result + result2);
			} else if (calculatePerimeter.isSelected()) {
				result = result + "perimeter is " + newCircle.calculatePerimeter();
				result2 = result2 + " perimeter is " + newCircle2.calculatePerimeter();
				resultArea.setText(result + result2);
			} else if (checkIfEqual.isSelected()) {
				if (newCircle.areYouEqualTo(newCircle2)) {
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
