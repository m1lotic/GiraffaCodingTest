package Buja; // syntax error
public class test_0814 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 폰켓몬

	/* 해결일 : 8월 16일 21시 53분
	   문제점 : 이것은 국어 문제인가..
	           어쨋거나 해시를 쓰면 되기는 한다
	           
	           중복인 부분을 걸러주고
	           1/2가 넘지만 않게 해주면 끝
	*/
	/*
	import java.util.*;

	class Solution {
	    public int solution(int[] nums) {
	        int answer = 0;
	    
	        HashMap<Integer, Integer> pokemonMap = new HashMap<>();
	        
	        // 해시에 값을 넣어준다
	        for(int num : nums)
	        {
	            pokemonMap.put(num,0);
	        }
	        
	        // hashMap의 크기만큼 출력을 돌려준다        
	        for(int key : pokemonMap.keySet())
	        {   
	            // 1/2를 넘길 수는 없으니
	            if(nums.length/2 <= answer)        break;
	            answer +=1;
	            
	                
	        }
	        return answer;
	    }
	}/
	
	// 소수 만들기
	/* 해결일 : 8월 16일 22시 23분
	   문제점 :  3중 for문을 지양하기 위해 시도를 해보았는데
	            3중 for문을 사용안하고 풀기는 매우 어렵다..
	            안그러면 조합써야하는데..
	            조합쓰는게 이 풀이보다 더 복잡하다
	*/
	/*
	class Solution {
	    public int solution(int[] nums) {
	        int answer = 0;
	        int check =0; //소수체크(약수가 몇개인지?)
	        int sum = 0;
	        
	        // 3중 for문([1,2,3],4) 선택을 위함
	        for(int i=0;i<nums.length;i++)  //  (1),2,3,4
	        {
	            for(int j=i+1;j<nums.length;j++) // 1,(2),3,4
	            {
	                for(int z=j+1;z<nums.length;z++)// 1,2,(3),4
	                {
	                    sum += (nums[i]+nums[j]+nums[z]); // 수의 3개 합 구하기
	                    for(int k=2;k<=sum;k++) // 수가 소수인 지 검사
	                        if(sum%k==0)   check +=1;
	                    if(check==1)   answer +=1; // 소수인가 판결
	                    System.out.println(sum+" "+check);
	                    check=0;
	                    sum=0; // 값을 초기화함
	                }
	            }
	        }
	        return answer;
	    }
	}
	*/
	
	// 실패율
	/*  해결일 : 8월 20일 16시 58분
    문제점 : 이 문제가 어떻게 레벨 1인지를 모르겠다
    다른 건 문제가 없는데 마지막에 순위를 어떻게 표현할 것인지
    실패율은 나왔는데, 순위 때문에 많이 힘들었다
    전통적인 버블 소트를 써서 했다.
*/
	/*
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] failed = new int[N];
        int[] current = new int [N];
        int[] answer = new int[N];
        double[] failed_Percent = new double[N];
        int stage_Idx = 0;
        
        // 정답 행렬에 몇스테이지인지 수동 입력(순위 비교 위함)
        for(int i = 0; i<N;i++) answer[i] = i+1;
        
        
        // 클리어 기준 회차 조회
        for(int stage = 0; stage < stages.length; stage++)  stages[stage]--;
        
        // index가 0(1스테이지)부터 검색하기 위해
        Arrays.sort(stages);
        
        // 스테이지에 도달한 플레이어 수(player:플레이어의 현 스테이지)
        for(int stage = 0; stage < N; stage++){
            for(int player = 0; player < stages.length; player++){
             if(stages[player]>=stage) current[stage]++;
            }
        }
        
        // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 
       for(int stage = 0; stage < N; stage++){
            for(int player = stage_Idx; player < stages.length; player++){
             if(stages[player]<=stage) failed[stage]++;
            }
           stage_Idx += failed[stage];
           
        }
        
        // 실패율 계산
         for(int stage = 0; stage < N; stage++){
             failed_Percent[stage] = (double)failed[stage] / (double)current[stage];
             System.out.println(failed_Percent[stage]);
         }
        
        double tmp=0; // 순위 비교 임시값
        int  tmp2=0;
        
        // 순위 계산(버블 정렬)
        for (int stage = 0; stage < N - 1; stage++) {
            for (int i = 0; i < N - stage - 1; i++) {
                if (failed_Percent[i] < failed_Percent[i+1]) {
                    tmp = failed_Percent[i];
                    failed_Percent[i] = failed_Percent[i+1];
                    failed_Percent[i+1] = tmp;

                    tmp2 = answer[i];
                    answer[i] = answer[i+1];
                    answer[i+1] = tmp2;
                }
            }
        }
        
        return answer;
    }
}*/