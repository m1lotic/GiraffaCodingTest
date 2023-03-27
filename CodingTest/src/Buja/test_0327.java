package Buja; // syntax error
public class test_0327 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	/* 3월 20일
	 * 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if(s.length()==4 || s.length()==6){
            if(s.matches("[0-9]+")) // 살면서 정규식 첨써봄
            {
                answer =true; 
            } 
        }
        return answer;
    }
}
	 
	 */
	/* 3월 21일 부족한 금액 계산하기 
	 * class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        for(int i=1; i<=count;i++)
        {
            answer += (price*i);
        }
        answer = (answer>money) ? (answer-money): 0;
        return answer;
    }
}
	 */
	
	/* 3월 22일 행렬의 덧셈
	 * class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        if(arr1.length==1){
            answer[0][0] = arr1[0][0]+arr2[0][0];
        }
        else{
            for(int i=0;i<arr1.length;i++)
            {
                for(int j=0;j<arr2[0].length;j++)
                {
                   answer[i][j] = arr1[i][j]+arr2[i][j]; 
                }
            }
        }
        
        return answer;
    }
}
	 */
	
	/* 3월 23일 직사각형 별찍기
	 * 
	 * import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for(int i=0;i<b;i++)
        {
            for(int j=0;j<a;j++)
            {
                System.out.print('*');
            }
            System.out.println();
        }
        
    }
}
*/
	
	/* 3월 24일 최대공약수와 최소공배수 (정모로 인해 3월 23일 작성)ㄴ
	 * 
	 * class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
 
        if(n>=m)
        {
            for(int i=1 ; i<=m ; i++)
            {
                if(n%i==0 && m%i==0){
                     answer[0]=i;
                     answer[1]=(n/i)*(m/i)*i;
                }
                  
            }
        }
        else
        {
             for(int i=1 ; i<=n ; i++)
            {
                if(m%i==0&& n%i==0){
                    answer[0]=i;
                    answer[1]=(n/i)*(m/i)*i;
                    }
            }
        }
        return answer;
    }
}
	 */
//} 
 

