package Buja; // syntax error
public class test_0710 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 점프와 순간 이동
	/* 해결일 : 7월 13일 0시 13분
	   문제점 : 이 문제는 다른 알고리즘을 쓰면 금방 풀리는데,
	           그러니까 주어진 두 배열을 sort 후 비교해서
	           빼버리거나 하면 답이 쉽게 나오는 부분인데
	           hash로 하니까 너무 꼬이고 꼬였다..
	           getOrDefault라는 찾는 키가 있으면 찾는 키를 반환하고
	           그렇지 않으면 디폴트 값을 반환하는 코드를
	           사용해보는 것도 좋은 아이디어이다.
	           
	           hash로 구현하다보니 예상 시간이 너무 길어졌다
	           검색하는 시간도 길어지고..
	          
	*/
import java.util.*;

class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hashMap = new HashMap<>();

		// hashMap에 배열 값을 집어넣는 모습
		for (int i = 0; i < participant.length; i++) {
			try {
				if (hashMap.containsKey(participant[i]))
					hashMap.put(participant[i], hashMap.get(participant[i]) + 1);
				else
					hashMap.put(participant[i], 1);
			} catch (NullPointerException e) {
				System.out.println("Error!");
			}
		}
		// hashMap에 도착한 사람 명단 하나씩 제끼기
		for (int i = 0; i < participant.length - 1; i++) {
			try {
				if (hashMap.containsKey(completion[i]))
					hashMap.replace(completion[i], hashMap.get(completion[i]) - 1);
			} catch (NullPointerException e) {
				System.out.println("Error!");
			}
		}

		// hashMap에서 value가 1이면(도착 못한사람) 그 key가 답임. hashMap는 자동으로 iteration 지원안해서 별 수 없음
		for (Map.Entry<String, Integer> entry : hashMap.entrySet()) { // key 반환하기 위한 entry 만들기
			if (entry.getValue() == 1)
				return entry.getKey();
		}

		return answer; // 빈값(오류)
	}
}