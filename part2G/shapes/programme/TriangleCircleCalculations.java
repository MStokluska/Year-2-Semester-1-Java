package programme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
//calculations done if triangle and circle are selected.
public class TriangleCircleCalculations extends JFrame implements ActionListener {
	private Colors newBackgroundColors;
	private JLabel circleLabel, triangleLenghtLabel, triangleHeightLabel, calculateLabel;
	private JTextField circleField, triangleLenghtField, triangleHeightField;
	private JCheckBox calculateArea, calculatePerimeter, combinePerimeter, combineArea;
	private JButton calculateButton, backButton;
	private JTextArea resultArea;
	private double circleRadius;
	private int triangleLenght, triangleHeight;
	private Circle newCircle;
	private Triangle newTriangle;
	private String result, result2, combinedArea, combinedPerimeter;

	public TriangleCircleCalculations() {
		super("Circle Triangle Calculations");
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
		newBackgroundColors = new Colors();
		circleLabel = new JLabel("Your Circle Radius: ");
		circleField = new JTextField("", 20);
		triangleLenghtLabel = new JLabel("Lenght of Triangle: ");
		triangleLenghtField = new JTextField("", 20);
		triangleHeightLabel = new JLabel("Height of Triangle: ");
		triangleHeightField = new JTextField("", 20);
		calculateLabel = new JLabel("Choose functions: ");
		calculateArea = new JCheckBox("Calculate Area");
		calculatePerimeter = new JCheckBox("Calculate Perimeter");
		combinePerimeter = new JCheckBox("Combine Perimeter");
		combineArea = new JCheckBox("Combine Area");
		calculateButton = new JButton("Calculate");
		resultArea = new JTextArea("", 3, 30);
		backButton = new JButton("Back");
		content.setLayout(layout);
		content.add(circleLabel);
		content.add(circleField);
		content.add(triangleLenghtLabel);
		content.add(triangleLenghtField);
		content.add(triangleHeightLabel);
		content.add(triangleHeightField);
		content.add(calculateLabel);
		content.add(calculateArea);
		content.add(calculatePerimeter);
		content.add(combinePerimeter);
		content.add(combineArea);
		content.add(calculateButton);
		content.add(resultArea);
		content.add(backButton);
		calculateButton.addActionListener(this);
		backButton.addActionListener(this);
		this.setContentPane(content);

	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == calculateButton) {
			circleRadius = Double.parseDouble(circleField.getText());
			triangleLenght = Integer.parseInt(triangleLenghtField.getText());
			triangleHeight = Integer.parseInt(triangleHeightField.getText());
			newCircle = new Circle(circleRadius);
			newTriangle = new Triangle(triangleLenght, triangleHeight);
			result = "Your Circle ";
			result2 = "\nYour Triangle ";
			combinedArea = " \nShapes combined area give ";
			combinedPerimeter = " \nShapes combined perimeter give ";
			if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected()) && (combinePerimeter.isSelected())
					&& (combineArea.isSelected())) {
				result = result + "area is " + newCircle.calculateArea() + " and its perimeter is "
						+ newCircle.calculatePerimeter();
				result2 = result2 + "area is " + newTriangle.calculateArea() + " and its perimeter is "
						+ newTriangle.calculatePerimeter();
				combinedArea = combinedArea + (newTriangle.calculateArea() + newCircle.calculateArea());
				combinedPerimeter = combinedPerimeter
						+ (newTriangle.calculatePerimeter() + newCircle.calculatePerimeter());
				resultArea.setText(result + result2 + combinedArea + combinedPerimeter);
			} else if ((calculateArea.isSelected()) && (combinePerimeter.isSelected()) && (combineArea.isSelected())) {
				result = result + "area is " + newCircle.calculateArea();
				result2 = result2 + "area is " + newTriangle.calculateArea();
				combinedPerimeter = combinedPerimeter
						+ (newTriangle.calculatePerimeter() + newCircle.calculatePerimeter());
				combinedArea = combinedArea + (newTriangle.calculateArea() + newCircle.calculateArea());
				resultArea.setText(result + result2 + combinedPerimeter + combinedArea);
			} else if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected())
					&& (combinePerimeter.isSelected())) {
				result = result + "area is " + newCircle.calculateArea() + " and its perimeter is "
						+ newCircle.calculatePerimeter();
				result2 = result2 + "area is " + newTriangle.calculateArea() + " and its perimeter is "
						+ newTriangle.calculatePerimeter();
				combinedPerimeter = combinedPerimeter
						+ (newTriangle.calculatePerimeter() + newCircle.calculatePerimeter());
				resultArea.setText(result + result2 + combinedPerimeter);
			} else if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected())
					&& (combineArea.isSelected())) {
				result = result + "area is " + newCircle.calculateArea() + " and its perimeter is "
						+ newCircle.calculatePerimeter();
				result2 = result2 + "area is " + newTriangle.calculateArea() + " and its perimeter is "
						+ newTriangle.calculatePerimeter();
				combinedArea = combinedArea + (newTriangle.calculateArea() + newCircle.calculateArea());
				resultArea.setText(result + result2 + combinedArea);
			} else if ((calculatePerimeter.isSelected()) && (combinePerimeter.isSelected())
					&& (combineArea.isSelected())) {
				result = result + "perimeter is " + newCircle.calculatePerimeter();
				result2 = result2 + "perimeter is " + newTriangle.calculatePerimeter();
				combinedPerimeter = combinedPerimeter
						+ (newTriangle.calculatePerimeter() + newCircle.calculatePerimeter());
				combinedArea = combinedArea + (newTriangle.calculateArea() + newCircle.calculateArea());
				resultArea.setText(result + result2 + combinedPerimeter + combinedArea);
			} else if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected())) {
				result = result + "area is " + newCircle.calculateArea() + " and its perimeter is "
						+ newCircle.calculatePerimeter();
				result2 = result2 + "area is " + newTriangle.calculateArea() + " and its perimeter is "
						+ newTriangle.calculatePerimeter();
				resultArea.setText(result + result2);
			}

			else if (calculatePerimeter.isSelected() && combinePerimeter.isSelected()) {
				result = result + "perimeter is " + newCircle.calculatePerimeter();
				result2 = result2 + "perimeter is " + newTriangle.calculatePerimeter();
				combinedPerimeter = combinedPerimeter
						+ (newTriangle.calculatePerimeter() + newCircle.calculatePerimeter());
				resultArea.setText(result + result2 + combinedPerimeter);
			} else if (combineArea.isSelected() && combinePerimeter.isSelected()) {
				combinedPerimeter = combinedPerimeter
						+ (newTriangle.calculatePerimeter() + newCircle.calculatePerimeter());
				combinedArea = combinedArea + (newTriangle.calculateArea() + newCircle.calculateArea());
				resultArea.setText(combinedArea + combinedPerimeter);
			} else if (calculatePerimeter.isSelected() && combineArea.isSelected()) {
				result = result + "perimeter is " + newCircle.calculatePerimeter();
				result2 = result2 + "perimeter is " + newTriangle.calculatePerimeter();
				combinedArea = combinedArea + (newTriangle.calculateArea() + newCircle.calculateArea());
				resultArea.setText(result + result2 + combinedArea);
			} else if (calculateArea.isSelected() && combineArea.isSelected()) {
				result = result + "area is " + newCircle.calculateArea();
				result2 = result2 + "area is " + newTriangle.calculateArea();
				combinedArea = combinedArea + (newTriangle.calculateArea() + newCircle.calculateArea());
				resultArea.setText(result + result2 + combinedArea);
			} else if (calculateArea.isSelected() && combinePerimeter.isSelected()) {
				result = result + "area is " + newCircle.calculateArea();
				result2 = result2 + "area is " + newTriangle.calculateArea();
				combinedPerimeter = combinedPerimeter
						+ (newTriangle.calculatePerimeter() + newCircle.calculatePerimeter());
				resultArea.setText(result + result2 + combinedPerimeter);
			} else if (calculateArea.isSelected()) {
				result = result + "area is " + newCircle.calculateArea();
				result2 = result2 + "area is " + newTriangle.calculateArea();
				resultArea.setText(result + result2);
			} else if (calculatePerimeter.isSelected()) {
				result = result + "perimeter is " + newCircle.calculatePerimeter();
				result2 = result2 + "perimeter is " + newTriangle.calculatePerimeter();
				resultArea.setText(result + result2);
			} else if (combinePerimeter.isSelected()) {
				combinedPerimeter = combinedPerimeter
						+ (newTriangle.calculatePerimeter() + newCircle.calculatePerimeter());
				resultArea.setText(combinedPerimeter);
			} else if (combineArea.isSelected()) {
				combinedArea = combinedArea + (newTriangle.calculateArea() + newCircle.calculateArea());
				resultArea.setText(combinedArea);
			}
		} else if (event.getSource() == backButton) {
			new MainWindow();
			this.setVisible(false);
		}
	}
}
