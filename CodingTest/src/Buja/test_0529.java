package Buja; // syntax error
public class test_0522 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 최댓값과 최솟값

	/* 해결일 : 5월 31일
	   문제점 : 이렇게 푸는게 맞나 싶어서 계속 풀었는데
	           결국 접근방안이 비슷했다.
	           특이한 점이라 하면
	           최대 최솟값이 어디일지 예측이 안가니
	           max min의 갭을 두고 구현을 했다는 특징이 있다.

	*/
/*
	class Solution {
	    public String solution(String s) {
	        String answer = "";
	        String[] split = s.split(" ");
	        long[] splitLong = new long[split.length];
	        long max = -999999998;
	        long min = +999999999;
	        for(int i =0;i<split.length;i++) splitLong[i] = Long.parseLong(split[i]);
	        
	        for(int i =0;i<split.length;i++){
	            if(splitLong[i]>max) max = splitLong[i];
	            if(splitLong[i]<min) min = splitLong[i];
	        }
	        
	        answer = min +" "+max;
	        
	        return answer;
	    }
	}
	
	*/