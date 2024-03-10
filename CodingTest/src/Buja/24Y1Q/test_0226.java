package Buja; // syntax error
public class test_0219 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 뒤에 있는 큰 수 찾기
	/* 해결일 : 3월 10일 20시 7분
	   문제점 : 스택 구현을 처음에는 if로 했는데
	           if로 하면 여러개 처리가 안되서 오류가 나는 부분을 놓침
	           만족할 때 까지 스택 돌려야하는것이 핵심
	           */

	import java.util.*;

	class Solution {
	    public int[] solution(int[] numbers) {
	        int[] answer = new int[numbers.length];
	        

	         Stack<Integer> stack = new Stack<>();

	        // 0번 인덱스
	        stack.push(0);
	        for(int i=1;i < numbers.length;i++){
	            
	            while(!stack.isEmpty() &&  numbers[stack.peek()] <numbers[i] ){
	                answer[stack.pop()] = numbers[i];                
	            }
	                stack.push(i);
	        }   
	            
	            while(!stack.isEmpty()){
	                answer[stack.pop()]=-1;
	            }
	         
	        return answer;
	    }
	}