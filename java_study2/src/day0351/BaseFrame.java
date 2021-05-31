package day0351;

import java.awt.Component;

import javax.swing.JFrame;

public class BaseFrame extends JFrame {

	public static OverideTest overideTest;
	
	public BaseFrame(String title, int width, int height) {
			setTitle(title);
			setSize(width, height);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	
}
