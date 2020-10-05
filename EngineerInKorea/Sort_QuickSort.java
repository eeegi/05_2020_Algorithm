package EngineerInKorea;
/**
 * O(n log n)
 * 파티션을 계속 반으로 나누고
 * 다음번에는 다시 이를 반으로 나누고
 * 
 * 1. pivot(기준값)을 정한다 (기준값이 중간값이면 좋다)
 *  기준값이 최소나 최대일 경우 worst로 O(n^2)
 * 2. 기준값으로 S(start)로 시작하여 기준값보다 크거나 같으면 멈춤
 *  E(end)는 점차 작은 값으로 기준값보다 작거나 같으면 멈춤
 *  S and E이 교체 
 * 3. S와 E가 정한 범위내가 아닐 때 종료. 
 *   이때 현재 S가 가르키고 있는 배열방이 두번재 파티션의 첫번째 배열방의 index이다.
 *   
 * watch?v=7BDzle2n47c
 */
public class Sort_QuickSort {
	
	private static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	private static void quickSort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end); // partition의 리턴값이 오른쪽방 첫번째 값이다.
		if (start < part2 - 1) { // 오른쪽 첫번째 방이 start보다 1개 이상 차이가 날 때
			quickSort(arr, start, part2 - 1);
		}
		if (part2 < end) { // 오른쪽 첫번째 방이 1개 이상일 때 여기서 end는 array.lenght -1 
			quickSort(arr, part2, end);
		}
	}
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) / 2];
		while(start <= end) {
			while (arr[start] < pivot) { // 배열방이 pivot보다 크거나 같으면 멈춤
				start++;
			}
			while (arr[end] > pivot) { // 배열방이 pivot보다 작거나 같으면 멈춤
				end--;
			}
			if (start <= end) { // S와 E가 만나서 지났는지 확인 후 
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return start; //오른쪽 첫번째 방의 값
	}
	
	private static void swap(int[]arr, int start, int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}
	private static void printArray(int[] arr) {
		for (int data : arr) {
			System.out.print(data + ", ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
		printArray(arr);
		quickSort(arr);
		printArray(arr);
	}
}
