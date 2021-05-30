package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ChartFrame1 extends BaseFrame{

	private Color[] colors = {Color.red, Color.green, Color.BLUE, Color.YELLOW, Color.BLACK, Color.orange, Color.WHITE};
	private String[] xTitles = {"RED","GREEN","BLUE","YELLOW","BLACK","ORANAGE","WHITE"};
	
	private int data[][] = {{30, 20, 10, 5, 0, 25, 20},
			  				{19, 17, 5, 3, 7, 8, 41},
			  				{43, 15,10,15,5,12,10},
			  				{25,10,10,10,20,15,20},
			  				{9,20,20,5,11,25,20},
							{10,20,19,12,13,11,25},
							{9,11,10,5,21,25,29},
							{45,20,12,15,10,25,20},
							{20,10,10,5,10,25,20},
							{4,24,7,15,3,21,36},
							{10,20,0,5,0,33,42},
							{10,10,10,5,0,15,60}};
	
	public ChartFrame1() {
		
		super("Yearly color perference survey", 1280, 720);				
		createLegend();
		createChart();
	}
	
	private void createLegend() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		add(panel, BorderLayout.NORTH);		
		
		for (int i = 0; i < colors.length; i++) {
			JLabel lb = new JLabel();
			lb.setBackground(colors[i]);
			lb.setOpaque(true);
			lb.setPreferredSize(new Dimension(10, 10));
			
			panel.add(lb);
			panel.add(new JLabel(xTitles[i]));
		}
	}
	
	private void createChart() {
		JPanel panel = new JPanel(new GridLayout(12, 1, 0, 30));
		panel.setBorder(new EmptyBorder(20, 10, 20, 10));
		add(panel);
		
		for (int i = 0; i < 12; i++) {
			
			JPanel panel2 = new JPanel(new BorderLayout());
			panel.add(panel2);

			panel2.add(new JLabel(String.valueOf(2010 + i) + " "), BorderLayout.WEST);
			
			JPanel panel3 = new JPanel(new GridBagLayout());

			panel2.add(panel3, BorderLayout.CENTER);
			
			for (int j = 0; j < 7; j++) {
				JPanel p = new JPanel();
				p.setBackground(colors[j]);
				gInsert(panel3, p, j, data[i][j]);
			}				
		}						
	}
	
	private void gInsert(JPanel pnl, Component com, int x, int w) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx =  x;
		gbc.weightx = w;
		gbc.weighty = 1.0;
		pnl.add(com, gbc);		
	}
	
	public static void main(String[] args) {
		new ChartFrame1().setVisible(true);
	}
}
