package Study.Day190526;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue<T> {

	// �⺻ ������
	Queue(){}
	
	// LinkedList�� Queue�� ����� ������
	Queue(LinkedList<T> list){
		for(int i=0; i<list.size(); i++) {
			push(list.get(i));
		}
	}
	
	// ArrayList�� Queue�� ����� ������
	Queue(ArrayList<T> list){
		for(int i=0; i<list.size(); i++) {
			push(list.get(i));
		}
	}
	
	// Node��� ���� Ŭ������ ����
	class Node<T>{
		// Node�� ���� �ڽ� data��
		private T data;
		// �� ���� data�� ���������� ������ ����.
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	// 
	private Node<T> first;
	private Node<T> last;
	
	// Queue�� �߰��ϴ� �޼ҵ�
	public void push(T item) {
		// �߰��Ϸ��� TŸ���� ������ ���ο� Node ����.
		Node<T> t = new Node<T>(item);
		
		// last�� �ִٸ�, last�� ���
		if (last != null) {
			last.next = t;
		}
		last = t;
		// first�� ����մٸ�, first�� last�� �� 
		if (first == null) {
			first = last;
		}
	}
	
	// Queue���� ������ �޼ҵ�
	public T pop() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		// first�� ���� �����͸� first�� �����, first�� data�� return
		T data = first.data;
		first = first.next;
		
		if (first == null) {
			last = null;
		}
		
		return data;
	}
	
	// ������ ���⸸ �ϴ� �޼ҵ� (�����δ� queue�� �����鼭, ���ŵȴ�.)
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
