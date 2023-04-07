package Buja; // syntax error
public class test_0403 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	/* 4월 3일 삼총사(학생 3명의 정수 번호를 더했을 때 0이 되면 3명의 학생은 삼총사)
	 * 
	 * 	class Solution {
	    public int solution(int[] number) {
	        int answer = 0;
	        int sum= 123;
	        int i=0;
	        int j=1;
	        int z=2;
	        
	        for(;i<number.length;i++)
	        {
	            for(;j<number.length;j++)
	            {
	                for(;z<number.length;z++)
	                {
	                    sum = number[i]+number[j]+number[z];
	                   System.out.println((i+1)+" "+(j+1)+" "+(z+1)+" ");//디버깅
	                    if(sum==0) answer +=1;
	                }
	                
	                z=(j+2); //j++로 j가 1 더해지므로 2개를 더함
	            }
	            j=(i+1); // i보다 한 칸 뒤에 있어야함
	        }
	        return answer;
	    }
	}
	 */
	
	/* 4월 4일 명함 크기(가로 세로)
	 * class Solution { 
    public int solution(int[][] sizes) {
        int answer = 0;
        int width=0; // 가로
        int height=0; // 높이..가 아니고 세로
        int swap =0;
        
        for(int i=0;i<sizes.length;i++)
        {
                if(sizes[i][0]<sizes[i][1]) // [1,2]에서 왼쪽이 무조건 크게 정렬
                {
                    swap = sizes[i][0]; 
                    sizes[i][0] = sizes[i][1];  
                    sizes[i][1] = swap;
                }
        }
        for(int i=0;i<sizes.length;i++) // 가로길이 세로 길이 계산(가로가 긴거.세로가 긴거 각각)
        {
                if(sizes[i][0]>width)  width=sizes[i][0];
                if(sizes[i][1]>height) height=sizes[i][1];
        }        
        answer = width*height;
        return answer;
    }
}
	 */
	/* 4월 7일 보물지도
	 * 
	class Solution {
	    public String[] solution(int n, int[] arr1, int[] arr2) {
	        String[] answer2 = new String[n]; // 합치기용
	        String[] answer3 = new String[n];// 글자 합치기용

	         //2진수 비트 합치기
	        for(int i=0;i<n;i++)
	        {
	            answer2[i] = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(arr1[i] | arr2[i]))).replace(' ', '0'); 

	          System.out.print(answer2[i]+" ");
	        }
	        //2진수 글자 합치기
	        for(int i=0;i<n;i++) 
	        {
	               answer3[i] = answer2[i].replace('1','#').replace('0',' ');
	        }
	              
	        return answer3;
	    }
	}
	 * 
	 */
//} 
