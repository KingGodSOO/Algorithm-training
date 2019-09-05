package Study.Day190519;

//시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
//2 초	128 MB	33840	8938	5894	27.579%
// N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOK_1920 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// n : 검색대상인 정수들의 개수 nArr : 검색대상인 정수들 m : 총 검사할 정수의 개수 mArr : 검사할 정수들
		int n = Integer.parseInt(s.nextLine());
		String ns = s.nextLine();
		int m = Integer.parseInt(s.nextLine());
		String ms = s.nextLine();
		// 입력받은 값을 배열화
		int[] nArr = strToArr(ns, n);
		int[] mArr = strToArr(ms, m);
		// 정렬
		quickSort(nArr);
		// 탐색
		for (int key : mArr) {
			binarySearch(nArr, key);
		}
	}

	private static void binarySearch(int[] inputArr, int key) {

		int low = 0;
		int high = inputArr.length - 1;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			// key가 중간보다 큰 경우
			if (key > inputArr[mid]) {
				low = mid + 1;
			}
			// key가 중간보다 작은 경우
			else if (key < inputArr[mid]) {
				high = mid - 1;
			}
			// key라면, stop
			else {
				// 존재 시, 1 출력
				System.out.println(1);
				return;
			}
		}
		System.out.println(0); // key가 없음!
		return;
	}

	// 소팅 메소드 -> 퀵소트
	private static void quickSort(int[] arr) {
		// 재귀함수 시작
		quickSort(arr, 0, arr.length - 1);
	}

	// 재귀함수 -> 배열과 시작점, 끝점을 받아옴
	private static void quickSort(int[] arr, int start, int end) {
		// 우측 배열의 시작점을 return 받음.
		int part2 = partition(arr, start, end);
		// 좌측의 시작점이 우측의 시작점 바로 전 이 되기 전까지 (즉, 크기가 1이 될 때까지)
		if (start < part2 - 1) {
			// 좌측의 배열을 재귀호출
			quickSort(arr, start, part2 - 1);
		}
		// 우측의 시작점이 마지막의 바로 전 이 되기 전까지 (즉, 크기가 1이 될 때까지)
		if (part2 < end) {
			// 우측의 배열을 재귀호출
			quickSort(arr, part2, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		// pivot은 임의적으로 배열 중간값으로 정해줌.
		int pivot = arr[(start + end) / 2];
		// 시작점이 끝점보다 작거나 같은경우에만(양쪽으로 훑어오던 것이 서로 교차될 때 까지)
		while (start <= end) {
			// pivot 좌측의 값이 pivot보다 크면 pass, 작으면 stop
			while (arr[start] < pivot)
				start++;
			// pivot 우측의 값은 pivot보다 작으면 pass, 크면 stop
			while (arr[end] > pivot)
				end--;
			// pivot 좌측의 인덱스와, 우측의 인덱스가 만나거나 지나치지 않은 경우에만
			if (start <= end) {
				// 두 값을 바꿔주고
				swap(arr, start, end);
				// 한 칸씩 더 이동시켜서, 반복
				start++;
				end--;
			}
		}
		// 끝까지 수행되면, 새로 나눌 오른쪽 배열의 첫번쨰 인덱스 값을 반환 (pivot+1)
		return start;
	}

	// 배열의 두 인덱스 위치를 바꾸는 메소드
	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	// 문자열과 그 크기를 받으면 숫자로 쪼개 배열에 담는 메소드
	private static int[] strToArr(String str, int n) {
		StringTokenizer stok = new StringTokenizer(str, " ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt((stok.nextToken()));
		}
		return arr;
	}

}