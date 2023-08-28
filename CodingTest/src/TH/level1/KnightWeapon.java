package TH.level1;

import java.util.stream.IntStream;

public class KnightWeapon {
    public int divisor(int num){
        int cnt = 0;
            // 제곱근 이전까지의 약수 판별
        for(double i = 0; i < Math.sqrt(num); i++){
            if(num%i == 0) cnt++;
        }
            // 제곱근 판별 전까진 약수의 개수가 cnt*2이니
            //    제곱근은 return 쪽에서 판별
        return num % Math.sqrt(num) == 0 ? cnt*2+1 : cnt*2;
    }
    public int solution(int number, int limit, int power) {
//        int answer = 0;
//        for(int i = 1; i <= number; i++){
//            answer += divisor(i) > limit ? power : divisor(i);
//        }
//        return answer;
            // 1~number까지 반복
            // 약수 개수가 limit보다 크면 power, 아니면 약수 개수
            // 이후 합산
        return IntStream.rangeClosed(1, number)
                .map(num -> divisor(num) > limit ? power : divisor(num))
                .sum();
    }
    public static void main(String[] args) {
        KnightWeapon kw = new KnightWeapon();
        System.out.println(kw.solution(
                5, 3, 2
        ));
        System.out.println(kw.solution(
                10, 3, 2
        ));

    }
}
