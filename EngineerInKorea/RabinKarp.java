package EngineerInKorea;

import java.util.ArrayList;
import java.util.List;
/* 라빈 카프(Rabin-Karp)알고리즘은 문자열 매칭 알고리즘 (항상 빠르지는 않지만 일반적인 경우 빠르게 작동하는 간단한 구조의 무자열 매칭 알고리즘)
 * Hash 기법을 사용 : 해시 값이 중복되는 경우 발생 할 수 있음. 이것을 충돌(Collision)이라고 하는데 확률은 낮음.
 * O(n)
 * 긴 글 해시 값 = 2 * (긴 글 해시값 - 가장 앞에 있는 무자의 수치) - 새롭게 들어온 문자의 수치
 */
public class RabinKarp {
	public static void main(String[] args) {
		String parent = "ABABABABBABABABABC";
		String pattern = "ABABABABC";
		RabinKarp(parent, pattern);
	}

	private static void RabinKarp(String parent, String pattern) {
		double parentHash = 0;
		double patternHash = 0;
		double power = 1;
		
		for (int i = 0; i <= parent.length() - pattern.length() ; i++) { //  1. parent.length() - pattern.length() 계산 이유?
			if (i == 0) {
				for (int j =0; j < pattern.length();j++) {
					parentHash += parent.charAt(pattern.length() -1 -j) * power;
					patternHash += pattern.charAt(pattern.length() -1 -j) * power;
					if (j < pattern.length() - 1) {
						power *= 2;
					}
				}
			} else { // 2.  power 연산 shift 연산 : 1 << 3; // 1을 좌측으로 3번 시프트 즉 0001에서 1000으로 됨.
				parentHash = 2 * (parentHash - (parent.charAt(i - 1) * power)) + parent.charAt(pattern.length() -1 + i);
			}
			if (parentHash == patternHash) {
				boolean finded = true;
				for (int j = 0; j < pattern.length(); j++) {
					if (parent.charAt(i+j) != pattern.charAt(j)) {
						finded = false;
						break;
					}
				}
				if (finded) {
					System.out.print("%d번째에서 발견 했습니다." + (i));
				}
			}
		}
	}
}
