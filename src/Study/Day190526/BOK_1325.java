package Study.Day190526;

import java.util.HashMap;
import java.util.LinkedList;

import Study.Day190526.Graph.Node;

//효율적인 해킹
//시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
//5 초	256 MB	14131	2442	1617	21.705%
//문제
//해커 김지민은 잘 알려진 어느 회사를 해킹하려고 한다. 이 회사는 N개의 컴퓨터로 이루어져 있다. 김지민은 귀찮기 때문에, 한 번의 해킹으로 여러 개의 컴퓨터를 해킹 할 수 있는 컴퓨터를 해킹하려고 한다.
//
//이 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지 않는 관계로 이루어져 있는데, A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다는 소리다.
//
//이 회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때, 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에, N과 M이 들어온다. N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다. 둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며, "A가 B를 신뢰한다"를 의미한다. 컴퓨터는 1번부터 N번까지 번호가 하나씩 매겨져 있다.
//
//출력
//첫째 줄에, 김지민이 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력한다.
//
//예제 입력 1 
//5 4
//3 1
//3 2
//4 3
//5 3
//예제 출력 1 
//1 2

// 소요시간 = 2시간+           체감난이도 = 상

public class BOK_1325 {
	// 노드를 내부 클래스로 생성
	class Node {
		// 자기 자신 컴퓨터 번호
		int data;
		// 신뢰하는 컴퓨터
		LinkedList<Node> faith;

		// 생성자
		Node(int data) {
			this.data = data;
			faith = new LinkedList<Node>();
		}
	}
	
	// node1이 node2를 신뢰하는 경우
	// node2의 faith에 node1 추가.
	public void beFaith(Node node1, Node node2) {
		if(!(node2.faith.contains(node1))) {
			node2.faith.add(node1);
		}
	}
	static void mostHackingPC(int n, int m) {

	}

	public static void main(String[] args) {

	}

}
