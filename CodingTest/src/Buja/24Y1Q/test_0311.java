package Buja; // syntax error
public class test_0311 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 삼각 달팽이
	/* 해결일 : 3월 17일 11시 32분
	   문제점 : 처음에는 1차원 배열에 직접 밀어넣으려고 했는데
	           너무 복잡해져서 포기하고
	           2차원 배열로 구했다
	           결국 2차원 배열에 활성화 된 삼각형만 처리하고
	           나머지는 무시하는 그런 방향으로 하니까
	           되더라
	*/           

	import java.util.*;

	class Solution {
	    public int[] solution(int n) {
	        int[][] triangle = new int[n][n];
	        int len = n*(1+n)/2; // 달팽이 크기
	        int[] answer = new int[len];
	        
	        // 배열 채우기
	        for (int i = 0; i < n; i++)            Arrays.fill(triangle[i], 0);
	        
	        
	        // 아래 -> 오른쪽 -> 위 (패턴 3개)
	        
	        int x = -1;
	        int y = 0;
	        int cnt = 1;
	        
	        for(int i =0;i<n;i++){
	            for(int j=i;j<n;j++){
	                // 아래
	                if(i%3==0){
	                    x++;
	                }
	                // 오른쪽
	                else if(i%3==1){
	                    y++;
	                }
	                else if(i%3==2){
	                    x--;
	                    y--;
	                }
	                
	                triangle[x][y] = cnt;
	                cnt++;
	            }
	        }
	        
	        cnt =0;
	        
	        for(int i=0;i<n;i++){
	            for(int j=0;j<n;j++){
	                if(triangle[i][j]==0) continue;
	                
	                answer[cnt++] = triangle[i][j];
	           //     System.out.println(triangle[i][j]);
	            }
	        }
	        
	        return answer;
	    }
	}


	/*
	        
	        // 필요한 개수 산출
	        int len = n*(1+n)/2; // 달팽이 크기
	        int n_temp = n;
	        int[] answer = new int[len];
	        
	        int seq = 1; // 1번부터 산출하는 수        
	        int temp= 0; // 임시적으로 계산하는 수;
	        
	        while(n>0){
	            
	          // 위 -> 아래
	            for(int i = 1; i<=n; i++){
	             temp =((i*i-i+2)/2)-1;
	            answer[temp] =i;
	            seq+=1;
	          }
	         n-=1;
	            
	          // 왼쪽 -> 오른쪽
	          for(int i=1;i<=n;i++){
	              answer[temp+i] = seq;
	              seq+=1;
	          }
	         n-=1;
	            
	          // 아래 -> 위
	            for(int i =n+2; i>1; i--){
	             temp =((i*i-i+2)/2)-2;
	            System.out.println(n+ "   i "+i+" temp "+temp+" seq "+seq);
	            answer[temp] =seq;
	                System.out.println(temp);
	            seq+=1;
	          }
	             System.out.println("3번째"+n);
	             n-=1;
	        }

	*/
