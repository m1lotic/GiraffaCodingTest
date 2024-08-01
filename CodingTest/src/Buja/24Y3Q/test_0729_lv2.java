package Buja; // syntax error
public class test_0729_lv2 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 호텔 대실
	/* 해결일 : 8월 1일 21시 40분
	   문제점 : 문자열값인 시간값을 숫자로 바꿔주는 부분이 상당히 까다로웠다
	           우선순위 큐 사용 시 항상 큐가 비었는지를 검사해야하는 점을
	           잊지 않아야겠다.
	*/

	import java.util.*;

	class Solution {
	    public int solution(String[][] book_time) {
	        int answer = 0;
	        int[][] book_time_int = new int[book_time.length][2]; 
	        
	        Arrays.sort(book_time, Comparator.comparing((String[] o) -> o[0]));
	        
	        // 대실시간 계산
	        for(int i=0;i<book_time.length;i++){
	            for(int j=0;j<=1;j++){
	                book_time_int[i][j] = Integer.parseInt(book_time[i][j].replace(":", ""));
	            }
	            // 종료시간은 10분을 더해야 한다
	               book_time_int[i][1] += 10;
	               if(book_time_int[i][1]%100>=60){
	                   // 종료시간 처리
	                   book_time_int[i][1]+=40;
	               //    System.out.println(book_time_int[i][1]);
	               }
	              // System.out.println(book_time_int[i][0]+" "+book_time_int[i][1]);
	                   
	        }
	        
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        

	           for(int i=0;i<book_time.length;i++){
	            //   System.out.println("시간"+book_time_int[i][0]+" "+pq.peek());
	                while(!pq.isEmpty()&&book_time_int[i][0]>=pq.peek()){
	                    pq.poll();
	                }
	                pq.add(book_time_int[i][1]);
	               // 최댓값을 매번 확인해줘야함
	               answer = Math.max(answer, pq.size());
	            }


	        // 현재 스트링으로 되어있는걸 substring 활용해서 시간, 분으로 쪼개고
	        // 시작시간 기준으로 정렬하고
	        // 우선순위큐에다가 종료시간+10분 집어넣고
	        // 다음 배열 종료시간 체크하면서 종료시간+10분 지났는지 확인하고
	        return answer;
	    }
	}s