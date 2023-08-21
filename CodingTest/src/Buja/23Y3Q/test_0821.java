package Buja; // syntax error
public class test_0821 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 성격 유형 검사하기

/*	  해결일 : 8월 21일 20시 54분
     문제점 : 이 문제는 저번주 실패율보다 쉽다
            근데 성공률이 왜 낮은가..
            
            이게 국어가(요구사항이) 길다 보니까
            사람들이 독해를 못해서(공대 특...)
            해석을 못해서 문제를 못푸는거다.
            
            이 문제는 안타깝지만 하드코딩을 강제로 해야하는 문제이다.
            survey 배열에 없는 성격 유형도 출력을 시켜줘야 하기에..
            
            사람들에 따라 점수까지 하드코딩 했던데
            나는 하드코딩 지양 원칙에 따라 필요한 만큼만 했다.
            
            실무 코드는 로직 단위로 쪼개서 만드니까
            나도 자연스럽게 그렇게 하게 된다(아침부터 저녁까지 그런 코드 보면 누구나 그렇게 될거다..)

            
            
import java.util.*;
class Solution {
    // 성격 점수를 계산할 hashMap(전역 변수)
    HashMap<String,Integer> personalMap = new HashMap<>();
    
    // 각 질문 별 성격 유형 점수를 계산하는 로직(본 로직)
    public HashMap<String,Integer> calculateChoicesPoint(int i, int j, int k, String[] survey, int[] choices) {
                if(personalMap.containsKey(survey[i].substring(j,k))){
                   int oldPoint = personalMap.get(survey[i].substring(j,k));
                   personalMap.put(survey[i].substring(j,k),Math.abs(choices[i]-4)+oldPoint);
                }                   
                else personalMap.put(survey[i].substring(j,k),Math.abs(choices[i]-4));
                    
             return personalMap;
    }
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String[] types = {"R","T","C","F","J","M","A","N"};
        
        // 각 질문 별 성격 유형 점수를 계산하는 로직
        for(int i=0;i<choices.length;i++){
            if(choices[i]<4){
               calculateChoicesPoint(i,0,1,survey,choices);
            }
            if(choices[i]>4){
               calculateChoicesPoint(i,1,2,survey,choices);
            }
        }
        
        // 각 질문 별 성격 유형 점수를 계산하는 로직
        for(int count = 0; count < types.length;){
        //    System.out.println(types[count]+"의 값"+personalMap.get(types[count]));
        //    System.out.println(types[count+1]+"의 값"+personalMap.get(types[count+1]));
            
            // NULL일 경우 0으로 처리(Optional Class)
            personalMap.put(types[count],Optional.ofNullable(personalMap.get(types[count])).orElse(0));
            personalMap.put(types[count+1],Optional.ofNullable(personalMap.get(types[count+1])).orElse(0));
            
            // 성격 유형을 출력해주는 로직
            if(personalMap.get(types[count])>=personalMap.get(types[count+1]))
               answer+=types[count];
          else answer+=types[count+1];
                
            count +=2; // 2칸씩 비교
        }
        
        return answer;
    }
}
*/

	// 서울에서 김서방 찾기
	/* 해결일 : 8월 21일 9시 19분
	   문제점 : 평소처럼 i를 0부터 순회하는 for 문 만들면
	           1분만에 풀리는데
	           그렇게 하지 않고 람다식으로 하려고 시도했다.
	           나중에 보니까 return에 answer 할 필요없이
	           그냥 바로 return해주면 되더라
	           단, 람다식이니 int 형 변수 하나는 필요하다.
	           그러면 결국 거기서 거기 아닌가?
	
	import java.util.*;

	class Solution {
	    public String solution(String[] seoul) {
	        String answer = "";
	        int idx = 0;
	        for(String count : seoul){
	            if(count.equals("Kim")){
	                answer +="김서방은 ";
	                answer +=idx;
	                answer +="에 있다";
	                break;
	            }
	            idx++;
	        }
	        return answer;
	    }
	}*/