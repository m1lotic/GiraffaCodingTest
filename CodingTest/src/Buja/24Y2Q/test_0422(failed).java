package Buja; // syntax error
public class test_0422 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 숫자블록
	/* 해결하지못함(효율성)
	           
	*/
	import java.util.*;

	class Solution {
	    public int[] solution(long begin, long end) {
	        long len = end - begin + 1;
	        int[] answer = new int[(int)len];
	 

	        // 	100000014, 100000015, 100000016 3개보는거임
	        
	        // 나눠지는 수는 1부터 end까지 다 봐야하고
	        // 나눠지는 수는 begin이 처음이고
	        // 하지만 1000만을 넘기면은 안됨
	        // 나눠지는 수의 개수만큼 answer 배열 요소 만들면 됨
	        for(long i=1;i<end;i++){
	            for(long j=begin;j<=end;j++){
	                long tmp = -begin +j;
	                if(j!=i && i%j <=10000000){
	                    if(j % i == 0) answer[(int)tmp] = (int)i;
	                }
	            }
	        }
	        
	        return answer;
	    }
	}
