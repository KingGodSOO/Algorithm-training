package Study.Day190526;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

class Graph {

	// ��带 ���� Ŭ������ ����
	class Node {
		// �ڱ� �ڽ� data
		int data;
		// ������ ���
		LinkedList<Node> adjacent;
		// �湮 ����
		boolean marked;

		Node(int data) {
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}

	Node[] nodes;

	// �׷��� ������
	Graph(int size) {
		// �Է¹��� ũ�� ��ŭ ���迭 ����
		nodes = new Node[size];
		// ���ǻ�, �ε��� ��ȣ = ������
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}

	// �� ����� ���踦 �����ϴ� �Լ�
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
		// �Ѹ�����
		Graph.Node root = graph.nodes[index];
		// stack�� �ְ�
		Stack<Graph.Node> stack = new Stack<Graph.Node>();
		stack.push(root);
		root.marked = true;
		// stack�� �� ������
		while (!stack.isEmpty()) {
			// stack���� �����鼭 ����ϰ�, �α� ��带 ���ÿ� �ִ´�.
			Graph.Node r = stack.pop();
			for (Graph.Node n : r.adjacent) {
				// marked �� �� �͸�!
				if (n.marked == false) {
					n.marked = true;
					stack.push(n);
				}
			}
			//���
			visit(r);
				
		}
	}
	
	// dfs�� ��� ���ȣ��� ���� ������ �� �ִ�.
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
	// dfs�� �����ϰ�, queue�� ����.
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
