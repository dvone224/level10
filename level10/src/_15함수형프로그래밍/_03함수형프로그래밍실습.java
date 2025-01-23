package _15함수형프로그래밍;

class Calculate {
	int add(int a, int b) {
		return a + b;
	}

	int subtract(int a, int b) {
		return a - b;
	}

	int multiply(int a, int b) {
		return a * b;
	}
}

@FunctionalInterface
interface CalFunction {
	int cal(int a, int b);
}

public class _03함수형프로그래밍실습 {
	public static void main(String[] args) {
		Calculate cal = new Calculate();
		System.out.println(cal.add(10, 20));
		System.out.println(cal.subtract(10, 20));
		System.out.println(cal.multiply(10, 20));
		System.out.println("===================");

		CalFunction add = (x, y) -> x + y;
		System.out.println(add.cal(10, 20));

		CalFunction sub = (x, y) -> x - y;
		System.out.println(sub.cal(10, 20));

		CalFunction mult = (x, y) -> x * y;
		System.out.println(mult.cal(10, 20));
		
		CalFunction mult2 = (x, y) -> mult.cal(x, y);
	}
}
