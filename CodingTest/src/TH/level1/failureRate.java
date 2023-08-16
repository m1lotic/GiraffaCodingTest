package TH.level1;

import java.util.*;
import java.util.stream.Collectors;

public class failureRate {
    public int[] solution(int N, int[] stages) {
            // 답을 저장할 리스트
        ArrayList<Integer> answer = new ArrayList<>();
            // 실패율/스테이지 번호 저장할 리스트
        ArrayList<double[]> failure_list = new ArrayList<>();
            // 받은 스테이지 정렬해서 arrayList에 저장
        ArrayList<Integer> list = new ArrayList<>(Arrays.stream(stages).boxed().sorted().collect(Collectors.toList()));

        // 계산할 플레이어 전체 수
        int players = stages.length;
        // 실패한 사람     // 실패율
        int fail_player = 0; double failure = 0;
        // 1~N 스테이지까지 실패율 판별
        for(int i = 1; i <= N; i++){
            // 깨지 못하는 사람은 각 스테이지 번호를 할당 받음
              // 해당 스테이지에서 막힌 플레이어가 존재하면 실패율 계산
            if(list.contains(i)){
                // 도전 중인 플레이어 = (현재인덱스+1 -떨어진 이미 플레이어) / 현재 남은 플레이어
                failure = (double)(list.lastIndexOf(i)+1-fail_player) / players;
                fail_player = list.lastIndexOf(i)+1; // n번째 기준이 인덱스니까 +1씩 진행
                players = stages.length - (list.lastIndexOf(i)+1);  // 남은 플레이어 = 전체 플레이어 - 이미 실패한 플레이어
            } else{
                // 도전 중인 플레이어가 없으면 실패율은 0이고
                    //  남은 플레이어, 현재 플레이어에 대한 계산은 다음으로 미룸
                failure = 0;
            }
            // 실패율 저장용 리스트에 저장
            failure_list.add(new double[]{failure, (double)i});

            // 이미 떨어진 플레이어 및 현재 남은 플레이어 재계산
        }
        // 정렬
        Collections.sort(failure_list, Comparator.comparingDouble(a -> a[0]));

        // 실패율이 가장 높은 스테이지 중 낮은 스테이지를 뽑고 저장
        // 저장하면 해당 값 리스트에서 삭제, 리스트에 값 없을 때까지 반복
        while(failure_list.size()>0){
            double[] max_value = Collections.max(failure_list, Comparator.comparingDouble((double[] a) -> a[0]));
            answer.add((int) max_value[1]);
            failure_list.remove(max_value);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        failureRate fRate = new failureRate();

        System.out.println(Arrays.toString(fRate.solution(
                3, new int[] {1, 1, 3, 4}
        )));
    }
}
