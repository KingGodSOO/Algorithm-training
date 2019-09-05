package Study.Day190526;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

class Graph {

	// 노드를 내부 클래스로 생성
	class Node {
		// 자기 자신 data
		int data;
		// 인접한 노드
		LinkedList<Node> adjacent;
		// 방문 여부
		boolean marked;

		Node(int data) {
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}

	Node[] nodes;

	// 그래프 생성자
	Graph(int size) {
		// 입력받은 크기 만큼 노드배열 생성
		nodes = new Node[size];
		// 편의상, 인덱스 번호 = 데이터
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}

	// 두 노드의 관계를 저장하는 함수
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if (!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if (!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}

}

public class NumberOfCases {
	
	Graph graph = null;
	
	NumberOfCases(Graph graph){
		this.graph = graph;
	}
	void dfs() {
		dfs(0);
	}

	void dfs(int index) {
		// 뿌리부터
		Graph.Node root = graph.nodes[index];
		// stack에 넣고
		Stack<Graph.Node> stack = new Stack<Graph.Node>();
		stack.push(root);
		root.marked = true;
		// stack이 빌 때까지
		while (!stack.isEmpty()) {
			// stack에서 꺼내면서 출력하고, 인근 노드를 스택에 넣는다.
			Graph.Node r = stack.pop();
			for (Graph.Node n : r.adjacent) {
				// marked 안 된 것만!
				if (n.marked == false) {
					n.marked = true;
					stack.push(n);
				}
			}
			//출력
			visit(r);
				
		}
	}
	
	// dfs의 경우 재귀호출로 쉽게 구현할 수 있다.
	void dfsR() {
		dfsR(0);
	}
	void dfsR(int index) {
		Graph.Node r = graph.nodes[index];
		dfsR(r);
	}

	void dfsR(Graph.Node r) {
		if(r == null) return;
		r.marked = true;
		visit(r);
		for (Graph.Node n : r.adjacent) {
			if (n.marked == false) {
				dfsR(n);
			}
		}
	}
	

	
	void bfs() {
		bfs(0);
	}
	// dfs와 동일하게, queue로 구현.
	void bfs(int index) {
		Graph.Node root = graph.nodes[index];
		Queue<Graph.Node> queue = new Queue<Graph.Node>();
		queue.push(root);
		root.marked = true;
		while (!queue.isEmpty()) {
			Graph.Node r = queue.pop();
			for (Graph.Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					queue.push(n);
				}
			}
			visit(r);
		}
	}

	void visit(Graph.Node n) {
		System.out.print(n.data + " ");
	}
	
}
