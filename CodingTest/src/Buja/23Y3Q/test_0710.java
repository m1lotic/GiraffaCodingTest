package Buja; // syntax error
public class test_0710 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 완주하지 못한 선수
	/* 해결일 : 7월 13일 0시 13분
	   문제점 : 이 문제는 다른 알고리즘을 쓰면 금방 풀리는데,
	           그러니까 주어진 두 배열을 sort 후 비교해서
	           빼버리거나 하면 답이 쉽게 나오는 부분인데
	           hash로 하니까 너무 꼬이고 꼬였다..
	           getOrDefault라는 찾는 키가 있으면 찾는 키를 반환하고
	           그렇지 않으면 디폴트 값을 반환하는 코드를
	           사용해보는 것도 좋은 아이디어이다.
	           
	           hash로 구현하다보니 예상 시간이 너무 길어졌다
	           검색하는 시간도 길어지고..
	          
	*/
import java.util.*;

class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hashMap = new HashMap<>();

		// hashMap에 배열 값을 집어넣는 모습
		for (int i = 0; i < participant.length; i++) {
			try {
				if (hashMap.containsKey(participant[i]))
					hashMap.put(participant[i], hashMap.get(participant[i]) + 1);
				else
					hashMap.put(participant[i], 1);
			} catch (NullPointerException e) {
				System.out.println("Error!");
			}
		}
		// hashMap에 도착한 사람 명단 하나씩 제끼기
		for (int i = 0; i < participant.length - 1; i++) {
			try {
				if (hashMap.containsKey(completion[i]))
					hashMap.replace(completion[i], hashMap.get(completion[i]) - 1);
			} catch (NullPointerException e) {
				System.out.println("Error!");
			}
		}

		// hashMap에서 value가 1이면(도착 못한사람) 그 key가 답임. hashMap는 자동으로 iteration 지원안해서 별 수 없음
		for (Map.Entry<String, Integer> entry : hashMap.entrySet()) { // key 반환하기 위한 entry 만들기
			if (entry.getValue() == 1)
				return entry.getKey();
		}

		return answer; // 빈값(오류)
	}
}

// 멀리 뛰기
/*  해결일 : 7월 15일 22시 25분
    문제점 : 이 문제는 수학 문제이다.
            일반화를 시키고 문제를 풀면 된다고 생각해서
            처음엔 조합으로 접근했다.
            조합으로 풀어도 될텐데 정확한 값을 계산해주는 게 어려워서
            정답 수열을 분석해보았다
            1 2 3 5 8 13 21.. 
            이것은 명백한 피보나치 수열이었다.
            일반화 된 값은 피보나치 수열이니까
            피보나치 수열 값을 구하는 로직을 구현했다.
            물론 이럴 때, 1234567로 나눈 나머지니까
            answer 값이 1234567이 넘으면, 나머지를 리턴하도록 설정해야 한다.
            백업 코드로 내가 고민했던 코드를 첨부해두었다.
*/

class Solution {
     
    public long solution(int n) {
 
        long answer =3;
        long fibo_One = 1;
        long fibo_Two = 2;
        
        if(n==1) return fibo_One;
        if(n==2) return fibo_Two;
        if(n==3) return answer;
        
        
        for(int i=4;i<=n;i++)
        {
            fibo_One = fibo_Two%1234567;
            fibo_Two = answer%1234567;
           // System.out.println(fibo_One + " "+fibo_Two);
            answer = ((fibo_One) + (fibo_Two))%1234567;
        }
        return answer;
    }
}      

/* 백업용 코드
for(int i=2;(n-i)>i;i++)
        {
            for(int j=1;j<i+1;j++)
            fact_one *= (n-j);
          //  System.out.println("분자테스트 : "+fact_one);
            for(int k=1;k<=i+1;k++) fact_two *= k; // ex) 1*2, 1*2*3
         //   System.out.println("분모 : "+fact_two);
            combination = fact_one/fact_two;
        //    System.out.println("더할 값: "+combination);
            answer += combination;
            
            //팩토리얼 6c1 5c2 같은거
            //param : 첫숫자(6) 몇번 곱해야 하나?(1) 
            
            factorial()
            
            
            fact_one=1;
            fact_two=1;
            
        }
        */

/* 백업코드 2
   public long factorial(int n, int i, int k) {
        
        long result=n;
        int  cnt_N = n-1;
        // 돌리는 횟수
        
        if(k==1){
            for(int j=1;j<i;j++)
        {
            result *= cnt_N;
            cnt_N--;
                
            //    System.out.print(j +" ");
        }
     //   System.out.println(n+" 기준 "+ i+"번 돌린 결과값 "+result);
        if(result==0) return 1;
        
        return result;
        }
        
        if(k==2){
            cnt_N=n;
            for(int j=1;j<=i;j++)
        {
            result *= cnt_N;
            cnt_N++;
        }
       // System.out.println(n+" 기준 "+ i+"번 돌린 결과값 "+result);
        if(result==0) return 1;
        
        
        }
        return result;
    }
*/

/*      백업코드3(solution 메소드)
long answer = 1;
        long fact_one = 1;
        long fact_two = 1;
        long combination = 0;
        long origin_N = n; // N값 따로 수집
        int i=0;
        
        // 일반화 식 1+nC1 + (n-1)C2 + (n-2)C3+... 
        // 단, C우측 숫자가 (n-i)보다 커질수는 없음
        
        
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 3;
        
        answer += n-1;
        
        // 4c2가 처음 즉 분자는 4*3=12, 분모는 2*1=2
        for(i=2;i<origin_N;i++)
        {        
            //팩토리얼 6c1 5c2 같은거
            //param : 첫숫자(6) 몇번 곱해야 하나?(1) 
            
            if(n>i)
            {
           // System.out.println(n-2+"C"+i);
            fact_one=factorial(n-2, i, 1);
            fact_two=factorial(1  , i, 2);
            
            answer+= fact_one/fact_two;
          //  System.out.println(answer);
            n--;
            }
            
            
            
        }
        
        */
