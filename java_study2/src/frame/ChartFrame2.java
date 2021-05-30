package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChartFrame2 extends BaseFrame{

	private int data[][] = {{3, 5, 10, 12, 11, 1},
							{9, 9, 5, 5, 8, 8},
							{10, 6, 5, 7, 2, 5}, 
							{9, 5, 3, 8, 9, 5},
							{4, 2, 9, 7, 6, 0},
							{7, 3, 5, 2, 3, 10}};
	
	private int[] colors = { 0x4e008e,  0x0064ca, 0xff7276, 0x8b5f4e, 0x00ab84 , 0xffe900};
	private String[] xData = {"A", "B", "C", "D", "E", "F"};
	private JPanel pnlCenter = new JPanel(null);
	
	public ChartFrame2() {
		super("Polygon Chart", 1270, 720);
		createChart();
		createLegend();
	}
	
	
	private void createChart() {
		add(pnlCenter);
		Chart chart = new Chart();
		pnlCenter.add(chart);
		chart.setBounds(0, 0, 1200, 720);
	
	}
	
	private void createLegend() {
		JPanel pnl = new JPanel(new GridLayout(6, 2, 10, 10));
		pnlCenter.add(pnl);
		pnl.setBounds(1200, 320, 40, 150);
		
		for (int i = 0; i < colors.length; i++) {
			JLabel lb = new JLabel();
			pnl.add(lb);
			pnl.add(new JLabel(xData[i]));
			lb.setBackground(new Color(colors[i]));
			lb.setOpaque(true);
			lb.setPreferredSize(new Dimension(10, 10));
		}
	}
	
	class Chart extends JPanel{

		@Override
		public void paint(Graphics g) {
			super.paint(g);

			int num = 12;
			int minX = 80;
			int minY = 570;

			g.setColor(Color.BLACK);
			
			for (int i = 0; i < 7; i++) {
				g.drawLine(minX, minY - ( i * 80), 1100, minY - ( i * 80));
				g.drawString(String.valueOf(num), 60, (i * 80) + 90);
				g.drawString(String.valueOf(2010 + i), minX + (i * 200), 600);
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
		new ChartFrame2().setVisible(true);
	}
}
