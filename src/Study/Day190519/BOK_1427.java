package Study.Day190519;

//�ð� ����	�޸� ����	����	����	���� ���	���� ����
//2 ��	128 MB	14117	8270	7246	59.964%
// ����
// �迭�� �����ϴ� ���� ����. ���� �־�����, �� ���� �� �ڸ����� ������������ �����غ���.
// �Է�
// ù° �ٿ� �����ϰ����ϴ� �� N�� �־�����. N�� 1,000,000,000���� �۰ų� ���� �ڿ����̴�.
// ���
// ù° �ٿ� �ڸ����� ������������ ������ ���� ����Ѵ�.

import java.util.Scanner;

public class BOK_1427 {
	
	
	private static void quickSort(int input) {
		// �迭ȭ �Լ��� �迭ȭ��Ŵ.
		int[] arr = numbToArr(input);
		// ����Լ� ����
		quickSort(arr, 0, arr.length-1);
		// ���������� ���
		for (int data : arr) {
			System.out.print(data);
		}
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
			// pivot ������ ���� pivot���� ũ�� pass, ������ stop
			while (arr[start] > pivot) start++;
			// pivot ������ ���� pivot���� ������ pass, ũ�� stop
			while (arr[end] < pivot) end--;
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
	
	// �ڿ����� �޾Ƽ� �迭�� ��ȯ��Ű�� �޼ҵ�
	private static int[] numbToArr(int input) {
		// �������� ���̸� üũ
		int length = (int) (Math.log10(input) + 1);
		// ���ڸ� ���� �迭�� ����
		int[] arr = new int[length];
		// 1.�Է¹��� ���ڸ� �ڸ������ �ɰ��� �迭�� ����(�� �� ���ڰ� �ݴ�� ��)
		for (int i = 0; i < length; i++) {
			arr[i] = input % 10;
			input = input/10;
		}
		return arr;
	}
	
	// �迭�� �� �ε��� ��ġ�� �ٲٴ� �޼ҵ�
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
