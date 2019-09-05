package Study.Day190519;

public class Sorting {

	private static void selectionSort(int[] arr, boolean b) {
		// �Ű������� �� ��° ������ true�� ������ ��������
		if (b) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = i; j < arr.length; j++) {
					// a[i] �װ� a[j] �� ���ؼ�, a[j]�� �� ������ swap
					if (arr[j] < arr[i]) {
						swap(arr, i, j);
					}
				}
			}
		}
		// false�� ��� ��������
		else {
			for (int i = 0; i < arr.length; i++) {
				for (int j = i; j < arr.length; j++) {
					// a[i]�װ� a[j] �� ���ؼ�, a[j]�� �� ũ�� swap
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
			// �迭�� �� ��°���� �˻�
			for (int i = 1; i < arr.length; i++) {
				// 1. ������ ������ ����
				tmp = arr[i];
				// j�� 0�� �����ϰų�, arr[j]�� ���� ���غ��� ū ����
				for (int j = i - 1; j >= 0 && arr[j] > tmp; j--) {
					// �迭�� �ڷ� �� ĭ�� �̷��, ������ arr[j]�� ����.
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		} else {
			for (int i = 1; i < arr.length; i++) {
				tmp = arr[i];
				// j�� 0�� �����ϰų�, arr[j]�� ���� ���غ��� �������� ���� ���ǹٲ�
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
			// �迭�� ũ�� -1��ŭ �ݺ��Ѵ�.
			while (size > 0) {
				for (int i = 0; i < size; i++) {
					// �� ���� ũ�⸦ ���ؼ�, �ڸ��� ����.
					if (arr[i] > arr[i + 1]) {
						swap(arr, i, i+1);
					}
				}
				// �˻������� �� ĭ ���̰�, �ݺ����� ä���.
				size--;
			}

		} else {
			while (size > 0) {
				for (int i = 0; i < size; i++) {
					if (arr[i] < arr[i + 1]) {
						swap(arr, i, i+1);
					}
				}
				// �˻������� �� ĭ ���̰�, �ݺ����� ä���.
				size--;
			}
		}
		
		printing(arr);
	}
	
	
	//=========================mergeSort==========================
	private static void mergeSort(int[] arr) {
		// �ӽ� �������
		int[] tmp = new int[arr.length];
		// ���ȣ�� ����(�迭, �ӽ��������, ����, �� �ε��� �Ѱ���)
		mergeSort(arr, tmp, 0, arr.length-1);
		// ���
		printing(arr);
	}
	
	// ���ȣ�⿡ ���� ������ �̸��� �޼ҵ�
	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		// ���� �ε����� �� �ε������� ���� ���ȸ�, �� �迭�� ũ�Ⱑ 1�� �ƴ� ���ȸ�!!
		if (start < end) {
			// �߰��� ����ؼ�
			int mid = (start + end) / 2;
			// �ڸ� ����� ��, �� ����� ���ȣ��!
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid+1, end);
			// ���ȣ���� ���� ���̵��� ���ʴ�� �պ� ������ ��ĥ ����.
			merge(arr, tmp, start, mid, end);
		}
	}
	// ���� ����� �ݺ������� �����ϴ� �迭�� ������? , �ӽ��������, ������ġ, �߰���ġ, ����ġ
	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		// ������ �� ���� �迭�� ���� �ӽ� �迭�� �ϳ��� ��ħ.
		for (int i=start; i<=end; i++) {
			tmp[i]= arr[i];
		}
		// ������ �����ε���
		int part1 = start;
		// ������ �����ε���
		int part2 = mid+1;
		// ������� index�� ����������!
		int index = start;
		while (part1 <= mid && part2 <= end) {
			// ������ ũ��, �ε����� ��ġ�� ����(������)���� ä���	
			if (tmp[part1] <= tmp[part2]) {	//�������� :  if (tmp[part1] >= tmp[part2]) { 
				arr[index] = tmp[part1];
				// �������� �ִ� �迭�� ���� ���� ��
				part1++;
			// �ݴ��� ���
			}else {
				arr[index] = tmp[part2];
				part2++;
			}
			// �׸���, �� ������ �����ؾ���.
			index++;
		}
		// �ӽ� �迭����, ���� �迭�� ���� �����ִ� ��� �ڿ� �����־�� �Ѵ�.
		for (int i=0; i <= mid - part1; i++) {
			arr[index +i] = tmp[part1 += i];
		}
	}
	//=========================mergeSort ��==========================
	
	
	//=========================quickSort ����==========================
	private static void quickSort(int[] arr) {
		// ����Լ� ����
		quickSort(arr, 0, arr.length-1);
		// ���
		printing(arr);
	}
	// ����Լ� -> �迭�� ������, ������ �޾ƿ�
	private static void quickSort(int[] arr, int start, int end) {
		// ���� �迭�� �������� return ����.
		int part2 = partition(arr, start, end);
		// ������ �������� ������ ������ �ٷ� ��   �� �Ǳ� ������ (��, ũ�Ⱑ 1�� �� ������)
		if (start < part2-1) {
			// ������ �迭�� ���ȣ��
			quickSort(arr, start, part2-1);
		}
		// ������ �������� �������� �ٷ� ��    �� �Ǳ� ������ (��, ũ�Ⱑ 1�� �� ������)
		if (part2 < end) {
			// ������ �迭�� ���ȣ��
			quickSort(arr, part2, end);
		}
	}
	private static int partition(int[] arr, int start, int end) {
		// pivot�� ���������� �迭 �߰������� ������.
		int pivot = arr[(start + end) / 2];
		// �������� �������� �۰ų� ������쿡��(�������� �Ⱦ���� ���� ���� ������ �� ����)
		while (start <= end) {
			// pivot ������ ���� pivot���� ������ pass, ũ�� stop    
			while (arr[start] < pivot) start++;		//�������� : while (arr[start] > pivot) start++;
			// pivot ������ ���� pivot���� ũ�� pass, ������ stop    
			while (arr[end] > pivot) end--;		//�������� : while (arr[end] < pivot) end--;
			// pivot ������ �ε�����, ������ �ε����� �����ų� ����ġ�� ���� ��쿡��
			if (start <= end) {
				// �� ���� �ٲ��ְ�
				swap (arr, start, end);
				// �� ĭ�� �� �̵����Ѽ�, �ݺ�
				start++;
				end--;
			}
		}
		// ������ ����Ǹ�, ���� ���� ������ �迭�� ù���� �ε��� ���� ��ȯ (pivot+1)
		return start;
	}
	
//	==============================quickSort ��=======================
	
	// �迭�� �� �ε����� �ٲٴ� �޼ҵ�
	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	// ��� �޼ҵ�
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
