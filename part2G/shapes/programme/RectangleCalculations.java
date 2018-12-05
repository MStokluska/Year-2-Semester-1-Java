package programme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
//different calculations that can be performed on rectangle when only rectangle is selected
public class RectangleCalculations extends JFrame implements ActionListener {
	private Colors newBackgroundColors;
	private JLabel lenghtLabel, heightLabel, calculateLabel;
	private JTextField lenghtField, heightField;
	private JCheckBox calculateArea, calculatePerimeter;
	private JButton calculateButton, backButton;
	private JTextArea resultArea;
	private int lenght, height;
	private Rectangle newRectangle;
	private String result;

	public RectangleCalculations() {
		super("Rectangle Calculations");
		this.setSize(400, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		Container content = this.getContentPane();
		FlowLayout layout = new FlowLayout();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		Colors newBackgroundColors = new Colors();
		content.setBackground(new Color(255, 255, 255));
		if (newBackgroundColors.getRed() != 0) {
			content.setBackground(new Color(newBackgroundColors.getRed(), newBackgroundColors.getGreen(),
					newBackgroundColors.getBlue()));
		}
		lenghtLabel = new JLabel("Lenght of Rectangle: ");
		heightLabel = new JLabel("Height of Rectangle: ");
		calculateLabel = new JLabel("Choose functions: ");
		lenghtField = new JTextField("", 20);
		heightField = new JTextField("", 20);
		calculateArea = new JCheckBox("Calculate Area");
		calculatePerimeter = new JCheckBox("Calculate Perimeter");
		calculateButton = new JButton("Calculate");
		resultArea = new JTextArea("", 3, 30);
		backButton = new JButton("Back");

		content.setLayout(layout);
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
			int lenght = Integer.parseInt(lenghtField.getText());
			int height = Integer.parseInt(heightField.getText());
			Rectangle newRectangle = new Rectangle(lenght, height);
			String result = "Your rectangle ";
			if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected())) {
				result = result + "area is " + newRectangle.calculateArea() + " and perimeter is "
						+ newRectangle.calculatePerimeter();
				resultArea.setText(result);
			} else if (calculatePerimeter.isSelected()) {
				result = result + "perimeter is " + newRectangle.calculatePerimeter();
				resultArea.setText(result);
			} else if (calculateArea.isSelected()) {
				result = result + "area is " + newRectangle.calculateArea();
				resultArea.setText(result);
			}
		} else if (event.getSource() == backButton) {
			new MainWindow();
			this.setVisible(false);
		}
	}
}
