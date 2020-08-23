 package EngineerInKorea;
/*
 * Knuth-Morris-Pratt 알고리즘
 * prfix, suffix
 * lps : longest proper prefix which is also suffix
 */
public class KMP {
	public static void main(String[] args) {
		String target = "ABABABABBABABABABC";
//		String target1 = "ABABABABBABABABABCCABABABABC";
		String pattern = "ABABABABC";
//		String target = "this is the test";
//		String pattern = "test";
		char[] targetArray = target.toCharArray();
		char[] patternArray = pattern.toCharArray();
		int[] lps = calculate_lps(patternArray);
		for (int i : lps) {   
			System.out.print(i + " ");
		}
		System.out.println();
		KMP(targetArray, patternArray, lps);
	}

	private static void KMP(char[] targetArray, char[] patternArray, int[] lps) {
		int j = 0;
		for (int i = 0; i <targetArray.length; i++) {
			while (j > 0 && targetArray[i] != patternArray[j]) {
				j = lps[j-1];
			}
			if (targetArray[i] == patternArray[j]) {
				if (j == (patternArray.length - 1)) {
					System.out.println("Found matching at " + (i - patternArray.length + 1));
					j = lps[j];
				} else {
					j++;
				}
			}
		}		
	}

	private static int[] calculate_lps(char[] pattern) {
		int[] lps = new int[pattern.length];
		int j = 0;
		for (int i = 1 ; i < pattern.length; i++) {
			while(j > 0 && pattern[i] != pattern[j]) {
				j = lps[j-1];
			}
			if (pattern[i] == pattern[j]) {
				lps[i] = ++j;
			}
		}
		return lps;
	}

}
