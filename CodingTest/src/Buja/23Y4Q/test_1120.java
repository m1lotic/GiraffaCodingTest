package Buja; // syntax error
public class test_1120 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기

	// H-Index

  /* 해결일 : 11월 18일 오후 6시 37분
   문제점 : 문제 난이도가 높아지면서, 기술적인 부분보다는
           수학적인 사고력이 많이 필요로 하는 것 같다.
           수학 공부에도 신경써야겠다.
*/
	/* 해결일 : 11월 25일 오후 10시 42분
	   문제점 : 이 문제는, 현업이 요구사항을 정확하게 전달하는 것이
	           얼마나 중요한 지를 깨달을 수 있는 문제이다.
	           문제의 설명대로 하면 풀 수가 없고,
	           원래 H-index의 정의대로 풀어야 한다.
	           정의 : "해당 저자/저널이 h번 이상 인용된 h개 이상의 논문을 출판한 h의 최댓값"
	           처음에는 high / low로 따져서 나눠서 비교하고 그랬었는데 그런 짓 필요없고
	           정의대로 하면 문제 해결된다.
	           최댓값이므로 이론상 나올 수 있는 최대의 수부터 하나씩 낮춰가면서
	           비교하면 문제 없다.
	*/
	           
	import java.util.*;
	class Solution {
	    public int solution(int[] citations) {
	        int answer = 0;
	        int len    = citations.length;
	        int max    = citations[len-1]; // 최댓값
	        int high   = 0;                // 비교용(h 기준값 초과했는지)
	        Arrays.sort(citations);
	      //  System.out.println(Arrays.toString(citations));
	        
	        if(citations[len-1]>len) max=len;
	        if(len==1)  return 0;
	        
	        // 최댓값부터 비교
	        for(int i=max;i>0;i--)
	        {
	            for(int j=0;j<len;j++)
	            {
	                if(citations[j]>=i)     high++;
	             //   System.out.println("값 : "+i+"기준 "+high+" "+low);
	            }
	            if(high!=0){
	                    if(high >= i){
	                        answer = i;
	                        return i;
	                      //  break;
	                    }
	            }  
	            //    System.out.println("값검증"+high+" "+(len-low)+" i값 "+i);
	             //   System.out.println("");
	                high=0;
	        }
	        
	        return answer;
	    }
	}