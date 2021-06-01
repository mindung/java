package java_study2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Iterator;

import javax.swing.JButton;

import Chart.BaseFrame;

public class TestFrame extends BaseFrame{

	private JButton[] btn = new JButton[5];
	
	public TestFrame() {
		super("Test", 300, 300);
		setLayout(new FlowLayout());

		System.out.println("CurSor 예제");
//		point(x, y)
//		정수 정밀도로 지정되는 (x, y) 좌표 공간에서의 위치를 나타내는 점
//		좌표 공간의 지정된 위치 (x,  y)에 점을 구축해 초기화합니다.

		Image image = Toolkit.getDefaultToolkit().getImage("pencil.jpg");
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), "pencil");
		setCursor(cursor);
	    
		System.out.println("switch 예제");
		// switch문은 어떤 !!변수의 값!!에 따라서 문장을 실행할 수 있도록 하는 제어문
		//  switch 장점은 비교하고자 하는 조건이 많을 경우 가독성이 좋음
		
		// 연산자  int형 범위의 정수값
		// 키워드는 switch, case, default, break
		// break 문장이 있을 경우와 없을 경우를 확실하게 구분!
		// break 문 : 실행을 멈추고 블록 빠져나오기

		//  default 값을 설정하면 조건에 맞지 않는 값은 default의 수행문
		
		var strBtn = "회원 등록/삭제, 도서 등록/삭제, 도서 대여/반납, 모든 대여 정보,종료".split(",");
		for (int i = 0; i < strBtn.length; i++) {
			add(addC(btn[i] = new JButton(strBtn[i]), 150, 35));
			switch (i) {
			case 0: case 1: case 2: // 조건 제시 
				btn[i].setBackground(Color.WHITE); 
				break; // 실행 멈춤 블록 빠져나감
			case 4:
				btn[i].setBackground(Color.yellow);
				break;
			default:
				btn[i].setBackground(Color.pink);
				break;
			}
			
		}
//		void[] o = {btn1(), btn2()};	
		
	}
	
	public static void main(String[] args) {
		new TestFrame().setVisible(true);
	}
}
