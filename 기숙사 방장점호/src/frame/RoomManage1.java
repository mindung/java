package frame;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RoomManage1 extends BaseFrame{

	public RoomManage1() {
		super("������ȣ �� ���ϱ�", 400, 500);
		u_floor = 0;
		
		var panel = new JPanel(new GridLayout(4, 1, 0, 10));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel);
		
		var pnl = new JPanel();
		add(pnl, BorderLayout.NORTH);

		pnl.add(createLabel("���� ��ȣ �� ���ϱ�", JLabel.CENTER, "���� ���", Font.BOLD, 30), BorderLayout.NORTH);
		var b = new JButton("Ȩ����");
		pnl.add(b);

		for (int i = 4; i >= 1; i--) {
			int f = i;
			var btn = new JButton(String.format("%d��", i));
			panel.add(btn);
			btn.addActionListener(e -> {
				u_floor = f;
				openFrame(new RoomManage2());
			});
		}
		
		b.addActionListener(e -> openFrame(new Main()));
	}
	
	public static void main(String[] args) {
		new RoomManage1().setVisible(true);
	}
}
