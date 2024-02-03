package Buja; // syntax error
public class test_0108 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	

// 혼자 놀기의 달인
/* 해결일 : 2월 3일 20시 34분
   문제점 : 다른 게 아니고
           문제가 너무너무 이해하기가 힘들다
           국어가 복잡하게 적혀있다
           그런데 결국, 1번부터 시작해서 cards[i] 에 적혀있는 번호로
           다시 리턴되면 그 때를 1회 마감이라고 보면 되는 문제이다.
           dfs로도 해결이 가능하다고 한다.
*/
  /*
import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer[] = new int[cards.length]; // 최대 카드 길이 만큼 가능
        
        for(int i = 0; i < cards.length;i++){
            int cnt = 0; // 이번 회차의 시행 횟수
            
        // 카드가 아직 조회되지 않았을 때
            while(cards[i]>0){
                int next = cards[i] - 1;
                System.out.println("열어본 카드"+ cards[i]+"next "+next);
                cards[i]=0; // 0(순회 완료) 처리
                i = next; // 1번째 8 -> 8번 상자(인덱스는 7번)로 이동해야함
                System.out.println("i 확인"+ i);

                cnt++; // 순회 횟수 1회 증가
            }
            answer[i] = cnt; // 이번 차례 순회한 횟수 입력
        }
        
        Arrays.sort(answer); // 순회 횟수 입력이 최종 i 위치로 입력 되어있으므로 최고 숫자 산출 위해 정렬함
        System.out.println(Arrays.toString(answer));
        // 정답 배열 계산
        int len  = answer.length;
        return answer[len -1] * answer[len -2];
    }
}

*/
