package 인터페이스;

// 추상클래스 vs 인터페이스
// 인터페이스는 다중상속이 목적이다
// 인터페이스는 객체를 따로 만들 수 없다
// 인터페이스 자체는 객체를 생성하는 것이 목적이 아니다

// 추상클래스 : 동물 식물 기계
// 인터페이스 : movable() flyable() eatable() swimable() aboardable()


class A{
	int num =10;
}

abstract class B{
	int num = 10;
	abstract void init();
}

// 추상클래스보다 더 추상적인 것 => 인터페이스 => 여러개를 상속하려고
// 인터페이스에서 멤버 변수는 무조건 상수
interface C{
	int num = 10; // public static final int num = 10;
	
	void test1(); // public abstract void test1();
	
	
}

interface D{
	void test2();
}

class F extends A implements C, D{

	@Override
	public void test1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test2() {
		// TODO Auto-generated method stub
		
	}
	
}

interface G extends D{
	
}
public class _01인터페이스 {

}
