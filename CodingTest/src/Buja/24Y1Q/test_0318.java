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
	
	// N개의 최소공배수
	/* 해결일 : 3월 30일 23시 27분
	   문제점 : 이 문제의 경우에는
	           최소공배수가 2개 수가 아니고
	           여러 개를 구해야 하는 코드라서
	           
	           알고리즘이 정형화 될 수 밖에 없어보인다..
	*/ 



	import java.util.*;

	class Solution {
	    
	    
	    // 최대공약수
	    public int gcd(int a, int b){
	        int tmp=0;
	        
	        while(b != 0){
	           tmp = a%b;
	           a = b;
	           b = tmp;
	        }
	        
	        return a;

	    }
	    // 최소공배수
	    public int lcm(int a, int b){
	        return a * b / gcd(a,b);
	    }
	    
	    
	    public int solution(int[] arr) {
	        int answer = arr[0];
	        
	        for(int i=0;i<arr.length;i++){
	            answer  = lcm(answer, arr[i]);
	        }
	        
	        return answer;
	    }
	}