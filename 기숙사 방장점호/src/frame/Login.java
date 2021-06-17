package frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends BaseFrame{

	private JTextField tf[] = {new JTextField(), new JPasswordField()};
	public Login() {
		super("로그인", 330, 190);
		
		var pnl = new JPanel(new BorderLayout());
		var panel = new JPanel(new GridLayout(2, 2, -100, 10));
		var str = "아이디,비밀번호".split(",");
		var btn = new JButton("로그인");
		
		for (int i = 0; i < tf.length; i++) {
			panel.add(new JLabel(str[i]));
			panel.add(tf[i]);
		}
		
		pnl.add(panel, BorderLayout.CENTER);
		pnl.add(btn, BorderLayout.EAST);
		
		add(pnl);
//		btn.setBorder(new EmptyBorder(5, 5, 5, 5));
//		panel.setBorder(new EmptyBorder(15, 20, 15, 20));
	}
	
	public static void main(String[] args) {
		new Login().setVisible(true);
	}
}

