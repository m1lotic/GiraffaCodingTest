package Buja; // syntax error
public class test_0401 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 택배상자
	/* 해결일 : 4월 7일 20시 29분
	   문제점 : 문제 이해하기가 너무 까다롭다
	          order는 택배기사님이 원하는 순서
	          그리고 order에 있는 상자들은 1번부터 오름차순으로..
	          순서가 일치하지 않으면 보조에 올려둘 수 있음
	*/
	import java.util.*;

	class Solution {
	    public int solution(int[] order) {
	        int answer = 0;
	        int orderNum = 0; 
	        
	        Stack<Integer> stack = new Stack<>();
	        
	        for(int i =1;i <=order.length;i++){
	            // 상자 번호와 원하는 순서 불일치할 때
	            if(order[orderNum]!=i){
	          //       System.out.println("0번 "+orderNum);
	                stack.push(i);
	                continue;
	            }
	            
	            // 원하는 순서가 일치하면
	            orderNum++;
	            answer++;
	            
	            // 보조 컨테이너 벨트, 보조에 0개 될 때까지 확인, 있으면 뺀 후 다음 상자 확인
	                while(!stack.isEmpty()  && stack.peek()==order[orderNum]){
	                         answer++;
	                         orderNum++;
	                         stack.pop();
	                }

	            }
	        
	        
	        return answer;
	    }
	}