package Buja; // syntax error
public class test_0906 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 타겟넘버
	/* 해결일 : 9월 6일 21시 13분
	   문제점 : DFS 처음 써봤다.
	           그래서 다 쓴 현재도 코드 자체가 익숙하지 않아서
	           좀 더 살펴봐야겠다.
	           
	           현재는 코드를 구현해내는게 중요해서
	           그 부분이 어느정도 되면(뭔가 기본적인 코드 구현법을 위해
	           인터넷 검색 안해도 되면)
	           알고리즘도 날잡아서 공부하던가 해야
	*/
	           

	class Solution {
	    // DFS 쓰는 메소드(재귀임)
	    public int useDFS(int[] numbers, int target){
	        return dfs(numbers,target, 0,0);
	    }
	    
	    // DFS로 합계 검사
	    public int dfs(int[] numbers, int target, int idx, int sum){
	        // 합계가 찾는 값이면
	        if(idx == numbers.length){
	            if(sum == target) return 1;
	            else              return 0;
	        }
	        // 찾는 값이 아니면(계산을 해야 하면)
	        else{
	            int add      = dfs(numbers,target,idx+1,sum+numbers[idx]);
	            int subtract = dfs(numbers,target,idx+1,sum-numbers[idx]);
	            return add+subtract;
	        }
	    }
	    
	    
	    public int solution(int[] numbers, int target) {
	      
	        // DFS 사용 연습
	        return useDFS(numbers, target);
	    }
	}
