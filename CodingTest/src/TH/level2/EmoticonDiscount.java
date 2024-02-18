package TH.level2;

import java.util.*;

public class EmoticonDiscount {
    public static List<int[]> permMap = new ArrayList<>();
    public static int[][] inputUsers;
    public static int[] inputEmoticons;

    public static void permutation(int[] arr, int[] currentDiscount, int depth, int r){
        if(depth == r){
            int plus = 0;           // 플러스 구독
            int totalPrice = 0;     // 총 비용
            for(int userIndex = 0; userIndex < inputUsers.length; userIndex++){
                // 해당 유저의 이모티콘 구매 금액
                int userPrice = 0;
                for(int emoticonIndex = 0; emoticonIndex < inputEmoticons.length; emoticonIndex++){
                    // 할인율 확인
                    if(currentDiscount[emoticonIndex] >= inputUsers[userIndex][0]) {
                        // 할인율 적용
                        userPrice += inputEmoticons[emoticonIndex] * (1 - (double)currentDiscount[emoticonIndex] / 100);
                    }
                }
                // 플러스 구독 가능 체크
                if(userPrice >= inputUsers[userIndex][1]) plus++;
                else totalPrice += userPrice;
            }
            // 해당 순열 결과값 저장
            permMap.add(new int[] {plus, totalPrice});
            return;
        }
        for(int i=0; i<arr.length; i++){
            currentDiscount[depth] = arr[i];
            permutation(arr, currentDiscount, depth+1, r);
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        int[] discountRate = {10, 20, 30, 40};
        inputUsers = users;
        inputEmoticons = emoticons;
        // 이모티콘 순열 생성
        permutation(discountRate, new int[emoticons.length], 0, emoticons.length);

        // 순열 정렬
        permMap.sort((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        return permMap.get(0);
    }
    public static void main(String[] args) {
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};
//        int[][] users = {{40, 10000}, {25, 10000}};
//        int[] emoticons = {7000, 9000};
        EmoticonDiscount ed = new EmoticonDiscount();
        Arrays.stream(ed.solution(users, emoticons)).forEach(System.out::println);
    }
}
