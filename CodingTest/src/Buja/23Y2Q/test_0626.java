package Buja; // syntax error
public class test_0626 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
//  두 개 뽑아서 더하기
	/* 해결일 : 6월 29일 
	   문제점 : 자바 공부하면서 한 번도 해본적 없는
       Set 자료형, 그것도 이진트리를 활용하는
       TreeSet를 사용해보았다.
       어차피 2개를 뽑아서 더하는거니
       먼저 엉망진창 숫자를 하나로 정렬하고
       숫자를 더하는데, 중복값을 걸러주는 set이므로
       중복이 자동생략,
       그리고 순서를 고려해주니까
       더욱 빠르게 문제를 해결할 수 있었다.
       원래 이렇게 풀면 안되는데 해 본 적이 없어
       이렇게 시도해봤다.


import java.util.*;

class Solution {
	public TreeSet<Integer> solution(int[] numbers) {
		TreeSet<Integer> answer = new TreeSet<>();
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				answer.add(numbers[i] + numbers[j]);
			}
		}
		return answer;
	}
}
*/