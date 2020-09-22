package EngineerInKorea;

public class Sort_BubbleSort {
	
	/*
	 * O(n^2)
	 */
	private static void bubbleSort(int[] arr) {
		bubbleSort(arr, arr.length -1);
	}
	
	private static void bubbleSort(int[] arr, int last) {
		if (last > 0) {
			for (int i = 1;i <= last; i++) {
				if (arr[i-1] > arr[i]) {
					swap(arr, i-1, i);
				}
			}
			/* 마지막 배열까지 비교 하려면, 
			 * 1부터 시작 하고, 마지막 배열 - 1 까지 순환
			 * for문 안에 -1 값이 있으므로, ArrayIndexOutOfBounds 피할 수 있음
			 * for (int i = 0; i < last; i++) {
				if (arr[i] > arr[i+1]) {
					swap(arr, i-1, i);
				}
			}
			 */
			bubbleSort(arr, last -1);
		}
	}
	
	private static void swap(int[] arr, int source, int target) {
		int tmp = arr[source];
		arr[source] = arr[target];
		arr[target] = tmp;
	}
	private static void printArray(int[] arr) {
		for (int data : arr) {
			System.out.print(data + ", ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = {3, 5, 4, 2, 1};
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
	}
}
