package Buja; // syntax error
public class test_0408 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 할인행사
	/* 해결일 : 4월 14일 오후 8시 16분
	   느낀점 : 이번 문제는 Map을 이용해서 간결하게 풀었다.
	           내가 원하는 품목과 10일치 할인 품목 다 집어넣어서
	           완전히 동일하면 true 반환해서 계산하였다.
	           HashMap은 이렇게 사용하는게 정석적인 방법 같다.
	*/         

	import java.util.*;

	class Solution {
	    public int solution(String[] want, int[] number, String[] discount) {
	        int answer = 0;
	        HashMap<String,Integer> discountMap  = new HashMap<>(); // 할인 품목 계산
	        HashMap<String,Integer> wantMap  = new HashMap<>(); // 내가 원하는 품목 계산
	        
	        for(int i=0;i<want.length;i++) wantMap.put(want[i], number[i]); // 내가 원하는 품목 Map에 집어넣기
	        
	      //  wantMap.forEach((k,v) -> System.out.println(String.format("Key  %s, Value %s", k, v)));
	        
	        // 첫날부터 할인 마지막날까지(회원 유효기간 10일이라 10일치 봐야 함)
	        for(int day = 0; day<= discount.length-10; day++){
	            for(int j = day; j < day+10;j++){
	                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
	            }
	       //     discountMap.forEach((k,v) -> System.out.println(String.format("할인지도 Key  %s, Value %s", k, v)));
	            
	            // 결국 할인 품목과 내가 원하는 품목의 key, value가 모두 동일하면 맞는거임
	            if(discountMap.equals(wantMap)) answer++;
	            
	            // 비교 끝났으면 초기화 해야 함
	            discountMap.clear();
	        }
	        
	        
	        return answer;
	    }
	}