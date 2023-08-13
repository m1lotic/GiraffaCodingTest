package TH.level2;

import java.util.*;

public class Tuple {
    public int[] solution(String s) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        s = s.substring(2, s.length()-2);
        String[] str = s.split("},\\{");
        // 큰 중괄호 제거 후 각 튜플을 잘라서 배열에 저장
        // 길이 순으로 정렬    (str, 이후 comparator를 오버라이드해서 길이별 정렬로 수정)
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
            //    Arrays.sort(arr, (a, b)->{return a.length() - b.length();}); <- 람다식 써도 된다
        for(String tuple : str){    // 튜플 한개씩 뽑기
            for(String num : tuple.split(",")){ // 튜플 내의 원소 뽑기
                set.add(Integer.parseInt(num)); // Integer형 변환 후 집어 넣기 (LinkedHashSet은 중복없이 순서대로 조회가능)
            }
        }
        //        for(String s1 : arr) {
        //            for(String s2 : s1.split(",")) {
        //                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
        //                    set에 들어가면(중복값이 아니면) answer에 집어넣기  <<<<< 개씽크빅
        //            }
        //        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        Tuple tp = new Tuple();
        System.out.println(Arrays.toString(tp.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));

    }
}
