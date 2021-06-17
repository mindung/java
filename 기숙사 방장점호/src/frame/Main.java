package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends BaseFrame{

	
	public Main() {
		super("메인", 450, 450);
		
		var panel = new JPanel(new GridLayout(2, 2));
		var str = "방장 점호, 벌점&상점, 게시판".split(",");
		
		for (int i = 0; i < str.length; i++) {
			var btn = new JButton(str[i]);
			panel.add(btn);
			btn.setFont(new Font("맑은 고딕", Font.BOLD, 25));
			btn.setForeground(Color.WHITE);
			if (i == 0) {
				btn.setBackground(Color.red);
			} else if (i == 1) {
				btn.setBackground(Color.blue);
				
			} else if (i == 2) {
				btn.setBackground(Color.ORANGE);
			}
			
			ActionListener a[] = {e -> openFrame(new RoomManage1()),
					e -> openFrame(new RoomManage1()), 
					e -> openFrame(new RoomManage1()),
					};
			
			btn.addActionListener(a[i]);
		}
		
		panel.add(new JLabel(getIcon("./고양이.jpg", 250, 250)));
		add(panel);
	}
	
	public static void main(String[] args) {
		new Main().setVisible(true);
	}
}
