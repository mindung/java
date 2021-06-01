package frame;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUp extends BaseFrame{
	
	private JTextField[] tf = new JTextField[5];
	
	public SignUp() {
		super("예시", 410, 400);
		setLayout(null);
		
		var panel = new JPanel(new GridLayout(5, 2, -70, 20));
		var btn = createButton("인증번호 받기", e -> getNumber());
		
		add(addC(panel, 20, 20, 250, 300));
		add(addC(btn, 280, 280, 110, 30));
		
		var str = "이름, 비밀번호, 비밀번호체크, 전화번호, 인증번호".split(", ");
		for (int i = 0; i < str.length; i++) {
			panel.add(new JLabel(str[i]));
			panel.add(tf[i] = new JTextField());
			if(i == 4) {
			}
		}
	}
	
	private void getNumber() {
		System.err.println(tf[3].getText());
		NumberInfo nbInfo = new NumberInfo();
		
		nbInfo.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				tf[4].setText(nbInfo.isPermit ? "허용됨" : "다시 검사");
			}
		});
	
		nbInfo.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SignUp().setVisible(true);
	}
}
