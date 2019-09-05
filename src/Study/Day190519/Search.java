package Study.Day190519;

public class Search {
	// �迭��, ã������ key���� ���ڷ� ����
	public static int binarySearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length -1;
		int mid;
		
		while (low <= high) {
			mid = (low + high)/2;
			// key�� �߰����� ū ���
			if (key > arr[mid]) {
				low = mid+1;
			}
			// key�� �߰����� ���� ���
			else if (key < arr[mid]) {
				high = mid-1;
			}
			// key���, stop
			else {
				return mid;	// �ε����� ��ġ ��ȯ
			}
		}
		return -1; // key�� ����!
	}
	public static void main(String[] args) {
		int[] test = {4,5,6,7,8,9,10,11,12};
		System.out.println(binarySearch(test, 10));
	}

}
