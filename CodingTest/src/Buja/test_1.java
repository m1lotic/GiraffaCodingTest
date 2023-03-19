package Buja; // syntax error
public class test_1 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	/* 1. 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
	public static void main(String[] args) {
		class Solution {
		    public int solution(int n) {
		        int answer = 0;
		        for(int i=1; i<=n;i++)
		        {
		            if(n%i==0)
		                answer +=i;
		        }
		        return answer; // test
		    }	
		}
	}
	*/
	
	/* 2. 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.
	 * class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        
        for(int i = 0; i<arr.length;i++)
        {
            answer += arr[i];
        } 
        answer /= arr.length;
        return answer;
    }
}
*/
	/*3.  정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
	 * class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n;i++)
        {
            if(n%i==0)
                answer +=i;
        }
        return answer;
    }
    
}
	 */
	
	/*4. 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
import java.util.*;
public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while(n>0)
        {
            answer = answer + (n%10);
            
                n /= 10;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        return answer;
    }
}
/* 5. 함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 
 * class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        for(int i =0; i<n;i++)
        {
            answer[i]= (long)x * (i+1);
        }
        return answer;
    }
}
 */
/*
6. 자연수 뒤집어 배열로 만들기
*/
	/* 7. 문자열 내 p와 y의 개수
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p =0;
        int y= 0;
        for(int i =0;i<s.length();i++)
        {
            if(((s.charAt(i)) == 'p')|| ((s.charAt(i)) == 'P'))
            {
                p+=1;
            }
            else if(((s.charAt(i)) == 'y')|| ((s.charAt(i)) == 'Y'))
            {
               y+=1;
            }
            
        }
        
        if(p==y)
        {
            answer = true;
        }
        else
        {
            answer=false;
        }
        return answer;
    }
}
/* 8. 정수 제곱근 판별
 * class Solution {
    public long solution(long n) {
        for(long i=0;i<500000000;i++)
        {
            if((i*i)==n)
            {
                return ((i+1)*(i+1));
            }
        }
        return -1;
    }
}
*/
/*	9. 나머지가 1이 되는 수 찾기
class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int x=1;x<=1000000;x++)
        {
            if(n%x==1)
            {
                answer =x;
                break;
            }
        }
        return answer;  
    } 
}
*/
//}


