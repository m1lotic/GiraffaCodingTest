package Buja; // syntax error
public class test_0508 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 둘만의 암호
	/* 해결일 : 5월 9일
	   문제점 : 프로그래밍 실력의 한계로 인해
	   3중 for문으로 해결할 수 밖에 없었고
	   결국 시간이 길어졌다.
	   분명 어차피 아스키코드값은 정해져있으니
	   다른 방법 있지 않을까?
	   다행인건, 아스키코드 변환 방법을 옛날에 비해
	   덜 복잡하게 수행했다는 점이다. 
	   (반례 찾기가 어려워서 질문하기를 참고했다)\
	

	class Solution {
	    public String solution(String s, String skip, int index) {
	        String answer = "";
	        int[] intSkip = new int[skip.length()];
	        int[] intS    = new int[s.length()];
	        for(int i=0;i<skip.length();i++) intSkip[i] = (char)skip.charAt(i);// skip 대상값
	        for(int i=0;i<s.length();i++) intS[i] = (char)s.charAt(i);// s 대상값(바꿔질 값)
	        
	            
	        for(int j=0;j<s.length();j++){ 
	           for(int k=0;k<index;k++){  // 인덱스를 1씩 올려보며 검사
	                  intS[j] +=1; // 무조건 값 1은 올려야함
	               for(int h=0;h<skip.length();h++){ // 스킵값을 하나씩 올리면서 검사
	                    if(intS[j]>122) intS[j]-=26;
	                   if(intS[j]==intSkip[h]) 
	                   {    
	                       intS[j] +=1;
	                       if(intS[j]>122) intS[j]-=26;
	                         h=-1; // h값 초기화
	                   }
	               }
	           }
	        }
	        
	         for(int i=0;i<s.length();i++) answer += ((char)intS[i]); //answer 값  출력
	        
	        return answer;
	    }
	}
	
	*/
	
     // 카드 뭉치
	/* 해결일 : 5월 10일
	   문제점 : 이 문제를 보자마자
	         아 어차피 card1 card2 길이는 얼마안되니까
	         랜덤으로 뽑아보면 되지 않을까? 하면서
	         고민을 했는데 ㅋㅋㅋ
	         생각보다 시간이 오래 걸렸다.
	         이유는 null 값 처리의 문제.
	         금방 끝날 줄 알았는데 실패뜨길래 어떻게하지? 하다가
	         디버깅 해보니 null값이 계속 뜨는데
	         정해진 card1의 값을 초과했는데도 계속 right(생성한 단어) 배열에 넣으려고 해서였다.
	         그래서 그 값이 초과되면 무조건 특정 값만 나오도록(어차피 길이는 정해져있으니)
	         처리하고, 길이가 10일경우 경우에 따라 실패할 수 있으므로
	         50만 회 반복을 해서(요즘 CPU 성능 좋다) 처리를 했다.
	         재밌는 방법으로 한번 풀어봤다 아마 좋아요 박힐듯 ㅋㅋ
	         

	
import java.util.*;

class Solution {
	public String solution(String[] cards1, String[] cards2, String[] goal) {
		Random rd = new Random();
		rd.setSeed(System.currentTimeMillis()); // 시드값 설정을 따로 할수도 있음
		int a = 0;
		int one_check = 0;
		int two_check = 0;
		String[] right = new String[goal.length];
		String answer = "No";

		for (int i = 0; i < 500000; i++) {
			one_check = 0;
			two_check = 0;
			for (int j = 0; j < (goal.length); j++) {
				a = rd.nextInt(2);

				// 정해진 값 초과시 무조건 값 고정 처리
				if (one_check >= cards1.length)
					a = 1;
				if (two_check >= cards2.length)
					a = 0;

				if (a == 0) {
					if (one_check < cards1.length) {
						right[j] = cards1[one_check];
						one_check += 1;
					}

				} else if (a == 1) {
					if (two_check < cards2.length) {
						right[j] = cards2[two_check];
						two_check += 1;
					}
				}

			}
			// System.out.println(Arrays.toString(right));
			// 배열 일치 검사
			if (Arrays.equals(right, goal)) {
				answer = "Yes";

				break;
			} else {
				answer = "No";
			}
		}
		return answer;
	}
}*/
	
	// 대충 만든 자판
	/* 해결일 : 5월 14일
	   문제점 : 어려운 문제라 시간이 좀 많이 걸렸다
	   하루만에 푼 문제가 아니고 몇일에 걸쳐서 해결을 한 문제고
	   아무리 생각해도 답이 안나와서 질문에 있는 반례 참고를 좀했다
	   하다보니 코드 구조가 많이 복잡해졌다.
	   keymap에서 한번 비교하는 로직
	   targets에서 한번 비교하는 로직 2개가 구조는 비슷하긴하지만
	   구현이 다르게 되어있다.
	   이 문제는 반례처리를 하는 것이 중요한데,
	   targets 배열 내 원소가 keymap 원소 중 일부만 들어있는(전부 다 만족 안하는)
	   그런 case가 있어서 예외 처리를 했어야 했다.
	   나는 처음 시작값을 1000이라는 가상의 값으로 잡고 시작해서
	   1000보다 많은(일부만 만족하면 무조건 값이 더해졌을테니) 값일 경우
	   모두 -1를 표출하도록 했으나,
	   차후에는 값을 검색했을 때 없다면 exception을 띄어주는 그런 작업을 하는게
	   더 나은 코딩 방법이라고 생각한다. 
	   
	   
import java.util.*;

class Solution {
	public int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];
		int tmp = 0; // 임시저장값
		Map<Character, Integer> alphabet = new HashMap<>(); // 알파벳 저장할 자리(A부터 Z까지 입력받을거임)
		for (int i = 65; i <= 90; i++) 
			alphabet.put((char) i, 1000); // 최소값을 찾아나가기 위한 큰 값
 
 		// A부터 Z까지 keymap별로 몇 회를 입력해야 하는 지를 검사한다. 
		for (int i = 65; i <= 90; i++) // 알파벳 저장 최솟값
		{

			for (int k = 0; k < keymap.length; k++) {
				tmp = 0;
				for (int j = 0; j < keymap[k].length(); j++) {
					tmp += 1;
					// System.out.println("기준:"+(char)i +" "+keymap[k].charAt(j));
					if (keymap[k].charAt(j) == (char) i) {
						if (tmp < alphabet.get((char) i)) {
							alphabet.put((char) i, tmp);
							System.out.println((char) i + " " + tmp);
							break;
						}
					}
				}
			}
		}
		
		// target에 해당하는 알파벳 값이 있는지 검사하고 정답 배열에 더한다.
		for (int i = 65; i <= 90; i++) // 알파벳 저장 최솟값
		{

			for (int k = 0; k < targets.length; k++) {
				for (int j = 0; j < targets[k].length(); j++) {
					if (targets[k].charAt(j) == (char) i) {
						answer[k] += alphabet.get((char) i);
						// System.out.println((char)i+" "+answer[k]);
					}
				}
			}
		}

        // 정답 행렬에 1000 이상의 값(keymap에 없는 알파벳)이 있을 때 -1로 처리한다
		for (int k = 0; k < answer.length; k++)
			if (answer[k] >= 1000)
				answer[k] = -1;

		return answer;
	}
}*/
