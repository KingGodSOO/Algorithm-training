package Study.Day190526;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class numTree {
	Map hm = null;

	void dfs(int root) {
		// �θ� ��� ���.
		System.out.print(root);
		System.out.print(" ");
		// Ʈ���� ������ ����� return
		if (hm.get(root) == null) {
			return;
		}
		// �迭 ���·� ����� �ڽĳ����� ȣ���ؼ� dfs ����.
		int[] arr = (int[]) hm.get(root);
		for (int i = 0; i < 3; i++) {
			dfs(arr[i]);
		}
	}

	void bfs(int root) {
		Queue<Integer> queue = new Queue<Integer>();
		// 1. root�� queue�� �ִ´�
		queue.push(root);
		// 2. queue���� �ϳ� ����� ����ϰ�, �ڼյ��� �ٽ� queue�� �ִ´�.
		while (!(queue.isEmpty())) {
			int x = queue.pop();

			int[] arr = (int[]) hm.get(x);
			// arr�� null�� �ƴ� ��쿡��, queue�� push(��üũ�� �ؾ���)
			if(arr != null) {
				for (int i = 0; i < arr.length; i++) {
					queue.push(arr[i]);
				}
			}
			System.out.print(x + " ");
		}
		// 3. queue�� ������ �� ������ �ݺ�.
	}

	// Ʈ������
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
