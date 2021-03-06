package EngineerInKorea;

/**
 * O(n log n)
 * worst case에서도 n long n
 * 
 * watch?v=QAyl79dCO_k&t=269s
 *
 */
public class Sort_MergeSort {
	private static void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length - 1);
	}
	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid + 1, end);
			merge(arr, tmp, start, mid, end);
		}
	}
	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		for (int i = start ; i <= end; i++) {
			tmp[i] = arr[i];
		}
		int part1 = start;
		int part2 = mid + 1;
		int index = start;
		while (part1 <= mid && part2 <= end) {
			if (tmp[part1] <= tmp[part2]) {
				arr[index] = tmp[part1];
				part1++;
			} else {
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
		}
		// 앞쪽 배열만 넣어주면 됨. 200929 Why?
		// 201006 
		// 1) 앞쪽 배열(arr[start] ~ arr[mid])이 남아 있는 경우
		//    앞쪽 배열에 남은 만큼(mid - part1) 돌면서 최종값에 남은 값들을 붙여줌
		// 2) 뒤쪽 배열이 남을 경우
		//    뒤쪽 배열은 최종 배열에 이미 자리 잡고 있기 때문에 그냥 나둬도 된다.
		for (int i = 0; i <= mid - part1; i++) {
			arr[index + i] = tmp[part1 + i];
		}
	}
	
	private static void printArray(int[] arr) {
		for (int data : arr) {
			System.out.print(data);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		printArray(arr);
		mergeSort(arr);
		printArray(arr);
	}
}
