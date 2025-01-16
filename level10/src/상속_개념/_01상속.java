package 상속_개념;

// 객체지향 OOP : object oriented programming

// 영화를 예매한다 -> 영화관, 좌석, 유저, 영화, 스크린...

// 객체가 유깆적으로 존재해서 상호작용 (메서드 호출, 리턴값 받아오기) => 시스템 구현

// 1. 캡슐화(encapsulation) : 객체를 독립적으로 만든다. private 필드, getter, setter
// 2. 상속(inheritance) : 자식 클래스가 부모 클래스의 속성(필드 + 메서드)을 상속 받는다
// 3. 추상화(abstract) : 미완성된 메서드가 단 한 개라도 존재하면 추상클래스 <-> 구체화
// 4. 다형성(polymorphism) : 

class A {
	int a = 10;
	int b = 20;

	A() {
		System.out.println("A 생성 됨");
	}
}

class B {
	A a;
	int c = 30;
	int d = 40;

	B() {
		a = new A();
		System.out.println("B 생성 됨");
	}

}


// 자식객체는 부모객체가 만들어진 다음에 만들어진다
class C extends A{
	int e = 50;
	int f = 60;
	
	int a = 23412;
	

	C() {
		// super(); 먼저 부모를 생성한다, super() 부모생성자 호출
		System.out.println("C 생성 됨");
	}

	C(int e, int f) {
		this(); // 자기자신의 기본 생성자
		this.e = e;
		this.f = f;
	}
	
	void createC(int num1, int num2) {
		
	}
	
	void printA() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(super.a);
	
	}
	
}

// 상속받은 자식클래스
// 1. 부모클래스의 필드나 메서드를 바로 접근가능

public class _01상속 {
	public static void main(String[] args) {

		B b = new B();
		System.out.println(b.c);
		System.out.println(b.d);
		System.out.println(b.a.a);
		System.out.println(b.a.b);
		System.out.println("------------------");
		C c = new C(10,20);
		c.printA();
		System.out.println(c.a);
		
	}
}
