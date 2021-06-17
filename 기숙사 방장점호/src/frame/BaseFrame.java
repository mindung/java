package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;

import jdbc.DbManager;

public class BaseFrame extends JFrame{

	public static DbManager dbManager = new DbManager();
	
	public static String u_def = "";
			
	public static Integer u_floor = 1;
	
	public static String d_name = "";
	public static String selectedDate = "";
	public static String selectedBed= "";
	
	
	protected DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	protected <T extends JComponent> T addC(T com, int w, int h ) {
		com.setPreferredSize(new Dimension(w, h));
		return com;
	}

	protected <T extends JComponent> T createCom(T com) {
		com.setBackground(Color.WHITE);
		com.setOpaque(true);
		return com;
	}
	
	protected void openFrame(JFrame frame) {
		dispose();
		frame.setVisible(true);
	}
	
	protected void iMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "확인", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	protected void eMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "오류", JOptionPane.ERROR_MESSAGE);
	}
	
	public BaseFrame(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	

	protected <T extends JComponent> T addC(T com, int x, int y, int w, int h) {
		com.setBounds(x, y, w, h);
		return com;
	}
	
	protected JLabel createLabel(String text, int h, String font, int st, int s) {
		JLabel lb = new JLabel(text , h);
		lb.setFont(new Font(font, st, s));
		return lb;
	}
	
	protected ImageIcon getIcon(String path, int w, int h) {
		return new ImageIcon(Toolkit.getDefaultToolkit().getImage(path).getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}
}
