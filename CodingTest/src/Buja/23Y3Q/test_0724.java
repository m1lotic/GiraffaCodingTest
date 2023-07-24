package Buja; // syntax error
public class test_0724 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기

//  기능개발
/*  해결일 : 7월 25일 오전 0시 45분
    문제점 : 메소드 한 개로 모듈화해서 구현을 시도했다.
            솔직히 이정도 길이는 메소드 하나에 할 게 아니고
            메소드 여러개로 만들어야 한다. 실력쌓이면 그렇게 할 예정
            
            일단 정답의 길이는 가변적이므로 ArrayList 하나 만들고,
            스택 적혀있으니 스택으로 풀자고 해서 스택했다.
            처음에는 HashMap으로 하려고 했는데, 코드가 꼬일거 같아서
            그냥 스택으로 하라니 스택으로 했다.
            먼저 스택에 진행도 값을 밀어넣고
            맨 위에 있는 스택부터 스피드값 넣었다.
            그렇게 하면서 맨 위가 100이면 스택을 하나씩 제거시켰다.
            
            근데, 스택이 0개가 되면 오류가 나게 된다. 스택이 텅 비었다면서
            그 부분을 예외처리해서 0개가 되면 오류가 아니고 값을 출력할 수 있도록 해주었다.
            이 시간까지 할 생각은 없었는데
            코드가 될 듯 말 듯 해가지고 그냥 이시간까지 구현했다.
*/

import java.util.*;

class Solution {
	public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> answer = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();

		int length = progresses.length - 1; // 길이는 1부터, index는 0이라서 index 중심으로 길이 산정
		int count = 0;
		int count_save = 0; // 카운트값 기록하는 변수(올바른 위치의 stack값 조작을 위함)
		System.out.println(">>>>>>디버깅 길이는>>>>> " + length); // index 값 올바를 예정인지 확인

		// stack에 진행도 밀어넣기
		// 단, index가 0번인거부터 검사해야하니 stack으로는 맨 위에 있어야함(밀어넣는게 역순임)
		for (int i = 0; i < length + 1; i++) {
			stack.push(progresses[length - i]);
			System.out.println("젤 위에있는 값은 : " + stack.peek()); // 스택값 검사
		}

		// speed의 진행률 반영(무한루프 방지 포함)
		while (count < 100) {
			// stack에 진행도 더하기
			for (int i = 0; i < length + 1 - count_save; i++) {
				try {
					stack.set(length - i - count_save, stack.elementAt(length - i - count_save) + speeds[i + count_save]);
					System.out.println("변경된 스택값: " + stack.elementAt(length - i - count_save));
					System.out.println(">>>>>디버깅 현재 index>>>> " + (length - i));
				} catch (EmptyStackException e) {
					System.out.println("뭔가 버그가 있습니다 여기서");
					return answer;
				}
			}

			// 맨 위 스택의 progress가 100 넘었는지 검사
			try {
				while (stack.peek() >= 100 && count < 100) // 무한루프방지
				{
					System.out.println(stack.peek() + "가 사라졌어요 ㅠ 이제 스택 사이즈는 : " + (stack.size() - 1));
					stack.pop();
					count++;
				}
			} catch (EmptyStackException e) {
				System.out.println("스택이 0개됐네요. 가난ㅠ"); // 스택 0개일 때 반복문 탈출
				answer.add(count);
				count = 0;
				break;
			}

			// System.out.println("코드 동작중");
			if (count >= 1) {
				answer.add(count);
				count_save += count;
				// System.out.println(count_save);
				count = 0;
			}

		}

		return answer;
	}
}