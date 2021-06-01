package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class NumberInfo extends BaseFrame{

	public boolean isPermit = false;
	
	private JTextField tf = new JTextField(15);
	
	private JPanel pnlMsg = new JPanel(new FlowLayout());
	private int userNum;
	
	public NumberInfo() {
		super("인증번호", 300, 500);
		setLocation(300 + 200, this.getHeight());
		
		userNum = randomIdx();
		System.out.println(userNum);
		addPanel(String.format("인증번호 %d \n\n 입력해주세요.", userNum), "출력");
		
		var btn = createButton("확인", e -> addPanel(tf.getText(), "입력"));
		var pnlSouth = new JPanel(new FlowLayout());
		
		pnlSouth.add(tf);
		pnlSouth.add(btn);
		add(pnlMsg);
		add(pnlSouth, BorderLayout.SOUTH);
		
	}
	
	private void addPanel(String text, String type) {
		
		if(text.isEmpty()) {
			eMessage("인증번호를 입력하세요.");
			return;
		}
		
		var panel = new JPanel();
		panel.add(new JLabel(text, type.equals("입력") ? JLabel.RIGHT : JLabel.LEFT));
		panel.setPreferredSize(new Dimension(250, 30));
		
		panel.setBorder(new LineBorder(Color.BLACK));
		pnlMsg.add(panel);
		pnlMsg.updateUI();
		
		tf.setText("");
		
	}
	
	private int randomIdx() {
		int random = (int) (Math.random() * 999999) + 100000;
		return random;
		
		// (int) (Math.random() * x) + y;
		// x 값은 랜덤 숫자가 나올 수 있는 값이 존재하는 숫자 범위, 값은 시작값
	}
	
	public static void main(String[] args) {
		new NumberInfo().setVisible(true);
	}
}
