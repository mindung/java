package day0351;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Chart.BaseFrame;

public class OverideTest {
	
	public DefaultTableModel dtm;
	public JTable table;
	public JScrollPane jsp;
	public JPanel pnl;
	
	public OverideTest(int width, int height, int x, int y) {
		dtm = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(dtm);
		table.setSize(width, height);
		table.getTableHeader().setReorderingAllowed(false);
		
		jsp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setSize(width, height);
		
		pnl = new JPanel(null);
		pnl.setBounds(x, y, width, height);
		pnl.add(jsp);
		
	}

	public void setColSize(int num, int size) {
		table.getColumnModel().getColumn(num).setWidth(size);

	}
	
	public void addDataSource(ResultSet rs) {
		String data[] = new String[table.getColumnCount()];
		
		try {
			while (rs.next()) {
				for (int i = 0; i < data.length; i++) {
					data[i] = rs.getString(i + 1);
				}
				
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void setHeader(String head[]) {
		for (String col : head) {
			dtm.addColumn(col);
		}
	}
	
	public void setColumnCenter() {
		DefaultTableCellRenderer cell = new DefaultTableCellRenderer();
		cell.setHorizontalAlignment(cell.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(cell);
		}
	}
}
