package Buja; // syntax error
public class test_1106 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기

	// 광물캐기
	/* 해결일 : 11월 10일 오전 12시 16분
	   문제점 : 하단 코드는 그리디를 사용했다라고 한다
	           어차피 한번 곡괭이 들면 바꿀수가 없으므로
	           5개 씩 묶어서 시행을 한다.
	           단, 서로의 피로도가 다르기 때문에
	           돌 곡괭이를 드는 경우는 최후의 경우가 되어야 하고
	           돌 곡괭이 들 때 피로도가 크다면, 다이아몬드를 들 때
	           피로도가 작아지는 지 확인해야한다.
	           주의할 점은 5의 배수로 미네랄이 주어지는 건 아니라서
	           5의 배수가 아닐 경우 튕겨내야 한다.
	           
	           조건을 잘못 읽어서 처음에는 Map으로 했다가,
	           완전탐색으로 돌렸다가,
	           이런저런 방법을 해도 결국 안되서 하단과 같이 하게 되었다.
	           다음 문제부터는 문제풀이전에 어디에 예상 풀이를 써놓고 하던가해야..
	           
	*/
	import java.util.*;
	class Solution {
	    
	    
	    public int solution(int[] picks, String[] minerals) {
	        int answer = 0;
	        
	        // 마지막 (5개 단위로 했을 때) 세기
	        int cnt    = Math.min(minerals.length/5+1,picks[0]+picks[1]+picks[2]);
	      //  System.out.println(cnt);
	        int[][] fiveminerals = new int[cnt][3];
	        int[] temp = new int[3];
	       //  System.out.println(temp[0]);
	        for(int i=0;i<minerals.length;i+=5){
	            //마지막 cnt 하고 끝
	            if(i/5==cnt) break;
	            
	            for(int j=i;j<i+5;j++){
	                if(minerals[j].equals("diamond")){
	                    temp[0]+=1;
	                    temp[1]+=5;
	                    temp[2]+=25;
	                }
	                else if(minerals[j].equals("iron")){
	                    temp[0]+=1;
	                    temp[1]+=1;
	                    temp[2]+=5;
	                }
	                else if(minerals[j].equals("stone")){
	                    temp[0]+=1;
	                    temp[1]+=1;
	                    temp[2]+=1;
	                }
	                
	                // 배열 길이 초과 방지
	                if(j==minerals.length-1) break;
	            }
	            
	            fiveminerals[i/5][0]=temp[0];
	            fiveminerals[i/5][1]=temp[1];
	            fiveminerals[i/5][2]=temp[2];
	            
	            temp[0]=0;
	            temp[1]=0;
	            temp[2]=0;
	        }
	        
	        Arrays.sort(fiveminerals, Comparator.comparingInt((int[] arr) -> arr[2]).reversed());
	       
	        for(int i=0;i<cnt;i++){
	            if(picks[0]>0){
	                answer += fiveminerals[i][0];
	                picks[0]--;
	            }
	            else if(picks[1]>0){
	                answer += fiveminerals[i][1];
	                picks[1]--;
	            }
	            else if(picks[2]>0){
	                answer += fiveminerals[i][2];
	                picks[2]--;
	            }
	        }
	        return answer;
	    }
	    

	}