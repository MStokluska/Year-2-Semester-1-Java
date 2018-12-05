package programme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
//calculations that can be performed if 2 circles are selected.
public class RectangleCircleCalculations extends JFrame implements ActionListener {
	private Colors newBackgroundColors;
	private JLabel rectangleLenghtLabel, rectangleHeightLabel, circleLabel, calculateLabel;
	private JTextField rectangleLenghtField, rectangleHeightField, circleField;
	private JCheckBox calculateArea, calculatePerimeter, combinePerimeter, combineArea;
	private JButton calculateButton, backButton;
	private JTextArea resultArea;
	private int rectangleLenght, rectangleHeight;
	private double circleRadius;
	private Rectangle newRectangle;
	private Circle newCircle;

	public RectangleCircleCalculations() {
		super("Rectangle Circle Calculations");
		this.setSize(330, 430);
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

		rectangleLenghtLabel = new JLabel("Lenght of Rectangle: ");
		rectangleLenghtField = new JTextField("", 20);
		rectangleHeightLabel = new JLabel("Height of Rectangle: ");
		rectangleHeightField = new JTextField("", 20);
		circleLabel = new JLabel("Radius of Circle: ");
		circleField = new JTextField("", 20);
		calculateLabel = new JLabel("Choose functions: ");
		calculateArea = new JCheckBox("Calculate Area");
		calculatePerimeter = new JCheckBox("Calculate Perimeter");
		combinePerimeter = new JCheckBox("Combine Perimeter");
		combineArea = new JCheckBox("Combine Area");
		calculateButton = new JButton("Calculate");
		resultArea = new JTextArea("", 3, 30);
		backButton = new JButton("Back");
		content.setLayout(layout);
		content.add(rectangleLenghtLabel);
		content.add(rectangleLenghtField);
		content.add(rectangleHeightLabel);
		content.add(rectangleHeightField);
		content.add(circleLabel);
		content.add(circleField);
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
//different calculations that can be selected & performed
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == calculateButton) {
			rectangleLenght = Integer.parseInt(rectangleLenghtField.getText());
			rectangleHeight = Integer.parseInt(rectangleHeightField.getText());
			circleRadius = Double.parseDouble(circleField.getText());
			newRectangle = new Rectangle(rectangleLenght, rectangleHeight);
			newCircle = new Circle(circleRadius);
			String result = "Your Rectangle ";
			String result2 = "\nYour Circle ";
			String combinedArea = " \nShapes combined area give ";
			String combinedPerimeter = " \nShapes combined perimeter give ";
			if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected()) && (combinePerimeter.isSelected())
					&& (combineArea.isSelected())) {
				result = result + "area is " + newRectangle.calculateArea() + " and its perimeter is "
						+ newRectangle.calculatePerimeter();
				result2 = result2 + "area is " + newCircle.calculateArea() + " and its perimeter is "
						+ newCircle.calculatePerimeter();
				combinedArea = combinedArea + (newCircle.calculateArea() + newRectangle.calculateArea());
				combinedPerimeter = combinedPerimeter
						+ (newCircle.calculatePerimeter() + newRectangle.calculatePerimeter());
				resultArea.setText(result + result2 + combinedArea + combinedPerimeter);
			} else if ((calculateArea.isSelected()) && (combinePerimeter.isSelected()) && (combineArea.isSelected())) {
				result = result + "area is " + newRectangle.calculateArea();
				result2 = result2 + "area is " + newCircle.calculateArea();
				combinedPerimeter = combinedPerimeter
						+ (newCircle.calculatePerimeter() + newRectangle.calculatePerimeter());
				combinedArea = combinedArea + (newCircle.calculateArea() + newRectangle.calculateArea());
				resultArea.setText(result + result2 + combinedPerimeter + combinedArea);
			} else if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected())
					&& (combinePerimeter.isSelected())) {
				result = result + "area is " + newRectangle.calculateArea() + " and its perimeter is "
						+ newRectangle.calculatePerimeter();
				result2 = result2 + "area is " + newCircle.calculateArea() + " and its perimeter is "
						+ newCircle.calculatePerimeter();
				combinedPerimeter = combinedPerimeter
						+ (newCircle.calculatePerimeter() + newRectangle.calculatePerimeter());
				resultArea.setText(result + result2 + combinedPerimeter);
			} else if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected())
					&& (combineArea.isSelected())) {
				result = result + "area is " + newRectangle.calculateArea() + " and its perimeter is "
						+ newRectangle.calculatePerimeter();
				result2 = result2 + "area is " + newCircle.calculateArea() + " and its perimeter is "
						+ newCircle.calculatePerimeter();
				combinedArea = combinedArea + (newCircle.calculateArea() + newRectangle.calculateArea());
				resultArea.setText(result + result2 + combinedArea);
			} else if ((calculatePerimeter.isSelected()) && (combinePerimeter.isSelected())
					&& (combineArea.isSelected())) {
				result = result + "perimeter is " + newRectangle.calculatePerimeter();
				result2 = result2 + "perimeter is " + newCircle.calculatePerimeter();
				combinedPerimeter = combinedPerimeter
						+ (newCircle.calculatePerimeter() + newRectangle.calculatePerimeter());
				combinedArea = combinedArea + (newCircle.calculateArea() + newRectangle.calculateArea());
				resultArea.setText(result + result2 + combinedPerimeter + combinedArea);
			} else if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected())) {
				result = result + "area is " + newRectangle.calculateArea() + " and its perimeter is "
						+ newRectangle.calculatePerimeter();
				result2 = result2 + "area is " + newCircle.calculateArea() + " and its perimeter is "
						+ newCircle.calculatePerimeter();
				resultArea.setText(result + result2);
			}

			else if (calculatePerimeter.isSelected() && combinePerimeter.isSelected()) {
				result = result + "perimeter is " + newRectangle.calculatePerimeter();
				result2 = result2 + "perimeter is " + newCircle.calculatePerimeter();
				combinedPerimeter = combinedPerimeter
						+ (newCircle.calculatePerimeter() + newRectangle.calculatePerimeter());
				resultArea.setText(result + result2 + combinedPerimeter);
			} else if (combineArea.isSelected() && combinePerimeter.isSelected()) {
				combinedPerimeter = combinedPerimeter
						+ (newCircle.calculatePerimeter() + newRectangle.calculatePerimeter());
				combinedArea = combinedArea + (newCircle.calculateArea() + newRectangle.calculateArea());
				resultArea.setText(combinedArea + combinedPerimeter);
			} else if (calculatePerimeter.isSelected() && combineArea.isSelected()) {
				result = result + "perimeter is " + newRectangle.calculatePerimeter();
				result2 = result2 + "perimeter is " + newCircle.calculatePerimeter();
				combinedArea = combinedArea + (newCircle.calculateArea() + newRectangle.calculateArea());
				resultArea.setText(result + result2 + combinedArea);
			} else if (calculateArea.isSelected() && combineArea.isSelected()) {
				result = result + "area is " + newRectangle.calculateArea();
				result2 = result2 + "area is " + newCircle.calculateArea();
				combinedArea = combinedArea + (newCircle.calculateArea() + newRectangle.calculateArea());
				resultArea.setText(result + result2 + combinedArea);
			} else if (calculateArea.isSelected() && combinePerimeter.isSelected()) {
				result = result + "area is " + newRectangle.calculateArea();
				result2 = result2 + "area is " + newCircle.calculateArea();
				combinedPerimeter = combinedPerimeter
						+ (newCircle.calculatePerimeter() + newRectangle.calculatePerimeter());
				resultArea.setText(result + result2 + combinedPerimeter);
			} else if (calculateArea.isSelected()) {
				result = result + "area is " + newRectangle.calculateArea();
				result2 = result2 + "area is " + newCircle.calculateArea();
				resultArea.setText(result + result2);
			} else if (calculatePerimeter.isSelected()) {
				result = result + "perimeter is " + newRectangle.calculatePerimeter();
				result2 = result2 + "perimeter is " + newCircle.calculatePerimeter();
				resultArea.setText(result + result2);
			} else if (combinePerimeter.isSelected()) {
				combinedPerimeter = combinedPerimeter
						+ (newCircle.calculatePerimeter() + newRectangle.calculatePerimeter());
				resultArea.setText(combinedPerimeter);
			} else if (combineArea.isSelected()) {
				combinedArea = combinedArea + (newCircle.calculateArea() + newRectangle.calculateArea());
				resultArea.setText(combinedArea);
			}
		} else if (event.getSource() == backButton) {
			new MainWindow();
			this.setVisible(false);
		}
	}
}
