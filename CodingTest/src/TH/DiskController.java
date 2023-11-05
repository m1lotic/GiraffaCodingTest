package TH.stack_queue.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//
// 디스크 컨트롤러 문제
//  각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때,
//  작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지
//  return 하도록 solution 함수를 작성해주세요.
public class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;
        // 작업 개수
        int len = jobs.length;
        // 현재 시간
        int time = 0;
        // 작업 탐색
        int idx = 0;
                                            // 정렬기준을 o[1]을 기준으로 하겠다.
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
                                        // 정렬기준을 o[0] (작업 요청 시간)으로 하겠다.
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        // 작업이 끝날 때까지 + 큐에 남은 작업이 없을 때 까지 반복
        while (idx < len || !queue.isEmpty()) {
            // 디스크가 작업 중
                // 현재 들어온 요청들 큐에 저장
            while (idx < len && jobs[idx][0] <= time)
                queue.offer(jobs[idx++]);
            // 디스크가 놀고 있음
                // 들어온 요청 바로 처리
            if (queue.isEmpty())
                time = jobs[idx][0];
                // 큐에 저장된 요청 정렬해서 바로 처리
            else {
                int[] job = queue.poll();
                // 여태 처리한 작업 시간 - 작업 요청 시간 + 방금 처리한 작업 시간의 총합
                answer += time - job[0] + job[1];
                time += job[1];
            }
        }
        return answer / len;
    }
    public static void main(String[] args) {
        DiskController dc = new DiskController();
        System.out.println(dc.solution(new int[][] {{0, 3}, {1, 9}, {2, 6}}));
    }
}
