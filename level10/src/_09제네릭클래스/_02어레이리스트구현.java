package _09제네릭클래스;

import java.util.Arrays;

class MyArrayList<T> implements Cloneable{
	private T[] arr;
	private int size; 
	private final int DEFUALT_CAPACITY = 10;
	private int capacity;
	// 기본 10개 값이 증가 = > 20개로 변경됨  
	// 20 였던 방에서 기본값이 11개에서 10개로 줄면 capacity도 20 -> 10개로 변경 
	/*
    1. 추가 : add(value)
    2. 삭제 : remove(int idx) , remove( Integer value)
    3. 삽입 : add(idx, value)
    4. 수정 : set(idx , value)
    5. 갯수 : size()
    6. 값읽기 : get(idx)
    7. 전체삭제 : clear()
    */
	MyArrayList(){
		capacity = DEFUALT_CAPACITY;
		arr = (T[]) new Object [capacity];
	}
	
	int size() {
		return size;
	}
	int capacity() {
		return capacity;
	}
	T get(int idx) {
		checkVaildIdx(idx,size-1);
		
		return arr[idx];
	}
	T remove(int idx) {
		checkVaildIdx(idx,size-1);
		T num = arr[idx];
		for(int i = idx; i < size;i+=1)
			arr[i] = arr[i+1];
		
		arr[size-1] = null;
		size-=1;
		
		if(size == capacity - DEFUALT_CAPACITY ) {
			capacity-= DEFUALT_CAPACITY;
		}
		return num;
	}
	boolean remove(T value) {
		int idx = -1;
		for(int i =0; i < size; i+=1) {
			if(value == arr[i]) {
				idx = i;
				break;
			}
		}
		if(idx == -1) return false;
		
		for(int i = idx; i < size;i+=1)
			arr[i] = arr[i+1];
		
		arr[size-1] = null;
		size-=1;
		if(size == capacity - DEFUALT_CAPACITY ) {
			capacity-= DEFUALT_CAPACITY;
		}
		return true;
	}
	
	boolean add(T value) {
		 grow();
		arr[size] = value;
		size+=1;
		return true;
	}
	
	void grow() {
		if(size >= capacity) {
			T[] temp = arr;
			arr = (T[]) new Object[capacity + DEFUALT_CAPACITY];
			capacity += DEFUALT_CAPACITY; 
			for(int i =0; i < size; i+=1)
				arr[i] = temp[i];
			
		}
	}
	void checkVaildIdx( int idx , int end) {
		if(idx < 0 || idx > end) {
			throw new ArrayIndexOutOfBoundsException("배열의 방길이를 초과했습니다");
		}
	}
	// 삽입 
	void add(int idx , T value) {
		checkVaildIdx(idx , size);
		 grow();
		 for(int i = size; i > idx; i--){
			 arr[i] = arr[i-1];
		 }
		 arr[idx] = value;
		 size+=1;
		
	}
	
	T set(int idx , T value) {
		checkVaildIdx(idx,size);
		T num = arr[idx];
		arr[idx] = value; // 오토언박싱 Integer -> int 
		return num;  // 오토박싱   int -> Integer 
	}
	
	void clear() {
		size =0;
		capacity = DEFUALT_CAPACITY;
		arr = (T[]) new Object[capacity]; 
	}

	@Override
	public String toString() {
		if(size == 0)return "[]";
		String data ="[";
		for(int i =0 ; i <size;i+=1) {
			data+=arr[i]+",";
		}
		data = data.substring(0,data.length()-1);
		data+="]";
		return data;
	}
	
}

public class _02어레이리스트구현 {
	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList();
		
		list.add("test1");
		list.add("test2");
		list.add("test3");
		list.add("test4");
		System.out.println(list);
		
//		MyArrayList<Double> v1 = new MyArrayList<>();
//
//		System.out.println(v1);
//		System.out.println(v1.size());
//		System.out.println(v1.capacity());
//
//		for (int i = 0; i < 10; i += 1) {
//			v1.add((i + 1) * 10*1.0);
//		}
//
//		System.out.println(v1.size());
//		System.out.println(v1.capacity());
//		System.out.println(v1.get(1));
//
//		v1.set(1, 1000.0);
//		System.out.println(v1);
//
//		v1.add(1, 20.0);
//		System.out.println(v1);
//
//		v1.remove(3);
//		System.out.println(v1);
//		System.out.println(v1.size());
//		System.out.println(v1.capacity());
//
//		v1.clear();
//		System.out.println(v1);
//		System.out.println(v1.size());
//		System.out.println(v1.capacity());
	
	}
}