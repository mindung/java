package day0602;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import frame.BaseFrame;

public class Calendar extends BaseFrame{

private String[] Days = {"일","월","화","수","목","금","토","일"};
	
	private JPanel pnlDays = new JPanel(new GridLayout(6 , 7));
	private JLabel lbDate = new JLabel("",JLabel.CENTER);
	
	private LocalDate date = LocalDate.now();
	private LocalDate now = LocalDate.now();
	TextTransfer text;
	
	public Calendar(TextTransfer text) {
		super("달력", 300, 350);
		this.text = text;
		
		var pnlNorth = new JPanel();
		var pnlWeekDay = new JPanel(new GridLayout(1, 7));
		var pnlCalendar = new JPanel(new BorderLayout());
		var btnPrev = new JButton("◀");
		var btnNext = new JButton("▶");
		
		pnlNorth.add(btnPrev);
		pnlNorth.add(lbDate);
		pnlNorth.add(btnNext);
		
		pnlCalendar.add(pnlWeekDay,BorderLayout.NORTH);
		pnlCalendar.add(pnlDays);
		
		add(pnlCalendar);
		add(pnlNorth,BorderLayout.NORTH);
		add(new JPanel(),BorderLayout.SOUTH);
		
		btnPrev.addActionListener(e -> getPrve());
		btnNext.addActionListener(e -> getNext());
		
		var Days = "일,월,화,수,목,금,토".split(",");
		for (int i = 0; i < Days.length -1 ; i++) {
			JLabel lb = new JLabel(Days[i],JLabel.CENTER);
			lb.setForeground(i == 0 ? Color.red : (i == 6 ? Color.BLUE : Color.BLACK));
			pnlWeekDay.add(lb);
		}
		getDays();
	}
	
	public static void main(String[] args) {
//		TextTransfer text;
//		new Calendar(e -> text).setVisible(true);
	}

	private void getPrve() {
		date = date.minusMonths(1);
		getDays();
	}
	
	private void getNext() {
		date = date.plusMonths(1);
		getDays();
	}
	
	private void getDays() {
		pnlDays.removeAll();		
	
		lbDate.setText(date.format(DateTimeFormatter.ofPattern("yyyy년 MM월")));
		LocalDate firstDay = LocalDate.of(date.getYear(), date.getMonth(), 1);
		
		for (int i = 0; i < firstDay.getDayOfWeek().getValue(); i++) {
			pnlDays.add(new JLabel());
		}
		
		for (int i = 1; i <= date.lengthOfMonth(); i++) { // date에 해당하는 일을 다 구해야함
			LocalDate day = LocalDate.of(date.getYear(), date.getMonth(), i); // 년,월 일(변수) 지정
			pnlDays.add(createButton(day));
		}

		while (pnlDays.getComponentCount() < 42) {
			pnlDays.add(new JLabel());
		}
	}
	
	private JButton createButton(LocalDate date) {
		var btn = new JButton(String.valueOf(date.getDayOfMonth()));
		
		btn.setForeground(date.getDayOfWeek() == DayOfWeek.SUNDAY ? Color.red : ( date.getDayOfWeek() == DayOfWeek.SATURDAY ? Color.BLUE : Color.BLACK));
		btn.setBorder(new LineBorder(Color.BLACK));
		
		if(date.compareTo(now) < 0) {
			btn.setEnabled(false);
		}
		
		btn.addActionListener(e -> {
			text.textSend(date.toString());
			dispose();
		});
		
		return btn;
	}
}
