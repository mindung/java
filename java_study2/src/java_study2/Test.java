package java_study2;

public class Test {

	public static void main(String[] args) {
		int i = 0;
		
		// 먼저 피연산자의 값을 1 증가시킨 후에 해당 연산을 진행함.
		System.out.println(++i);
		System.out.println(++i);
		System.out.println(++i);
		System.out.println(i);
		// 출력 값 : 1, 2, 3
		
		// 먼저 해당 연산을 수행하고 나서, 피연산자의 값을 1 증가시킴.
		
		i = 0;
		System.out.println(i++);
		System.out.println(i++);
		System.out.println(i++);
		System.out.println(i);
		// 출력 값 : 0, 1, 2
	}
}
