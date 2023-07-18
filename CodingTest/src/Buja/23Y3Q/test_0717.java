package Buja; // syntax error
public class test_0717 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	/*  해결일 : 7월 18일 22시 41분
    문제점 : Arraylist를 써야하는 문제인데
            익숙하지가 않아서
            사용법을 많이 검색으로 찾을 수 밖에 없었다.
            그리고 commands상에 있는 원소들은
            "xx번째" 인데도 불구하고
            그 부분 체크 못하고, xx번째+1의 원소를 찾도록
            로직이 작동하다보니 답을 찾아내는 데 오랜 시간이 걸렸다.
            이거 아마 줄일 수 있는 로직 분명히 있을 것이다.
            
*/
import java.util.*;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		ArrayList<Integer> sorted = new ArrayList<>();
		for (int i = 0; i < commands.length; i++) {
			for (int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++) {
				// System.out.println(j+1);
				sorted.add(array[j]);
				// System.out.println(j+" 어레이 "+array[j]);
			}
			Collections.sort(sorted);
			// System.out.println(sorted);
			answer[i] = sorted.get(commands[i][2] - 1);
			sorted = new ArrayList<>(); // Array 초기화 작업

		}
		return answer;
	}
}