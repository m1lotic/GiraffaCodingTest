package Buja; // syntax error
public class test_0715_lv2 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 하노이의 탑
	/* 해결일 : 7월 19일 19시 39분
	   문제점 : 지금부터는 그림을 그려가면서 
	           해결하지 않으면 문제를 풀 수가 없다
	           int[][]로 하면 번잡하니 차라리 첨부터
	           ArrayList<int[]>로 반환하면 더 간단하게 처리되는 것으로 보인다.
	           그리고 대소문자 구분 잘 할 것.
	*/

	import java.util.*;

	class Solution {
	    
	    // 이동경로 저장 리스트
	    private ArrayList<int[]> answer;

	    public ArrayList<int[]> solution(int n) {
	        
	        answer =  new ArrayList<>();
	        
	        // n개 링, 시작, 종료, 보조(3번으로 가기위해 필요한)
	        hanoi(n,1,3,2);
	        
	        return answer;
	    }
	    
	    public void hanoi(int n, int start, int target, int support) {
	        if(n == 1){
	            answer.add(new int[]{start,target});
	            return;
	        }
	        hanoi(n-1,start,support,target);
	        
	        answer.add(new int[]{start,target});
	        
	        hanoi(n-1,support,target,start);
	    }
	        
	    
	        
	}