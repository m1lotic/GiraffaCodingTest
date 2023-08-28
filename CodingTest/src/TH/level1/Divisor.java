package TH.level1;

import java.util.stream.IntStream;

public class Divisor {

    public int solution(int left, int right) {
        // 약수 갯수가 홀수인 경우 = 제곱근이 정수인 경우 -> -num
        return IntStream.rangeClosed(left, right)
                .map(num -> Math.sqrt(num) == (int)(Math.sqrt(num))
                    ? -num : num)
                .sum();
    }
    public static void main(String[] args) {
        Divisor divi = new Divisor();
        System.out.println(divi.solution(13, 17));
    }
}
