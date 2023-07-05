package Buja; // syntax error
public class test_0703 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	/* 해결일 : 7월 5일
	   문제점 : 해결하는데 5분 걸렸다.
	           이 문제는 코딩보다는 수학 문제이다.
	           거리가 K만큼 떨어지는 경우의 수에는 여러 케이스가 있다.
	           그 경우의 수를 1부터 다 구할 수는 없다
	           결국 n 값에서 역순으로 구하는 방법 뿐이다
	           어차피 순간이동은 건전지가 들지 않으니..
	           
	           코드를 보면 특이하게 ans=1; 로 되어있다.
	           처음 위치가 0이지만 1부터 시작해야 문제가 유효하니
	           결국 1번 이동은 무조건 해야 하기 때문이다.
	           
	           그 외에는, 홀수일 경우(점프가 필요한 경우) 짝수로 나눠서
	           순간이동(2배씩 커짐) 할 수 있도록 조치했다.
	           그리고 정답을 출력했고
	           모든 테스트 케이스에서 약 0.02ms라는 우수한 처리 속도가 나왔다.
	

import java.util.*;

public class Solution {
	public int solution(int n) {
		int ans = 1;

		while (n > 1) {
			if (n % 2 == 1) {
				n -= 1;
				ans += 1;
			}
			n /= 2;
			// System.out.println("현재 n값 : "+ n );
		}

		return ans;
	}
}*/