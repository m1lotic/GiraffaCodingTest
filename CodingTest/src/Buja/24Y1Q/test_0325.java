package Buja; // syntax error
public class test_0318 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 카펫(재 풀이)
	/* 해결일 : 3월 31일 20시 22분
	   문제점 : 지난번에 테스트케이스 잘못짜서 헷갈렸다는 거 있었는데,
	   		  이번에도 그 이슈가 있었다.
	   		  결국 공식 만들어서,
	   		  사전에 계산해 둔
	   		  xy = x+y 인 시점을 찾아보았다.
	   		  (y를 3부터 시작해서 올려가면서)
	*/ 



	class Solution {
	    public int[] solution(int brown, int yellow) {
	        int[] answer = new int[2];
	  
	        // (공식)  =>  yellow = xy(가로*세로) - brown
	        // brown / 2 +2 = x+y
	        // yellow + brown = xy
	        
	        int xAddY = (brown / 2) + 2;
	        int xMultyY = yellow + brown;
	        
	        int x = 0;
	        int y = 0;
	        
	        // *** (x>2, y>2), x,y는 자연수
	        
	        for(y= 3; y <= xAddY / 2 ;y++){
	            x = xAddY - y;
	            
	            
	            if((x*y) == xMultyY){
	               answer[0] = x;
	               answer[1] = y;
	                break;
	            }
	        }
	        
	        
	        return answer;
	    }
	}
