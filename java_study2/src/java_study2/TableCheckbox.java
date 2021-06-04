package java_study2;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TableCheckbox extends JFrame {

    private JTable table;
    public TableCheckbox() {
        Object[] columnNames = {"Type", "Company", "Shares", "Price", "Boolean"};
        Object[][] data = {
            {"Buy", "IBM", new Integer(1000), new Double(80.50), false},
            {"Sell", "MicroSoft", new Integer(2000), new Double(6.25), true},
            {"Sell", "Apple", new Integer(3000), new Double(7.35), true},
            {"Buy", "Nortel", new Integer(4000), new Double(20.00), false}
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        
        table = new JTable(model) {

            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                case 4:
                	return Boolean.class;
                default:
                    return String.class;
                }
            }
        };
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	TableCheckbox frame = new TableCheckbox();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocation(150, 150);
                frame.setVisible(true);
            }
        });
    }
}