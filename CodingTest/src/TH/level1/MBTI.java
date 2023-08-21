package TH.level1;

import java.util.HashMap;
import java.util.Map;

public class MBTI {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        // MBTI유형 미리 저장
        map.put('R', 0); map.put('T', 0);
        map.put('C', 0); map.put('F', 0);
        map.put('J', 0); map.put('M', 0);
        map.put('A', 0); map.put('N', 0);

        // 설문조사 계산
        for(int i = 0; i < survey.length; i++){
            char type; int score;
                // 모르겠음(0점) ~ 매우 동의(3점) <우측 유형 점수>
                    // choices[i] - 4 하면 점수 구할 수 있음
            if(choices[i]>=4){
                        // 이전에 담긴 값에 추가로 더 함
                type = survey[i].charAt(1);
                score = map.get(survey[i].charAt(1)) + choices[i]-4;
            } else {    // <좌측 유형 점수>  4 - choices[i]로 구할 수 있음
                type = survey[i].charAt(0);
                score = map.get(survey[i].charAt(0)) + 4 - choices[i];
            }
  //          System.out.println("타입 : " + type + " // 점수 : "+score);
            // 계산값 map에 갱신
            map.put(type, score);
        }

        // 설문조사 정리
        String[] mbti_type = {"RT", "CF", "JM", "AN"};
        for(String ty : mbti_type){
                // 전자값, 후자값 추출
            int former = map.get(ty.charAt(0));
            int after = map.get(ty.charAt(1));
//            System.out.printf("%c - %d // ", ty.charAt(0), former);
//            System.out.printf("%c - %d\n", ty.charAt(1), after);
            // 값이 같은 경우 알파벳 순으로
            if(former == after){
                answer += (ty.charAt(0) > ty.charAt(1)) ? ty.charAt(1) : ty.charAt(0);
            } else{ // 값이 다른 경우 큰 쪽
                answer += (former > after) ? ty.charAt(0) : ty.charAt(1);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        MBTI mbti = new MBTI();

        System.out.println(mbti.solution(
                new String[]{"TR", "RT", "TR"},
                new int[]{7, 1, 3}
        ));
    }
}
