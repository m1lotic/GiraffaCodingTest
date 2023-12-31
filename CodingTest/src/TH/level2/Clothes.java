package TH.hash;

import java.util.Arrays;
import java.util.HashMap;

public class Clothes {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothMap = new HashMap<>();
        // 옷 집어넣기
        Arrays.stream(clothes).forEach((clo)->{
            String key = clo[1];
            clothMap.put(key, clothMap.getOrDefault(key, 0)+1);
        });

        // 종류별 개수로 스트림
            // reduce -> 연산을 통해 스트림 요소를 하나로 압축
        int totalCombinations = clothMap.values()
                .stream().reduce(1, (start, current)-> start * (current+1));
                    // 초기값+비어있을 때 반환값, (연산 중인 값, 현재값)
        // 모든 조합의 수에서 아무 것도 선택하지 않은 경우 1을 빼줌
        return totalCombinations - 1;
    }

    public static void main(String[] args) {
        Clothes ct = new Clothes();
        System.out.println(ct.solution(
                new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}
        ));
    }
}
