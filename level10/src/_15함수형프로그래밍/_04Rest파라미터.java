package _15함수형프로그래밍;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _04Rest파라미터 {

	public static int getSum(int... nums) { // int[] nums
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return sum;
	}

	public static void main(String[] args) {

		int[] arr = { 10, 20, 39 };
		System.out.println(getSum());
		System.out.println(getSum(10));
		System.out.println(getSum(10, 20, 30));
		System.out.println(getSum(10, 20, 30, 40, 50, 60, 70));
		System.out.println(getSum(arr));

		List<String> list = Arrays.asList("강아지", "고양이", "사자", "토끼");

		for (String element : list)
			System.out.println(element);

		// 리스트의 요소를 처음부터 끝까지 한개씩 꺼내오는 메서드 => 함수형 인터페이스 사용
		list.forEach(element -> System.out.println(element));
		
		System.out.println("-------------");
		
		// 사용할 클래스 객체 :: 메서드 이름 => 매개변수 값 생략
		
		list.forEach(System.out::println);
	}
}
