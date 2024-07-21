package TH.level2;

public class Q240721 {
    // 제출할 2차원 배열 -> 재귀 함수라 함수에 리턴하기 보다 전역 변수 사용
    public static int[][] answer;
    // 위 배열의 인덱스
    public int idx = 0;
    public int[][] solution(int n) {
        // 하노이탑 최소 이동 횟수 점화식
        int minimum = (int)Math.pow(2, n) -1;
            // 2^n - 1
        answer = new int[minimum][2];
        hanoi(n, 1, 2, 3);

        return answer;
    }
    // 첫 이동 시 start : (1), mid : (2), destination : (3)
    public void hanoi(int n, int start, int mid, int destination){
        // 이동할 원판이 1개인 경우 재귀 종료
        if(n == 1) {
            answer[idx++] = new int[]{start, destination};
            return;
        }
    // n번째 원판을 (1) -> (3)로 옮기는 경우
        // 1. n-1개의 원판을 (1) -> (2)로 이동
        hanoi(n-1, start, destination, mid);
        // 2. n번째 원판을 (1) -> (3)로 이동 = start 지점의 n번쨰 원판을 destination으로 이동
        answer[idx++] = new int[]{start, destination};
        // 3. n-1개의 원판을 (2) -> (3)로 이동
        hanoi(n-1, mid, start, destination);
    }

    public static void main(String[] args) {
        Q240721 q = new Q240721();
        q.solution(2);
    }
}
