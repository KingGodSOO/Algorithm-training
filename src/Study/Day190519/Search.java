package Study.Day190519;

public class Search {
	// 배열과, 찾으려는 key값을 인자로 받음
	public static int binarySearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length -1;
		int mid;
		
		while (low <= high) {
			mid = (low + high)/2;
			// key가 중간보다 큰 경우
			if (key > arr[mid]) {
				low = mid+1;
			}
			// key가 중간보다 작은 경우
			else if (key < arr[mid]) {
				high = mid-1;
			}
			// key라면, stop
			else {
				return mid;	// 인덱스의 위치 반환
			}
		}
		return -1; // key가 없음!
	}
	public static void main(String[] args) {
		int[] test = {4,5,6,7,8,9,10,11,12};
		System.out.println(binarySearch(test, 10));
	}

}
