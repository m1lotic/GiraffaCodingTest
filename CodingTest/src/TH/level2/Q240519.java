package TH.dijkstra;

import java.util.*;

public class Q240519 {
    static final int INFINITY = Integer.MAX_VALUE;
    // 우선순위 큐에 마을번호, 시간 저장을 위한 클래스
    static class node{
        int v; int value;
        public node(int v, int value){
            this.v = v; this.value = value;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;  int maximunTime = K;  int totalTown = N;
        // 1. DP용 그래프 생성
            // 노드를 저장할 그래프 초기화
        ArrayList<node>[] graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
            // 그래프에 node 저장 (시작점, 끝점, 소요 시간)
        for(int i = 0; i < road.length; i++){
            int start = road[i][0];
            int end   = road[i][1];
            int value = road[i][2];
            graph[start].add(new node(end, value));
            graph[end].add(new node(start, value));
        }
        // 2. 소모 시간 저장용 배열 초기화
        int [] memo = new int [totalTown+1];
            // 최단 시간이 기준이니 초기화는 INTEGER 최대 값으로 설정
        Arrays.fill(memo, INFINITY);
            // 시작 위치 소모시간은 0
        memo[1] = 0;
        // 3. 우선순위큐
        PriorityQueue<node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        pq.add(new node(1, 0));
        while(!pq.isEmpty()){
            node node = pq.poll();
            // 해당 마을에 직접적으로 갈 방법이 없는 경우 패스
            if(memo[node.v]!=node.value) continue;
            // 꺼낸 노드를 시작점으로 도착할 수 있는 마을들 순회
            for(node next : graph[node.v]){
                // 최소 거리로 업데이트 되는 노트만 큐에 넣음
                if(memo[next.v] <= memo[node.v] + next.value) continue;
                memo[next.v] = memo[node.v] + next.value;
                pq.add(new node(next.v, memo[next.v]));
            }
        }
        // 4. 소모 시간이 저장된 배열을 순회하여 최대 소모 시간과 비교
        for(int i = 2; i <= N; i++){
            if(memo[i] <= maximunTime) answer++;
        }
        // 5. 1번 마을 포함해야해서 +1
        return answer + 1;
    }

    public static void main(String[] args) {
        Q240519 instance = new Q240519();
        int answer = instance.solution(6,
                new int[][]{{1, 2, 1},
                        {1, 3, 2},
                        {2, 3, 2},
                        {3, 4, 3},
                        {3, 5, 2},
                        {3, 5, 3},
                        {5, 6, 1}}, 4);
        System.out.println(answer);
    }
}
