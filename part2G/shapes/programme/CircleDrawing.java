package programme;
//drawing Circle
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CircleDrawing extends JPanel {

	public void paintComponent(Graphics circle) {
		super.paintComponent(circle);
		Colors newBackgroundColors = new Colors();
		this.setBackground(new Color(255, 255, 255));
		if (newBackgroundColors.getRed() != 0) {
			this.setBackground(new Color(newBackgroundColors.getRed(), newBackgroundColors.getGreen(),
					newBackgroundColors.getBlue()));
		}
		circle.setColor(Color.BLACK);
		circle.drawString("This is your circle", 40, 20);
		circle.setColor(Color.BLACK);
		circle.drawOval(35, 25, 100, 100);

	}

}
