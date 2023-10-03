package Buja; // syntax error
public class test_1002 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	

    // 카펫
	/* 해결일 : 10월 3일 오후 7시 51분
	   문제점 : 사실 이 문제는 가장자리를 구하는 공식을 활용해서 찾으면
	           좀 더 라인 수가 줄어들 것 같다(수학적인 문제임)
	           맞는 거 같은데 왜 안되나 생각하는데, 아마 테스트용 케이스를 내가 하나 만든게있는데
	           그게 잘못이 되서 틀렸던것이 아닌가 하는 생각이 든다.
	           테스트케이스를 제대로 만들자.
	           처음에도 테스트 케이스 잘못 만들어서(가로 세로 착각해서)
	           제대로 된 풀이였는데 갈아엎었던 건 아닌 지 하는 생각이 든다.
	           (처음엔 최대공약수로 값을 구하려고 했는데 내가 만든 테스트 케이스에서만 오류났음)
	           */

	class Solution {
	    public int[] solution(int brown, int yellow) {
	        int[] answer = new int[2];
	        int sum = 0;
	        
	        for(int i = 1; i<=(brown+yellow)/2;i++)
	        {
	            if(yellow%i ==0)
	            {
	                // yellow/i는 가로길이 i는 세로길이
	                sum = (yellow/i) * 2  + (i+2)*2;
	                if(sum == brown){

	                    // 가로가 긴 경우
	                    if(((yellow)/i) >= i){
	                     // 가장자리 크기 찾는 공식대로 값 계산
	                    answer[1] = i+2;
	                    answer[0] = (brown+yellow)/answer[1];
	                         System.out.println("1번"+sum+" "+ i);
	                    }
	                    else{
	                    answer[0] = i+2;
	                    answer[1] = (brown+yellow)/answer[0];
	                  System.out.println("2번"+sum+" "+ i);
	                    }
	                }
	            }

	        }
	        
	        return answer;
	    }
	}