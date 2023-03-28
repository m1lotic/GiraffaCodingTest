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
//} 
 

