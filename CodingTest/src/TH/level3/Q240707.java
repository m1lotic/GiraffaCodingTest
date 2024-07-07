package TH;

import java.util.Collections;
import java.util.PriorityQueue;

// 야근 지수
// 회사원 Demi는 가끔은 야근을 하는데요, 야근을 하면 야근 피로도가 쌓입니다.
// 야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값입니다.
// Demi는 N시간 동안 야근 피로도를 최소화하도록 일할 겁니다.
// Demi가 1시간 동안 작업량 1만큼을 처리할 수 있다고 할 때,
// 퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해 야근 피로도를 최소화한 값을 리턴하는 함수 solution을 완성해주세요.
public class Q240707 {
    // 가장 큰 값을 1씩 줄이면 최소값
    public long solution(int n, int[] works) {
        long answer = 0;
        // 우선순위 큐에 넣기 + 높은 값이 우선순위로 지정
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work: works) {
            pq.offer(work);
        }
        // 우선순위(높은값)을 꺼내서 1씩 빼기
        while( n > 0 ) {
            int value = pq.poll();
            // 작업이 끝(0)일땐 끝
            if(value <= 0) break;
            pq.offer(value - 1);
            n--;
        }
        // 남은 작업량 제곱
        for(int value: pq) {
            if(value == 0) {
                continue;
            }
            answer += Math.pow(value,2);
        }
        return answer;
    }
    public static void main(String[] args) {
        Q240707 q = new Q240707();
        long answer = q.solution(4, new int[] {4, 3, 3});
        System.out.println(answer);
    }
}
