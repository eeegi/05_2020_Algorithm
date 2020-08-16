package EngeerInKorea;
/*
 * 주어진 문자열의 공백을 %20으로 변환하는 함수를 구현하시오.
 * 문자열의 맨끝에는 변환에 필요한 충분한 공백이 있고,
 * 실제 문자열의 사이즈를 알고 있음
 * Input string : "Mr John Smith"
 * Output string : "MR%20John%20Smith"
 * 
 * 뒤부터 이동하면서 순차적으로 채워주고
 * 빈칸에서는 이동하지 않고, %20을 채우고 나서 이동한다
 */
public class String_InsertString {
	
	private static String URLify(String str, int len) {
		return URLify(str.toCharArray(), len);
	}
	private static String URLify(char[] arr, int len) {
		int spaceNum = 0;
		// 1.char 의 공백 체크 못함.
		// c가 공백일때 " ".equals(c)로 체크 안됨
		// ==> char의 경우에는 String 즉 객체가 아니므로 문자열 비교 하면 안됨. char는 숫자로 매핑됨 (ASCII 등)
		/*for (char c : arr) {
			if (" ".equals(c)) { // check 안됨. 무조건 not equal
				spaceNum++;
			}
		}*/
		
		// 2. index -2씩 감소됨. 
		// if 조건문 체크 시 -1,  else 루틴에서 다시 -1
		/* if 조건문에서 (arr[arrIndex--]) 말고, 조건 true일경우에만, arrIndex--
		 * 	
 		if(' ' == (arr[arrIndex--])) {
				output[j--] = '0';
				output[j--] = '2';
				output[j] = '%';
				arrIndex--;
			} else {
				output[j] = arr[arrIndex--];
			}
		 */
		
		// 3 for 문을 output array에서가 아닌 arr에서의 for문으로
		// 결과 동일 하고 for문 횟수 줄어듬
		/*
		 * 	int outputIndex = len + spaceNum * 2 - 1;
		    for (int i = arr.length -1; i >=0 ; i--) {
			if(' ' == arr[i]) {
				output[outputIndex--] = '0';
				output[outputIndex--] = '2';
				output[outputIndex--] = '%';
			} else {
				output[outputIndex--] = arr[i];
			}
		}
		 */
		for (char ch : arr) {
			if (' ' == ch) {
				spaceNum++;
			}
		}
		char[] output = new char[len + spaceNum * 2];
		int arrIndex = len - 1;
		for (int j = len + spaceNum * 2 - 1; j >= 0; j--) {
			if(' ' == (arr[arrIndex])) {
				output[j--] = '0';
				output[j--] = '2';
				output[j] = '%';
				arrIndex--;
			} else {
				output[j] = arr[arrIndex--];
			}
		}
		
		return new String(output);
	}
	public static void main(String[] args) {
		String input = "Mr John Smith";
		System.out.println(URLify(input, 13));
	}
}
