package Study.Day190519;

//�ð� ����	�޸� ����	����	����	���� ���	���� ����
//2 ��	128 MB	33840	8938	5894	27.579%
// N���� ���� A[1], A[2], ��, A[N]�� �־��� ���� ��, �� �ȿ� X��� ������ �����ϴ��� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOK_1920 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// n : �˻������ �������� ���� nArr : �˻������ ������ m : �� �˻��� ������ ���� mArr : �˻��� ������
		int n = Integer.parseInt(s.nextLine());
		String ns = s.nextLine();
		int m = Integer.parseInt(s.nextLine());
		String ms = s.nextLine();
		// �Է¹��� ���� �迭ȭ
		int[] nArr = strToArr(ns, n);
		int[] mArr = strToArr(ms, m);
		// ����
		quickSort(nArr);
		// Ž��
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
			// key�� �߰����� ū ���
			if (key > inputArr[mid]) {
				low = mid + 1;
			}
			// key�� �߰����� ���� ���
			else if (key < inputArr[mid]) {
				high = mid - 1;
			}
			// key���, stop
			else {
				// ���� ��, 1 ���
				System.out.println(1);
				return;
			}
		}
		System.out.println(0); // key�� ����!
		return;
	}

	// ���� �޼ҵ� -> ����Ʈ
	private static void quickSort(int[] arr) {
		// ����Լ� ����
		quickSort(arr, 0, arr.length - 1);
	}

	// ����Լ� -> �迭�� ������, ������ �޾ƿ�
	private static void quickSort(int[] arr, int start, int end) {
		// ���� �迭�� �������� return ����.
		int part2 = partition(arr, start, end);
		// ������ �������� ������ ������ �ٷ� �� �� �Ǳ� ������ (��, ũ�Ⱑ 1�� �� ������)
		if (start < part2 - 1) {
			// ������ �迭�� ���ȣ��
			quickSort(arr, start, part2 - 1);
		}
		// ������ �������� �������� �ٷ� �� �� �Ǳ� ������ (��, ũ�Ⱑ 1�� �� ������)
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
			while (arr[start] < pivot)
				start++;
			// pivot ������ ���� pivot���� ������ pass, ũ�� stop
			while (arr[end] > pivot)
				end--;
			// pivot ������ �ε�����, ������ �ε����� �����ų� ����ġ�� ���� ��쿡��
			if (start <= end) {
				// �� ���� �ٲ��ְ�
				swap(arr, start, end);
				// �� ĭ�� �� �̵����Ѽ�, �ݺ�
				start++;
				end--;
			}
		}
		// ������ ����Ǹ�, ���� ���� ������ �迭�� ù���� �ε��� ���� ��ȯ (pivot+1)
		return start;
	}

	// �迭�� �� �ε��� ��ġ�� �ٲٴ� �޼ҵ�
	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	// ���ڿ��� �� ũ�⸦ ������ ���ڷ� �ɰ� �迭�� ��� �޼ҵ�
	private static int[] strToArr(String str, int n) {
		StringTokenizer stok = new StringTokenizer(str, " ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt((stok.nextToken()));
		}
		return arr;
	}

}