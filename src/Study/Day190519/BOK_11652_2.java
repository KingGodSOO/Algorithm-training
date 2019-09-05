package Study.Day190519;

//시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
//1 초	256 MB	5990	3888	3183	67.436%
//2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOK_11652_2 {
	public static void main(String[] args) {
		// 입력받은 값에서 x좌표와 y좌표를 분리할 StringTokenizer 객체 선언
		// 첫 줄 입력
		Scanner s = new Scanner(System.in);
		int num = Integer.parseInt(s.nextLine());
		
		// key값으로 2차원->1차원 축소시킨 배열을 넣고, value값으로 입력받은 문자열을 넣는다.
		HashMap<Long, String> hm = new HashMap<Long, String>(num);
		// 정렬하기 위해 value로 이루어진 배열도 생성.
		long[] keys = new long[num];
		
		for (int i=0; i<num; i++) {
			String Line = s.nextLine();
			long key = dimRed(Line);
			hm.put(key, Line);
			keys[i] = key;
		}
		
		// 배열을 정렬
		quickSort(keys);
		// 배열의 순서대로 key값들을 출력
		for (long key : keys) {
			System.out.println(hm.get(key));
		}
	}
	
	// 퀵소트 메소드
	private static void quickSort(long[] keys) {
		quickSort(keys, 0, keys.length-1);
	}
	private static void quickSort(long[] keys, int start, int end) {
		int part2 = partition(keys, start, end);
		if (start < part2-1) {
			quickSort(keys, start, part2-1);
		}
		if (part2 < end) {
			quickSort(keys, part2, end);
		}
	}
	private static int partition(long[] keys, int start, int end) {
		long pivot = keys[(start + end) / 2];
		while (start <= end) {
			while (keys[start] < pivot) start++;
			while (keys[end] > pivot) end--;
			if (start <= end) {
				swap (keys, start, end);
				start++;
				end--;
			}
		}
		// 끝까지 수행되면, 새로 나눌 오른쪽 배열의 첫번쨰 인덱스 값을 반환 (pivot+1)
		return start;
	}
	
	// 위치 바꾸기
	private static void swap(long[] keys, int a, int b) {
		long tmp = keys[a];
		keys[a] = keys[b];
		keys[b] = tmp;
	}
	
	
	// 입력받은 라인을 2차원으로 해석한 뒤, 1차원으로 축소하는 메소드
	private static long dimRed(String str) {
		StringTokenizer stok = new StringTokenizer(str, " ");
		int x = Integer.parseInt(stok.nextToken());
		long y = Integer.parseInt(stok.nextToken());
		return y*1000000 + x;
	}
	
}
