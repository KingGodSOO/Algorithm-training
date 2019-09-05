package Study.Day190721;

/*
  풀이날짜 :2019/07/20      풀이시간 :  1시간15분      체감난이도 :   하 

 
8*8크기의 체스판에 왕이 하나 있다. 킹의 현재 위치가 주어진다. 체스판에서 말의 위치는 다음과 같이 주어진다. 알파벳 하나와 숫자 하나로 이루어져 있는데, 알파벳은 열을 상징하고, 숫자는 행을 상징한다. 열은 가장 왼쪽 열이 A이고, 가장 오른쪽 열이 H까지 이고, 행은 가장 아래가 1이고 가장 위가 8이다. 예를 들어, 왼쪽 아래 코너는 A1이고, 그 오른쪽 칸은 B1이다.

킹은 다음과 같이 움직일 수 있다.

R : 한 칸 오른쪽으로
L : 한 칸 왼쪽으로
B : 한 칸 아래로
T : 한 칸 위로
RT : 오른쪽 위 대각선으로
LT : 왼쪽 위 대각선으로
RB : 오른쪽 아래 대각선으로
LB : 왼쪽 아래 대각선으로
체스판에는 돌이 하나 있는데, 돌과 같은 곳으로 이동할 때는, 돌을 킹이 움직인 방향과 같은 방향으로 한 칸 이동시킨다. 아래 그림을 참고하자.



입력으로 킹이 어떻게 움직여야 하는지 주어진다. 입력으로 주어진 대로 움직여서 킹이나 돌이 체스판 밖으로 나갈 경우에는 그 이동은 건너 뛰고 다음 이동을 한다.

킹과 돌의 마지막 위치를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 킹의 위치, 돌의 위치, 움직이는 횟수 N이 주어진다. 둘째 줄부터 N개의 줄에는 킹이 어떻게 움직어여 하는지 주어진다. N은 50보다 작거나 같은 자연수이고, 움직이는 정보는 위에 쓰여 있는 8가지 중 하나이다.

출력
첫째 줄에 킹의 마지막 위치, 둘째 줄에 돌의 마지막 위치를 출력한다.
*/


import java.util.Scanner;

public class SW_1063 {
	
	public static String convertToChess(int row, int col) {
		
	}
	
	public static int[] convertToTwoDimension(String chessPosition) {
		
	}
//	kr = king의 위치행  kc = king의 위치열   sr = 돌의 위치행  sc = 돌의 위치열
	
	int[] king = new int[2];
	int[] stone = new int[2];
	
	SW_1063(int kr, int kc, int sr, int sc) {
		// 킹은 1로, 돌은 2로 표시.
		king[0] = kr;
		king[1] = kc;
		stone[0] = sr;
		stone[1] = sc;
	}
	
