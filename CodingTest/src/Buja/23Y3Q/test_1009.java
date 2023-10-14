package Buja; // syntax error
public class test_1002 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	

    // 조이스틱(미완료)
	// 소스가 너무 길어져서 추후에 정리하여 다시 구하기
	import java.util.*;

	// A가 어디에 있는지도 체크해야함(AAZZZZ면 ZZZZ 4번주고 끝)
	// 방향을 오른쪽 왼쪽 둘다 체크해야함
	class Solution {
	    public int solution(String name) {
	        int answer = 0;
	        int ans_left = 0; //왼쪽방향
	        int count_a = 0; // a 연속 몇개있는지
	        
	        char[] char_Name = name.toCharArray();
	        int now = 0; // 조이스틱으로 현재 위치 알파벳?
	        // 오른쪽 방향으로 찾기
	        for(int i=0;i<name.length();i++){
	           now = (int)(char_Name[i]);
	            if(now > 77)  answer += 91 - now;
	            else          answer += now - 65;
	            System.out.println(answer);
	            
	        }
	        
	       // A가 얼마나 연속인지 검사(오른쪽기준, 그만큼 덜 카운트함)
	        // 단 길이는 2부터 검사함
	        for(int i=name.length()-1;i>0;i--)
	        {
	            now = (int)(char_Name[i]);
	            if(now == 65) count_a++;
	            else break;
	        }
	        
	        answer += name.length()-count_a-1;// 몇칸이동
	    
	        count_a=0;
	        // 왼쪽 이동할 때 첫글자계산
	        now = (int)(char_Name[0]);
	        if(now > 77)  ans_left += 91 - now;
	        else          ans_left += now - 65;
	        
	        
	        // 왼쪽 방향으로 찾기
	        for(int i=name.length()-1;i>0;i--){
	           now = (int)(char_Name[i]);
	            if(now > 77)  ans_left += 91 - now;
	            else          ans_left += now - 65;
	       //     System.out.println(ans_left);
	            
	        }
	        
	        // A가 얼마나 연속인지 검사(왼쪽기준, 그만큼 덜 카운트함
	        // 단 길이는 2부터 검사함
	        for(int i=1;i<name.length();i++)
	        {
	            now = (int)(char_Name[i]);
	            if(now == 65) count_a++;
	            else break;
	        }
	        System.out.println(count_a);
	        ans_left += name.length()-count_a-1;
	        
	        if(ans_left<answer) answer = ans_left;
	        System.out.println(answer+" "+ans_left);
	        
	        
	        // 위에 있는 부분은 왼쪽으로 갔다가 다시 오른쪽으로 가는
	        // 특수한 경우의수 처리가 안됨
	        
	        return answer;
	    }
	}