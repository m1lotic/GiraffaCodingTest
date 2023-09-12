package TH.DFS_BFS;

public class targetNumber {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        // 현재 합한 값, 탐색 위치(깊이), numbers, target
        dfs(0, 0, numbers, target);
        return answer;
    }

    private void dfs(int sum, int idx, int[] numbers, int target) {
            // 최대 깊이와 현재 위치가 같음 && 총합이 target일 때 
        if (idx == numbers.length && sum == target) {
            answer++;
            return;
        }
            // 최대 깊이를 넘었는데 총합이 target이 아닐때
        if (idx >= numbers.length) {
            return;
        }
            // 처음엔 일반적인 DFS
        dfs(sum + numbers[idx], idx + 1, numbers, target);
            // +가 안되면 -로 DFS진행
        dfs(sum - numbers[idx], idx + 1, numbers, target);
    }

    public static void main(String[] args) {
        targetNumber tn = new targetNumber();
        System.out.println(tn.solution(
                new int[]{1, 1, 1, 1, 1}, 3
        ));
    }
}
