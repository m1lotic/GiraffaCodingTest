package Buja; // syntax error
public class test_0828 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 기사단원의 무기

	/* 해결일 : 29일 22시 03분
	   문제점 : 처음에는 무식하게 완전탐색으로
	           1번부터 쫙 풀었더니
	           10초안에도 못푸는 문제가 발생했다.
	           
	           그래서 방법을 찾아보니
	           나누기 2를 해라
	           제곱근을 해라
	           온갖 방법이 있어 시도해도 안되었다.
	           
	           제곱근을 썼는데 안되는게, 원인은
	           100/10 = 10 같이 약수가 2개가 나오는 부분을
	           어떻게 처리하는 지가 중요한 부분이었다.
	           
	           따라서, 약수가 중복이면 1만 더하고
	           나머지는 2만 더하도록 계산했고, 문제가 풀렸다.
	          
	import java.util.*;

	class Solution {
	    public int solution(int number, int limit, int power) {
	        int divid_cnt =0;// 약수 개수
	        int iron = 0; // 철의 양
	        
	        // 기사 번호 당 계산
	        for(int i = 1; i<=number; i++){
	            for(int j=1; j<=Math.sqrt(i);j++){
	            // j가 i의 약수가 되는지
	              if(i%j==0){
	              if(i/j == j)  divid_cnt+=1;
	              else          divid_cnt+=2;
	            }
	            }
	          //  System.out.println(divid_cnt);
	            if(divid_cnt > limit) iron += power;
	            else iron += divid_cnt;
	            
	            divid_cnt =0;
	        }
	        
	        return iron;
	    }
	}
	 */
	
	// 약수의 개수와 덧셈
	/* 해결일 : 8월 30일 21시 46분
	   문제점 : 정답이 맞는데 풀이가 틀려서 다시 봤다.
	            만약 약수를 /2를 해서 구한다면
	            자기자신의 수가 빠지므로
	            약수의 개수는 0개에서 카운트가 아니고 1에서
	            카운트를 시켜줘야한다.
	            
	
	class Solution {
	    public int solution(int left, int right) {
	        int answer = 0;
	        int divid_cnt=1; // 자기 자신 수
	        while(left<=right){
	            for(int i = 1; i<=left/2;i++)    if(left%i==0) divid_cnt++;
	            
	            System.out.println(divid_cnt);
	            if(divid_cnt%2==0) answer += left;
	            else answer -= left;
	            divid_cnt=1;
	            left++;
	        }
	        return answer;
	    }
	}*/