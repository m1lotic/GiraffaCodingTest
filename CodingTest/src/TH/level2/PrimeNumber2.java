package TH.level2;

import java.util.*;

public class PrimeNumber2 {
    public HashSet<Integer> set;
    public String mixing_number;
    public void dfs(int start_idx, Stack<Integer> stack, int[][] graph, boolean[] visited, String numbers){
        visited[start_idx] = true;
        stack.push(start_idx);

        // 현재 탐색 중인 값 set에 저장
        mixing_number += ""+numbers.charAt(start_idx);
        this.set.add(Integer.parseInt(mixing_number));

        for(int i = 0; i < numbers.length(); i++){
            if(graph[start_idx][i] == 1 && !visited[i]) {
                dfs(i, stack, graph, visited, numbers);
                // dfs 후에 방문 노드를 false로 만들어주어 해당 노드를 방문하지 않은 것으로 해줌
                // -> 모든 경로를 구하기 위함
                visited[i] = false;
                mixing_number = mixing_number.substring(0, mixing_number.length()-1);
            }
        }
        stack.pop();
    }

    public int solution(String numbers) {
        // 앞자리에 넣을 숫자들 (중복제거, 0제거)
        int[] sortNums = numbers.chars().filter(n-> n != '0').map(n->n-48).sorted().distinct().toArray();
        // numbers의 인덱스를 활용해 DFS를 진행하면서 만들어지는 값 스택에 저장
            // numbers의 인덱스를 넣을 그래프 생성 -> 어차피 모든 정점이 연결돼 있기 때문에 배열로 구현하였다.
        int[][] graph = new int[numbers.length()][numbers.length()];
        boolean[] visited = new boolean[numbers.length()];
        // 문자열 저장용 set 선언
        this.set = new HashSet<>();

        // DFS 진행할 스택 생성
        Stack<Integer> stack = new Stack<Integer>();

            // start로 넣을 값
        for(int i = 0; i < sortNums.length; i++){
            int start_idx = numbers.indexOf(String.valueOf(sortNums[i]));
            mixing_number = "";
            Arrays.fill(visited, false);
            // 진행할때마다 그래프 초기화
            for(int j = 0; j < numbers.length(); j++){
                Arrays.fill(graph[j], 1);
                graph[j][j] = 0;
            }
            dfs(start_idx, stack, graph, visited, numbers);
            }

        // 소수 카운터
        int answer = 0;
        Integer max = Collections.max(set);
        boolean[] sieve = new boolean[max+1];
        sieve[0] = sieve[1] = true;
        for(int i = 2; i*i <= max; i++){
            // sieve[i]가 소수면
            if(!sieve[i]){
                for(int j = i*i; j<=max; j+=i) sieve[j] = true;
            }
        }

        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()){
            if(!sieve[iter.next()])  answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        PrimeNumber2 pNum = new PrimeNumber2();
        System.out.println(pNum.solution("13"));
    }
}
