package closure;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	
	public MainFrame() {
		setSize(500, 500);
		setTitle("날짜선택");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		var btn1 = new JButton("달력1");
		var btn2 = new JButton("달력2");

		
		btn1.setBounds(0, 0, 100, 100);
		btn2.setBounds(130, 0, 100, 100);
		tf1.setBounds(0, 130, 100, 20);
		tf2.setBounds(130, 130, 100, 20);
		
		add(btn1);
		add(btn2);
		add(tf1);
		add(tf2);
		
		btn1.addActionListener(e -> {
			// new CalendarFrame(str -> System.out.println(str)).setVisible(true);
			new CalendarFrame(str -> tf1.setText(str)).setVisible(true);
			// new CalendarFrame(this::clickBtn1).setVisible(true);
		});

		btn2.addActionListener(e -> {
			new CalendarFrame(this::clickBtn2).setVisible(true);
		});
	}
	
	private void clickBtn1(String text) {
		this.tf1.setText(text);
	}
	private void clickBtn2(String text) {
		this.tf2.setText(text);
	}
	public static void main(String[] args) {
		new MainFrame().setVisible(true);
	}
}
