package Study.Day190609;

/*
 풀이 날짜 : 19/06/08     풀이 시간 : 11시간          체감 난이도 : 중상
 리팩토링 1 : 19/07/06    시간 : 1시간           바뀐내용 : 결과값을 반환하기 위해 TreeSet을 사용하던 것을 지우고, 최소값을 지역변수로 선언한 뒤
 								count가 최소값 이상일 때 dfs 멈추게 해서 쓸데없는 검사를 줄임.

https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu
2112. [모의 SW 역량테스트] 보호 필름
시간 : 50개 테스트케이스를 합쳐서 C의 경우 5초 / C++의 경우 5초 / Java의 경우 5초 / Python의 경우 15초
메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내

[제약사항]

1. 시간제한 : 최대 50개 테스트 케이스를 모두 통과하는데, C/C++/Java 모두 5초

2. 보호 필름의 두께 D는 3이상 13이하의 정수이다. (3≤D≤13)

3. 보호 필름의 가로크기 W는 1이상 20이하의 정수이다. (1≤W≤20)

4. 합격기준 K는 1이상 D이하의 정수이다. (1≤K≤D)

5. 셀이 가질 수 있는 특성은 A, B 두 개만 존재한다.

[입력]

첫 줄에 총 테스트 케이스의 개수 T가 주어진다.

두 번째 줄부터 T개의 테스트 케이스가 차례대로 주어진다.

각 테스트 케이스의 첫 줄에는 보호 필름의 두께 D, 가로크기 W, 합격기준 K가 차례로 주어진다.

그 다음 D줄에 보호 필름 단면의 정보가 주어진다. 각 줄에는 셀들의 특성 W개가 주어진다. (특성A는 0, 특성B는 1로 표시된다.)


[출력]

테스트 케이스의 개수만큼 T줄에 T개의 테스트 케이스 각각에 대한 답을 출력한다.

각 줄은 “#x”로 시작하고 공백을 하나 둔 다음 정답을 출력한다. (x는 1부터 시작하는 테스트 케이스의 번호이다)

출력해야 할 정답은 성능검사를 통과할 수 있는 약품의 최소 투입 횟수이다. 약품을 투입하지 않고도 성능검사를 통과하는 경우에는 0을 출력한다.
*/

import java.util.Arrays;
import java.util.Scanner;

public class SW_2112 {
	
	// D=행의 개수, W= 열의 개수, K= 합격 기준, film = 보호필름, minimum = 결과로 반환할 최소값.
	// 계속해서 사용되므로 지역변수로 선언!
	// minimum 또한 메소드가 공유해서 사용하는 변수이므로 지역변수로 선언.
	// backup이 있으므로, film을 지역변수로 선언하여 사용해도 된다! 물론 매개변수로 넣더라도 동일하게 backup이 필요하다. 
	final int D, W, K;
	int minimum;
	int[][] film;
	SW_2112(int D, int W, int K, int[][] film){
		this.D = D;
		this.W = W;
		this.K = K;
		this.film = film;
		this.minimum = K;
	}
	
	// 테스트를 통과하는지 확인하는 메소드
	boolean check() {
		
		// 해당 열이 테스트를 통과하는지 확인하는 지표.
		int eachcount=0;
		
		// 컬럼이 테스트를 통과했는지 확인하는 지표.
		boolean check = false;
		
		// 모든 열에 대해서 수행
		for (int i = 0; i < W; i++) {
			
			// 하나의 열에 대해 검사를 시작할 떄, check를 false로 초기화.
			check = false;
			
			// 0번째 행부터, D-K 행까지 반복(K개의 연속된 동일한 값을 가지면 되므로)
			columnloop: for (int j = 0; j <= D - K; j++) {
				// eachcount를 초기화.
				eachcount = 0;
				
				// 각 행의 값을 합격기준치(K)만큼의 횟수로 더해서, j부터 j+k 까지 확인
				for (int l = 0; l < K; l++) {
					eachcount += film[j+l][i];
				}
				
				// 모두 동일한 경우 eachcount의 값은 0 또는 k가 될 것이다.
				// 통과하면 check를 true로 바꾸고 해당 열 검사 종료.
				if (eachcount == K || eachcount == 0) {
					check = true;
					break columnloop;
				}
			}
			
			// 다음 열로 넘어가기 전 통과했는지 확인. 끝까지 break 되지 않았다면 검사를 중지하고 false 반환.
			if (check == false) return false;
		}
		// 모든 열이 테스트를 통과한다면 true 반환.
		return true;
	}
	
