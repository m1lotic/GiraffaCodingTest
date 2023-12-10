package Buja; // syntax error
public class test_1204 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기

	// 귤고르기

	/* 해결일 : 12월 10일 20시 07분
	   문제점 : 이 문제도 특정한 알고리즘을 강요하는 느낌이 들었다.
	           원래는 아래 코드와 조금 다르게 풀었는데, 일부 항목에서 틀렸다고 떠서 방법 변경했다.
	           어차피 몇 번의 귤을 넣는지는 안중요하니까 개수만 세기 위해
	           우선순위 큐에 크기별 귤 몇개인지 집어넣었고 하나씩 제거했다.
	           특이한 점이라 하면 타 문제와 다르게 주어진 매개변수의 값을 건드렸다.
	*/
	import java.util.*;

	class Solution {
	    public int solution(int k, int[] tangerine) {
	        int answer = 0;
	        int cnt = 0;
	        int count = 0;

	        HashMap<Integer, Integer> map =  new HashMap<>();
	        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
	        
	        // 맵에 숫자 넣기
	        for(int i =0;i<tangerine.length;i++){
	            map.put(tangerine[i],map.getOrDefault(tangerine[i], 0) + 1);
	        }
	        
	        // 우선순위 큐에 셌던 값 넣기
	        for (int counts : map.values()) {
	            queue.add(counts);
	        }
	        
	       // 큐에서 숫자(특정 크기 귤 개수 전체 수) 를 하나씩 빼주기
	       while (k > 0 && !queue.isEmpty()) {
	            count = queue.poll();
	            answer++;
	            k -= count; // 그리고 남은 귤 개수(상자가 여러개가 아니고 상자 1개임)
	        }

	        return answer;
	    }
	}