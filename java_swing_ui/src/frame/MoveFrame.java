package frame;

import java.sql.Connection;
import java.util.Random;

public class MoveFrame extends BaseFrame{

	public MoveFrame() {
		super("움직이는 폼", 400, 600);
		
		Thread t = new Thread(() -> {
			int r = 5000;
			try {
				while (r > 0) {
					Thread.sleep(10);
					
					Random random = new Random();
					System.out.println(random.nextInt()% 5);
					int x = getX() + random.nextInt() % 5; // 새위치x // rdIdx(); // 
					int y = getY() + random.nextInt() % 5; // + random.nextInt() % 5; // 새위치y rdIdx();
					setLocation(x, y); // 프레임의 위치 이동
					System.out.println(x + ", " + y);
					r = r - 100;
					System.out.println(r);
				}
				
			} catch (Exception e) {
//				return;
				e.printStackTrace();
			}
		
//			System.out.println(x);
//			System.out.println(y);
//			System.out.println("실행");
		});
		
		t.start();
	}
	
	private int rdIdx() {
		int randomIdx = (int) (Math.random() * 9) + 1;
		return randomIdx;
	}
	public static void main(String[] args) {
		new MoveFrame().setVisible(true);
	}
}
