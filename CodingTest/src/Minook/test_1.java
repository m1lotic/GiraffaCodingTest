package Minook;

import java.util.Vector;

public class test_1 {
	
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	public static void main(String[] args) {

		System.out.println(solution());

	}
	
	
	//1. 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
   
//    public String solution(int num) {
//    String answer = "";
	
//    if(num%2==0){
//        answer = "Even";
//    }else{
//        answer = "Odd";
//    }
//        return answer;
//    }
	
	
	//2. 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.
	
//     public double solution(int[] arr) {
//    double answer = 0;
//    
//    for(int i=0; i<arr.length; i++){
//       answer += arr[i];
//    }
//        
//    answer /= arr.length ;
//    
//        return answer;
//    }
	
	
	//3. 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
	
//    public int solution(int n) {
//        int answer = 0;
//   
//        for(int m=1; m<=n; m++){ 
//        if(n%m==0){
//        answer += m;
//        }
//     }
//        return answer;
//     }
	
	
	//4. 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
	
//    public int solution(int n) {
//        int answer = 0;
//
	// 10으로 나눈 나머지 값 활용법
//        while(n>0){
//        answer += n%10;
//        n /= 10;
//        }
	// 문자열로 변환
//    String s = Integer.toString(n); //int n을 String으로 변환
//    
//    for(int i=0; i<s.length(); i++){
//        answer += Integer.parseInt(s.substring(i, i+1));
//    }
//        return answer;
//    }
	
	
	//5. x만큼 간격이 있는 숫자.
	
//    public long[] solution(int x, int n) {
//        
//        long[] answer = new long[n];
//        long num = x;
//        
//        for(int i=0; i<answer.length; i++){
//	        answer[i] = num*(i+1);
//	    }
//        
//        return answer;
//    }
    
    
	
}
