package Buja; // syntax error
public class test_0624_lv3 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 야근 지수
	/* 해결일 : 6월 30일 21시 26분
	   문제점 : 원래라면 우선순위큐 직접 구현해야 하는데
	           우선순위 큐를 사용하는 방법(1)
	           이 문제를 우선순위 큐를 사용하면 풀수있다는 것(2)
	           이라는 두 개 요소를 생각을 못해내고 있다는것이 심각한 문제로 보인다.
	           특히 (1)을 위해 인터넷 뒤적거려야 하는 것이 
	           매우 좋지 않은 것 같다.
	           
	*/

	import java.util.*;

	class Solution {
	    public long solution(int n, int[] works) {
	        long answer = 0;
	        int temp_Sum = 0;
	        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	        
	        int temp_Cur = 0;
	 
	        // 잔여물이 야근 필요시간보다 작을 경우
	        for(int i=0;i<works.length;i++){
	            temp_Sum += works[i];
	            pq.add(works[i]);
	        }
	        if(temp_Sum <=  n) return 0;
	        
	        // 야근 다 해도 잔여 일감 있을 때
	        while(n>0){
	            temp_Cur = pq.poll();
	            pq.add(temp_Cur-1);
	            n--;
	        }
	        
	        // 야근 지수 계산
	        long test = 0;
	        while(!pq.isEmpty()) {
	        test = (long)Math.pow(pq.poll(),2); // Math.pow()는 double 타입으로 반환하기 때문
	           
	         answer += test;
	        }
	 
	        return answer;
	    }
	}