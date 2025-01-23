package _15함수형프로그래밍;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@FunctionalInterface
interface ItemComparator extends Comparator<Item>{
	
}

public class _06스트림실습_기본 {
	
	public static List<Item> setData(){
		List<Item> itemList = new ArrayList<Item>();

		itemList.add(new Item(1001,"과자", "새우깡", 1500));
		itemList.add(new Item(1002,"음료수", "사이다", 1000));
		itemList.add(new Item(1003,"과자", "고래밥", 3000));
		itemList.add(new Item(1004,"음료수", "콜라", 500));
		itemList.add(new Item(1005,"고기", "닭고기", 15000));
		itemList.add(new Item(1006,"고기", "돼지고기", 20000));
		itemList.add(new Item(1005,"고기", "닭고기", 15000));
		itemList.add(new Item(1002,"음료수", "사이다", 1000));
		itemList.add(new Item(1002,"음료수", "사이다", 1000));
		itemList.add(new Item(1008,"과자", "홈런볼", 3500));
		
		return itemList;
	}
	public static void main(String[] args) {
		
		
		List<Item> itemList = setData();
//		System.out.println(itemList);
		
		// 문제 1번 전체 출력
		System.out.println("=====[ 1 ]=====");
		itemList.stream().forEach(System.out::print);
		
		// 문제 2번 중복된 데이터 제거 후 출력
		System.out.println("=====[ 2 ]=====");
		itemList.stream().distinct().forEach(System.out::print);
		
		// 문제 3번 카테고리가 과자인 itemList 출력
		System.out.println("=====[ 3 ]=====");
		itemList.stream().filter(item -> item.getCategory().equals("과자")).forEach(System.out::print);
		
		// 문제 4번 카테고리가 고기인 item 갯수 출력
		System.out.println("=====[ 4 ]=====");
		int cnt = (int) itemList.stream().filter(item -> item.getCategory().equals("고기")).count();
		System.out.println(cnt);
		
		// 문제 5번 가격이 10000원 이상인 값들의 ArrayList<Item> 만들기
		System.out.println("=====[ 5 ]=====");
		ArrayList<Item> itemsOver10000 = (ArrayList<Item>) itemList.stream().filter(item -> item.getPrice() >= 10000).collect(Collectors.toList());
		System.out.println(itemsOver10000);
		
		// 문제 6번 카테고리가 고기인 아이템 이름만 가져와서 ArrayList<String>으로 만들기
		System.out.println("=====[ 6 ]=====");
		ArrayList<String> items = (ArrayList<String>) itemList.stream().filter(item -> item.getCategory().equals("고기")).map(Item::getName).collect(Collectors.toList());
		System.out.println(items);
		
		// 문제 7번 아이템 번호로 정렬 후 출력
		Comparator<Item> itemCompByItemNo = (item1, item2) -> (item1.getItemNo() < item2.getItemNo()) ? -1 : ((item2.getItemNo() == item2.getItemNo()) ? 0 : 1);
		System.out.println("=====[ 7 ]=====");
		itemList.stream().sorted(itemCompByItemNo).forEach(System.out::print);
		itemList.stream().sorted(Comparator.comparing(Item::getItemNo));
		
		// 문제 8번 아이템 가격 순으로 정렬
		System.out.println("=====[ 8 ]=====");
		Comparator<Item> itemCompByPrice = (item1, item2) -> item1.getPrice() - item2.getPrice();
		itemList.stream().sorted(itemCompByPrice).forEach(System.out::print);
		
	}

}