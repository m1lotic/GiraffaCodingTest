package Buja; // syntax error
public class test_0605 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 푸드 파이트 대회

	/* 해결일 : 6월 6일
	   문제점 : 이 문제는 결국 음식 순서를 어떻게 배열할 것인지의 문제이다.
	          먼저 음식의 개수가 홀수면 배열이 안되니까 짝수로 바꿨다
	          그리고 중앙에 물 배치하고
	          나머지는 음식 절반씩 앞 뒤에 배치를 하였다.
	          for문 한번에 이렇게 수행하는 방법은 없을까?
	          지금 상황에서는 방법이 생각나지 않는다
	          언젠가 시도 해 봐야지
	
	           
	   
	class Solution {
	    public String solution(int[] food) {
	        String answer = "";
	        int    foodSum= 0; // 음식 몇개있는지 체크
	        
	        // food[i]가 홀수인 경우를 확인하여 짝수로 바꾼다(음식 하나 버린다)
	        for(int i=1;i<food.length;i++){ // 물 제외
	            if(food[i]%2==1)  food[i]-=1;
	            foodSum += food[i];
	        }
	        
	        // 음식의 배치(중간 이전까지)
	        for(int i=1;i<food.length;i++){
	            for(int j=0;j<food[i]/2;j++) answer += (i);
	        }
	        // 물의 양(1임)
	        answer += 0; 
	        
	        // 음식의 배치(중간 이후부터)
	        for(int i=food.length-1;i>0;i--){
	            for(int j=0;j<food[i]/2;j++) answer += (i);
	        }
	        
	        return answer;
	    }
	}
		
	}