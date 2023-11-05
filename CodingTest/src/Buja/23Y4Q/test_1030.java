package Buja; // syntax error
public class test_1030 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기

	// 영어 끝말잇기
	/*  해결일 : 11월 5일 20시 23분
    문제점 : 이 문제 해결하는데 시간이 많이 걸렸다.
            로직을 짜는게 어려운게 아니고
            예외가 너무많아서 예외 처리하는데 시간이 너무 많이 걸렸다.
            
*/            
            
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int   temp_one = 0;
        int   temp_two = 0;
        int   min =0;        
        // 똑같은 단어 말함
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(words[i].equals(words[j])){
                    
                    temp_one = (j+1);
                    
//                     // 도저히 방법 못찾겠어서(순서가 0,1,2 가 아닌 1,2,3 표현방법)
//                     // 하드 코딩 처리
                    if(((j+1)%n)==0)    answer[0] = n;
                    else                answer[0] = ((j+1)%n);
                    
                    answer[1] = (int) Math.ceil((double)(j+1)/n);
//                   //  System.out.println("1번 기준값 "+(j+1));
//                   //  System.out.println(answer[0]+" "+answer[1]);
                }    
            }
        }
        
        // 맨뒷글자와 맨앞글자가 다름
        for(int i=0;i<words.length-1;i++){
            char last  = words[i].charAt(words[i].length()-1); 
            char first = words[i+1].charAt(0); 
            if(last!=first){
                    temp_two = (i+2);
                    if((temp_two > temp_one) && temp_one !=0) return answer;
                    if(((i+2)%n)==0)    answer[0] = n;
                    else                answer[0] = ((i+2)%n);
                
                    answer[1] = (int) Math.ceil((double)(i+2)/n);
                
              //  // System.out.println("2번 기준값 "+ (i+2));
              // //  System.out.println(answer[0]+" "+answer[1]);
                 return answer;
                }
        }
        

        return answer;
    }
}