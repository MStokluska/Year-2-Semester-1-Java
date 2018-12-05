package programme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Setup extends JFrame implements ActionListener {
	JButton applyButton, backButton;
	JSlider scaleR, scaleG, scaleB;
	JLabel rLabel, gLabel, bLabel;
	Colors newBackgroundColors;

	public Setup() {
		super("Setup");
		this.setSize(300, 250);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		Container content = this.getContentPane();
		FlowLayout layout = new FlowLayout();
		//setting background color and position.
		newBackgroundColors = new Colors();
		content.setBackground(new Color(255, 255, 255));
		if (newBackgroundColors.getRed() != 0 && newBackgroundColors.getGreen() != 122 && newBackgroundColors.getBlue() != 174) {
			content.setBackground(new Color(newBackgroundColors.getRed(), newBackgroundColors.getGreen(), newBackgroundColors.getBlue()));
		}
		applyButton = new JButton("Apply");
		backButton = new JButton("Back");
		scaleR = new JSlider(0, 255);
		scaleG = new JSlider(0, 255);
		scaleB = new JSlider(0, 255);
		rLabel = new JLabel("Red Color");
		gLabel = new JLabel("Green Color");
		bLabel = new JLabel("Blue Color");
		scaleR.setMajorTickSpacing(50);
		scaleR.setMinorTickSpacing(5);
		scaleR.setPaintTicks(true);
		scaleR.setPaintLabels(true);
		scaleG.setMajorTickSpacing(50);
		scaleG.setMinorTickSpacing(5);
		scaleG.setPaintTicks(true);
		scaleG.setPaintLabels(true);
		scaleB.setMajorTickSpacing(50);
		scaleB.setMinorTickSpacing(5);
		scaleB.setPaintTicks(true);
		scaleB.setPaintLabels(true);
		content.add(rLabel);
		content.add(scaleR);
		content.add(gLabel);
		content.add(scaleG);
		content.add(bLabel);
		content.add(scaleB);
		content.setLayout(layout);
		content.add(applyButton);
		content.add(backButton);
		applyButton.addActionListener(this);
		backButton.addActionListener(this);
		this.setContentPane(content);
	}
//setting colors of the background using slider, changing values in static color
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == applyButton) {
			int redColor = scaleR.getValue();
			int greenColor = scaleG.getValue();
			int blueColor = scaleB.getValue();
			Colors newColors = new Colors();
			newColors.setRed(redColor);
			newColors.setGreen(greenColor);
			newColors.setBlue(blueColor);
			this.setVisible(false);
			new Setup();
		}
		if (event.getSource() == backButton) {
			this.setVisible(false);
			new LoginWindow();
		}
	}
}
