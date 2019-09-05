package Study.Day190519;

import java.util.Scanner;
import java.util.StringTokenizer;

// 시간초과로 탈락

//시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
//1 초	256 MB	5990	3888	3183	67.436%

//2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

public class BOK_11651 {

	// 2차원 배열과 행 수를 입력받아, 정렬한 값을 출력해주는 메소드
	public static void q11651(int[][] tdarr, int range) {
		// 버블정렬
		int size = range -1;
		int tmp;
		while (size > 0) {
			for (int i =0; i< size; i++) {
				// y값을 비교해서, 정렬
				if (tdarr[i][1]>tdarr[i+1][1]) {
					tmp = tdarr[i][1];
					tdarr[i][1] = tdarr[i+1][1];
					tdarr[i+1][1] = tmp;
					// y값을 정렬할 때, x값도 따라가야 한다.
					tmp = tdarr[i][0];
					tdarr[i][0] = tdarr[i+1][0];
					tdarr[i+1][0] = tmp;
				}
				// y값이 동일하면 x값으로 정렬
				else if (tdarr[i][1]==tdarr[i+1][1]) {
					if (tdarr[i][0]>tdarr[i+1][0]) {
						tmp = tdarr[i][0];
						tdarr[i][0]=tdarr[i+1][0];
						tdarr[i+1][0]=tmp;
					}
				}
			}
			size--;
		}
		for(int i=0; i<range; i++) {
			System.out.println(tdarr[i][0]+""+' '+tdarr[i][1]+"");
		}
	}

	public static void main(String[] args) {
		// 입력받은 값에서 x좌표와 y좌표를 분리할 StringTokenizer 객체 선언
		StringTokenizer stok;
		// 첫 줄 입력
		Scanner s = new Scanner(System.in);
		int num = Integer.parseInt(s.nextLine());
		// 메소드에 넣을 변수 지정
		int range = num;
		// x, y 좌표를 담을 2차원 배열 생성
		int[][] tdarr = new int[num][2];
		// 배열에 1행부터 차례로 변수를 넣기위해 i 선언
		int i = 0;
		// 첫 줄의 수 만큼 반복해서, 2차원 배열을 입력받는다.
		while (num > 0) {
			String input = s.nextLine();
			// 공백으로 자르는 방법을 모르겠다.
			stok = new StringTokenizer(input, " ");
			tdarr[i][0] = Integer.parseInt((stok.nextToken()));
			tdarr[i][1] = Integer.parseInt(stok.nextToken());
			num--;
			i++;
		}
		// 정렬 결과를 출력
		q11651(tdarr, range);

	}

}
