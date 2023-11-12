package TH.greedy;
//  철 곡괭이는 다이아몬드를 캘 때 피로도 5가 소모되며,
//  철과 돌을 캘때는 피로도가 1씩 소모됩니다.
//  각 곡괭이는 종류에 상관없이 광물 5개를 캔 후에는 더 이상 사용할 수 없습니다.
//
//  마인은 다음과 같은 규칙을 지키면서 최소한의 피로도로 광물을 캐려고 합니다.
//
//  사용할 수 있는 곡괭이중 아무거나 하나를 선택해 광물을 캡니다.
//  한 번 사용하기 시작한 곡괭이는 사용할 수 없을 때까지 사용합니다.
//  광물은 주어진 순서대로만 캘 수 있습니다.
//  광산에 있는 모든 광물을 캐거나, 더 사용할 곡괭이가 없을 때까지 광물을 캡니다.
//  즉, 곡괭이를 하나 선택해서 광물 5개를 연속으로 캐고, 다음 곡괭이를 선택해서 광물 5개를 연속으로 캐는 과정을 반복하며,
//  더 사용할 곡괭이가 없거나 광산에 있는 모든 광물을 캘 때까지 과정을 반복하면 됩니다.
//
//  마인이 갖고 있는 곡괭이의 개수를 나타내는 정수 배열 picks와
//  광물들의 순서를 나타내는 문자열 배열 minerals가 매개변수로 주어질 때,
//  마인이 작업을 끝내기까지 필요한 최소한의 피로도를 return 하는 solution 함수를 완성

import java.util.*;
import java.util.function.Function;

public class MiningMinerals {
    public int solution(int[] picks, String[] minerals) {
        // 가진 곡괭이 수, 곡괭이 종류 String 배열에 저장
        int pickNum = 0;
        List<String> pickString = new ArrayList<>();
        for (int i = 0; i < picks.length; i++) {
            pickNum += picks[i];
            // picks[i]만큼 반복, switch문의 결과를 add
            pickString.addAll(Collections.nCopies(picks[i], switch (i) {
                case 0 -> "DIAMOND";
                case 1 -> "IRON";
                case 2 -> "STONE";
                default -> throw new RuntimeException("이상한 광물이 있는데요?");
            }));
        }
        // 가진 광물을 모두 캘 수 있는 곡괭이 수
        int mineNum = minerals.length/5 + 1;

        // pickNum, mineNum 중 작은 수를 기준으로 minerals배열을 5개씩 나누기
        int groupSize = Math.min(pickNum, mineNum);
        List<String[]> groupedMinerals = new ArrayList<>();
            // 5개씩 묶어서 깊은 복사
        for (int i = 0; i < groupSize; i++) {
            int startIndex = i * 5;
            int endIndex = Math.min((i + 1) * 5, minerals.length);
            String[] group = Arrays.copyOfRange(minerals, startIndex, endIndex);
            groupedMinerals.add(group);
        }

        // 피로도 비교가 가능한 stone 곡괭이를 기준으로 피로도 계산 후 내림차순 정렬
        List<StonePick> stonePick = new ArrayList<>();
        for(String[] groupMineral : groupedMinerals){
            stonePick.add(
                    new StonePick(Pickax.STONE.fatigue(groupMineral, 0),groupMineral)
                    );
        }
        stonePick.sort(Comparator.comparingInt(StonePick::getCost).reversed());

        int result = 0;
        for(int i = 0; i < stonePick.size(); i++){
            // 내림차순으로 정렬했으니 비싼걸 좋은 곡괭이에 맡김
            result += Pickax.valueOf(pickString.get(i))
                    .fatigue(stonePick.get(i).getMinerals(),0);
        }

        return result;
    }

    // 돌 곡괭이 기준으로 피로도 계산
    class StonePick {
        private int cost;
        private String[] minerals;

        public StonePick(int cost, String[] minerals) {
            this.cost = cost;
            this.minerals = minerals;
        }

        public int getCost() {
            return cost;
        }

        public String[] getMinerals() {
            return minerals;
        }
    }

    // 각 곡괭이에 따른 광물 5개에 대한 피로도 계산
    enum Pickax{
        DIAMOND (x -> calculateFatigue(x, 1, 1, 1)),
        IRON    (x -> calculateFatigue(x, 5, 1, 1)),
        STONE   (x -> calculateFatigue(x, 25, 5, 1));

        Pickax(Function<String[], Integer> expression){this.expression = expression;}
        private Function<String[], Integer> expression;

        public Integer fatigue(String[] minerals, int y){
            return this.expression.apply(minerals);
        }

        private static int calculateFatigue(String[] minerals, int diamond, int iron, int stone) {
            int fatigue = 0;
            for (String mine : minerals) {
                fatigue += switch (mine) {
                    case "diamond" -> diamond;
                    case "iron" -> iron;
                    case "stone" -> stone;
                    default -> 0;
                };
            }
            return fatigue;
        }
    }

    public static void main(String[] args) {
        MiningMinerals mm = new MiningMinerals();
        System.out.println(
                mm.solution(
                        new int[] {1, 3, 2},
                        new String[] {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}
                )
        );
    }
}
