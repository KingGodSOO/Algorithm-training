package Study.Day190623;

//3x3 크기의 배열이 있을때 0,0에서 출발하여 가능한 모든 경로를 출력하세요 (DFS , BFS 중 택 1)
//출력 형태 예시)  (0,0) -> (0,1) -> (0,2) -> (1,2) -> (1,1) -> (1,0) -> (2,0) -> (2,1) -> (2,2)
public class SquarePractice {
// 옵셋 추가하기
// 백업 수정
// 한번에 출력되기
	// arr = 각 위치의 값이 (index,index) 인 String요소를 갖는 배열
	// checkArr = 해당 위치가 방문했던 곳인지 확인하기 위한 배열 (방문한곳 = true // 방문하지 않은 곳= false)
	String[][] arr;
	boolean[][] checkArr;
	
	public void makeArr() {
		arr = new String[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = "("+i+","+j+")";
			}
		}
	}
	
	
	// 모두 false로 초기화
	public void makeCheckArr() {
		checkArr = new boolean[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				checkArr[i][j] = false;
			}
		}
	}

	// i, j의 배열을 받으면 해당 0,0 부터 i,j의 위치를 찾아가는 메소드
	public void squareDFS(int x, int y){
		if(x<0 || y<0 || x>2 || y>2) return;
		if(checkArr[x][y]) return;
		checkArr[x][y] = true;
		System.out.print(arr[x][y]);
		
		if(x==2&&y==2) {
			System.out.println();
			return;
		}else {
			System.out.print("->");
		}
		
		// 백업은 방문기록을 한다.
		boolean[][] backupArr = new boolean[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0;j<3;j++) {
				backupArr[i][j] = checkArr[i][j];
			}
		}
		squareDFS(x-1, y);
		checkArr = backupArr;
		
		squareDFS(x+1, y);
		checkArr = backupArr;
		
		squareDFS(x, y-1);
		checkArr = backupArr;
		
		squareDFS(x, y+1);
		checkArr = backupArr;
	}
	public static void main(String[] args) {
		SquarePractice practice = new SquarePractice();
		practice.makeArr();
		practice.makeCheckArr();
		
		practice.squareDFS(0,0);
	}

}
