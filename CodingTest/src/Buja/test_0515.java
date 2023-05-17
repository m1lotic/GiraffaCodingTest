package Buja; // syntax error
public class test_0515 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 삼총사

	/* 해결일 : 5월 16일
	   문제점 : for-each 문을 사용하기 위해서 계속 시도했으나 실패했다.
	           for-each 문에는 큰 특징이 있는데,
	           일단 type과 변수명이 필요하고, for를 iteration해주는
	           scope 밖에서 쓸 수가 없는 변수라 실패 한 것이다.
	           그리고 다음부터는 number.length보다는 
	           int length= number.length 같이 처리를 해서
	           하드 코딩으로 박아넣는 행위를 좀 자제 해야 할 듯 하다.(수정의 어려움)
	

	class Solution {
	    public int solution(int[] number) {
	        int answer = 0;
	        int sum= 123; // 임의숫자임
	        // 초기선언
	        int i=0; 
	        int j=1; 
	        int z=2; 
	        
	        // (a, b, c)
	        for(;i<number.length;i++)
	        {
	            for(;j<number.length;j++)
	            {
	                for(;z<number.length;z++)
	                {
	                    // 합계를 계산하는 코드
	                    sum = number[i]+number[j]+number[z];
	                    if(sum==0) answer +=1;
	                }
	                   z=(j+2);
	            
	                        }
	            j=(i+1);
	        }
	          return answer;
	    }
	}
*/
	
	// 최소직사각형
	/* 해결일 : 5월 17일
	   문제점 : 이 부분은 완전탐색이라고 하지
	           그렇게 해결을 해보았다
	           결국 모든 크기의 명함을 수납하려면
	           여러 명함 중 가로가 가장 긴거
	           세로가 가장 긴거 이런식으로 처리해야하는데,
	           어떤 명함들은 가로가 길고, 어떤 명함들은 세로가 기므로
	           가로가 가장 길게끔 통일해준다.
	           그리고 세로 부분에서 가장 긴 부분을 체크해서
	           넓이를 가로*세로로 하면 답이 나온다.
	

	class Solution {
	    public int solution(int[][] sizes) {
	        int answer = 0;
	        int width=0; // 가로
	        int height=0; // 세로
	        int swap =0;
	        int sizesLength= sizes.length;
	        
	        // 직사각형의 가장 큰 값을 찾아본다.([i]번째 사각형별로 가로가 긴쪽오도록)
	        for(int i=0;i<sizesLength;i++)
	        {
	                if(sizes[i][0]<sizes[i][1]) // 세로가 더 길면
	                {
	                    swap = sizes[i][0];  
	                    sizes[i][0] = sizes[i][1];  
	                    sizes[i][1] = swap; // 가로랑 세로값을 바꿔서 가로가 길게 한다
	                }
	        }
	        
	        
	        // [i]번째 직사각형의 가로와 세로의 길이를 비교한다
	        // 결국 직사각형의 (가로, 세로) 각각 가장 큰 값이 우리가 찾는 그 값이니까
	        // 어느 직사각형인지 상관없다. 직사각형 중 가장 큰 (가로/세로) 부분만 찾으면 해결된다
	        for(int i=0;i<sizesLength;i++)
	        {
	                if(sizes[i][0]>width)  width=sizes[i][0];
	                if(sizes[i][1]>height) height=sizes[i][1];
	        }
	        
	        answer = width*height;
	        
	        return answer;
	    }
	}
	*/