package Study.Day190526;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class numTree {
	Map hm = null;

	void dfs(int root) {
		// 부모 노드 출력.
		System.out.print(root);
		System.out.print(" ");
		// 트리의 마지막 노드라면 return
		if (hm.get(root) == null) {
			return;
		}
		// 배열 형태로 저장된 자식노드들을 호출해서 dfs 시전.
		int[] arr = (int[]) hm.get(root);
		for (int i = 0; i < 3; i++) {
			dfs(arr[i]);
		}
	}

	void bfs(int root) {
		Queue<Integer> queue = new Queue<Integer>();
		// 1. root를 queue에 넣는다
		queue.push(root);
		// 2. queue에서 하나 꺼내어서 출력하고, 자손들을 다시 queue에 넣는다.
		while (!(queue.isEmpty())) {
			int x = queue.pop();

			int[] arr = (int[]) hm.get(x);
			// arr이 null이 아닌 경우에만, queue에 push(널체크를 해야함)
			if(arr != null) {
				for (int i = 0; i < arr.length; i++) {
					queue.push(arr[i]);
				}
			}
			System.out.print(x + " ");
		}
		// 3. queue가 완전히 빌 때까지 반복.
	}

	// 트리생성
	void makeTree(int num) {
		hm = new HashMap(num);

		int j = 1;

		for (int i = 0; i < num; i++) {
			int[] arr = new int[3];
			for (int k = 0; k < 3; k++) {
				arr[k] = j + k;
			}
			hm.put(i, arr);
			j += 3;
		}
	}

	public static void main(String[] args) {
		numTree test = new numTree();
		test.makeTree(13);

		System.out.println("dfs====================");
		test.dfs(0);
		System.out.println();

		System.out.println("bfs====================");
		test.bfs(0);
	}

}
