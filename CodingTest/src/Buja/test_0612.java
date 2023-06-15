package Buja; // syntax error
public class test_0612 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
	// 푸드 파이트 대회

	/*  해결일 : 6월 15일
    문제점 : 하드코딩을 지양하기 위해
            앞으로 조건들은 가능한 상수로 고정시키고 풀 예정이다.
            실무에서도 상수들을 properties에 작성하고 커밋하면
            서버 재 기동 없이 원하는 대로 쉽게 운영할 수 있게 된다.
            
            이 문제는 처음에는 잘못 이해를 해서
            12 23 34 같이 겨루는 줄 알았는데
            그게 아니고 12 34 56 78 -> 12 34 이렇게 라운드가 넘어가는거였다.
            한국말을 정확하게 이해하는것이 시급하다고 생각한다.
            
            내가 짠 코드의 핵심은 무한루프이다.
            a와 b의 값은 달라야하는데, 같아지는 경우를 이 글 작성 당시에 파악을 못해서
            무한루프를 탈출시키는 조건이 필요했는데
            a==b 즉, a와 b가 값이 동일해지게 되면 다음 라운드 넘기지 않고
            게임 강제 종료시켜 현재까지 라운드 출력하게 했고, 정답 처리 되었다.
            
            이 글 쓰는 당일에, SQL 쿼리에 오타가 있다는 점을 빠르게 파악하지 못해
            현업 담당자에게 오늘 못한다고 죄송하다는 말을 할 수 밖에 없었다.
            발생할 수 있는 오류를 사전에 파악하고 수정할 수 있도록 노력해야지.        

// 예상 대진표
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer =1;   // 라운드 수
        final int divConst = 2; // 나눠야 하는 수
        
        while((a>=1) && (b>=1))
        {
            System.out.println(answer+ "라운드(전) "+a+" "+b);
            if(a%divConst == 1 && a!=1) a+=1;
            if(b%divConst == 1 && b!=1) b+=1;
            System.out.println(answer+ "라운드(후) "+a+" "+b);
            
            // 라운드에서 만나는 조건 -> 연속 값이어야 함
            if((a-b == 1) || (b-a == 1)) break;
            
            // 1이 아니면 divConst만큼 나눠야 다음 라운드 진행가능
            if(a!=1) a /= divConst;
            if(b!=1) b /= divConst;
            
            // 무한루프 방지
            if(a==b) break;
            answer+=1;
        }
        
        return answer;
    }
}