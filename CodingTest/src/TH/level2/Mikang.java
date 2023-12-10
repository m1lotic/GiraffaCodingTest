package TH.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Mikang {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        // 분류용 map
        Map<Integer, Integer> mikang = new HashMap<>();
        // map에 귤 분류
            // 귤 정렬 -> 크기에 따른 수 저장
        Arrays.stream(tangerine)
                .sorted()
                .forEach((tan) ->
                        mikang.put(tan, mikang.containsKey(tan) ?(mikang.get(tan) + 1) :1));
        // 크기별 개수 기준으로 내림차순 -> k에서 개수 빼기
        for(Map.Entry<Integer, Integer> entry : mikang.entrySet().stream().sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed()).toList()){
            k -= entry.getValue();
            answer++;
            if(k <= 0) break;
        }
        return answer;
    }

    public static void main(String[] args) {
        Mikang mk = new Mikang();
        mk.solution(6, new int[] {1, 3, 2, 5, 4, 5, 2, 3});
        mk.solution(4, new int[] {1, 3, 2, 5, 4, 5, 2, 3});
        mk.solution(2, new int[] {1, 1, 1, 1, 2, 2, 2, 3});
    }
}