package Minook;

import java.util.ArrayList;
import java.util.Vector;

public class test_1 {

	/*
	 * 인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR) EUC-KR(완성형,박)에서
	 * UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함. window - preference - workspace -
	 * utf8 window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	 */
	// ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	// ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	// alt+방향키 : 코드 순서 바꾸기

	public static void main(String[] args) {

		System.out.println(solution(118372));

	}

	// 1. 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.

//    public String solution(int num) {
//    String answer = "";

//    if(num%2==0){
//        answer = "Even";
//    }else{
//        answer = "Odd";
//    }
//        return answer;
//    }

	// 2. 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.

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

	// 3. 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

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

	// 4. 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.

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

	// 5. x만큼 간격이 있는 숫자.

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

	// 6. 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을
	// 리턴합니다.

//	public int[] solution(long n) {
//        String s = String.valueOf(n);
//        int[] answer = new int[s.length()];
//        for(int i=0; i<s.length(); i++){
//        answer[i] = Integer.parseInt(s.substring(s.length() - (i+1), s.length()-i));
//        }
//        return answer;
//    }

	// 7. 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
	// n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

//	 public long solution(long n) {
//	        long answer = 0;
//	        for(long x = 1; x*x<=n; x++){
//	            if(n==x*x){
//	                answer = (x+1)*(x+1);
//	            }else{
//	                answer = -1;
//	            }
//	        }
//	        return answer;
//	    }  

	// 8. 대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
	// s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요.
	// 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

//	boolean solution(String s) {
//        boolean answer = true;
//        int p=0;
//        int y=0;
//        for(int i=0; i<s.length(); i++){
//        if(s.substring(i,i+1).equals("p")||s.substring         (i,i+1).equals("P")){p+=1;}
//        else if(s.substring(i,i+1).equals("y")||s.substring(i,i+1).equals("Y")){y+=1;}
//        }
//        if(p==y){
//            answer = true;
//        }else{
//            answer = false;
//        }
//        
//        return answer;
//    }

	// 9. 함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.
	
//	public static long solution(long n) {
//		long answer = 0;
//		String s = "";
//
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		while(n>0){
//			arr.add((int) (n % 10));
//			n /= 10;
//		}
//	
//		int m = arr.get(0);
//		int x = 0;
//		int[] arri = new int[arr.size()];
//		for (int i = 0; i < arri.length; i++) {
//			for (int j = 0; j < arr.size(); j++) {
//				if (arr.get(j) >= m) {
//					m = arr.get(j);
//					x = j;
//				}
//			}
//			arr.remove(x);
//			arri[i] = m;
//			m = 0;
//			s += arri[i];
//		}
//
//		answer = Long.parseLong(s);
//
//		return answer;
//	}
	
	//10. 자연수 n이 매개변수로 주어집니다. n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요. 답이 항상 존재함은 증명될 수 있습니다.
	
//    public int solution(int n) {
//        int answer = 0;
//        
//        for(int i=1; i<n; i++){
//            answer += 1;
//            if(n%answer==1){
//                break;     
//            }
//        }
//        return answer;
//    }

}
