package programme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
//calculations of triangle when only triangle is selected.
public class TriangleCalculations extends JFrame implements ActionListener {
	private Colors newBackgroundColors;
	private JLabel lenghtLabel, heightLabel, calculateLabel;
	private JTextField lenghtField, heightField;
	private JCheckBox calculateArea, calculatePerimeter;
	private JButton calculateButton, backButton;
	private JTextArea resultArea;
	private double lenght, height;
	private Triangle newTriangle;
	private String result;

	public TriangleCalculations() {
		super("Triangle Calculations");
		this.setSize(400, 250);
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
		content.setLayout(layout);
		lenghtLabel = new JLabel("Lenght of Triangle: ");
		lenghtField = new JTextField("", 20);
		heightLabel = new JLabel("Height of Triangle: ");
		heightField = new JTextField("", 20);
		calculateLabel = new JLabel("Choose functions: ");
		calculateArea = new JCheckBox("Calculate Area");
		calculatePerimeter = new JCheckBox("Calculate Perimeter");
		calculateButton = new JButton("Calculate");
		resultArea = new JTextArea("", 3, 30);
		backButton = new JButton("Back");
		content.add(lenghtLabel);
		content.add(lenghtField);
		content.add(heightLabel);
		content.add(heightField);
		content.add(calculateLabel);
		content.add(calculateArea);
		content.add(calculatePerimeter);
		content.add(calculateButton);
		content.add(resultArea);
		content.add(backButton);
		calculateButton.addActionListener(this);
		backButton.addActionListener(this);
		this.setContentPane(content);

	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == calculateButton) {
			double lenght = Integer.parseInt(lenghtField.getText());
			double height = Integer.parseInt(heightField.getText());
			Triangle newTriangle = new Triangle(lenght, height);
			String result = "Your triangle ";
			if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected())) {
				result = result + "area is " + newTriangle.calculateArea() + " and perimeter is "
						+ newTriangle.calculatePerimeter();
				resultArea.setText(result);
			} else if (calculatePerimeter.isSelected()) {
				result = result + "perimeter is " + newTriangle.calculatePerimeter();
				resultArea.setText(result);
			} else if (calculateArea.isSelected()) {
				result = result + "area is " + newTriangle.calculateArea();
				resultArea.setText(result);
			}
		} else if (event.getSource() == backButton) {
			new MainWindow();
			this.setVisible(false);
		}
	}
}
