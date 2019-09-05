package Study.Day190526;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue<T> {

	// 기본 생성자
	Queue(){}
	
	// LinkedList를 Queue로 만드는 생성자
	Queue(LinkedList<T> list){
		for(int i=0; i<list.size(); i++) {
			push(list.get(i));
		}
	}
	
	// ArrayList를 Queue로 만드는 생성자
	Queue(ArrayList<T> list){
		for(int i=0; i<list.size(); i++) {
			push(list.get(i));
		}
	}
	
	// Node라는 내부 클래스를 정의
	class Node<T>{
		// Node는 현재 자신 data와
		private T data;
		// 그 다음 data의 참조변수를 가지고 있음.
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	// 
	private Node<T> first;
	private Node<T> last;
	
	// Queue에 추가하는 메소드
	public void push(T item) {
		// 추가하려는 T타입의 변수로 새로운 Node 생성.
		Node<T> t = new Node<T>(item);
		
		// last가 있다면, last를 대신
		if (last != null) {
			last.next = t;
		}
		last = t;
		// first가 비어잇다면, first가 last가 됨 
		if (first == null) {
			first = last;
		}
	}
	
	// Queue에서 꺼내는 메소드
	public T pop() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		// first의 다음 데이터를 first로 만들고, first의 data는 return
		T data = first.data;
		first = first.next;
		
		if (first == null) {
			last = null;
		}
		
		return data;
	}
	
	// 꺼내어 보기만 하는 메소드 (실제로는 queue는 꺼내면서, 제거된다.)
	public T peek() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
}
