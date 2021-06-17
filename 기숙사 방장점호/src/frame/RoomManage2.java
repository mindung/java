package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RoomManage2 extends BaseFrame{

	public RoomManage2() {
		super("�а� ����", 400, 250);
		
		var b = new JButton("Ȩ����");
		var panel = new JPanel(new GridLayout(1, 2, 0, 5));
		add(panel);

		var pnlS = new JPanel();
		pnlS.setPreferredSize(new Dimension(400, 20));
		add(pnlS, BorderLayout.SOUTH);
		
		var pnl = new JPanel();
		pnl.add(createLabel("������ȣ �а� ����", JLabel.CENTER,"���� ���" ,Font.BOLD, 30), BorderLayout.NORTH);
		pnl.add(b);
		add(pnl, BorderLayout.NORTH);

		var str = "�ڵ�ȭ ����,�������� �����".split(",");
		for (int i = 0; i < str.length; i++) {
			var btn = new JButton(str[i]);
			btn.setName(str[i]);
			panel.add(btn);

			btn.addActionListener(e -> {
				u_def = btn.getName();
				openFrame(new RoomManage3());
			});
		}

		b.addActionListener(e -> openFrame(new RoomManage1()));
	}
	
	public static void main(String[] args) {
		new RoomManage2().setVisible(true);
	}
}
