package 다형성실습;

import java.util.Random;

abstract class Shape {
	String name;
	String color;
	double size;

	Shape(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	abstract void draw();

	@Override
	public String toString() {
		return String.format("%s %s (%.2f)", color, name, size);
	}
}

class Line extends Shape {

	Line(String name, String color, int size) {
		super(name, color);
		super.size = size;
	}

	@Override
	void draw() {
		System.out.println("선을 긋는다");
	}

}

class Point extends Shape {

	Point(String name, String color, int size) {
		super(name, color);
		super.size = size;
	}

	@Override
	void draw() {
		System.out.println("점을 찍는다");
	}

}

class Circle extends Shape {

	int radius;

	Circle(String name, String color, int radius) {
		super(name, color);
		this.radius = radius;
		size = Math.PI * radius * radius;
	}

	@Override
	void draw() {
		System.out.println("원을 그린다");
	}

}

class Rect extends Shape {

	int height;
	int width;

	Rect(String name, String color, int height, int width) {
		super(name, color);
		this.height = height;
		this.width = width;
		size = height * width;
	}

	@Override
	void draw() {
		System.out.println("사각형을 그린다");
	}

}

class Triangle extends Shape {
	Triangle(String name, String color, int height, int width) {
		super(name, color);
		this.height = height;
		this.width = width;
		size = height * width / 2.0;
	}

	int height;
	int width;

	@Override
	void draw() {
		System.out.println("삼각형을 그린다");
	}

}

public class _01도형 {
	public static void main(String[] args) {

		// 모양도 랜덤하게 색깔 사이즈 랜덤해게 도형 10개를 출력하세요
		// 점 , 선 기존 size 출력
		// 원, 네모, 세모 => size 넓이를 계산해서 출력
		Random rd = new Random();
		String[] colors = { "파란색", "빨간색", "보라색", "분홍색", "노란색" };

		



		// [문제1] 10 랜덤하게 생성해서 출력하기
		System.out.println("[문제1]");
		Shape[] list = new Shape[10];
		for (int i = 0; i < 10; i++) {
			int rdNum1 = rd.nextInt(5);
			int rdColor = rd.nextInt(colors.length);
			int rdNum2 = rd.nextInt(50) + 1;
			int rdNum3 = rd.nextInt(50) + 1;
			Shape shape = null;
			if (rdNum1 == 0) {
				shape = new Point("점", colors[rdColor], rdNum2);
			} else if (rdNum1 == 1) {
				shape = new Line("선", colors[rdColor], rdNum2);
			} else if (rdNum1 == 2) {
				shape = new Circle("원", colors[rdColor], rdNum2);
			} else if (rdNum1 == 3) {
				shape = new Rect("사각형", colors[rdColor], rdNum2, rdNum3);
			} else if (rdNum1 == 4) {
				shape = new Triangle("삼각형", colors[rdColor], rdNum2, rdNum3);
			}
			list[i] = shape;
			list[i].draw();
			System.out.println(list[i]);
			System.out.println();
		}
		
		// [문제2] 원만 출력하기
		System.out.println("[문제2]");
		for(Shape shape : list) {
			if(shape instanceof Circle) {
				System.out.println(shape);
				shape.draw();
				System.out.println();
			}
		}

	}
}
