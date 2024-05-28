package Buja; // syntax error
public class test_0520_lv3 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 단어 변환
	/* 해결일 : 5월 28일 22시 36분
	   문제점 : 현재 해당 코드는 테스트케이스 안되는데, 제출 채점 해보니까 통과되는
	            기적의 코드이다.
	            BFS/DFS에 대한 기본적인 이해가 안되어있으면 헤맬 것 같아서
	            날 잡고 파야할 것 같다(쉬운 부분부터)
	*/

	import java.util.*;

	class Solution {
	    public int solution(String begin, String target, String[] words) {

	        // 리스트에 단어 있는지 찾아보는 부분
	        boolean isWordExists = false;
	        
	        for(String word : words){
	            if(word.equals(target)){
	                isWordExists = true;
	                break;
	            }
	        }
	        if(!isWordExists) return 0;
	        
	        // BFS 구현
	        boolean[] visited = new boolean[words.length];
	        Queue<String> q = new LinkedList<>();
	        
	        q.offer(begin);
	        
	        int level = 0; // BFS 깊이
	        
	        // 큐 소진될 때까지 계속 진행
	        while(!q.isEmpty()){
	            
	            level++; // 깊이 추가
	            
	            for(int i=0;i<q.size();i++){
	              String currentWord = q.poll();
	                
	                for(int j=0;j<words.length;j++){
	                    // 핵심부분(큐에서 꺼낸부분과 비교 대상 단어를 비교)
	                    if(!visited[j] && isDiffer(currentWord, words[j])){
	                        if(words[j].equals(target)){
	                            System.out.println(level);
	                            return level;
	                        } 
	                        q.offer(words[j]);
	                        visited[j]=true;
	                    }
	                }
	            }
	        }
	        return 0;
	    }
	    
	    
	    boolean isDiffer(String start, String end){
	        int differ = 0;
	        
	        for(int i =0;i<start.length();i++){
	            if(start.charAt(i) !=(end.charAt(i)))
	                differ++;
	            if(differ > 1) return false;
	        }
	            return differ == 1;
	    }
	    
	}