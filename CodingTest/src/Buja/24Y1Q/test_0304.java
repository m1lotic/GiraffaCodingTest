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
	
	// 주식가격(기해결)
	import java.util.*;

	class Solution {
	    public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        Stack<Integer> stack = new Stack<>();
	        

	        for(int i=0;i<prices.length;i++){
	            // 0부터 하나씩 스택에 넣으면서 주식 가격보다 스택의 값이 높은 경우
	            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
	                // 해당 숫자를 삭제
	                int top = stack.pop();
	             //     System.out.println("Test"+top);
	                // 해당 하는 값이 몇번째만에 일어난 케이스인지
	                answer[top] = i - top;
	            }
	            stack.push(i);
	          //  System.out.println(stack.peek());
	        }
	        
	        
	        while (!stack.isEmpty()) { // 끝까지 값이 안떨어졌을 떄 남은 배열이 가난해질 때까지 뜯어냄
	            int top = stack.pop();
	              System.out.println("testq"+top);
	            // 해당 숫자가 마지막까지 버텼으니 배열길이 - 시작~최종 시간(살아있는 숫자 기준) - 1 처리
	            // 이미 위에서 처리된 숫자는 스킵됨
	            answer[top] = prices.length - top - 1;
	        }
	        
	        return answer;
	    }
	}