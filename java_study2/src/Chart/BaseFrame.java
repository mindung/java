package Chart;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BaseFrame extends JFrame {

	
	public BaseFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	protected void openFrame(JFrame frame) {
		dispose();
		frame.setVisible(true);
	}
	
	protected void openFrame(JFrame frame, JFrame frame1) {
		dispose();
		frame.setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame1.setVisible(true);
			}
		});
	}

	protected void iMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "메시지", JOptionPane.INFORMATION_MESSAGE);
	}
	
	protected void eMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "경고", JOptionPane.ERROR_MESSAGE);
	}
	
	public static JButton createButton(String text, ActionListener action) {
		JButton button = new JButton(text);
		button.addActionListener(action);
		return button;
	}
	
//	public Object setData(Object o) {
//		var s = "dd,d".split(",");
//		var d = v
//		return d;
//		
//	}
	
	protected ImageIcon getImg(String path) {
		return new ImageIcon(Toolkit.getDefaultToolkit().getImage(path));
	}
	
	protected ImageIcon getImg(String path,int w, int h) {
		return new ImageIcon(Toolkit.getDefaultToolkit().getImage(path).getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}
	
	protected JLabel createLabel(String t, int h, String n, int s, int size) {
		JLabel lb = new JLabel(t, h);
		lb.setFont(new Font(n, s, size));
		return lb;
	}
	
	protected <T extends JComponent> T addC(T com, int w, int h) {
		com.setPreferredSize(new Dimension(w, h));
		return com;
	}
	
	protected <T extends JComponent> T addC(T com, int x, int y, int w, int h) {
		com.setBounds(x, y, w, h);
		return com;
	}
}
