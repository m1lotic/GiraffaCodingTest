package Buja; // syntax error
public class test_0415 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 요격 시스템
	/* 해결일 : 4월 21일 18시 24분
	   특이점 : s,e 중에서 e 지점을 기준으로
	           발사횟수를 맞춰주면 되는 문제
	           아이디어 생각이 매우 까다로움
	           
	*/
	import java.util.*;

	class Solution {
	    public int solution(int[][] targets) {
	        int answer = 0;
	        
	        // e 기준으로 sort(개구간이라 시점에서는 발사불가, 끝나는 지점에서 판단)
	        Arrays.sort(targets, (o1, o2) -> o1[1]-o2[1]);
	        
	        // int s=0; 사유 : 불필요
	        
	        int e=0;
	        for(int i =0; i<targets.length;i++){
	            // s가 e보다 같거나(개구간만 됨) 크면 새로 발사해야 함)
	            if(targets[i][0]>=e){
	                answer++; 
	                e=targets[i][1]; // 비교 기준값을 e 지점으로 변경해줌
	            }
	            
	        }
	    return answer;
	    }
	}