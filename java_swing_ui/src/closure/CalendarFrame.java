package closure;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CalendarFrame extends JFrame {
	
	public CalendarFrame(TextTransfer textTransfer) {
		setSize(300, 300);
		setTitle("날짜선택");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		var tf1 = new JTextField();
		var btn1 = new JButton("입력");
		
		btn1.setBounds(0, 0, 100, 100);
		tf1.setBounds(0, 130, 100, 20);
		
		add(btn1);
		add(tf1);
		
		btn1.addActionListener(e -> {
			textTransfer.sendText(tf1.getText());
			dispose();
		});
	}
	
}
