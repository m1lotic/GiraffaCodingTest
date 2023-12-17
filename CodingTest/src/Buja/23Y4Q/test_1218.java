package Buja; // syntax error
public class test_1218 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기

	// JadenCase 문자열 만들기

	/* 해결일 : 12월 17일 22시 13분
	   문제점 : 이걸 풀고 나서 다른 풀이를 보니까
	           String 글자 하나씩 배열로 담아서
	           lowercase해주고, flag 비교해서
	           특정 결과만 uppercase 바꿔주는 그런거 있더라
	           왜냐면 지금 무슨 단어가 입력했는 지 기억할 필요가 없어서
	           다음에는 저렇게 구현하는 게 낫겠다 싶었다.
	*/
	import java.util.*;


	class Solution {
	    public String solution(String s) {
	        String answer = "";
	        boolean flag  = true; // 대문자 걸어야 하는 글자 플래그
	     

	        
	     // 나머지 글자 검증(단, 첫글자만 대문자, 나머지는 소문자)
	        for(int i =0; i<s.length();i++){
	            if(s.charAt(i)==' '){
	                answer+=' ';
	                flag = true;
	                continue;
	            }
	            
	            if(s.charAt(i)>='a' && s.charAt(i)<='z' && flag == true){
	                   answer+=(char)(-32+s.charAt(i));
	                   flag=false;
	                    continue;
	                }
	            
	            else{
	                if(s.charAt(i)>='A' && s.charAt(i)<='Z' && flag == false){
	                   answer+=(char)(32+s.charAt(i));
	                    continue;
	                }
	                 else{
	                     answer+=s.charAt(i);
	                     flag=false;
	                 }
	                }
	            
	        }
	        return answer;
	    }
	}