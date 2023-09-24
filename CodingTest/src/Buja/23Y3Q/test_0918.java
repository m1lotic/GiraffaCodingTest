package Buja; // syntax error
public class test_0918 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 3진법 뒤집기
	/* 해결일 : 9월 24일 17시 29분
	   문제점 : 형변환을 어떻게 할것인가?
	            이 문제는 이렇게 형변환을 했다.
	            10진수 -> 3진수 : Long을 toString(값, 3진수로)
	            StringBuffer를 이용한 String 타입 뒤집기
	            3진수 -> 10진수 : rev의 string값 가져오고, 3진수임을 알림, 그리고 parselong으로 10진수 화
	*/ 


	import java.util.*;

	class Solution {
	    public long solution(int n) {
	        long answer = 0;
	        String Jin_3 = "";
	        
	        Jin_3 = Long.toString(n,3);
	        
	        StringBuffer sb = new StringBuffer(Jin_3);
	        String rev = sb.reverse().toString();
	        
	       // System.out.println(Long.parseLong(rev));
	        answer = Long.parseLong(String.valueOf(rev),3);
	        
	        return answer;
	    }
	}
	
	
	// 문자열 다루기 기본
	/* 해결일 : 9월 24일 오후 5시 41분
	   문제점 : 사실 정규식으로 하면 라인이 줄어들긴한다
	           하지만, try catch로 한번 잡아보자고 생각했다
	          길이 조건을 만족할 때 일부로 Exception이 발생할 수 있는
	          코드를 한 줄 추가하여 Exception이 뜨면
	          예외 throws 해서 answer의 값이 true로 바꾸는게 아닌 false를 고정시켜주는 코드이다.
	*/

	class Solution {
	    public boolean solution(String s){
	        boolean answer = false;
	        Integer number =0;
	        try{
	            if(s.length()==4 || s.length()==6)
	            {
	                number = Integer.valueOf(s);
	                answer = true;
	            }
	        
	                
	        }
	        catch (NumberFormatException e){
	            answer = false;
	        }
	        return answer;
	    }
	}