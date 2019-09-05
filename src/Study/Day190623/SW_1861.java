package Study.Day190623;

import java.util.Arrays;
import java.util.Scanner;

/*

풀이날짜 :2019/07/06      풀이시간 :  약 4시간      체감난이도 :   B-      
느낀점 : 문제를 꼼꼼히 읽는 습관을 들이자!!!! 조건하나 빼먹으면 한참 헤맨다....

시간 : 27개 테스트케이스를 합쳐서 C++의 경우 1초 / Java의 경우 2초 / Python의 경우 4초
메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
※ SW Expert 아카데미의 문제를 무단 복제하는 것을 금지합니다.

N2개의 방이 N×N형태로 늘어서 있다.

위에서 i번째 줄의 왼쪽에서 j번째 방에는 1이상 N2 이하의 수 Ai,j가 적혀 있으며, 이 숫자는 모든 방에 대해 서로 다르다.

당신이 어떤 방에 있다면, 상하좌우에 있는 다른 방으로 이동할 수 있다.

물론 이동하려는 방이 존재해야 하고, 이동하려는 방에 적힌 숫자가 현재 방에 적힌 숫자보다 정확히 1 더 커야 한다.

처음 어떤 수가 적힌 방에서 있어야 가장 많은 개수의 방을 이동할 수 있는지 구하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N (1 ≤ N ≤ 103)이 주어진다.

다음 N개의 줄에는 i번째 줄에는 N개의 정수 Ai, 1, … , Ai, N (1 ≤ Ai, j ≤ N2) 이 공백 하나로 구분되어 주어진다.

Ai, j는 모두 서로 다른 수이다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

한 칸을 띄운 후, 처음에 출발해야 하는 방 번호와 최대 몇 개의 방을 이동할 수 있는지를 공백으로 구분하여 출력한다.

이동할 수 있는 방의 개수가 최대인 방이 여럿이라면 그 중에서 적힌 수가 가장 작은 것을 출력한다.
*/

public class SW_1861 {
	
	// 배열과 크기를 final 지역변수로 선언.
	final int[][] rooms;
	final int size;
	
	// 이동할 수 있는 최대 회수.
	int maxCnt = 0;
	// 최대 방의 개수를 가진 방의 번호.
	int maxRoom;
	// maxCnt가 바뀌었는지 확인하는 장치
	boolean isMax;
	// cnt와 maxCnt가 동일한지 확인하는 장치.
	boolean changeRoom;
	
	SW_1861(int[][] rooms, int size){
		this.rooms = rooms;
		this.size = size;
		maxRoom = size*size;
	}
	
	// N*N의 모든 방을 돌면서  checkRoom.
	void checkAllRooms() {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				// isMax와 changeRoom을 false로 초기화.
				isMax = false;
				changeRoom = false;
				// 주변에 -1이 있는지 확인해서, 있다면 건너뜀(최대값이 될 수 없으므로)
				if(i+1<size) {
					if(rooms[i][j]-rooms[i+1][j]==1) continue;
				}
				if(i-1>=0) {
					if(rooms[i][j]-rooms[i-1][j]==1) continue;
				}
				if(j+1<size) {
					if(rooms[i][j]-rooms[i][j+1]==1) continue;
				}
				if(j-1>=0) {
					if(rooms[i][j]-rooms[i][j-1]==1) continue;
				}
				// -1이 없다면, +1이 있는지 확인하는 로직 수행.
				checkRoom(i,j,1);
				// maxCnt가 바뀐 경우 maxRoom의 방번호 값 변화.
				if(isMax) {
					maxRoom = rooms[i][j];
				}
				// maxCnt와 cnt가 동일한 경우, 방 번호를 비교해서 작은 값을 maxRoom으로 지정.
				if(changeRoom && maxRoom>rooms[i][j]) {
					maxRoom = rooms[i][j];
				}
			}
		}
	}
	
	// 이동할 수 있는 방이 있는지 체크하고, 있다면 cnt를 1 더한 후  재귀함수 호출한다.
	// 최종적으로 이동할 수 있는 방이 없을 때까지 재귀함수를 행한 뒤 maxCnt와 cnt를 비교한다.
	void checkRoom(int i, int j, int cnt) {
		// 양 옆으로 이동했는지 확인하는 장치.
		boolean isplused = false;
		
		if(i+1<size) {
			if(rooms[i+1][j]-rooms[i][j]==1) {
				isplused = true;
				cnt++;
				checkRoom(i+1, j, cnt);
			}
		}
		if(i-1>=0) {
			if(rooms[i-1][j]-rooms[i][j]==1) {
				isplused = true;
				cnt++;
				checkRoom(i-1, j, cnt);
			}
		}
		if(j+1<size) {
			if(rooms[i][j+1]-rooms[i][j]==1) {
				isplused = true;
				cnt++;
				checkRoom(i, j+1, cnt);
			}
		}
		if(j-1>=0) {
			if(rooms[i][j-1]-rooms[i][j]==1) {
				isplused = true;
				cnt++;
				checkRoom(i, j-1, cnt);
			}
		}
		
		// 위의 if문을 하나라도 거치지 않았다면, 현재의 cnt값을 maxCnt와 비교한다.
		if (!(isplused)) {
			if(maxCnt < cnt) {
				maxCnt = cnt;
				// maxCnt가 바뀐 경우.
				isMax = true;
			}
			// maxCnt와 cnt값이 같은 경우, 방번호를 비교해야함.
			if(maxCnt == cnt) {
				changeRoom = true;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = Integer.parseInt(s.nextLine());
		for (int i = 0; i < T; i++) {
			int size = Integer.parseInt(s.nextLine());
			int[][] rooms = new int[size][size];
			
			for(int j=0; j<size; j++) {
				String arrline = s.nextLine();
				String[] arr = arrline.split(" ");
				// 문자열 배열을 받아서 숫자열 배열로 바꾸는 로직
				int[] eachline = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
				rooms[j]=eachline;
			}
			SW_1861 execute = new SW_1861(rooms, size);
			// 검사 수행
			execute.checkAllRooms();
			// 결과 출력
			System.out.println("#"+(i+1)+" "+execute.maxRoom+" "+execute.maxCnt);
		}
		
	}

}
