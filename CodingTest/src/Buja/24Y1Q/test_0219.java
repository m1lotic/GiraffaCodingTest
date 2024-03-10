package Buja; // syntax error
public class test_0219 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 게임 맵 최단거리
	/* 해결일 : 2월 25일 20시 11분
	   문제점 : 그래프 알고리즘인 dfs, bfs 의 경우
	           직관적으로 이해하기 어려운 부분이 있다.
	           
	           익숙하지 않아서 그런 것 같다.
	*/           

	import java.util.*;

	class Solution {
	    
	    // 상하 - 좌우
	    int[] moveX = {0,0,-1,1}; // 좌우
	    int[] moveY = {1,-1,0,0}; // 상하
	    
	    public int solution(int[][] maps) {
	        int answer = 0;
	        
	        // 방문 체크
	        int[][] visited = new int[maps.length][maps[0].length];
	        
	        bfs(maps, visited);
	        answer = visited[maps.length-1][maps[0].length-1];
	        
	        if(answer ==0) return -1;
	        return answer;
	    }
	    
	    public void bfs(int[][] maps, int[][] visited){
	        
	        Queue<int[]> queue = new LinkedList<>();        
	        queue.add(new int[]{0,0});
	        visited[0][0] = 1; // 시작지점(1,1 => 인덱스상(0,0))
	        
	        while(!queue.isEmpty()){
	            int[] now = queue.poll();
	            
	            int x = now[0];
	            int y = now[1];
	            
	            // 좌표이동(상하좌우) 시도
	            for(int i=0;i<4;i++){
	                int newX = x + moveX[i];
	                int newY = y + moveY[i];
	                
	                // 맵 밖으로 나가는 경우 패스
	                if(newX < 0 || newY <0 || newX > maps.length -1 || newY > maps[0].length -1){
	                    continue;
	                }
	                    
	                // 벽이 아니라면& 방문도 안했다면
	                    
	               if(maps[newX][newY] == 1 && visited[newX][newY] == 0){
	                   visited[newX][newY] = visited[x][y] + 1; // 기존좌표에서 +1
	                  queue.add(new int[]{newX,newY});
	               }
	                    
	            }
	            
	        }
	    }
	}