package Buja; // syntax error
public class test_0508_lv2 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 배달
	/* 해결일 : 5월 15일 21시 48분
	   문제점 : 이 문제는 오랜시간동안 해결해도
	           일부 문제가 풀리지 않아 해결이 어려웠다.
	           예외 처리한다고 플로이드 와샬 로직 쪽
	           반복문을 몇 번 흔들어 재꼈는데,
	           그 과정에서 코드가 꼬여서 실패가 된 것 같다.
	           반복문 순서 다시 바꾸니 정답 된다.
	           가중치 입력할 때 값 비교해서 더 작은 값으로 바꿔치기 해줘야 한다.
	           참고로, 시간이 초과되면 다익스트라로 찾아야함
	           */
	           

	class Solution {
	    
	    public static void edge(int[][] graph, int x, int y, int edge){
	        graph[x][y] = edge;
	        graph[y][x] = edge;
	    }
	    
	    public int solution(int N, int[][] road, int K) {
	        int[][] graph = new int[N+1][N+1];
	        int answer = 0;
	        
	        for(int i=0;i<N+1;i++){
	            for(int j=0;j<N+1;j++){
	                if(i==j) graph[i][j]=0;
	                else graph[i][j]=500001;
	            }
	        }
	        
	        // 가중치 입력
	        for(int i=0;i<road.length;i++){
	            if(graph[road[i][0]][road[i][1]] >= road[i][2]){
	            edge(graph, road[i][0], road[i][1], road[i][2]);}
	        }        
	        

	        
	  
	 //       최단거리 탐색(플루이드)

	        for(int i=0;i<N+1;i++){
	            for(int j=0;j<N+1;j++){
	                   for(int k=0;k<N+1;k++){
	                    graph[j][k] = Math.min(graph[j][k], graph[j][i]+graph[i][k]);
	                }
	            }
	        }
	        
	//   //      인접행렬 테스트 코드
//	         for(int i=1;i<N+1;i++){
//	             for(int j=1;j<N+1;j++){
//	               System.out.print(graph[i][j]+" ");
//	             }
//	             System.out.println("");
//	         }
	        
	        // 기준값 이하 측정
	            for(int i=1;i<N+1;i++){
	             //    System.out.println(graph[0][i]+" ");
	                if(graph[1][i] <= K) answer++;
	            }
	        

	        
	        return answer;
	    }
	}