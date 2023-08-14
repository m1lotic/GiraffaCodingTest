package TH.level1;

import java.util.*;
import java.util.stream.Collectors;

public class PonketMon {
    public int solution(int[] nums) {
                    // stream사용해서 int배열을 Integer타입으로 박싱하고 리스트화해서 바로 set에 집어넣기
        HashSet<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                    // 중복되지 않는 폰켓몬 수와 (전체 포켓몬수 / 2)를 비교해서
                        // 동시에 충족해야하므로 작은 쪽이 답
        return Math.min(nums.length/2, set.size());
        //Arrays.stream(nums)
        //                .boxed()
        //                .collect(Collectors.collectingAndThen(Collectors.toSet(),
        //                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
        // 스트림 넣고
        //                  박싱하고
        //                  set형으로 변환한 뒤에 작은 값 판별해서 제공
    }
    public static void main(String[] args) {
        PonketMon pMon = new PonketMon();
        System.out.println(pMon.solution(new int[]{3,3,3,2,2,4}));
        System.out.println(pMon.solution(new int[]{3,3,3,2,2,2}));
    }
}
