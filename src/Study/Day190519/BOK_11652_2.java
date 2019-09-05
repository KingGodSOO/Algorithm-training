package Study.Day190519;

//�ð� ����	�޸� ����	����	����	���� ���	���� ����
//1 ��	256 MB	5990	3888	3183	67.436%
//2���� ��� ���� �� N���� �־�����. ��ǥ�� y��ǥ�� �����ϴ� ������, y��ǥ�� ������ x��ǥ�� �����ϴ� ������ ������ ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOK_11652_2 {
	public static void main(String[] args) {
		// �Է¹��� ������ x��ǥ�� y��ǥ�� �и��� StringTokenizer ��ü ����
		// ù �� �Է�
		Scanner s = new Scanner(System.in);
		int num = Integer.parseInt(s.nextLine());
		
		// key������ 2����->1���� ��ҽ�Ų �迭�� �ְ�, value������ �Է¹��� ���ڿ��� �ִ´�.
		HashMap<Long, String> hm = new HashMap<Long, String>(num);
		// �����ϱ� ���� value�� �̷���� �迭�� ����.
		long[] keys = new long[num];
		
		for (int i=0; i<num; i++) {
			String Line = s.nextLine();
			long key = dimRed(Line);
			hm.put(key, Line);
			keys[i] = key;
		}
		
		// �迭�� ����
		quickSort(keys);
		// �迭�� ������� key������ ���
		for (long key : keys) {
			System.out.println(hm.get(key));
		}
	}
	
	// ����Ʈ �޼ҵ�
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
		// ������ ����Ǹ�, ���� ���� ������ �迭�� ù���� �ε��� ���� ��ȯ (pivot+1)
		return start;
	}
	
	// ��ġ �ٲٱ�
	private static void swap(long[] keys, int a, int b) {
		long tmp = keys[a];
		keys[a] = keys[b];
		keys[b] = tmp;
	}
	
	
	// �Է¹��� ������ 2�������� �ؼ��� ��, 1�������� ����ϴ� �޼ҵ�
	private static long dimRed(String str) {
		StringTokenizer stok = new StringTokenizer(str, " ");
		int x = Integer.parseInt(stok.nextToken());
		long y = Integer.parseInt(stok.nextToken());
		return y*1000000 + x;
	}
	
}
