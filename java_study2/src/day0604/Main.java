package day0604;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame{

	
	private DefaultTableModel dtm = new DefaultTableModel(new String[] {"no", "", "name", "etc"},  0);
	private JTable table = new JTable(dtm) {
		
		public Class getColumnClass(int column) {
			switch (column) {
			case 1: 
				return Boolean.class; // Boolean.Class check! Type : blue!@ 
			default:
 				return String.class;
			}
			
		};
	};
	
	public Main(){
		setTitle("Test");
		setSize(600, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		var jsp = new JScrollPane(table);
		add(jsp);
		
		dtm.addRow(new Object[] {
				1, true,"nana", "",
//				2, false,"mimi", ""
		});
	}

	public static void main(String[] args) {
		new Main().setVisible(true);
	}
}
