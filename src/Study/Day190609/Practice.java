package Study.Day190609;

// 배열과 합격기준을 입력받아서 모든 경우의수를 구현하는 연습.
public class Practice {
	
	// matrix : 약물 투입할 배열 // current : 현재 행(0~matrix.length) // count : 투입된 약물 수 // k : 투입가능한 약물 수 
	void dfs(int[][] matrix, int current, int count, int k) {
		printMatrix(matrix);
		if(count>=k)return;
		if(current >= matrix.length) {
			return;
		}
		
		// 약물을 넣지 않는 방향으로 dfs. backup이 필요없다(default값 그대로이므로)
		dfs(matrix, current+1, count, 1);
		
		// A약물을 넣는 방향으로 dfs. backup이 필요하므로 현재 matrix를 복사해서 dfs 후에 backup 해준다.
		int[] backup = matrix[current];
		putChemicalA(matrix, current);
		dfs(matrix, current+1, count+1, 1);
		matrix[current] = backup.clone(); // 굳이 클론 쓸 필요가 있을까..?
		
		// B약물을 넣는 방향으로 dfs
		putChemicalB(matrix, current);
		dfs(matrix, current+1, count+1, 1);
		matrix[current] = backup.clone();
	}
	
	void putChemicalA(int[][] matrix, int current) {
		int[] arr = {0,0,0,0,0,0,0,0};
		matrix[current] = arr.clone();
	}
	
	void putChemicalB(int[][] matrix, int current) {
		int[] arr = {1,1,1,1,1,1,1,1};
		matrix[current] = arr;
	}
	
	void printMatrix(int[][] matrix) {
		System.out.println("===============");
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] matrix = {{0, 0, 1, 0, 1, 0, 0, 1},
				{0, 1, 0, 0, 0, 1, 1, 1},
				{0, 1, 1, 1, 0, 0, 0, 0},
				{1, 1, 1, 1, 0, 0, 0, 1},
				{0, 1, 1, 0, 1, 0, 0, 1},
				{1, 0, 1, 0, 1, 1, 0, 1}};
		Practice test = new Practice();
		test.dfs(matrix, 0, 0, 1);
	}
	
}
