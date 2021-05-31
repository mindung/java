package day0351;

import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Test extends BaseFrame{

	public Test() {
		super("test", 400, 400);
		
		overideTest = new OverideTest(380, 100, 0, 0);
		
		String head[] = {"id","내자/외자","공급사명","제작/일반","사업자번호","대표자"};
		overideTest.setHeader(head);
		overideTest.setColumnCenter();
		overideTest.setColSize(1, 100);
		
		add(overideTest.pnl);
//		add(new Test1());
		
		overideTest.dtm.addRow(new Object[] {
				"가","나","다","라","마","바"
		});
		overideTest.setColumnCenter();
		
//		overideTest.addDataSource(null);
	}
	
	class Test1 extends JPanel{

		DefaultTableModel dtm = new DefaultTableModel(new String[] {"번호","이름"}, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		JTable table = new JTable(dtm);
		
		public Test1() {
			var jsp = new JScrollPane(table);
			add(jsp);
		}
	}
	
	public static void main(String[] args) {
		new Test().setVisible(true);
	}
	
	
}
