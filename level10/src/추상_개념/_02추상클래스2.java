package 추상_개념;

// 부모 클래스 == 상위 클래스 == 슈퍼 클래스
class Parent{
	int a;
	int b;
}

// 자식클래스 == 하위 클래스 == 서브 클래스
class Child extends Parent{
	int c;
	int d;
	
}
public class _02추상클래스2 {
	
	public static void main(String[] args) {
		
		// casting : 형변환
		
		// 강제 형변환
		System.out.println((int) 3.14159265);
		
		Parent p = new Parent();
		Child c = new Child();
		// upcasting : 하위클래스가 상위타입 전환 : 자식클래스 객체가 부모 클래스 겍체 전환
		
		Parent parent = new Child(); // 업케스팅
		
		// dwoncasting : 
		
		Child child = (Child)parent;
		
	}

}
