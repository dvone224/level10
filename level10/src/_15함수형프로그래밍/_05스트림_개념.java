package _15함수형프로그래밍;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _05스트림_개념 {
	public static void main(String[] args) {

		List<String> names = Arrays.asList("김민규", "유재석", "하하", "정형돈", "노홍철", "김민규", "하하");

		System.out.println("============1============");
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		System.out.println("============2============");
		for (String name : names) {
			System.out.println(name);
		}

		System.out.println("============3============");
		names.forEach(System.out::println);

		System.out.println("============4============");
		Stream<String> nameStream = names.stream();
		nameStream.forEach(System.out::println); // forEach는 최종연산이기 때문에 연산이 끝나면 스트림이 닫힌다

		System.out.println("============5============");

		names.stream().distinct().forEach(System.out::println);

		System.out.println("============6============");
		List<String> copyNames = names.stream().distinct().collect(Collectors.toList());
		System.out.println(copyNames);
		
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(5,2,0,8,4,5,1,5,3,1,5,4,6,2,2,5,5,4,2));
		
		System.out.println(list);
		List<Integer> odds = new ArrayList<Integer>();
		
		for(int i =0; i<list.size();i++) {
			if(list.get(i) % 2 != 0) odds.add(list.get(i));
		}
		System.out.println(odds);
		
		Collections.sort(odds);
		System.out.println(odds);
		
		String data = "";
		for(Integer i : odds) {
			data += i +", ";
		}
		data = data.substring(0,data.length()-1);
		
		System.out.println(data);
		
		System.out.println("--------------------------------");
		String result = list.stream().filter(i-> i%2!=0).sorted(Integer::compare).map(i -> i+"").collect(Collectors.joining(", "));
		
		System.out.println(result);
	}
}
