package Study.Day190519;

import java.util.Scanner;
import java.util.StringTokenizer;

// �ð��ʰ��� Ż��

//�ð� ����	�޸� ����	����	����	���� ���	���� ����
//1 ��	256 MB	5990	3888	3183	67.436%

//2���� ��� ���� �� N���� �־�����. ��ǥ�� y��ǥ�� �����ϴ� ������, y��ǥ�� ������ x��ǥ�� �����ϴ� ������ ������ ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

public class BOK_11651 {

	// 2���� �迭�� �� ���� �Է¹޾�, ������ ���� ������ִ� �޼ҵ�
	public static void q11651(int[][] tdarr, int range) {
		// ��������
		int size = range -1;
		int tmp;
		while (size > 0) {
			for (int i =0; i< size; i++) {
				// y���� ���ؼ�, ����
				if (tdarr[i][1]>tdarr[i+1][1]) {
					tmp = tdarr[i][1];
					tdarr[i][1] = tdarr[i+1][1];
					tdarr[i+1][1] = tmp;
					// y���� ������ ��, x���� ���󰡾� �Ѵ�.
					tmp = tdarr[i][0];
					tdarr[i][0] = tdarr[i+1][0];
					tdarr[i+1][0] = tmp;
				}
				// y���� �����ϸ� x������ ����
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
		// �Է¹��� ������ x��ǥ�� y��ǥ�� �и��� StringTokenizer ��ü ����
		StringTokenizer stok;
		// ù �� �Է�
		Scanner s = new Scanner(System.in);
		int num = Integer.parseInt(s.nextLine());
		// �޼ҵ忡 ���� ���� ����
		int range = num;
		// x, y ��ǥ�� ���� 2���� �迭 ����
		int[][] tdarr = new int[num][2];
		// �迭�� 1����� ���ʷ� ������ �ֱ����� i ����
		int i = 0;
		// ù ���� �� ��ŭ �ݺ��ؼ�, 2���� �迭�� �Է¹޴´�.
		while (num > 0) {
			String input = s.nextLine();
			// �������� �ڸ��� ����� �𸣰ڴ�.
			stok = new StringTokenizer(input, " ");
			tdarr[i][0] = Integer.parseInt((stok.nextToken()));
			tdarr[i][1] = Integer.parseInt(stok.nextToken());
			num--;
			i++;
		}
		// ���� ����� ���
		q11651(tdarr, range);

	}

}
