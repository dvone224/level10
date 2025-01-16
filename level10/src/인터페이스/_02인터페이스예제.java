package 인터페이스;

interface Dragable{
	void move(int x, int y);
}

interface Clickable{
	void click();
	void doubleClick();
}

class Title implements Clickable{
	@Override
	public void click() {
		System.out.println("타이틀 클릭");
	}
	
	@Override
	public void doubleClick() {
		System.out.println("타이틀 더블클릭");
	}
}

abstract class Button implements Dragable, Clickable{
	String name;
	int size;
	
	abstract void actionButton();
}

class NaberButton extends Button{
	@Override
	void actionButton() {
		System.out.println("네이버로 이동");
	}

	@Override
	public void move(int x, int y) {
		System.out.printf("좌표 %d %d 이동 \n",x,y);
	}

	@Override
	public void click() {
		System.out.println("같은 창에서 네이버 홈으로 이동");
	}

	@Override
	public void doubleClick() {
		System.out.println("새창에서 네이버 홈으로 이동");
		
	}
}

class GoogleButton extends Button{
	@Override
	void actionButton() {
		System.out.println("구글로 이동");
	}

	@Override
	public void move(int x, int y) {
		System.out.printf("좌표 %d %d 이동 \n",x,y);
	}

	@Override
	public void click() {
		System.out.println("같은 창에서 구글 홈으로 이동");
	}

	@Override
	public void doubleClick() {
		System.out.println("새창에서 구글 홈으로 이동");
		
	}
}

public class _02인터페이스예제 {
	public static void main(String[] args) {
		
		Button btn1= new NaberButton();
		Button btn2 = new GoogleButton();
		
		Title title = new Title();
		
		btn1.click();
		btn1.actionButton();
		
		title.doubleClick();
		
		btn2.doubleClick();
		btn2.move(10, 20);
	}
}
