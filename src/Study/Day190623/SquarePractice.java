package Study.Day190623;

//3x3 ũ���� �迭�� ������ 0,0���� ����Ͽ� ������ ��� ��θ� ����ϼ��� (DFS , BFS �� �� 1)
//��� ���� ����)  (0,0) -> (0,1) -> (0,2) -> (1,2) -> (1,1) -> (1,0) -> (2,0) -> (2,1) -> (2,2)
public class SquarePractice {
// �ɼ� �߰��ϱ�
// ��� ����
// �ѹ��� ��µǱ�
	// arr = �� ��ġ�� ���� (index,index) �� String��Ҹ� ���� �迭
	// checkArr = �ش� ��ġ�� �湮�ߴ� ������ Ȯ���ϱ� ���� �迭 (�湮�Ѱ� = true // �湮���� ���� ��= false)
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
	
	
	// ��� false�� �ʱ�ȭ
	public void makeCheckArr() {
		checkArr = new boolean[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				checkArr[i][j] = false;
			}
		}
	}

	// i, j�� �迭�� ������ �ش� 0,0 ���� i,j�� ��ġ�� ã�ư��� �޼ҵ�
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
		
		// ����� �湮����� �Ѵ�.
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
