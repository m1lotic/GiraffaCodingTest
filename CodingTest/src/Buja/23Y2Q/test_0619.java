package Buja; // syntax error
public class test_0619 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
//  다음 큰 숫자
/*  해결일 : 6월 20일
    문제점 : 21, 22일은 못 할 것 같아서 오늘 했다.
            이 문제를 보면 알겠지만 이 문제는
            코딩보다는 여러 기능을 활용해서 문제를 풀었다.
            1) Integer.toBinaryString으로 2진수로 바꾸고(String형임)
            2) 비교 대상 숫자를 하나씩 더해주면서
            3) 숫자가 바뀔 때 마다 2진수로 바꿔주고
            4) 바뀐 2진수 값을 원 2진수와 비교하는데, 1이 몇개있는지 센다
            5) 그리고 그 1을 제외해주고 0의 개수가 일치인 지 살펴본다
               (왜냐하면 자리수 다를 때 0의 개수가 맞아야 1 개수가 일치함
                자리 수가 바뀌는 순간 1이 하나 추가되기 때문)
            6) 그리고 맞는 값을 찾았다면, 그 부분을 2진수에서 10진수로 변환시킨다.
               (Integer.parseInt(변수명, 원래 진수))
            그리고 break까지.
            사실 내가 이 부분을 전부 구글에서 찾아보았다. 얼마나 올바른 자료를 찾아서
            정확하게 구현하는 지를 아는것도 중요하다.
            처음부터 끝까지 내가 구현해야 하는 경우는 없으니

class Solution {
  public int solution(int n) {
      int answer = 0;
      String bNum = ""; // 2진수
      String nNum = Integer.toBinaryString(n); // 2진수
      
      // 조건1, 2, 3 (n을 임의로 먼저 더하면 안됨)
      for(int i=1;i<1000000;i++){
      bNum= Integer.toBinaryString(n+i); 
      if((bNum.length()-bNum.replace("1","").length()) 
      == (nNum.length()-nNum.replace("1","").length())){
     //  System.out.println("디버깅" + (bNum.length()-bNum.replace("0","").length() +" "+ (nNum.length()-nNum.replace("0","").length())));
                  answer = Integer.parseInt(bNum,2);
          break;
      }
    }
      return answer;
  }
}*/