package 접근제어자실습;


final class Test{
	int num1;
	int num2;
	Test(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	void printNums() {
		System.out.printf("num1 = %d, num2 = %d, \n",num1 ,num2);
	}
}

class Parent {
	final int num1 = 10;
	
	int num2 = 20;
	
	// 메서드에 final 키워드를 붙이면 오버라이딩이 불가능
	final void printNum() {
		System.out.println(num1);
	}
}

class Childs extends Parent{
	
//  자식클래스에서 오버라이딩이 불가능
//	void printNum() {
//		
//	}
}


public class _02final테스트 {
	public static void main(String[] args) {
		final Parent p = new Parent(); // 참조타입, 새로운 객체로 변경 불가능, 주소값 변경이 불가능
		
		p.num2 = 10;
	}
}