	void move(String line){
		
		if(line.equals("R")) {
			// 이동자리에 돌이 있는 경우
			if(king[0]+1==stone[0]&&king[1]==stone[1]) {
				// 돌이 벗어나지 않는지 확인하고 이동
				if(stone[0]+1<9) {
					stone[0] += 1;
					king[0] += 1;
				}
			}
			// 이동자리에 돌이 없는경우
			else {
				// 킹이 벗어나지 않는지 확인하고 이동.
				if(king[0]+1<9) {
					king[0] += 1;
				}
			}
		}
		
		else if(line.equals("L")) {
			// 이동자리에 돌이 있는 경우
			if(king[0]-1==stone[0]&&king[1]==stone[1]) {
				// 돌이 벗어나지 않는지 확인하고 이동
				if(stone[0]-1>0) {
					stone[0] -= 1;
					king[0] -= 1;
				}
			}
			// 이동자리에 돌이 없는경우
			else {
				// 킹이 벗어나지 않는지 확인하고 이동.
				if(king[0]-1>0) {
					king[0] -= 1;
				}
			}
		}
		else if(line.equals("B")) {
			// 이동자리에 돌이 있는 경우
			if(king[0]==stone[0]&&king[1]-1==stone[1]) {
				// 돌이 벗어나지 않는지 확인하고 이동
				if(stone[1]-1>0) {
					stone[1] -= 1;
					king[1] -= 1;
				}
			}
			// 이동자리에 돌이 없는경우
			else {
				// 킹이 벗어나지 않는지 확인하고 이동.
				if(king[1]-1>0) {
					king[1] -= 1;
				}
			}	
		}
		else if(line.equals("T")) {
			// 이동자리에 돌이 있는 경우
			if(king[0]==stone[0]&&king[1]+1==stone[1]) {
				// 돌이 벗어나지 않는지 확인하고 이동
				if(stone[1]+1<9) {
					stone[1] += 1;
					king[1] += 1;
				}
			}
			// 이동자리에 돌이 없는경우
			else {
				// 킹이 벗어나지 않는지 확인하고 이동.
				if(king[1]+1<9) {
					king[1] += 1;
				}
			}	
		}
		
		else if(line.equals("RT")) {
			// 이동자리에 돌이 있는 경우
			if(king[0]+1==stone[0]&&king[1]+1==stone[1]) {
				// 돌이 벗어나지 않는지 확인하고 이동
				if(stone[0]+1<9&&stone[1]+1<9) {
					stone[0] += 1;
					stone[1] += 1;
					king[0] += 1;
					king[1] += 1;
				}
			}
			// 이동자리에 돌이 없는경우
			else {
				// 킹이 벗어나지 않는지 확인하고 이동.
				if(king[0]+1<9 && king[1]+1<9) {
					king[0] += 1;
					king[1] += 1;
				}
			}	
		}
		else if(line.equals("LT")) {
			// 이동자리에 돌이 있는 경우
			if(king[0]-1==stone[0]&&king[1]+1==stone[1]) {
				// 돌이 벗어나지 않는지 확인하고 이동
				if(stone[0]-1>0&&stone[1]+1<9) {
					stone[0] -= 1;
					stone[1] += 1;
					king[0] -= 1;
					king[1] += 1;
				}
			}
			// 이동자리에 돌이 없는경우
			else {
				// 킹이 벗어나지 않는지 확인하고 이동.
				if(king[0]-1>0 && king[1]+1<9) {
					king[0] -= 1;
					king[1] += 1;
				}
			}	
		}
		else if(line.equals("RB")) {
			// 이동자리에 돌이 있는 경우
			if(king[0]+1==stone[0]&&king[1]-1==stone[1]) {
				// 돌이 벗어나지 않는지 확인하고 이동
				if(stone[0]+1<9&&stone[1]-1>0) {
					stone[0] += 1;
					stone[1] -= 1;
					king[0] += 1;
					king[1] -= 1;
				}
			}
			// 이동자리에 돌이 없는경우
			else {
				// 킹이 벗어나지 않는지 확인하고 이동.
				if(king[0]+1<9 && king[1]-1>0) {
					king[0] += 1;
					king[1] -= 1;
				}
			}	
		}
		else if(line.equals("LB")) {
			// 이동자리에 돌이 있는 경우
			if(king[0]-1==stone[0]&&king[1]-1==stone[1]) {
				// 돌이 벗어나지 않는지 확인하고 이동
				if(stone[0]-1>0&&stone[1]-1>0) {
					stone[0] -= 1;
					stone[1] -= 1;
					king[0] -= 1;
					king[1] -= 1;
				}
			}
			// 이동자리에 돌이 없는경우
			else {
				// 킹이 벗어나지 않는지 확인하고 이동.
				if(king[0]-1>0 && king[1]-1>0) {
					king[0] -= 1;
					king[1] -= 1;
				}
			}	
		}
		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String line = s.nextLine();
		String arr[] = line.split(" ");
		// char(A)의 int값은 65, 1의 int값은 49
		int kc = (int)arr[0].charAt(0)-64;
		int kr = (int)arr[0].charAt(1)-48;
		int sc = (int)arr[1].charAt(0)-64;
		int sr = (int)arr[1].charAt(1)-48;
		int time = Integer.parseInt(arr[2]);
		SW_1063 execute = new SW_1063(kr, kc, sr, sc);
		
		for(int i=0; i<time; i++) {
			line = s.nextLine();
			execute.move(line);
		}
		
		System.out.println((char)(execute.king[1]+64)+(execute.king[0]+""));
		System.out.println((char)(execute.stone[1]+64)+(execute.stone[0]+""));
	}
}
