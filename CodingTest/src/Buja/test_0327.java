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
	
	/*3월 29일 이상한 문자 만들기(실패)
	 * import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] munja = s.split("");
        String[] ascii = new String[munja.length];
        int blank = 1; // 0 = odd(홀수), 1= even(짝수)
        
        for (int i = 0; i < s.length(); i++) {
            ascii[i] = Integer.toString((int)s.charAt(i)); 
            
                if (i % 2 == 0) { //짝수
                    if (Integer.parseInt(ascii[i]) > 97) {
                        ascii[i] = Integer.toString((int)s.charAt(i) - 32);
                    }
                } else { // 홀수
                    if (Integer.parseInt(ascii[i]) > 65 && Integer.parseInt(ascii[i]) < 90) {
                        ascii[i] = Integer.toString((int)s.charAt(i) + 32);
                    }
                }
                
                answer += (char)Integer.parseInt(ascii[i]); 
           
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
	/* 3월 31일 시저 암호(푸는 법을 몰겟음)
	 * class Solution {
    public String solution(String s, int n) {
        String answer = "";
        String[] arr = new String[s.length()];
        
        for(int i=0;i<s.length();i++)
        {
            
            
            arr[i]=Integer.toString(((int)s.charAt(i))+n);
            if(arr[i].equals('$'))
            {
             answer += " ";
                continue;
            }
            if(Integer.parseInt(arr[i]) >= 122)
            {
                arr[i]=Integer.toString((int)s.charAt(i)-26);
            }
            
            System.out.print(arr[i]+" ");
            answer += (char)Integer.parseInt(arr[i]);
        }
        
        
        return answer;
    }
}
	 */
//} 
 

