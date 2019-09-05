package Study.Day190519;

public class Sorting {

	private static void selectionSort(int[] arr, boolean b) {
		// 매개변수의 두 번째 항으로 true를 넣으면 오름차순
		if (b) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = i; j < arr.length; j++) {
					// a[i] 항과 a[j] 항 비교해서, a[j]가 더 작으면 swap
					if (arr[j] < arr[i]) {
						swap(arr, i, j);
					}
				}
			}
		}
		// false일 경우 내림차순
		else {
			for (int i = 0; i < arr.length; i++) {
				for (int j = i; j < arr.length; j++) {
					// a[i]항과 a[j] 항 비교해서, a[j]가 더 크면 swap
					if (arr[i] < arr[j]) {
						swap(arr, i, j);
					}
				}
			}
		}
		printing(arr);
	}

	private static void insertionSort(int[] arr, boolean b) {
		int tmp;
		if (b) {
			// 배열의 두 번째부터 검색
			for (int i = 1; i < arr.length; i++) {
				// 1. 기준을 변수에 저장
				tmp = arr[i];
				// j가 0에 도달하거나, arr[j]의 값이 기준보다 큰 동안
				for (int j = i - 1; j >= 0 && arr[j] > tmp; j--) {
					// 배열을 뒤로 한 칸씩 미루고, 기준을 arr[j]에 저장.
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		} else {
			for (int i = 1; i < arr.length; i++) {
				tmp = arr[i];
				// j가 0에 도달하거나, arr[j]의 값이 기준보다 작은동안 으로 조건바꿈
				for (int j = i - 1; j >= 0 && arr[j] < tmp; j--) {
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		printing(arr);
	}

	private static void bubbleSort(int[] arr, boolean b) {
		int size = arr.length - 1;
		if (b) {
			// 배열의 크기 -1만큼 반복한다.
			while (size > 0) {
				for (int i = 0; i < size; i++) {
					// 두 값의 크기를 비교해서, 자리를 맞춤.
					if (arr[i] > arr[i + 1]) {
						swap(arr, i, i+1);
					}
				}
				// 검색범위를 한 칸 줄이고, 반복수를 채운다.
				size--;
			}

		} else {
			while (size > 0) {
				for (int i = 0; i < size; i++) {
					if (arr[i] < arr[i + 1]) {
						swap(arr, i, i+1);
					}
				}
				// 검색범위를 한 칸 줄이고, 반복수를 채운다.
				size--;
			}
		}
		
		printing(arr);
	}
	
	
	//=========================mergeSort==========================
	private static void mergeSort(int[] arr) {
		// 임시 저장공간
		int[] tmp = new int[arr.length];
		// 재귀호출 시작(배열, 임시저장공간, 시작, 끝 인덱스 넘겨줌)
		mergeSort(arr, tmp, 0, arr.length-1);
		// 출력
		printing(arr);
	}
	
	// 재귀호출에 사용될 동일한 이름의 메소드
	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		// 시작 인덱스가 끝 인덱스보다 작을 동안만, 즉 배열의 크기가 1이 아닌 동안만!!
		if (start < end) {
			// 중간값 계산해서
			int mid = (start + end) / 2;
			// 자른 값들로 앞, 뒤 나누어서 재귀호출!
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid+1, end);
			// 재귀호출이 끝난 아이들은 차례대로 합병 과정을 거칠 것임.
			merge(arr, tmp, start, mid, end);
		}
	}
	// 정렬 결과를 반복적으로 저장하는 배열의 포인터? , 임시저장장소, 시작위치, 중간위치, 끝위치
	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		// 나눠진 두 개의 배열을 먼저 임시 배열에 하나로 합침.
		for (int i=start; i<=end; i++) {
			tmp[i]= arr[i];
		}
		// 좌측의 시작인덱스
		int part1 = start;
		// 우측의 시작인덱스
		int part2 = mid+1;
		// 뭐가됬든 index는 시작점부터!
		int index = start;
		while (part1 <= mid && part2 <= end) {
			// 뒤쪽이 크면, 인덱스의 위치를 앞쪽(작은값)으로 채우고	
			if (tmp[part1] <= tmp[part2]) {	//내림차순 :  if (tmp[part1] >= tmp[part2]) { 
				arr[index] = tmp[part1];
				// 작은값이 있는 배열의 다음 값을 비교
				part1++;
			// 반대의 경우
			}else {
				arr[index] = tmp[part2];
				part2++;
			}
			// 그리고, 그 다음에 저장해야함.
			index++;
		}
		// 임시 배열에서, 앞쪽 배열의 값이 남아있는 경우 뒤에 합쳐주어야 한다.
		for (int i=0; i <= mid - part1; i++) {
			arr[index +i] = tmp[part1 += i];
		}
	}
	//=========================mergeSort 끝==========================
	
	
	//=========================quickSort 시작==========================
	private static void quickSort(int[] arr) {
		// 재귀함수 시작
		quickSort(arr, 0, arr.length-1);
		// 출력
		printing(arr);
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
			// pivot 좌측의 값이 pivot보다 작으면 pass, 크면 stop    
			while (arr[start] < pivot) start++;		//내림차순 : while (arr[start] > pivot) start++;
			// pivot 우측의 값은 pivot보다 크면 pass, 작으면 stop    
			while (arr[end] > pivot) end--;		//내림차순 : while (arr[end] < pivot) end--;
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
	
//	==============================quickSort 끝=======================
	
	// 배열의 두 인덱스를 바꾸는 메소드
	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	// 출력 메소드
	private static void printing(int[] arr) {
		for (int data : arr) {
			System.out.print(data);
		}
	}

	public static void main(String[] args) {

		int[] test1 = { 4, 8, 2, 9, 6, 1, 3, 7, 5 };
//		selectionSort(test1, true);
//		System.out.println();
//		selectionSort(test1, false);
//		insertionSort(test1, true);
//		System.out.println();
//		InsertionSort(test1, false);
//		bubbleSort(test1, true);
//		System.out.println();
//		bubbleSort(test1, false);
		mergeSort(test1);
//		quickSort(test1);
	}
}
