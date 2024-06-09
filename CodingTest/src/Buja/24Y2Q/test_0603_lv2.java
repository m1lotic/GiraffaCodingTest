package Buja; // syntax error
public class test_0603_lv2 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 124 나라의 숫자
	/* 해결일 : 6월 9일 21시 30분
	   문제점 : 이 문제는 수학 문제에 가깝다
	           3진수를 계산하기 위해 원래 수에서 3씩 나누는데,
	           자리수가 바뀌는 케이스의 경우 1자리를 추가로 빼준다(n--;)
	*/   
	import java.util.*;

	class Solution {
	    public String solution(int n) {
	        StringBuffer sb = new StringBuffer();  

	        String test = "";
	        int t=0;
	        while(n>0){
	            t= n%3;
	            n/=3;
	            switch(t){
	                case 1:sb.append(1);
	                    break;
	                case 2:sb.append(2);
	                    break;
	                // 0일떄는 자리수가 바뀌기 때문에 n에서 1 빼줘야 함(3진수이기 때문)
	                case 0:sb.append(4);
	                    n--;
	                    break;
	            }
	        //    System.out.println(sb.toString());
	      
	        }
	        
	        test = sb.reverse().toString();
	        return test;
	    }
	}