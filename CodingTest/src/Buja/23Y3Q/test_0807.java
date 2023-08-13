package Buja; // syntax error
public class test_0807 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 과일 장수

	/* 해결일 : 8월 7일 20시 42분
	   문제점 : 생각보다 시간이 오래걸렸다.
	          항상 단점이 문제가 어떤문제인지 파악하는게
	          좀 많이 늦다.
	          문제를 천천히 읽고 판단을 해야하는데
	          NCS나 수능 국어에 익숙하다보니 일단 급하게 접근하게되고
	          그만큼 문제 파악에 결국 시간이 더 걸리게 된다.
	          
	          이 문제는 사과를 한 상자에 몇 개를 담아내는 것인가가 핵심이다.
	          사과의 점수 행렬을 오름차순으로 정리하고(내림으로 해도된다)
	          그리고 높은 점수를 가진 사과부터 1개 씩 담기 시작한다.
	          박스가 다 찼으면 마지막에 넣은 사과의 점수를 확인한 후
	          그 점수와 박스에 들어있는 사과의 수를 더한다.
	          그리고 만약에 score 행렬의 인덱스가 0보다 작은데
	          값을 찾으려고 한다면 Exception을 띄우면서
	          결과값을 출력해준다.
	          사실 원래 음수가 되는 순간 탈출해주는게 좋은데
	          매번 음수인지 확인하는 불필요한 검사를 만들 필요는 없기 때문에
	          생략하였다.
	          */

	import java.util.*;

	class Solution {
	    public int solution(int k, int m, int[] score) {
	        int answer = 0;
	        int len_Score = score.length; //score길이
	        int revenue = 0; // 매출액(이익)
	        int min = 0; // 최저 사과 점수
	        int idx_Cnt=1; // 사과를 몇개 채웠는지
	        Arrays.sort(score);
	     //   System.out.println(Arrays.toString(score));

	            while(len_Score>=0)
	            {
	              //  System.out.println("현재 사과 채운개수:"+idx_Cnt);
	                if((idx_Cnt ==m))
	                {
	                    try{
	                        min = score[len_Score-1];
	                    }
	                    catch(ArrayIndexOutOfBoundsException e){
	                        break; //인덱스가 마이너스 가르키고 있을 때는 의도가 아니므로 제외함
	                    }
	                    
	                   // System.out.println("인덱스위치 "+(len_Score));
	                    
	                    answer += (min) * (m);
	                   // System.out.println(answer);
	                    idx_Cnt=0;
	                }
	                len_Score--;
	                idx_Cnt++;
	            }
	        
	                return answer;
	    }
	}



// 튜플
/* 해결일 : 8월 13일 16시 39분
   문제점 : 이 코드에 사용된 자바 기능들에 대한 공부가 많이 부족해서
           찾아보면서 짜는데도 잘 모르겠다.
           
           급하게 공부하면서 놓쳤던 자바기능을
           별도로 공부할 수 있도록 날짜를 잡아서
           따로 공부할 필요가 있다.
           
           찾으면서 했기 때문에 별도의 문제점 코멘트 작성은 어렵다.
           
*/

import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        // }{를 기준으로 배열로 나누기
        String[] s_Splited =s.split("\\},\\{");
        
        // 배열 크기가 작은 것 부터 정렬
        Arrays.sort(s_Splited,Comparator.comparingInt(split -> split.replaceAll("[{}]", "").split(",").length));
        
        // 순서를 고려하면서 중복 안되게 저장하도록 선언
        Set<Integer> resultSet = new LinkedHashSet<>();
        
        // 분할된 "튜플"을 추출하고 숫자를 추가
        for(String split : s_Splited){
             String[] stringNumbers = split.replaceAll("[{}]", "").split(",");
            
            for (String stringNumber : stringNumbers) {
                resultSet.add(Integer.parseInt(stringNumber));
            }
            
        }
        
        // 결과 배열 생성
        int[] answer  = new int[resultSet.size()];
        int idx = 0;
        // resultSet에 있는 숫자를 최종배열에 저장
        for(int number : resultSet){
            answer[idx++] = number;
        }

        
        return answer;
    }
}

/*
       // 스트링을 배열화 한다
        for(int i=2;i<s.length()-2;i++)
        {
            while(String.valueOf(s.charAt(i)).equals(",")) 
            {
                arr_cnt_2++;
                i++;
            }
             while(String.valueOf(s.charAt(i)).equals("{")) i++;
             while(String.valueOf(s.charAt(i)).equals("}"))
            {
                arr_cnt++;
                i++;
                arr_cnt_2 = 0;
            }
            tupleArray[arr_cnt][arr_cnt_2] = Integer.parseInt(String.valueOf(s.charAt(i)));
            System.out.println((s.valueOf(i)));

        }
        */
