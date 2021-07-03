package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoomManage3 extends BaseFrame{

	public RoomManage3() {
		super("호수 정하기", 800, 600);

		var pnlC = new JPanel(new BorderLayout());
		add(pnlC, BorderLayout.CENTER);
		
		var pnlG = new JPanel(new GridLayout(2, 1));
		add(pnlG, BorderLayout.NORTH);

		var pnl = new JPanel();		
		pnlG.add(pnl);
		pnlG.add(createLabel(String.format("%d층", u_floor), JLabel.CENTER, "맑은 고딕", Font.BOLD, 25));
		
		var b = new JButton("이전으로");
		pnl.add(createLabel("방장점호 학과 선택", JLabel.CENTER, "맑은 고딕", Font.BOLD, 30));
		pnl.add(b);
		b.addActionListener(e -> openFrame(new RoomManage1()));

		var str = "자동화 기계과,전기전자 제어과".split(",");
		var panel = new JPanel(new FlowLayout());
		pnlC.add(panel, BorderLayout.NORTH);

		for (int i = 0; i < str.length; i++) {
			var btn = new JButton(str[i]);
			btn.setPreferredSize(new Dimension(150, 100));
			panel.add(btn);
			if (!u_def.equals(str[i])) {
				btn.setEnabled(false);
			}
		}
	}
	public static void main(String[] args) {
		new RoomManage3().setVisible(true);
	}
}
