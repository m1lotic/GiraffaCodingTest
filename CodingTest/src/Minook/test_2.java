package Minook;

public class test_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(118372));
	}
	
	//1. 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
	
//	public int solution(String s) {
//        int answer = 0;
//        if(s.substring(0,1).equals("-")){
//         answer = Integer.parseInt(s.substring(1,s.length()))*(-1);
//        }else if(s.substring(0,1).equals("+")){
//            answer = Integer.parseInt(s.substring(1,s.length()));
//        }else{
//            answer = Integer.parseInt(s.substring(0,s.length()));
//        }
//        return answer;
//    }
	
	//2. 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 
	//	자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수
	
//	public boolean solution(int x) {
//        boolean answer = true;
//        int res = x;
//        int obj = 0;
//        
//        while(x>0){
//            obj += x%10;
//            x /= 10;
//        }
//        answer = (res%obj == 0) ? true : false;  
//        
//        return answer;
//    }

	//3. 두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
//	예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
	
//	 public long solution(int a, int b) {
//	        long answer = 0;        
//	        
//	        if(a==b){
//	            answer = (long)a;
//	        }else if(a>b){
//	            for(long i = b; i<=a; i++){
//	                answer += i;
//	            }
//	        }else if(b>a){
//	            for(long i = a; i<=b; i++){
//	                answer += i;
//	            }
//	        } 
//	        return answer;
//	    }

	//4. 콜라츠 추측 : 홀수일 경우 2로 나누고 짝수일 경우 3을 곱하고 1을 더함, 500번이 넘어갈 경우 -1 반환 /결과가 1일 때 횟수 반환
	
//	  public int solution(long num) {
//	        int cnt = 0;
//	        
//	        while(num!=1){
//	            if(num%2==0){
//	                num /= 2;
//	                cnt++;
//	            }else{
//	                num = num*3+1;
//	                cnt++;
//	            }
//	            if(cnt>=500){
//	                return -1;
//	            }
//	        }
//	        return cnt;
//	    }

	
	//5. String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요

//	 public String solution(String[] seoul) {
//	        String answer = "";
//	        int idx = 0;
//	        for(int i=0; i<seoul.length; i++){
//	            if(seoul[i].equals("Kim")){
//	                idx = i;
//	                break;
//	            }
//	        }
//	        answer = "김서방은 "+idx+"에 있다";
//	        return answer;
//	    }
	
	//6.
}
