package 인터페이스;

class AA{
	void methodA(BB b) {
		System.out.println("메서드 a 호출");
		b.methodB();
	}
}
class BB{
	void methodB() {
		System.out.println("메서드 b 호출");
	}
}
class CC{
	void methodC() {
		System.out.println("메서드 c 호출");
	}
}

public class _03긴밀한관계 {
	public static void main(String[] args) {
		AA a = new AA();
		a.methodA(new BB());
	}
}
