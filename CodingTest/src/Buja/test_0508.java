package Buja; // syntax error
public class test_0508 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	/* 해결일 : 5월 9일
	   문제점 : 프로그래밍 실력의 한계로 인해
	   3중 for문으로 해결할 수 밖에 없었고
	   결국 시간이 길어졌다.
	   분명 어차피 아스키코드값은 정해져있으니
	   다른 방법 있지 않을까?
	   다행인건, 아스키코드 변환 방법을 옛날에 비해
	   덜 복잡하게 수행했다는 점이다. 
	   (반례 찾기가 어려워서 질문하기를 참고했다)\
	

	class Solution {
	    public String solution(String s, String skip, int index) {
	        String answer = "";
	        int[] intSkip = new int[skip.length()];
	        int[] intS    = new int[s.length()];
	        for(int i=0;i<skip.length();i++) intSkip[i] = (char)skip.charAt(i);// skip 대상값
	        for(int i=0;i<s.length();i++) intS[i] = (char)s.charAt(i);// s 대상값(바꿔질 값)
	        
	            
	        for(int j=0;j<s.length();j++){ 
	           for(int k=0;k<index;k++){  // 인덱스를 1씩 올려보며 검사
	                  intS[j] +=1; // 무조건 값 1은 올려야함
	               for(int h=0;h<skip.length();h++){ // 스킵값을 하나씩 올리면서 검사
	                    if(intS[j]>122) intS[j]-=26;
	                   if(intS[j]==intSkip[h]) 
	                   {    
	                       intS[j] +=1;
	                       if(intS[j]>122) intS[j]-=26;
	                         h=-1; // h값 초기화
	                   }
	               }
	           }
	        }
	        
	         for(int i=0;i<s.length();i++) answer += ((char)intS[i]); //answer 값  출력
	        
	        return answer;
	    }
	}
	
	*/

