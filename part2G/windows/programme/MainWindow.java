
package programme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame implements ActionListener {
	private JLabel firstInstruction, secondInstruction, error;
	private ButtonGroup firstShape, secondShape;
	private JRadioButton rectangle, triangle, circle, none;
	private JRadioButton rectangle2, triangle2, circle2, none2;
	private JButton next, back;
	private JFrame rectangleDraw, rectangleDraw2, circleDraw, circleDraw2, triangleDraw, triangleDraw2;

	public MainWindow() {
		super("New Project");
		this.setSize(400, 170);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		Container content = this.getContentPane();
		FlowLayout layout = new FlowLayout();
		content.setLayout(layout);
		//creating class for pull of background colors from static class colors.
		Colors newBackgroundColors = new Colors();
		content.setBackground(new Color(255, 255, 255));
		if (newBackgroundColors.getRed() != 0) {
			content.setBackground(new Color(newBackgroundColors.getRed(), newBackgroundColors.getGreen(),
					newBackgroundColors.getBlue()));
		}
		firstInstruction = new JLabel("1. Shape");
		firstShape = new ButtonGroup();
		rectangle = new JRadioButton("Rectangle");
		triangle = new JRadioButton("Triangle");
		circle = new JRadioButton("Circle");
		none = new JRadioButton("None");
		secondInstruction = new JLabel("2. Shape");
		secondShape = new ButtonGroup();
		rectangle2 = new JRadioButton("Rectangle");
		triangle2 = new JRadioButton("Triangle");
		circle2 = new JRadioButton("Circle");
		none2 = new JRadioButton("None");
		next = new JButton("Next");
		back = new JButton("Back");
		error = new JLabel("");
		rectangleDraw = new JFrame("Rectangle");
		rectangleDraw2 = new JFrame("Rectangle 2");
		circleDraw = new JFrame("Circle");
		circleDraw2 = new JFrame("Circle");
		triangleDraw = new JFrame("Triangle");
		triangleDraw2 = new JFrame("Triangle 2");
		firstShape.add(none);
		firstShape.add(rectangle);
		firstShape.add(triangle);
		firstShape.add(circle);
		secondShape.add(none2);
		secondShape.add(rectangle2);
		secondShape.add(triangle2);
		secondShape.add(circle2);
		none.addActionListener(this);
		none2.addActionListener(this);
		rectangle.addActionListener(this);
		triangle.addActionListener(this);
		circle.addActionListener(this);
		rectangle2.addActionListener(this);
		triangle2.addActionListener(this);
		circle2.addActionListener(this);
		back.addActionListener(this);
		next.addActionListener(this);

		content.add(firstInstruction);
		content.add(none);
		content.add(rectangle);
		content.add(triangle);
		content.add(circle);
		content.add(secondInstruction);
		content.add(none2);
		content.add(rectangle2);
		content.add(triangle2);
		content.add(circle2);
		content.add(back);
		content.add(next);
		content.add(error);

		this.setContentPane(content);

	}
//checking for different scenarios that were triggered in shape selection field and calling up right methods for different if statement
	//also making sure that a scenario from both radio button groups is selected.
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == next) {
			if (triangle.isSelected() && triangle2.isSelected()) {
				triangleDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				TriangleDrawing newTriangle = new TriangleDrawing();
				triangleDraw.add(newTriangle);
				triangleDraw.setSize(200, 200);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				triangleDraw.setLocation(dim.width / 2 + 400 - this.getSize().width / 2,
						dim.height / 2 - 100 - this.getSize().height / 2);
				triangleDraw.setVisible(true);
				triangleDraw2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				TriangleDrawing newTriangle2 = new TriangleDrawing();
				triangleDraw2.add(newTriangle2);
				triangleDraw2.setSize(200, 200);
				Dimension dim2 = Toolkit.getDefaultToolkit().getScreenSize();
				triangleDraw2.setLocation(dim.width / 2 + 400 - this.getSize().width / 2,
						dim2.height / 2 + 150 - this.getSize().height / 2);
				triangleDraw2.setVisible(true);
				new TwoTriangleCalculations();
				this.setVisible(false);
			}
			if (rectangle.isSelected() && rectangle2.isSelected()) {
				rectangleDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				RectangleDrawing newRectangle = new RectangleDrawing();
				rectangleDraw.add(newRectangle);
				rectangleDraw.setSize(320, 200);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				rectangleDraw.setLocation(dim.width / 2 + 400 - this.getSize().width / 2,
						dim.height / 2 - 100 - this.getSize().height / 2);
				rectangleDraw.setVisible(true);

				rectangleDraw2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				RectangleDrawing newRectangle2 = new RectangleDrawing();
				rectangleDraw2.add(newRectangle2);
				rectangleDraw2.setSize(320, 200);
				Dimension dim2 = Toolkit.getDefaultToolkit().getScreenSize();
				rectangleDraw2.setLocation(dim.width / 2 + 400 - this.getSize().width / 2,
						dim2.height / 2 + 150 - this.getSize().height / 2);
				rectangleDraw2.setVisible(true);
				new TwoRectangleCalculations();
				this.setVisible(false);
			}
			if (circle.isSelected() && circle2.isSelected()) {
				circleDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				CircleDrawing newCircle = new CircleDrawing();
				circleDraw.add(newCircle);
				circleDraw.setSize(320, 200);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				circleDraw.setLocation(dim.width / 2 + 400 - this.getSize().width / 2,
						dim.height / 2 - 100 - this.getSize().height / 2);
				circleDraw.setVisible(true);

				circleDraw2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				CircleDrawing newCircle2 = new CircleDrawing();
				circleDraw2.add(newCircle2);
				circleDraw2.setSize(320, 200);
				Dimension dim2 = Toolkit.getDefaultToolkit().getScreenSize();
				circleDraw2.setLocation(dim.width / 2 + 400 - this.getSize().width / 2,
						dim2.height / 2 + 150 - this.getSize().height / 2);
				circleDraw2.setVisible(true);
				new TwoCircleCalculations();
				this.setVisible(false);
			}
			if ((none.isSelected() || rectangle.isSelected() || triangle.isSelected() || circle.isSelected())
					&& (none2.isSelected() || rectangle2.isSelected() || triangle2.isSelected()
							|| circle2.isSelected())) {
				if ((none.isSelected()
						|| (none2.isSelected()) && ((rectangle.isSelected() || rectangle2.isSelected())
								|| (triangle.isSelected() || triangle2.isSelected()))
						|| (circle.isSelected() || circle2.isSelected()))) {
					if ((rectangle.isSelected() || rectangle2.isSelected())
							&& ((none.isSelected() || none2.isSelected()))) {
						rectangleDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						RectangleDrawing newRectangle = new RectangleDrawing();
						rectangleDraw.add(newRectangle);
						rectangleDraw.setSize(320, 150);
						Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
						rectangleDraw.setLocation(dim.width / 2 + 400 - this.getSize().width / 2,
								dim.height / 2 - this.getSize().height / 2);
						rectangleDraw.setVisible(true);
						new RectangleCalculations();
						this.setVisible(false);
					}
				}
				if ((circle.isSelected() || circle2.isSelected()) && ((none.isSelected() || none2.isSelected()))) {
					circleDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					CircleDrawing newCircleToDraw = new CircleDrawing();
					circleDraw.add(newCircleToDraw);
					circleDraw.setSize(200, 200);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					circleDraw.setLocation(dim.width / 2 + 400 - this.getSize().width / 2,
							dim.height / 2 - this.getSize().height / 2);
					circleDraw.setVisible(true);
					new CircleCalculations();
					this.setVisible(false);
				}
				if ((triangle.isSelected() || triangle2.isSelected()) && ((none.isSelected() || none2.isSelected()))) {
					triangleDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					TriangleDrawing newTriangle = new TriangleDrawing();
					triangleDraw.add(newTriangle);
					triangleDraw.setSize(200, 200);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					triangleDraw.setLocation(dim.width / 2 + 400 - this.getSize().width / 2,
							dim.height / 2 - this.getSize().height / 2);
					triangleDraw.setVisible(true);
					new TriangleCalculations();
					this.setVisible(false);
				}
				if ((rectangle.isSelected() || rectangle2.isSelected())
						&& (triangle.isSelected() || triangle2.isSelected())) {
					rectangleDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					RectangleDrawing newRectangle = new RectangleDrawing();
					rectangleDraw.add(newRectangle);
					rectangleDraw.setSize(320, 150);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					rectangleDraw.setLocation(dim.width / 2 + 400 - this.getSize().width / 2,
							dim.height / 2 - 100 - this.getSize().height / 2);
					rectangleDraw.setVisible(true);
					triangleDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					TriangleDrawing newTriangle = new TriangleDrawing();
					triangleDraw.add(newTriangle);
					triangleDraw.setSize(200, 200);
					Dimension dim2 = Toolkit.getDefaultToolkit().getScreenSize();
					triangleDraw.setLocation(dim.width / 2 + 400 - this.getSize().width / 2,
							dim2.height / 2 + 150 - this.getSize().height / 2);
					triangleDraw.setVisible(true);
					this.setVisible(false);
					new RectangleTriangleCalculations();
				}
				if ((rectangle.isSelected() || rectangle2.isSelected())
						&& (circle.isSelected() || circle2.isSelected())) {
					rectangleDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					RectangleDrawing newRectangle = new RectangleDrawing();
					rectangleDraw.add(newRectangle);
					rectangleDraw.setSize(320, 150);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					rectangleDraw.setLocation(dim.width / 2 + 400 - this.getSize().width / 2,
							dim.height / 2 - 100 - this.getSize().height / 2);
					rectangleDraw.setVisible(true);
					circleDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					CircleDrawing newCircleToDraw = new CircleDrawing();
					circleDraw.add(newCircleToDraw);
					circleDraw.setSize(200, 200);
					Dimension dim2 = Toolkit.getDefaultToolkit().getScreenSize();
					circleDraw.setLocation(dim.width / 2 + 400 - this.getSize().width / 2,
							dim2.height / 2 + 150 - this.getSize().height / 2);
					circleDraw.setVisible(true);
					new RectangleCircleCalculations();
					this.setVisible(false);
				}
				if ((triangle.isSelected() || triangle2.isSelected())
						&& (circle.isSelected() || circle2.isSelected())) {
					triangleDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					TriangleDrawing newTriangle = new TriangleDrawing();
					triangleDraw.add(newTriangle);
					triangleDraw.setSize(200, 200);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					triangleDraw.setLocation(dim.width / 2 + 400 - this.getSize().width / 2,
							dim.height / 2 - 100 - this.getSize().height / 2);
					triangleDraw.setVisible(true);
					circleDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					CircleDrawing newCircleToDraw = new CircleDrawing();
					circleDraw.add(newCircleToDraw);
					circleDraw.setSize(200, 200);
					Dimension dim2 = Toolkit.getDefaultToolkit().getScreenSize();
					circleDraw.setLocation(dim.width / 2 + 400 - this.getSize().width / 2,
							dim2.height / 2 + 150 - this.getSize().height / 2);
					circleDraw.setVisible(true);
					new TriangleCircleCalculations();
					this.setVisible(false);
				}

			} else {
				error.setForeground(Color.RED);
				error.setText("You must make both selections");
			}
		}
		if (event.getSource() == back) {
			new LoginWindow();
			this.setVisible(false);
		}

	}

}
