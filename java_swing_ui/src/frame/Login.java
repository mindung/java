package frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends BaseFrame{

	private JTextField[] tf = {new JTextField(), new JPasswordField()}; 
			
	public Login() {
		super("로그인", 330, 180);
		var panel = new JPanel(new GridLayout(2, 2, -150, 10));
		var btn = addC(createButton("로그인", e -> login()), 330, 35);
		
		add(panel);
		add(btn, BorderLayout.SOUTH);
		
		var strTf = "아이디,비밀번호".split(",");
		ActionListener[] actionArray = {
			e -> login(),
			e -> dispose(),
			e -> {
				this.setTitle("asd");
			}
		};
		
		
		for (int i = 0; i < strTf.length; i++) {
			panel.add(new JLabel(strTf[i]));
			panel.add(tf[i]);
			// createButton("로그인", actionArray[i]);
		}
		// stream(Arrays), split(",")
	}
	
	private void login() {
		String id = tf[0].getText();
		String pw = tf[1].getText();

		if(id.isEmpty() || pw.isEmpty()) return;
		
		try {
			var rs = getRs("select * from member where id = ? and pw = ?", id, pw);
			if (rs .next()) {
				iMessage(String.format("%s님 환영합니다.", rs.getString(4)));
			} else {
				eMessage("아이디 혹은 비밀번호를 다시 입력해주세요.");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Login().setVisible(true);
	}
}
