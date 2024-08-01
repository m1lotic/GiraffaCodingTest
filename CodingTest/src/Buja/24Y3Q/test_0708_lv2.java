package Buja; // syntax error
public class test_0708_lv2 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 멀쩡한 사각형
	/* 해결일 : 7월 14일 19시 00분
	   문제점 : 처음에는 가로 세로 한번에 해결하려고 했는데
	           되지 않았다.
	           따라서, 나눠서 계산을 했다.
	           double 위치에 따라 나눠지는값이 달라져서
	           오답 처리가 된 부분도 있었다
	           조심해서 처리해야겠다.
	*/
	class Solution {
	    public long solution(int w, int h) {
	        double x = 0;
	        double y = 0;
	        long use_Square = 0;
	        
	        
	        // 가로 기준
	        for(int i=1; i<w;i++){
	           x = (double)i*h/w;
	            use_Square += (long)x;
	        }
	        
	        // 세로 기준
	        for(int i=1; i<h;i++){
	           y = (double)i*w/h;
	            use_Square += (long)y;

	        }
	        
	      //  System.out.println(use_Square);
	        
	        return use_Square;
	    }
	}