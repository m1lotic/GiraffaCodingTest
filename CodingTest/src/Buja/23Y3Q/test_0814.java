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