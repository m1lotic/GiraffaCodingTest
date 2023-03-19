package Minook;

import java.util.ArrayList;

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
	
	//6.array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
	//	divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
	
//	public int[] solution(int[] arr, int divisor) {
//        Arrays.sort(arr);
//        ArrayList<Integer> answer = new ArrayList<Integer>();
//        int cnt = 0;
//        for(int i = 0; i<arr.length; i++){
//            if(arr[i]%divisor==0){
//                answer.add(arr[i]);
//                cnt++;
//            }
//        }
//        if(cnt == 0){
//            answer.add(-1);
//        }
//         
//        int[] result = answer.stream().mapToInt(Integer::intValue).toArray();
//        return result;
//    }
	
	//7.전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 
//	나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.
	
//	  public String solution(String phone_number) {
//	        String answer = "";
//	        for(int i = 0; i<phone_number.length(); i++){
//	            if(i>=phone_number.length()-4){
//	                 answer += phone_number.substring(i,i+1);   
//	            }else{
//	                answer += "*";
//	            }
//	        }
//	        return answer;
//	    }

	//8.음양 더하기
	
//    public int solution(int[] absolutes, boolean[] signs) {
//        int answer = 0;
//        
//        for(int i = 0; i<absolutes.length; i++){
//            if(signs[i]){
//                answer += absolutes[i];   
//            }else{
//                answer -= absolutes[i];
//            }
//        }
//        
//        return answer;
//    }

	//9.정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 
//	단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요 	
	
//    public int[] solution(int[] arr) {
//        int min = arr[0];
//        int x = 0;
//        ArrayList<Integer> result = new ArrayList<Integer>();
//        if(arr.length==1){
//        	result.add(-1);
//        }else{
//            for(int i =0; i<arr.length; i++){
//                if(arr[i]<=min){
//                min = arr[i];
//                x = i;
//                }
//            }
//            for(int j=0; j<arr.length; j++){
//                if(j!=x){
//                result.add(arr[j]);
//                }
//            }
//        }
//        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
//        return answer;
//    }
	
	//10. 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. 
//	numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

//	 public int solution(int[] numbers) {
//	        int answer = 0;
//	        for(int i = 0; i<numbers.length; i++){
//	            answer += numbers[i];
//	        }
//	        answer = 45 - answer; 
//	        return answer;
//	    }

	//sdsd
}
