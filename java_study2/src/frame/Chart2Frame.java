package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

public class Chart2Frame extends BaseFrame{

//	private Color[] colors = {Color.GREEN, Color.PINK, Color.BLACK, Color.YELLOW, Color.cyan, Color.BLUE};
	
	private int colors[] = {0x4e008e, 0x0084ca, 0xff7276, 0x8b6f4e, 0x00ab84, 0xffd900};
	
	private String[] str = {"A", "B", "C", "D", "E", "F"};
	
//	private int data[][] = {{3, 9, 10, 9, 4, 7},
//							{5, 9, 6, 5, 2, 3},
//							{10, 5, 5, 3, 9, 5},
//							{12, 5, 7, 8, 7, 2},
//							{11, 8, 2, 9, 6, 3},
//							{1, 8, 5, 5, 0, 10}};
	
	private int data[][] = {{3, 5, 10, 12, 11, 1},
							{9, 9, 5, 5, 8, 8},
							{10, 6, 5, 7, 2, 5},
							{9, 5, 3, 8, 9, 5},
							{4, 2, 9, 7, 6, 0},
							{7, 3, 5, 2, 3, 10}};

	private JPanel pnlCenter = new JPanel(null);
	
	public Chart2Frame() {
		
		super("PolygonChart", 1280, 720);

		createLegend();
		createChart();
	}

	private void createChart() {
		add(pnlCenter);
		Chart chart = new Chart();
		pnlCenter.add(chart);
		chart.setBounds(0, 0, 1200, 720);
	}

	private void createLegend() {

		JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
		pnlCenter.add(panel);
		panel.setBounds(1200, 320, 40, 150);

		for (int i = 0; i < 6; i++) {
			JPanel panel2 = new JPanel();
			panel.add(panel2);
			panel.add(new JLabel(str[i]));
			panel2.setBackground(new Color(colors[i]));
			panel2.setOpaque(true);
			panel2.setPreferredSize(new Dimension(10, 10));
			
		}
	}
	
	class Chart extends JPanel {
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			int num = 12;
			int minX = 80;
			int minY = 570;

			for (int i = 0; i < 7; i++) {
				g.setColor(Color.BLACK);
				g.drawLine(minX, minY - (i * 80), 1100, minY - (i * 80));
				g.drawString(String.valueOf(num), 60, (i * 80) + 90);
				g.drawString(String.valueOf(i + 2010), minX + (i * 200), 600);
				num -= 2;
			}
			
			int[] x = new int[8];
			int[] y = new int[8];
			
			for (int i = 0; i < 6; i++) {
				x[0] = minX;
				y[0] = minY;
				
				g.setColor(new Color(colors[i]));
				
				for (int j = 0; j < 6; j++) {
					x[j + 1] = minX + (j * 205);
					y[j + 1] = minY - (data[i][j] * 40);
				}

				x[7] = x[6];
				y[7] = minY;

				g.fillPolygon(x, y, 8);
			}
		}
	}

	public static void main(String[] args) {
		new Chart2Frame().setVisible(true);
	}
}
