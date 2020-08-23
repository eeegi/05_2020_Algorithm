package EngineerInKorea;

/*
 * You have isSubString() which checks if one word is a substring of another
 * Given two strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubString()
 */
public class String_findRotationString {
	/*
	 * 회전 문자열인지를 알아내는 방법 : 문자열을 한번더 더해서 원본 문자열이 포함되어 있는지 확인
	 * 원본 string
	 * 문자열 ingstr
	 * 확인 : ingstr + ingstr = intstringstr 
	 */
	private static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length()) { // 두개의 문자열의 갯수가 다르면 false
			return false;
		}
		return isSubString(s1 + s1, s2);
	}
	
	private static boolean isSubString(String s1, String s2) {
		return s1.contains(s2);
	}
	public static void main(String[] args) {
		System.out.println(isRotation("string", "ringst"));
		System.out.println(isRotation("string", "ingstr"));
		System.out.println(isRotation("string", "ingstn"));
		System.out.println(isRotation("string", "ringstr"));
	}
}
