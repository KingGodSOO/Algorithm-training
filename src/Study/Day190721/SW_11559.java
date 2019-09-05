package Study.Day190721;

import java.util.Scanner;

/*
     풀이날짜 :2019/07/20      풀이시간 :  12:30~14:00     체감난이도 :  상 
 
문제
뿌요뿌요의 룰은 다음과 같다.

필드에 여러 가지 색깔의 뿌요를 놓는다. 뿌요는 중력의 영향을 받아 아래에 바닥이나 다른 뿌요가 나올 때까지 아래로 떨어진다.

뿌요를 놓고 난 후, 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다.

뿌요들이 없어지고 나서 위에 다른 뿌요들이 있다면, 역시 중력의 영향을 받아 차례대로 아래로 떨어지게 된다.

아래로 떨어지고 나서 다시 같은 색의 뿌요들이 4개 이상 모이게 되면 또 터지게 되는데, 터진 후 뿌요들이 내려오고 다시 터짐을 반복할 때마다 1연쇄씩 늘어난다.

터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야 하고 여러 그룹이 터지더라도 한번의 연쇄가 추가된다.

남규는 최근 뿌요뿌요 게임에 푹 빠졌다. 이 게임은 1:1로 붙는 대전게임이라 잘 쌓는 것도 중요하지만, 상대방이 터뜨린다면 연쇄가 몇 번이 될지 바로 파악할 수 있는 능력도 필요하다. 하지만 아직 실력이 부족하여 남규는 자기 필드에만 신경 쓰기 바쁘다. 상대방의 필드가 주어졌을 때, 연쇄가 몇 번 연속으로 일어날지 계산하여 남규를 도와주자!

입력
12*6의 문자가 주어진다.

이때 .은 빈공간이고 .이 아닌것은 각각의 색깔의 뿌요를 나타낸다.

R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑이다.(모두 대문자로 주어진다.)

입력으로 주어지는 필드는 뿌요들이 전부 아래로 떨어진 뒤의 상태(즉 뿌요 아래에 빈 칸이 있는 경우는 없음) 이다.

출력
현재 주어진 상황에서 몇연쇄가 되는지 출력하라. (하나도 터지지 않는다면 0을 출력하면 된다.)
*/

public class SW_11559 {

	// matrix : input data     isChecked : 검사 시 해당 인덱스를 거쳐갔는지 확인하기 위한 boolean배열
	int[][] matrix = new int[12][6];
	boolean[][] isChecked = new boolean[12][6];
	int cnt = 0;
	
	// 생성자
	SW_11559(int[][] matrix){
		this.matrix = matrix;
	}
	
	
	// 검사를 처음부터 시작할  때, isChecked를 초기화 해준다.
	void resetCheck() {
		for(int row=0; row<12; row++) {
			for(int col=0; col<6; col++) {
				isChecked[row][col]=false;
			}
		}
	}
	
	
	void pung(int[][] matrix) {
		for(int row=0; row<12; row++) {
			for(int col=0; col<6; col++) {
				
				if(matrix[row][col]==46) continue;
				if(isChecked[row][col])	continue;
				
				cnt=0;
				
				if(check(row, col)) {
					// 부수는 로직
					
					// 메소드를 끝냄
				}
				
			}
		}
	}
	
	boolean check(int row, int col) {
		isChecked[row][col]=true;
		cnt++;
		if(row+1<12 && !(isChecked[row+1][col])) {
			if(matrix[row][col]==matrix[row+1][col]) {
				check(row+1, col);
			}
		}
		if(col+1<6 && !(isChecked[row][col+1])) {
			if(matrix[row][col]==matrix[row][col+1]) {
				check(row, col+1);
			}
		}
		
		if(cnt > 3) {
			return truet;
		}
		
	}

	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		// 값을 숫자로 받음.
		int[][] matrix = new int[12][6];
		
		for(int i=0; i<12; i++) {
			String Line = s.nextLine();
			for(int j=0; j<6; j++) {
				matrix[i][j] = (int)Line.charAt(j);
			}
			
		}
		
	}

}


// .:46  R:82 G:71 B:66 P:80 Y:89


































