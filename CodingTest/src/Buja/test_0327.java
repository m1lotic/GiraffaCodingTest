package Buja; // syntax error
public class test_0320 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	/* 3월 27일 같은 숫자는 싫어(스택/큐)
	 * 
	 * import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = new int[arr.length];
        
        int z=1;
        answer[0]=arr[0];
        for(int i = 1; i<arr.length;i++)
        {
            if(arr[i]!=arr[i-1])
            {
                answer[z]=arr[i];
                 
                 z++; 
               
            }
        }
        
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        
        int[] answer2 = new int[z];
        for(int j=0;j<z;j++)
        {
           answer2[j]=answer[j];
                
         
        }
        return answer2;
    }
}
	 */
	
	/* 3월 28일 3진법 뒤집기
	 * class Solution {
    public long solution(int n) {
        long answer = 0;
        String strn = String.valueOf(n);
        long Jin_3 = Long.parseLong(Long.toString(n,3));
        long Jin_3_Reverse =0;
        int i=0;
        
        while(Jin_3!=0){
            Jin_3_Reverse = Jin_3_Reverse*10+Jin_3%10;
            Jin_3 /=10;
        }     
                while(Jin_3_Reverse!=0){
            answer+=Jin_3_Reverse%10*Math.pow(3,i);
            Jin_3_Reverse /=10;
                    i++;
        }      
 
       
        return answer;
        
        
    }
}
	 */

	/*3월 29일 이상한 문자 만들기 (왜 되는지모름)
	 * import java.util.*;

class Solution {
	public String solution(String s) {
		String answer = "";
		char[] word = s.toCharArray();
		int odd = 1; // 0이 짝수임

		for (int i = 0; i < word.length; i++) {
			if (word[i] == ' ') {
				answer += ' ';
				odd = 0;
			}

			if (odd == 0) {
				if (word[i] <= 90 && word[i] >= 65) // 대문자 검사
				{
					answer += (char) (word[i] + 32); // 대문자는 그대로

				}
				if (word[i] >= 97 && word[i] <= 122) // 소문자 검사
				{
					answer += (char) (word[i]); // 소문자를 대문자로
				}
				odd = 1;
			} else if (odd == 1) {
				if (word[i] <= 90 && word[i] >= 65) {
					answer += (char) (word[i]);
				}
				if (word[i] >= 97 && word[i] <= 122) {
					answer += (char) (word[i] - 32);
				}
				odd = 0;
			}

		}

		return answer;
	}
}

	 */
	
	/* 3월 30일 예산(오름차순 정렬로 해결)
	 * import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum=0;
        Arrays.sort(d);
             
         for(int i=0;i<d.length;i++)
        {
            if(budget<d[i])
            {
                break;
            }
            System.out.print(d[i]);
            budget -=d[i];
            answer+=1;
        }
        
        
        return answer;
    }
}
	 */
	/* 3월 31일 시저 암호(민욱이 코드 스타일 반영 -> 수정일 4월 3일)
	class Solution {
	    public String solution(String s, int n) {
	        String answer = "";
	        char[] charArr = s.toCharArray();
	        
	        for(int i=0;i<charArr.length;i++)
	        {
	            if(charArr[i]==' ') // 공백처리
	            {
	                answer += charArr[i];
	            }
	            // 소문자 65~ 90 대문자 97~122
	            if(charArr[i]<=90 && charArr[i]>=65)
	            {
	                if(charArr[i]+n>90)  answer += (char)(charArr[i]-26+n);
	                else                 answer += (char)(charArr[i]+n);
	            }
	                if(charArr[i]<=97 && charArr[i]>=122)
	            {
	                if(charArr[i]+n>122)  answer += (char)(charArr[i]-26+n);
	                else                  answer += (char)(charArr[i]+n);
	            }
	            
	            
	                        if(charArr[i]<=122 && charArr[i]>=97)
	            {
	                if(charArr[i]+n>122)  answer += (char)(charArr[i]-26+n);
	                else                 answer += (char)(charArr[i]+n);
	            }
	                if(charArr[i]<=97 && charArr[i]>=122)
	            {
	                if(charArr[i]+n>122)  answer += (char)(charArr[i]-26+n);
	                else                  answer += (char)(charArr[i]+n);
	            }
	        }
	        
	        
	        
	        
	        return answer;
	    }
	}
  
	 */
//} 
	


