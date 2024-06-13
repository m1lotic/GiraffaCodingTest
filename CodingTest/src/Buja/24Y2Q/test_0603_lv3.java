package Buja; // syntax error
public class test_0603_lv3 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 정수 삼각형
	/* 해결일 : 6월 13일 23시 1분
	   문제점 : 밑에서 올라가는 형태로 진행했다
	           코드는 간결한데 이렇게 생각하기가 쉽지 않은 부분이 있다
	           DP 문제를 해결할수있도록 난이도를 낮춰서 이해해봐야겠다
	           또는 점화식 문제를 좀 풀던가
	           
	*/
	import java.util.*;

	class Solution {
	    public int solution(int[][] triangle) {
	        int answer = 0;
	        int[] dp = new int[triangle.length+1];
	        
	        
	        // 구현목표 : 밑에서부터 위로 계산
	        
	        // 몇 층
	        for(int i = triangle.length-1;i>=0;i--){
	            // 몇 번째
	            for(int j=0;j<triangle[i].length;j++){
	                // dp[j] = 왼쪽(바로위 = 왼쪽), dp[j+1] = 오른쪽
	                dp[j] = Math.max(dp[j],dp[j+1])+triangle[i][j];
	                answer = dp[j];
	                }
	        }
	        return answer;
	    }
	}