package Study.Day190526;

public class RockPaperScissors_BitMask {

	public static void main(String[] args) {
		// 비트를 두 칸씩 나누어, 한 명의 사람에게 배정.
		int n = 6;
		int num = 1;
		num <<= n;
		for (int i = 0; i < num; i++) {
			int bit = i;
			String view = "";
			boolean check = true;
			// 3명의 사람이므로, 3 번 반복, bit는 2 칸씩 이동하며 확인한다.
			for (int j = 0; j < 3; j++, bit >>= 2) {
				// bit를 3(2진법으로 1 1) 과 비교
				int x = ((bit & 3));
				if (x == 3) {
					view += "보 ";
				} else if (x == 2) {
					view += "바위 ";
				} else if (x == 1) {
					view += "가위 ";
				} else { // x == 0인 경우를 포함하는 결과는 출력하지 않도록 한다.
							// 이 경우 출력하지 않는다.
					check = false;
					continue;
				}
			}
			// x==0이 포함되지 않은 경우에만 출력
			if (check) {
				System.out.println(view);
			}
		}
	}

}
