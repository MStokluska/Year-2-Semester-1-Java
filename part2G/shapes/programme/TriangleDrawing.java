package programme;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TriangleDrawing extends JPanel {
//drawing triangle
	public void paintComponent(Graphics triangle) {
		super.paintComponent(triangle);
		this.setBackground(Color.WHITE);

		triangle.setColor(Color.BLACK);
		triangle.drawString("This is your triangle", 40, 10);
		triangle.setColor(Color.BLACK);
		triangle.drawLine(20, 100, 170, 100);
		triangle.drawLine(20, 100, 95, 20);
		triangle.drawLine(95, 20, 170, 100);

	}

}
