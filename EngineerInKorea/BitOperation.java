package EngineerInKorea;
/*
 * Integer 32bit = 4 byte : -2^31 < x < 2^31 -1  : 양의수는 0 퐘
 * 음의 수 -1은 1111 즉 sign bit 1이고 나머지도 다 1 
 *      -8은 1000
 *      
 * OR연산 둘중 하나만 1이면 1
 *    1) 0과 AND 연산 : 자기 자신
 *    2) 1과 AND 연산 : 1
 *    3) 자기 자신과 AND 연산 : 자기 자신 
 * AND연산 둘다 1일 경우에만 1
 *    1) 0과 AND 연산 : 모두 0
 *    2) 1과 AND 연산 : 자기 자신
 *    3) 자기 자신과 AND 연산 : 자기 자신
 * XOR 연산 두개의 값이 다르면 1 : 
 *    1) 0과 XOR 연산 : X(자기 자신)
 *    2) 1과 XOR 연산 : ~X (원래 값의 반대 값)
 *    3) 자기 자신과 XOR 연산 : 0 (다른 값이 없으니까) 
 * Shift << 왼쪽 , >> 오른쪽
 *    1) >>> (logical right shift) : Sign bit 무시하고 무조건 shift
 *    2) >> (arithmetic right shift) : Sign bit 무시 하지 않고 shift
 */

public class BitOperation {
	/* 
	 * 임의의 숫자 num에서 i번째 bit 확인 하는 방법
	 */
	static boolean getBit (int num, int i) {
		return (num & (1 << i)) != 0;
	}
	/*
	 * 임의의 숫자 num에서 i번째 bit를 1로 set 
	 */
	static int setBit(int num, int i) {
		return num | (1<<i);
	}
	
	public static void main(String[] args) {
		System.out.println(getBit(9,3));
		System.out.println(getBit(5,3));
	}
}
