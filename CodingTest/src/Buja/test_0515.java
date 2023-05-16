package Buja; // syntax error
public class test_0515 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 삼총사

	/* 해결일 : 5월 16일
	   문제점 : for-each 문을 사용하기 위해서 계속 시도했으나 실패했다.
	           for-each 문에는 큰 특징이 있는데,
	           일단 type과 변수명이 필요하고, for를 iteration해주는
	           scope 밖에서 쓸 수가 없는 변수라 실패 한 것이다.
	           그리고 다음부터는 number.length보다는 
	           int length= number.length 같이 처리를 해서
	           하드 코딩으로 박아넣는 행위를 좀 자제 해야 할 듯 하다.(수정의 어려움)
	

	class Solution {
	    public int solution(int[] number) {
	        int answer = 0;
	        int sum= 123; // 임의숫자임
	        // 초기선언
	        int i=0; 
	        int j=1; 
	        int z=2; 
	        
	        // (a, b, c)
	        for(;i<number.length;i++)
	        {
	            for(;j<number.length;j++)
	            {
	                for(;z<number.length;z++)
	                {
	                    // 합계를 계산하는 코드
	                    sum = number[i]+number[j]+number[z];
	                    if(sum==0) answer +=1;
	                }
	                   z=(j+2);
	            
	                        }
	            j=(i+1);
	        }
	          return answer;
	    }
	}
*/
	
	