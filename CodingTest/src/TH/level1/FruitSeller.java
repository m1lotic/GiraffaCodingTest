package TH.level1;

import java.util.Arrays;
import java.util.stream.Stream;

public class FruitSeller {
    public int solution(int k, int m, int[] score) {
            // 상자에 가장 가치 높은 순서대로 담아서 묶어 팔아야 최대 이득이라 정렬을 하였음
                // 역정렬도 생각했는데 역정렬에 리소스 쓰는 것보단 index만 바꿔주면 되니까 하지 않았음
        score = Arrays.stream(score).sorted().toArray();
        int answer = 0;
        int count = score.length / m;   // 배열크기/담아야할 사과 -> 사과를 담을 수 있는 상자 개수
            // 상자 개수만큼 반복 -> 상자의 가치는 상자 내의 가장 가치가 낮은 사과이므로
                // 가장 앞에 있는 사과의 값 * 담은 사과 수
        // 예시1) 1, 1, 1, 2, 2, 3, 3   | m = 4
        //               |^  가치가 큰 사과부터 담으므로 인덱스는 뒤를 기준으로 자르고 잘린 위치가 가격을 결정하는 사과
                // 뒤에서부터 자르므로 인덱스는 [score크기- (담을 사과 * 현재 상자 수)]로 계산함
        for(int i = 1; i <= count; i++){
            answer += m * score[score.length - (i * m)];
        }
        return answer;
    }
    public static void main(String[] args) {
        FruitSeller fSell = new FruitSeller();
        System.out.println(fSell.solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
        System.out.println(fSell.solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));

        String str = "{2, 1, 4, 3}";
        str = str.replaceAll("[^0-9]", "");
        System.out.println(str);
    }
}
