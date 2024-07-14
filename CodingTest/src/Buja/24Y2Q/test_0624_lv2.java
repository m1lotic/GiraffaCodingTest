package Buja; // syntax error
public class test_0624_lv2 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 문자열 압축
	/* 해결일 : 7월 14일 17시 59분
	   문제점 : 문자열 활용이 상당히 까다로운것같다.
	*/

	import java.util.*;

	class Solution {
	    public int solution(String s) {
	        int answer = 999999;
	        
	        // 동일한 문자열 반복 수 체크
	        int cnt = 1;  
	        
	        // 길이 1이면 값은 1
	        if(s.length()==1) return 1;
	     
	        for(int i=1; i<=s.length()/2;i++){
	            StringBuilder sb = new StringBuilder();       
	            String tmp = s.substring(0, i);

	            // 문자열의 조각단위 순환을 위해 j+=i 처리
	            for(int j=i;j<=s.length();j+=i){
	                int max = Math.min(j + i, s.length());

	                if(tmp.equals(s.substring(j,max))){
	                    cnt +=1;
	                }
	                else{
	                    if(cnt != 1){
	                        sb.append(cnt);
	                    }
	                    sb.append(tmp);
	                    tmp = s.substring(j,max);
	                    cnt =1;
	                    }
	                }
	            
	            sb.append(tmp);
	            answer = Math.min(answer,sb.length());
	            }
	            
	        
	        
	        return answer;
	    }
	}