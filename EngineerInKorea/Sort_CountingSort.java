package EngineerInKorea;

public class Sort_CountingSort {
	/**
	 * '범위 조건'이 있는 경우 빠른 알고리즘 O(n)
	 *  정렬할 데이타의 범위가 매우 크면 사용 할 수 없다. 
	 */

	public static void main(String[] args) {
		int array[] = {
				1,3,2,4,3,2,5,3,1,2,
				3,4,4,3,5,1,2,3,5,2,
				3,1,4,3,5,1,2,1,1,1
		};
		int[] count = new int[5];
		int temp = 0;
		// initial
		for (int i = 0; i < 5 ; i++) {
			count[i] = 0;
		}
		// Count
		for (int i = 0; i < array.length ; i++) {
//			count[array[i] -1] = array[i] + 1; // Error
			count[array[i] -1] = count[array[i] -1] + 1; // array는 1부터 시작 vs count는 0부터 시작
//			count[array[i] -1]++; //같은 결과
		}
		// Print
		for (int i = 0 ; i < 5; i++) {
			if (count[i] > 0) {
				for (int j = 0; j < count[i]; j++) {
					System.out.print(i+1);
				}
			}
		}
	}
}
