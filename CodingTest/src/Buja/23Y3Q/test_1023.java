package Buja; // syntax error
public class test_1023 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기

	// 더 맵게
	/* 해결일 : 10월 23일 오후 9시 1분
	   문제점 : 항상 코딩테스트 연습에서 문제 유형에 맞지 않는 풀이로
	           해결해야 했었는데, 
	           정석대로 해결이 되었다.
	           
	           처음에는 완전탐색 비슷하게 풀었다가
	           효율성 시간 초과로 인해 
	           지금처럼 우선순위 큐를 썼다.
	           우선순위 큐에 하나 add 해줄 때마다
	           최솟값을 자동 정렬해주니 편했다.
	           역시, 앞으로도 다양한 자료구조 공부를 해야겠다.
	           
	           이 코드를 하고 작동을 한 번 안했는데,
	           한 번도 안세는 경우가 있었다(처음부터 모든 값이 기준치를 넘는경우)
	           조건을 항상 생각하면서 해결해야지.
	           
	           Arrays.sort를 넣은 이유는 한번 정렬을 해주고 우선순위 큐에 넣어
	           불필요한 swap 행위를 막기 위함이었다.
	           실제로도 처리 속도가 무려 30%나 향상되었다.
	           */

import java.util.*;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;

		// 가장안매운거
		int first = 0;
		// 두번째로 안매운거
		int second = 0;
		// 섞은 음식의 값
		int temp = 0;

		PriorityQueue<Integer> QueueScoville = new PriorityQueue<>();

		// 정렬 추가 수행으로 30% 속도 향상
		Arrays.sort(scoville);

		// 우선순위큐에 모든 스코빌 값 ADD
		for (int i = 0; i < scoville.length; i++)
			QueueScoville.add(scoville[i]);

		// 혹시 횟수가 0인경우 검사
		if (QueueScoville.peek() >= K)
			return answer;

		try {
			for (int i = 0; i < scoville.length; i++) {
				// 우선순위큐에서 가장 작은 값 2개 꺼내기
				first = QueueScoville.poll();
				second = QueueScoville.poll();

				// 가장 작은 값 2개의 스코빌 값 계산
				temp = first + (second * 2);
				QueueScoville.add(temp);
				answer++;

				if (QueueScoville.peek() >= K)
					return answer;
			}
		}

		catch (NullPointerException e) {
			// 끝까지 계산했을 때 탈출이 안되면 -1
			return -1;
		}

		return -1;
	}
}