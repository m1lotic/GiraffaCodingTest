package Buja; // syntax error
public class test_0529 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 최댓값과 최솟값

	/* 해결일 : 5월 28일
	   문제점 : 처음에는 스택/큐로 푸래서
	           스택으로 해결하기 위해 이것저것 찾아보았다
	           문제는 해결했는데 시간복잡도 2번이 실패가 자꾸떠서
	           원인을 파악해보다가
	           원래 이 문제가 좀 이상해서
	           스택/큐로 풀 때 시간복잡도가 훨씬 크다고 했다.
	           그래서 나는 문제해결을 위해 일단 스택 큐 버리고
	           숫자로 환산해서 값이 일치하는지 처리를 했다.
	           그래서 정답을 해결했다
	           내가 작성한 코드의 시간복잡도는 O(n)로서
	           효율성 2번기준 6ms 걸렸다. 개빠른거다.
	           어쨌거나 풀면됐잖아?
	           



	class Solution {
	    boolean solution(String s) {
	        boolean answer = true;
	        int answerNum = 0; // ()의 개수를 세기 위한 값

	        for(int i =0;i<s.length();i++){
	             if(answerNum<0){      // ')'(-1빼는거)의 개수가 더 많을 수 없으니 false
	                answer = false; }
	            if(s.charAt(i) =='(')  answerNum +=1; // '(' 가 시작이니 +1 나머지는 -1
	            else                   answerNum -=1;
	            
	        }
	            if(answerNum!=0){  // 정상적으로 처리됐다면 0이어야하는데 다른값이 나오면 false
	                answer = false; } 

	        return answer;
	    }
	}


	// 스택큐로 해결 시도하려고 했던 코드(효율성 2번 실패)
	/*
	import java.util.*;

	class Solution {
	    boolean solution(String s) {
	        boolean answer = false;
	        Stack<Character> stack = new Stack<>();
	        char[] charArr = s.toCharArray();
	        
	        stack.push(charArr[0]);
	    

	        for(int i =1;i<charArr.length;i++){
	            stack.push(charArr[i]);
	           // System.out.println("꼭대기 "+stack.peek());
	         //   System.out.println("그다음 "+stack.get(stack.size() -1));
	        //   System.out.println(stack.size());
	            if(stack.size()>=2 && stack.peek().equals(')') && stack.get(stack.size() -2).equals('(')){
	            //    System.out.println("디버깅");
	                stack.pop();
	                stack.pop();
	            }
	            

	        }
	     //    System.out.println("최종사이즈 : "+stack.size());
	        if(stack.empty() == true)  answer = true;

	        return answer;
	    }
	}

	*/
	
	