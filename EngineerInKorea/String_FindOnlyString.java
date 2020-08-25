package EngineerInKorea;

import java.util.HashMap;

public class String_FindOnlyString {
	public static void main(String[] args) {
		System.out.println(isUnique("abcdefgghjkk"));
		System.out.println(isUnique("abcdefghijk"));
		System.out.println(isUniqueUnicode("abcdefgghjkk"));
		System.out.println(isUniqueUnicode("abcdefghijk"));
		System.out.println(isUniqueByBitOperator("abcdefgghjkk"));
		System.out.println(isUniqueByBitOperator("abcdefghijk"));
	}
	
	/*
	 * 문자열이 ASCII 일때
	 * ASCII - 128
	 * Extended ASCII - 256
	 * Unicode - 2^20 + 2^16 = 1,114,112
	 */
	private static boolean isUnique(String str) {
		if (str.length() > 128) return false;
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	/*
	 * 문자열이 Unicode 일때
	 * Unicode - 2^20 + 2^16 = 1,114,112
	 */
	private static boolean isUniqueUnicode(String str) {
		HashMap<Integer, Boolean> hashmap = new HashMap<Integer, Boolean>();
		for (int i = 0; i < str.length(); i++) {
			int c = str.charAt(i);
			if (hashmap.containsKey(c)) {
				return false;
			}
			hashmap.put(c, true);
		}
		return true;
	}
	
	/*
	 * 문자열이 소문자고 별도의 배열을 사용 없을 경우 : a-z : 26개
	 * shift 연산 : 1<<3; // 1을 3자리 왼쪽으로 즉, 8
	 * 정수의 최대값 : 2^31
	 * a - z (97 - 122) 이므로, 
	 * 0 부터 shift 값을 비교 하기 위하여(0-25)로 만들기 위해 - 'a'한다
	 * 
	 * 개념 : 
	 * Bit operator : 2의 거듭 제곱으로 설정 1, 2,4,8,16
	 * (1,2,3,4,5등으로 가면 4가 1과3의 합인지 순수한 4인지 알 수 없음)
	 */
	private static boolean isUniqueByBitOperator(String str) {
		int checker = 0;
		for (int i = 0; i <str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
}
