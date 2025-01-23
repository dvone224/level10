package _15함수형프로그래밍;

// 함수형 프로그래밍에 사용할 인터페이스 조건 => 단 하나의 추상메서드만 존재해야한다

@FunctionalInterface
interface Test{
	int getSsum(int[] arr);
}

public class _01함수형프로그래밍개념 {
	
	public static int getSum(int[] arr) {
		int sum =0;
		for(int i = 0; i< arr.length;i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		
		// 명령형 프로그래밍 : how : 과정 10 - 60까지 합산
		int[] arr = {10,20,30,40,50,60};
		int sum =0;
		for(int i = 0; i< arr.length;i++) {
			sum+=arr[i];
		}
		System.out.println(sum);
		
		// 선언형 프로그래밍 : 함수형 => 결과 집중
		System.out.println(getSum(arr));
		
		// 내부 클래스 == 이너 클래스 ==> 익명클래스 : 이름이 없는 클래스 => 일회성 클래스
		Test result = new Test() {

			@Override
			public int getSsum(int[] arr) {
				int sum =0;
				for(int i = 0; i< arr.length;i++) {
					sum+=arr[i];
				}
				return sum;
			}
			
		};
		
		System.out.println(result.getSsum(arr));
		
		// 람다식 => 자바스크립트의 화살표 함수
		// 함수형 프로그래밍을 편하게 사용하는 방식
		
		Test result2 = (int[] array) -> {
			int sum2 =0;
			for(int i = 0; i< arr.length;i++) {
				sum2+=arr[i];
			}
			return sum2;
		};
		
		System.out.println(result2.getSsum(arr));
		
		// 이미 만들어진 익명클래스 접근 (매개변수) -> 불러올 함수;
		Test result3 = arra -> result2.getSsum(arr);
		
	}

	
	
}
