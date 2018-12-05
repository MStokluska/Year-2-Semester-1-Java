package programme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//calculations that can be performed on if circle and only 1 circle is selected
public class CircleCalculations extends JFrame implements ActionListener {
	private Colors newBackgroundColors;
	private JLabel radiusLabel, calculateLabel;
	private JTextField radiusField;
	private JCheckBox calculateArea, calculatePerimeter;
	private JButton calculateButton, backButton;
	private JTextArea resultArea;
	private JFrame circleDraw;
	private double radius;
	private Circle newCircle;
	private String result;

	public CircleCalculations() {
		super("Circle Calculations");
		this.setSize(400, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		Container content = this.getContentPane();
		FlowLayout layout = new FlowLayout();
		newBackgroundColors = new Colors();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		Colors newBackgroundColors = new Colors();
		content.setBackground(new Color(255, 255, 255));
		if (newBackgroundColors.getRed() != 0) {
			content.setBackground(new Color(newBackgroundColors.getRed(), newBackgroundColors.getGreen(),
					newBackgroundColors.getBlue()));
		}
		JLabel radiusLabel = new JLabel("Radius of Circle: ");
		JLabel calculateLabel = new JLabel("Choose functions: ");
		radiusField = new JTextField("", 20);
		calculateArea = new JCheckBox("Calculate Area");
		calculatePerimeter = new JCheckBox("Calculate Perimeter");
		calculateButton = new JButton("Calculate");
		backButton = new JButton("Back");
		resultArea = new JTextArea("", 3, 30);
		circleDraw = new JFrame("Circle");
		content.setLayout(layout);
		content.add(radiusLabel);
		content.add(radiusField);
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
			radius = Integer.parseInt(radiusField.getText());
			newCircle = new Circle(radius);
			result = "Your circle ";
			if ((calculateArea.isSelected()) && (calculatePerimeter.isSelected())) {
				result = result + "area is " + newCircle.calculateArea() + " and perimeter is "
						+ newCircle.calculatePerimeter();
				resultArea.setText(result);
			} else if (calculatePerimeter.isSelected()) {
				result = result + "perimeter is " + newCircle.calculatePerimeter();
				resultArea.setText(result);
			} else if (calculateArea.isSelected()) {
				result = result + "area is " + newCircle.calculateArea();
				resultArea.setText(result);
			}
		} else if (event.getSource() == backButton) {
			new MainWindow();
			this.setVisible(false);
			circleDraw.setVisible(false);
		}
	}

}
