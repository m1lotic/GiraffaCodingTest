package Buja; // syntax error

public class test_1 {

	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	public static void main(String[] args) {
		class Solution {
		    public int solution(int n) {
		        int answer = 0;
		        for(int i=1; i<=n;i++)
		        {
		            if(n%i==0)
		                answer +=i;
		        }
		        return answer;
		    }
		}
		
		
		

	}

}
