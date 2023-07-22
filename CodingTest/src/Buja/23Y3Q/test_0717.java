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

//괄호 회전하기
//7월 23일 01시 37분 미해결
//미해결 사유 : stack를 사용하지 않고 풀고 있는데
//          stack 미고려한 예외 케이스 처리가 불가한 상황
//          해결시간 초과로 미해결 처리

import java.util.*;

class Solution {
	public int solution(String s) {
		int answer = 0;
		String new_s = s;
		int length = s.length();
		// 1[ 2( 3{ 4] 5) 6} 숫자로 바꾼다
		new_s = new_s.replace("[", "1").replace("(", "2").replace("{", "3")
					 .replace("]", "4").replace(")", "5").replace("}", "6");
		int[] count = new int[6];

		// 단일 조건 검사
		if (length == 1) {
			if (Integer.parseInt(new_s) < 4)
				return 1;
			if (Integer.parseInt(new_s) >= 4)
				return 0;
		}

		for (int i = 0; i < length; i++) {

			for (int j = 0; j < length - 1; j++) {
				count[Integer.parseInt(new_s.substring(j, j + 1)) - 1] += 1;
				if (count[0] < count[3] || count[1] < count[4] || count[2] < count[5]) {
					// System.out.println("틀린상황");
					answer -= 1;
					break;
				}
				// {()}는 가능 {(})는 불가
				// if()
			}
			answer += 1;
			Arrays.fill(count, 0);

			new_s = new_s.substring(1, length) + new_s.substring(0, 1);

			// System.out.println(new_s);
		}
		return answer;
	}
}
/*
          if(Integer.parseInt(test_new_s.substring(0,1))>=4)
          {
              answer +=1;
              continue;
          }
             if(test_new_s.substring(j,j+1).equals("1")){
             test_new_s=test_new_s.replaceFirst("1","");
             test_new_s=test_new_s.replaceFirst("4","");
                 k+=1;
             }
             
             if(test_new_s.substring(j,j+1).equals("2")){
             test_new_s=test_new_s.replaceFirst("2","");
             test_new_s=test_new_s.replaceFirst("5","");
                  k+=1;
             }
             
             if(test_new_s.substring(j,j+1).equals("3")){
             test_new_s=test_new_s.replaceFirst("3","");
             test_new_s=test_new_s.replaceFirst("6","");
                  k+=1;
             }
             */