package Study.Day190609;

// �迭�� �հݱ����� �Է¹޾Ƽ� ��� ����Ǽ��� �����ϴ� ����.
public class Practice {
	
	// matrix : �๰ ������ �迭 // current : ���� ��(0~matrix.length) // count : ���Ե� �๰ �� // k : ���԰����� �๰ �� 
	void dfs(int[][] matrix, int current, int count, int k) {
		printMatrix(matrix);
		if(count>=k)return;
		if(current >= matrix.length) {
			return;
		}
		
		// �๰�� ���� �ʴ� �������� dfs. backup�� �ʿ����(default�� �״���̹Ƿ�)
		dfs(matrix, current+1, count, 1);
		
		// A�๰�� �ִ� �������� dfs. backup�� �ʿ��ϹǷ� ���� matrix�� �����ؼ� dfs �Ŀ� backup ���ش�.
		int[] backup = matrix[current];
		putChemicalA(matrix, current);
		dfs(matrix, current+1, count+1, 1);
		matrix[current] = backup.clone(); // ���� Ŭ�� �� �ʿ䰡 ������..?
		
		// B�๰�� �ִ� �������� dfs
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
