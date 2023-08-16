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
	}