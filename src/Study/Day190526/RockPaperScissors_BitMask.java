package Study.Day190526;

public class RockPaperScissors_BitMask {

	public static void main(String[] args) {
		// ��Ʈ�� �� ĭ�� ������, �� ���� ������� ����.
		int n = 6;
		int num = 1;
		num <<= n;
		for (int i = 0; i < num; i++) {
			int bit = i;
			String view = "";
			boolean check = true;
			// 3���� ����̹Ƿ�, 3 �� �ݺ�, bit�� 2 ĭ�� �̵��ϸ� Ȯ���Ѵ�.
			for (int j = 0; j < 3; j++, bit >>= 2) {
				// bit�� 3(2�������� 1 1) �� ��
				int x = ((bit & 3));
				if (x == 3) {
					view += "�� ";
				} else if (x == 2) {
					view += "���� ";
				} else if (x == 1) {
					view += "���� ";
				} else { // x == 0�� ��츦 �����ϴ� ����� ������� �ʵ��� �Ѵ�.
							// �� ��� ������� �ʴ´�.
					check = false;
					continue;
				}
			}
			// x==0�� ���Ե��� ���� ��쿡�� ���
			if (check) {
				System.out.println(view);
			}
		}
	}

}
