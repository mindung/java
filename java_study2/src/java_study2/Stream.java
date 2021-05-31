package java_study2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Stream {

	public static void main(String[] args) {
		
//		Stream문은 데이터의 흐름. 배열 or 컬렉션 인스턴스에 함수 여러 개를 조합해서 원하는 결과를 필터링하고 가공된 결과를 얻을 수 있다.
//		Java 8버전부터 
//		람다 이용할 수 있는 기술 중 하나
		
//		더욱 더 안전하고, 깔끔.
//		 안전: 버그가 잘 안일어남, 버그를 쉽게 발견함.
//		 깔끔: 변수 선언이 줄어들고 짧아짐.
//		
//		 정수 배열이 있음.
//		 짝수만 추출하여 출력.
		
				var data = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
				var data1 = new int[] {1, 2, 8, 3, 4, 5, 6, 7};
					
				System.out.println("For문");
				// for문으로 푸는 법
				for (int i : data) {
					if (i % 2 == 0) {
						System.out.println(i);	
					}
				}
				
//				----------------------------------------------
				System.out.println("Stream문");
				
				// Stream 으로 푸는 법
				Arrays.stream(data) // 배열을 흐르는 줄기로 만듦
					.filter(i -> i % 2 == 0) // 데이터가 filter를 거침
					.forEach(System.out::println); // forEach 거침
				
				// Stream 합계 구해보자!
				System.out.println(Arrays.stream(data).sum());
				
				// 짝수의 합계는?
				System.out.println(Arrays.stream(data)
						.filter(i -> i % 2 == 0)
						.sum());
				
				System.err.println("평균");
				System.out.println(Arrays.stream(data).
						filter(i -> i % 2 == 0)
						.average().getAsDouble());

				System.err.println("최소값");
				System.out.println(Arrays.stream(data)
						.filter(i -> i % 2 == 0)
						.min().getAsInt());
				
				System.out.println("정렬");
				System.out.println(Arrays.stream(data1)
						.sorted()
						.boxed()
						.collect(Collectors.toList()));

				// 모든 값을 2씩 곱해서 출력
				Arrays.stream(data)
				.map(i -> i * 2)
				.forEach(System.out::println);

//				getAsInt, getAsDouble 등등 수식을 적어줘야 하는 것 들도 있다.
				
// ------------------------------------------------------------------------
				// 정규식
				String test = " ";
				// ^시작
				// $ 끝
				// + 1개 이상 (앞자리 패턴)
				// * 0개 이상 (앞자리 패턴)
				// \\d digit 숫자 [0-9]
				System.out.println(test.matches("^\\d+$"));
				
	}
}
