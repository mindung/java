package day0604;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
	
	JCheckBox cb =  new JCheckBox("전체선택");
	public Main(){
		setTitle("Test");
		setSize(600, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		var jsp = new JScrollPane(table);
		var panel = new JPanel(new FlowLayout());
		
		add(panel.add(cb), BorderLayout.NORTH);
		add(jsp);
		
		Object[][] objects = {{1, true,"nana", ""},
				{2, false,"mimi", ""}, 
				{3, table,"keke", ""}};
		
//		dtm.addRow(objects);
//		for (int i = 0; i < objects.length; i++) {
//			
//		}
//		dtm.addRow(new Object[] {
//				1, true,"nana", "",
////				2, false,"mimi", ""
//		});
		
		dtm.addRow(new Object[] { 1, true,"nana", ""});
		dtm.addRow(new Object[] { 2, false,"mimi", ""});
		dtm.addRow(new Object[] { 3, false,"simi", ""});
		dtm.addRow(new Object[] { 4, true,"hana", ""});
		
		cb.addActionListener(e -> cbCheck());
//		table.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				if((boolean) table.getValueAt(table.getSelectedRow(), 1)) {
//					
//				}
//			}
//		});
	}

	private void cbCheck() {
		for (int i = 0; i < table.getRowCount(); i++) {
			table.setValueAt(cb.isSelected(), i, 1);
		}
	}
	
	public static void main(String[] args) {
		new Main().setVisible(true);
	}
}
