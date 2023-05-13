package Buja; // syntax error
public class test_0507 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	/* 5월 5일 추억점수
	 * 
	 * 해결일 : 5월 5일
   문제점 : 처음에는 삼중 for문 생각했는데
   MAP를 가지고 풀어보라 하여 MAP를 사용해보았다.
   MAP를 실전에서 사용하는 것은 처음이어서 해맸지만
   MAP 사용법 자료만 가지고 아래와 같이 구현하는데 성공하였다.
   특히, 예외 상황에 대해 혼자 try ~ catch를 생각해서
   예외처리까지 완료한 것이 좋은 점이었다.
    
	 import java.util.*;

class Solution {
	public int[] solution(String[] name, int[] yearning, String[][] photo) {
		Map<String, Integer> map = new HashMap(); // map를 생성
		int[] answer = new int[photo.length];

		for (int i = 0; i < name.length; i++)
			map.put(name[i], yearning[i]); // map에 입력

		for (int j = 0; j < photo.length; j++) { // map에서 검색
			for (int k = 0; k < photo[j].length; k++) {
				try {
					answer[j] += map.get(photo[j][k]);
				} catch (NullPointerException e) { // NULL(안 그리운 사람) 예외 처리
					answer[j] += 0; // 사실 생략가능 e.printStackTrace() 보다는 이게 낫다
				}
			}
		}
		return answer;
	}
}
	 */
	
	/* 5월 5일 덧칠하기
	 * 해결일 : 5월 5일
   문제점 : 결국 결론은 한줄인데, 그 한 줄을 찾는데
   시간이 너무 오래걸렸다.
   이렇게 오래걸린건 결국 알고리즘 지식의 부재로 인한 거였다
(1시간동안 풀이했으나 실패하여
질문하기의 JS 풀이 이론을 기반으로 문제를 풀어나갔음)
	 * 
	 * class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int pos = 0; // 내가 몇번까지 칠했어?
        
         for(int i=0;i<section.length;i++){
            if(section[i]>pos){
                pos = (section[i]+m-1); // 한번에 m만큼 칠하니까!
                // 처음에는 pos를 +=로 처리했으나
                // 그렇게 될 경우 section의 배열 값 인식을 못해서
                // 값이 커질 경우 불일치되어 오답이 되는 이슈가 있었다
                answer +=1; // 그리고 한 번 칠하는거
            }
        }
        return answer;
    }
}
	 */
	/* 5월 6일 공원산책(미해결)
	 * 

	import java.util.*;


	// 해결 안된문제 : 이거 장애물 지났을때 원복이 아니고, 그 지점을 1칸씩 지나갈때
	// 넘어간다면 오류를 뿜고 continue하는거임

	/* 너무 복잡해서 구현 방향을 바꾸는 건 어떤가?
	가로 방향 보드하고
	세로 방향 보드 2개를 만들어가지고(0, 1로)

	방향 별로 검사를 하는데, 남쪽으로 3칸 이동 이러면
	남쪽 3칸 방향 배열을 불러와서
	X가 하나라도 있으면 이동시키지 않고 continue 처리를 하자

	
	class Solution {

		public int[] solution(String[] park, String[] routes) {
			int[] answer = new int[2]; // (의도는) [가로,세로]
			int[][] b1 = new int[park.length][park[0].length()];
			int[][] b2 = new int[park[0].length()][park.length];

			// 공원지도를 계산하기 쉽도록 숫자 배열화한다
			for (int i = 0; i < park.length; i++) {
				for (int j = 0; j < park[i].length(); j++) {
					if (park[i].charAt(j) == 'S')
						b1[i][j] = 2;
					if (park[i].charAt(j) == 'O')
						b1[i][j] = 0;
					if (park[i].charAt(j) == 'X')
						b1[i][j] = 1;
				}
			}
			for (int i = 0; i < park.length; i++) {
				for (int j = 0; j < park[i].length(); j++) {
					if (park[i].charAt(j) == 'S')
						b2[j][i] = 2;
					if (park[i].charAt(j) == 'O')
						b2[j][i] = 0;
					if (park[i].charAt(j) == 'X')
						b2[j][i] = 1;
				}
			}

			// 방향과 이동 숫자도 배열처리
			for (int i = 0; i < routes.length; i++) {
				int[] rot = new int[routes.length];
				int[] mov = new int[routes.length];

				mov[i] = Integer.parseInt(routes[i].substring(2));

				if (routes[i].substring(0, 1).equals('N'))	rot[i] = 1;
				if (routes[i].substring(0, 1).equals("S"))	rot[i] = 2;
				if (routes[i].substring(0, 1).equals("W"))	rot[i] = 3;
				if (routes[i].substring(0, 1).equals("E"))	rot[i] = 4;
			}

			// B1 : 좌우 B2: 상하 ㅜ

			// if (park[x].charAt(y) == 'S') {}

			return answer;
		}
	}


	/* 아래 코드는 백업입니다
	        int[] tmpAnswer = new int[2]; // 디버깅값(오류 체크 후 적용)
	            List<int[]> obsList = new ArrayList<>(); // 'X'의 위치를 저장할 리스트

	        // 장애물 리스트 전체 탐색
	    for (int x = 0; x < park.length; x++) {
	        for (int y = 0; y < park[x].length(); y++) {
	            if (park[x].charAt(y) == 'X') {
	                int[] pos = {x, y}; // 'X'의 좌표를 배열로 저장
	                obsList.add(pos); // 'X'의 좌표를 리스트에 추가
	            }
	        }
	    }
	        
	    
	    // 시작지점 인식
	    for (int x = 0; x < park.length; x++) {
	        for (int y = 0; y < park[x].length(); y++) {
	            if (park[x].charAt(y) == 'S') {
	               answer[0] = x;
	               answer[1] = y;
	                break;
	            }
	        }
	    }
	        // route 이동 알고리즘
	        for(int i=0;i<routes.length;i++){
	            
	            if(routes[i].substring(0,1).equals('N')){
	                tmpAnswer[0] -= Integer.parseInt(routes[i].substring(2));}
	            if(routes[i].substring(0,1).equals("S")){
	                tmpAnswer[0] += Integer.parseInt(routes[i].substring(2));}
	            if(routes[i].substring(0,1).equals("W")){
	               tmpAnswer[1] -= Integer.parseInt(routes[i].substring(2));}
	            if(routes[i].substring(0,1).equals("E")){
	               tmpAnswer[1] += Integer.parseInt(routes[i].substring(2));}
	            
	         
	        // 이동할 좌표가 장애물, out of range 인지 확인
	        for (int k = 0; k < obsList.size(); k++) {
	            System.out.println("list값 검사!"+obsList.get(k)[0]+obsList.get(k)[1]);
	            System.out.println("일치값  검사!"+tmpAnswer[0]+tmpAnswer[1]+" "+obsList.size());
	              if(obsList.get(k)[0] == tmpAnswer[0] && obsList.get(k)[1] == tmpAnswer[1]){
	                  
	                  tmpAnswer[0] = answer[0]; // 원복
	                  tmpAnswer[1] = answer[1];
	              }
	        }
	            
	        // 문제가 없으면 실제 좌표로 처리
	            answer[0]= tmpAnswer[0];
	            answer[1]= tmpAnswer[1];
	        }
	        
	       
	        return answer;
	    */
