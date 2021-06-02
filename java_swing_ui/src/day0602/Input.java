package day0602;

import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import frame.BaseFrame;

public class Input extends BaseFrame{

	JTextField tf = new JTextField();
	JTextField tf1 = new JTextField();

	public Input()  {
		super("입력", 300, 350);
		setLayout(null);
		
		var btn = new JButton("회원가입");
		var btn1 = new JButton("예약");
		
		add(addC(btn, 0, 0, 100, 100));
		add(addC(btn1, 110, 0, 100, 100));
		add(addC(tf, 0, 110, 100, 20));
		add(addC(tf1, 110, 110, 100, 20));
		
		btn.addActionListener(e -> new Calendar(str -> tf.setText(str)).setVisible(true));
		btn1.addActionListener(e -> new Calendar(str -> tf1.setText(str)).setVisible(true));
		
		// 메소드 레퍼런스
		// 람다 표현식에서 메서드 호출 1회로 코드가 끝난다면 - > 이 기법을 이용하면 코드를 더 짧게 적음.
		// 메서드 레퍼런스는 메서드명 앞에 구분자 (::)를 붙이는 방식

//		btn1.addActionListener(e -> new Calendar(this::clickBtn1).setVisible(true));
		
	}
	
	private void clickBtn1(String text) {
		this.tf1.setText(text);
	}
	
	public static void main(String[] args) {
		new Input().setVisible(true);
	}
}
