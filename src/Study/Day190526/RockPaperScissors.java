package Study.Day190526;

import java.util.ArrayList;
import java.util.HashMap;

public class RockPaperScissors {
	
	void dfs() {
		String[] arr = new String[3];

//		��Ȯ�ϰԴ�, �Ʒ�ó�� default���� �־���� backup�� �ǹ̰� �ְڴ�.
//		for(int i=0; i<arr.length; i++) {
//			arr[i]="�������!";
//		}
		
		int depth = 0;
		dfs("����", depth, arr);
		dfs("����", depth, arr);
		dfs("��", depth, arr);
	}
	void dfs(String x, int depth, String[] arr) {
		// �迭�� ���� index�� ����,����,�� �� �� �ϳ��� ����
		arr[depth] = x;
		// �迭�� �� á�� ���, ���
		if(depth == 2) {
			for (String data:arr) {
				System.out.print(data);
			}
			System.out.println();
			return;
		}
		
		// �迭�� ���� �ε������� dfs����
		depth ++;
		
		// dfs�� �迭�� ���� index�� ���� ����.
		dfs("����", depth, arr);
//		 =====================test=======================
//		 �Ʒ��� ���� Ȯ���ϸ�, arr�� ���ƿ��� �� backup�� �ȵǼ� ������ dfs�� �״�� ���°��� �� �� �ִ�.
//		 backup�� ���ϸ�, ���� dfs�� arr�� �ٲ� ���·� ���� ���� dfs�� �Ѿ�� ���� �� �� �ִ�.(���� ����� �����ϰ� ��µ�!) 
//		 (�����������!�������!��~ ���� ������ �ʴ� ������, �� ù��° ���� dfs�� �ƴ϶� ���� �ٸ� �޼ҵ忡�� ���� ȣ�����ֹǷ�)
//		for (String data:arr) {
//			System.out.print(data);
//		}
//		System.out.print("��~");
//		System.out.println();
		
		dfs("����", depth, arr);
		dfs("��", depth, arr);
		
		//================backup�� �ϴ� ����====================
		// �ϳ��� �迭�� ����ϹǷ�, 3�ܰ���� ����� ���� 1�ܰ�� ���ƿ��� �Ǿ��� �� 
		// 3�ܰ� ���� ����� �迭�� ���ƿ��Ƿ�, �ٸ� dfs�� ������ ��ģ��.
		// �������, 113���� ����� �Ŀ� 12�� ���ƿ� ���� ���� 123�� ���´�.
		// �� ���������� depth�� �̿��Ͽ� depth�� 3�϶��� ����� �ϹǷ� ����� ������, 
		// dfs�� ��� ��� node�� ���� ���縦 �Ѵٸ� �ݵ�� ����� ����� ��!(�� dfs�� �� ���� ���� �� node��
		// default ������ �ʱ�ȭ�� ���ְ� ���������� �Ѵ�).
		String backup = "�������!";
		arr[depth]=backup;
		
	}
	
	// bfs�� ������������ ��� ����� ���� ����ϴ� ����, Ʈ���� �� ��忡 ���� ����, ���� �־��� ��
	// �� �Ʒ� ��带 ��� �����ϰ� ����ϴ��� �̴�.
	// dfs������ depth�� �̿��߰�, bfs������ list�� size�� �̿��ߴµ�,
	// �� �κ��� ���� ��ƴ�.
	void bfs() {
		Queue<ArrayList<String>> queue = new Queue<ArrayList<String>>();
		ArrayList<String> list = new ArrayList<String>(3);
		// �� ó��, �� ����Ʈ�� queue�� �ִ´�.
		queue.push(list);
		// queue�� ������ �� ������
		while((!queue.isEmpty())) {
			// queue���� list�� �ϳ� ����
			list = queue.pop();
			// list�� ����� 3�� ���, ����ϰ� �ݺ������� ���ư���.
			if(list.size() == 3) {
				System.out.println(list.toString());
				continue;
			}
			// ����� �׺��� �۴ٸ�, queue���� ���� list�� �����͸� ������ copylist�� �����, ���� ��ġ�� ����, ����, ����
			// ���� �־��� �� queue�� ��´�.
			for(int i=0; i<3; i++) {
				ArrayList<String> copylist = new ArrayList<String>(list);
				if(i==0) {
					copylist.add("����");
				}
				else if(i==1) {
					copylist.add("����");
				}
				else {
					copylist.add("��");
				}
				queue.push(copylist);
			}
			
		}
	}
	
	void justFor() {
		HashMap hm = new HashMap(3);
		hm.put(0, "����");
		hm.put(1, "����");
		hm.put(2, "��");
		
		for(int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					System.out.println(hm.get(i)+"|"+hm.get(j)+"|"+hm.get(k));
				}
			}
		}
	}
	public static void main(String[] args) {
		RockPaperScissors test = new RockPaperScissors();
		System.out.println("dfs======================");
		test.dfs();
		System.out.println("bfs======================");
		test.bfs();
		System.out.println("justFor==================");
		test.justFor();
	}

}
