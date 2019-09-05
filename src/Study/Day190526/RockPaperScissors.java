package Study.Day190526;

import java.util.ArrayList;
import java.util.HashMap;

public class RockPaperScissors {
	
	void dfs() {
		String[] arr = new String[3];

//		정확하게는, 아래처럼 default값을 넣어줘야 backup이 의미가 있겠다.
//		for(int i=0; i<arr.length; i++) {
//			arr[i]="비어있음!";
//		}
		
		int depth = 0;
		dfs("가위", depth, arr);
		dfs("바위", depth, arr);
		dfs("보", depth, arr);
	}
	void dfs(String x, int depth, String[] arr) {
		// 배열의 현재 index에 가위,바위,보 셋 중 하나를 넣음
		arr[depth] = x;
		// 배열이 꽉 찼을 경우, 출력
		if(depth == 2) {
			for (String data:arr) {
				System.out.print(data);
			}
			System.out.println();
			return;
		}
		
		// 배열의 다음 인덱스에서 dfs진행
		depth ++;
		
		// dfs로 배열의 다음 index에 값을 넣음.
		dfs("가위", depth, arr);
//		 =====================test=======================
//		 아래와 같이 확인하면, arr가 돌아왔을 때 backup이 안되서 마지막 dfs가 그대로 오는것을 알 수 있다.
//		 backup을 안하면, 이전 dfs로 arr가 바뀐 상태로 남아 다음 dfs로 넘어가는 것을 알 수 있다.(같은 결과가 동일하게 출력됨!) 
//		 (가위비어있음!비어있음!뿅~ 으로 나오지 않는 이유는, 맨 첫번째 노드는 dfs가 아니라 위의 다른 메소드에서 따로 호출해주므로)
//		for (String data:arr) {
//			System.out.print(data);
//		}
//		System.out.print("뿅~");
//		System.out.println();
		
		dfs("바위", depth, arr);
		dfs("보", depth, arr);
		
		//================backup을 하는 이유====================
		// 하나의 배열을 사용하므로, 3단계까지 진행된 것이 1단계로 돌아오게 되었을 때 
		// 3단계 까지 진행된 배열이 돌아오므로, 다른 dfs에 영향을 미친다.
		// 예를들어, 113까지 진행된 후에 12로 돌아올 때의 노드는 123인 상태다.
		// 이 예제에서는 depth를 이용하여 depth가 3일때만 출력을 하므로 상관이 없지만, 
		// dfs의 경우 모든 node에 관해 조사를 한다면 반드시 백업을 해줘야 함!(즉 dfs를 다 돌고 나면 그 node는
		// default 값으로 초기화를 해주고 돌려보내야 한다).
		String backup = "비어있음!";
		arr[depth]=backup;
		
	}
	
	// bfs로 가위바위보의 모든 경우의 수를 출력하는 것은, 트리의 각 노드에 가위 바위, 보를 넣었을 때
	// 맨 아랫 노드를 어떻게 감지하고 출력하는지 이다.
	// dfs에서는 depth를 이용했고, bfs에서는 list의 size를 이용했는데,
	// 이 부분이 가장 어렵다.
	void bfs() {
		Queue<ArrayList<String>> queue = new Queue<ArrayList<String>>();
		ArrayList<String> list = new ArrayList<String>(3);
		// 맨 처음, 빈 리스트를 queue에 넣는다.
		queue.push(list);
		// queue가 완전히 빌 때까지
		while((!queue.isEmpty())) {
			// queue에서 list를 하나 빼고
			list = queue.pop();
			// list의 사이즈가 3일 경우, 출력하고 반복문으로 돌아간다.
			if(list.size() == 3) {
				System.out.println(list.toString());
				continue;
			}
			// 사이즈가 그보다 작다면, queue에서 꺼낸 list의 데이터를 가지는 copylist를 만들고, 다음 위치에 가위, 바위, 보를
			// 각각 넣어준 뒤 queue에 담는다.
			for(int i=0; i<3; i++) {
				ArrayList<String> copylist = new ArrayList<String>(list);
				if(i==0) {
					copylist.add("가위");
				}
				else if(i==1) {
					copylist.add("바위");
				}
				else {
					copylist.add("보");
				}
				queue.push(copylist);
			}
			
		}
	}
	
	void justFor() {
		HashMap hm = new HashMap(3);
		hm.put(0, "가위");
		hm.put(1, "바위");
		hm.put(2, "보");
		
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