	// 모든 경우의 수를 만들면서, check하는 메소드.
	void checkAllCases(){
		// 약물을 넣지 않은 경우를 확인해서, 통과하면 최소값을 0으로 바꾸고 종료.
		if(check()) {
			minimum = 0;
			return;
		}
		
		// 약물을 생성.(열의 크기에 맞게 0또는 1의 단일행을 만든다)
		int[] chemicalA = new int[W];
		int[] chemicalB = new int[W];
		for(int i=0; i<W; i++) {
			chemicalA[i]=0;
			chemicalB[i]=1;
		}
		
		// 재귀호출 시작.
		allCasesDFS(0, 0, chemicalA, chemicalB);
	}
	
	// current : 현재 행(0~film.length) // count : 투입된 약물 수.
	void allCasesDFS(int current, int count, int[] chemicalA, int[] chemicalB) {
		
		// 첨가한 약물의 개수가 최소값보다 같거나 크다면 건너뛴다.
		if(count>=minimum) return;

		// 약물을 1회 이상 투입한 경우에만 검사.  => 제거가능.
		if(count >= 1) {
			if(check()) {
				minimum = count;
			}
		}
		
		// 마지막 행까지 도달했을 경우 return
		if(current >= D) return;
		
		// 약물을 넣지 않는 방향으로 dfs. backup이 필요없다(분기점에서의 값 그대로이므로)
		allCasesDFS(current+1, count, chemicalA, chemicalB);
				
		// A약물을 넣는 방향으로 dfs. backup이 필요하므로 현재 film에서 약물을 투입할 행을 복사해서 dfs 후에 backup 해준다.
		int[] backup = film[current];
		putChemical(film, current, chemicalA);
		allCasesDFS(current+1, count+1, chemicalA, chemicalB);
		// 사실 여기서는 backup생략 가능. 곧바로 B약물이 들어갈 것이므로.		
		film[current] = backup;
			
		// B약물을 넣는 방향으로 dfs
		putChemical(film, current, chemicalB);
		allCasesDFS(current+1, count+1, chemicalA, chemicalB);
		film[current] = backup;
		
	}
	
	// 약물을 넣는(특정 행의 값을 동일하게 바꾸는) 메소드.
	void putChemical(int[][] film, int current, int[] chemical) {
		film[current] = chemical;
	}
	
	public static void main(String[] args) {
		// 입력받아서, 2차원 배열로 만듬.
		Scanner s = new Scanner(System.in);
		// 처음 입력받는 값 : 총 테스트 케이스 개수
		int T = Integer.parseInt(s.nextLine());
		// 각 테스트 케이스의 첫 줄에는 보호 필름의 두께 D, 가로크기 W, 합격기준 K
		for (int i = 0; i < T; i++) {
			String fline = s.nextLine();
			String[] arr = fline.split(" ");

			int D = Integer.parseInt(arr[0]);
			int W = Integer.parseInt(arr[1]);
			int K = Integer.parseInt(arr[2]);
			// D와 W는 FILM의 행과 열이 된다.
			int[][] film = new int[D][W];
			
			// D,W,K,film을 지역변수로 가지는 클래스 생성 => 필름을 초기화 하고 생성자로 바꾸자.
			SW_2112 test = new SW_2112(D,W,K,film);
			
			// 배열을 만드는 로직 - 열의 개수만큼 입력받음.
			for (int j = 0; j < D; j++) {
				String line = s.nextLine();
				arr = line.split(" ");
				// 문자열 배열을 받아서 숫자열 배열로 바꾸는 로직
				int[] filmline = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
				film[j] = filmline;
			}
			// minimum을 찾음.
			test.checkAllCases();
			// 결과값 출력.
			System.out.println("#"+(i+1)+" "+test.minimum);
		}
	}

}
