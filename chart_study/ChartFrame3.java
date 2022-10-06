package Chart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChartFrame3 extends BaseFrame{

	private int[] colors = {0x42008e, 0x0084ca, 0xff7276, 0x8b6f4e, 0x00ab84, 0xffe900 };
	private int[][] data = {{3, 5, 10, 12, 11, 1},
							{9, 9, 5, 5, 8, 8},
							{10, 6, 5, 7, 2, 5},
							{9, 5, 3, 8, 9, 5},
							{4, 2, 9, 7, 6, 0},
							{7, 3, 5, 2, 3, 10}};
	
	private String[] xTitle = {"A", "B", "C", "D","E", "F"};
	
	private JPanel pnlCenter = new JPanel(null);
	
	public ChartFrame3() {
		super("PolygonChart", 1270, 720);
		createChart();
		createLegend();
	}
	
	public static void main(String[] args) {
		new ChartFrame3().setVisible(true);
	}
	
	private void createLegend() {
	
		JPanel pnl = new JPanel(new GridLayout(6, 2, 10, 10));
		pnlCenter.add(pnl);
		pnl.setBounds(1150, 300, 40, 150);
		
		for (int i = 0; i < 6; i++) {
			JLabel lb = new JLabel();
			pnl.add(lb);
			pnl.add(new JLabel(xTitle[i]));
			lb.setOpaque(true);
			lb.setBackground(new Color(colors[i]));
			lb.setPreferredSize(new Dimension(10, 10));
		}
		
	}
	
	private void createChart() {
		Chart chart = new Chart();
		pnlCenter.add(chart);
		chart.setBounds(0, 0, 1100, 720);
		add(pnlCenter);
		
	}
	
	class Chart extends JPanel{
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			int num = 12;
			int minX = 80;
			int minY = 570;
			
			for (int i = 0; i < 7; i++) {
				g.setColor(Color.BLACK);
				g.drawLine(minX, minY - (i * 80), 1100, minY - (i * 80));
				g.drawString(String.valueOf(num), 60, 90 + (i * 80));
				g.drawString(String.valueOf(2010 + i), 70 + (i * 200), 600);
				num -= 2;
			}
			
			int[] x = new int[8];
			int[] y = new int[8];
			
			
			for (int i = 0; i < 6; i++) {
				x[0] = minX;
				y[0] = minY;
				g.setColor(new Color(colors[i]));
				
				for (int j = 0; j < 6; j++) {
					x[j + 1] = minX + ( j * 205);
					y[j + 1] = minY - ( data[i][j] * 40);
					
				}
				
				x[7] = x[6];
				y[7] = minY;
				
				g.fillPolygon(x, y, 8);
			}

		}
	}
}
