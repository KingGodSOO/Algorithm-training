package Study.Day190519;

//시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
//2 초	128 MB	14117	8270	7246	59.964%
// 문제
// 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
// 입력
// 첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
// 출력
// 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.

import java.util.Scanner;

public class BOK_1427 {
	
	
	private static void quickSort(int input) {
		// 배열화 함수로 배열화시킴.
		int[] arr = numbToArr(input);
		// 재귀함수 시작
		quickSort(arr, 0, arr.length-1);
		// 최종적으로 출력
		for (int data : arr) {
			System.out.print(data);
		}
	}
	// 재귀함수 -> 배열과 시작점, 끝점을 받아옴
	private static void quickSort(int[] arr, int start, int end) {
		// 우측 배열의 시작점을 return 받음.
		int part2 = partition(arr, start, end);
		// 좌측의 시작점이 우측의 시작점 바로 전   이 되기 전까지 (즉, 크기가 1이 될 때까지)
		if (start < part2-1) {
			// 좌측의 배열을 재귀호출
			quickSort(arr, start, part2-1);
		}
		// 우측의 시작점이 마지막의 바로 전    이 되기 전까지 (즉, 크기가 1이 될 때까지)
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
			while (arr[start] > pivot) start++;
			// pivot 우측의 값은 pivot보다 작으면 pass, 크면 stop
			while (arr[end] < pivot) end--;
			// pivot 좌측의 인덱스와, 우측의 인덱스가 만나거나 지나치지 않은 경우에만
			if (start <= end) {
				// 두 값을 바꿔주고
				swap (arr, start, end);
				// 한 칸씩 더 이동시켜서, 반복
				start++;
				end--;
			}
		}
		// 끝까지 수행되면, 새로 나눌 오른쪽 배열의 첫번쨰 인덱스 값을 반환 (pivot+1)
		return start;
	}
	
	// 자연수를 받아서 배열로 변환시키는 메소드
	private static int[] numbToArr(int input) {
		// 정수형의 길이를 체크
		int length = (int) (Math.log10(input) + 1);
		// 숫자를 넣을 배열을 생성
		int[] arr = new int[length];
		// 1.입력받은 숫자를 자릿수대로 쪼개서 배열에 넣음(이 때 숫자가 반대로 들어감)
		for (int i = 0; i < length; i++) {
			arr[i] = input % 10;
			input = input/10;
		}
		return arr;
	}
	
	// 배열의 두 인덱스 위치를 바꾸는 메소드
	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		quickSort(input);
	}

}
