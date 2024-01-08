package Buja; // syntax error
public class test_0108 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	

    // 이진 변환 반복하기
	/* 해결일 : 1월 8일 23시 3분
	   문제점 : 정답률을 보면 알겠지만, 간단한 문제인데
	           문제를 잘 못 읽어서 해결하는데 시간이 오래 걸렸다.
	           정규식을 한 번 써보고싶어서 replaeAll에 정규식
	           집어넣고 length 계산을 해 보았다..
	           
	           요즘 문해력이 떨어졌나..
	*/

	import java.util.*;

	class Solution {
	    public int[] solution(String s) {
	        int[] answer = new int[2];
	        int len = 0;

	        while(true){
	            answer[1] += s.length()-s.replaceAll("[^1-9]","").length();
	           if(s.equals("1")) break;

	            answer[0]++;
	           s=s.replaceAll("[^1-9]","");
	            len=s.length();
	           // System.out.println(len);
	           s=Integer.toString(len,2);
	        //   System.out.println(s);
	        
	        }
	    return answer;
	    }
	}
	
	
	/* 아래 방법으로도 가능 -> while문에 !조건문 사용
    while(!s.equals("1")){
    	answer[1] += s.length()-s.replaceAll("[^1-9]","").length();
    	answer[0]++;
    	
    	s=s.replaceAll("[^1-9]","");
    	len=s.length();
   
    	s=Integer.toString(len,2);
	
	*/