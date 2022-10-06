package Chart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChartFrame5 extends BaseFrame{

	private int[] colors = {0x4e008e, 0x0084ca, 0xff7276, 0x8b6f4e, 0x00ab84, 0xffe900};
	
	private int[][] data = {{5, 10, 13, 9, 4, 7},
							{5, 9, 16, 5, 2, 20},
							{3, 5, 5, 3, 9, 7},
							{1, 12, 7, 8, 7, 2},
							{4, 8, 1, 17, 6, 3},
							{3, 7, 5, 12, 1, 8}};
	
	private String[] xTitle = {"A", "B", "C", "D", "E", "F"};
	
	private JPanel pnlCenter = new  JPanel(null);
	
	private Diamond dia = new Diamond(1280 / 2, 720 / 2, 300);
	
	public ChartFrame5() {
		super("Company growth rate", 1270, 720);
		createChart();
		createLegend();
	}
	
	class Chart extends JPanel{
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.BLACK);
			
			Diamond diamond = new Diamond(1280 / 2,  720 / 2, 300);
	         
			for (int i = 0; i < 4; i++) {
				Diamond dia = new Diamond(1280 / 2, 720 / 2, 300 - (i * 90));
				g.drawPolygon(dia.pointX, dia.pointY, 6);
			}
			
			 for (int i = 0; i < 6; i++) {
		            g.setColor(Color.BLACK);
		            g.drawString(String.valueOf(2010 + i), diamond.pointX[i], diamond.pointY[i]);            
		         }

		         for (int i = 0; i < 6; i++) {
		            int centerX = diamond.centerX;
		            int centerY = diamond.centerY;
		            
		            int[] x = new int[6];
		            int[] y = new int[6];

		            g.setColor(new Color(colors[i]));
		            
		            for (int j = 0; j < 6; j++) {
		               
		               int length = 15 * data[i][j];
		               int b = (int) (length * Math.sin(Math.toRadians(30)));
		               int a = (int) Math.sqrt(length * length - b * b);
		               
		               x[j] = centerX;
		               y[j] = centerY;
		               
		               if(j == 0) {
		                  y[j] -= length;
		               } else if(j == 1) {
		                  x[j] += a;
		                  y[j] -= b;
		               } else if(j == 2) {
		                  x[j] += a;
		                  y[j] += b;
		               } else if(j == 3) {
		                  y[j] += length;
		               } else if (j == 4) {
		                  x[j] -= a;
		                  y[j] += b;
		               } else if (j == 5) {
							x[j] -= a;
							y[j] -= b;
						}
					}
					g.fillPolygon(x, y, 6);         
		         }
			
			int num = 20;

			for (int i = 0; i < 5; i++) {
				g.setColor(Color.BLACK);
				g.drawString(String.valueOf(num), dia.centerX - 20, dia.pointY[0] + (i * 80));
				num -= 5;
			}
		}
	}
	
	class Diamond {
		int centerX;
		int centerY;
		
		int[] pointX;
		int[] pointY;
		
		public Diamond(int x, int y, int length) {
			centerX = x;
			centerY = y;
			
			int b = (int) (length * Math.sin(Math.toRadians(30)));
			int a = (int) Math.sqrt(length * length - b * b);
			
			pointX = new int[] {centerX, centerX + a, centerX + a, centerX, centerX - a, centerX - a};
			pointY = new int[] {centerY - length, centerY - b, centerY + b, centerY + length, centerY + b, centerY - b};
		}
		
	}
	
	private void createChart() {
		Chart chart = new Chart();
		pnlCenter.add(chart);
		chart.setBounds(0, 0, 1100, 720);
		add(pnlCenter);	
	}
	
	private void createLegend() {
		JPanel pnl = new JPanel(new GridLayout(6, 2, 10, 10));
		pnlCenter.add(pnl);
		
		for (int i = 0; i < 6; i++) {
			JLabel lb = new JLabel();
			pnl.add(lb);
			pnl.add(new JLabel(xTitle[i] ));
			lb.setOpaque(true);
			lb.setPreferredSize(new Dimension(10, 10));
			lb.setBackground(new Color(colors[i]));
		}
		pnl.setBounds(1150, 300, 30, 120);
	}
	
	public static void main(String[] args) {
		new ChartFrame5().setVisible(true);
	}
}


