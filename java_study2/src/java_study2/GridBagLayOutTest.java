package java_study2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

import frame.BaseFrame;

public class GridBagLayOutTest extends BaseFrame{

	private JButton[] btn = new JButton[4];
	public GridBagLayOutTest() {
		super("Test", 500, 500);
		
		var panel = new JPanel(new GridBagLayout());
		var gbc = new GridBagConstraints();
		var strBtn = "A,B,C,D".split(",");
		
		// gbc 역할 -> 메소드(판넬) 실행시 실행되는 .. 세부 조건이랄까..?
		// 비중이 있으면 셀 크기가 변화한다.
		// x, y 지정 > 나머지 공백
		// fill -> 꽉 찬
		// weightX -> 비중 (비율) 가중치
		// weightY -> 1로 지정하면 크기가 일정하다.

//		gbc.gridheight = 1;
//		gbc.gridwidth = 100;
//		gbc.fill = GridBagConstraints.HORIZONTAL ;
		
		for (int i = 0; i < strBtn.length; i++) {
			gbc.gridx = i+ 1 ; // 해당 컴포넌트가 어디에 위치할 지 x축 좌표
			gbc.gridy = i ;   // 

			panel.add(btn[i] = new JButton(strBtn[i]), gbc);
		}
		
		add(panel);
		
	}
	
	public static void main(String[] args) {
		new GridBagLayOutTest().setVisible(true);
	}
	
}
