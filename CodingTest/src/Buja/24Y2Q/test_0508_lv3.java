package Buja; // syntax error
public class test_0508_lv3 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 이중우선순위큐
	/* 해결일 : 5월 15일 21시 15분
	   문제점 : 이 문제는 일단 treeSet으로 풀기는 했는데,
	           우선순위큐를 오름차순과 내림차순 2개를 만들어서
	           그렇게 구현을 해도 문제가 없을 것으로 보인다.
	           
	           단, 어느방법을 사용하던, remove는 속도가 느려서
	           시간초과할 수도 있다고 한다.
	*/      


	import java.util.*;

	class Solution {
	    public int[] solution(String[] operations) {
	        int[] answer = new int[2];
	        
	        TreeSet<Integer> treeSet = new TreeSet<>();
	        
	        for(int i=0;i<operations.length;i++){
	            // 숫자 삽입
	            if((operations[i].substring(0,1)).equals("I")){
	                treeSet.add(Integer.parseInt(operations[i].substring(2)));
	                System.out.println(operations[i].substring(2));
	            }
	            
	            // 최댓값 삭제
	            else if((operations[i].substring(0,1)).equals("D") 
	                     &&(operations[i].substring(2)).equals("1")){
	               if(!treeSet.isEmpty())  treeSet.remove(treeSet.last());
	                
	            }
	            // 최솟값 삭제
	            else{
	                if(!treeSet.isEmpty())   treeSet.remove(treeSet.first());
	            }
	        }
	        if(!treeSet.isEmpty()){
	          answer[0]=treeSet.last(); // 최댓값
	          answer[1]=treeSet.first(); // 최솟값
	        }
	        
	        return answer;
	    }
	}