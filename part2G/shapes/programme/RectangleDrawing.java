package programme;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RectangleDrawing extends JPanel {
//drawing rectangle
	public void paintComponent(Graphics rectangle) {
		super.paintComponent(rectangle);
		this.setBackground(Color.WHITE);

		rectangle.setColor(Color.BLACK);
		rectangle.drawString("This is your rectangle", 100, 20);
		rectangle.setColor(Color.BLACK);
		rectangle.drawRect(20, 25, 260, 50);

	}

}
