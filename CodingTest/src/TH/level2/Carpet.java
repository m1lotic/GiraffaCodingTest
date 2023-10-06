package TH.ExhaustiveSearch;

import java.util.Arrays;
import java.util.stream.IntStream;

// 완전탐색
/*
    Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
    Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때
    카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

 ○ ○ ○ ○ ○  1. yellow의 약수를 통해 가로/세로 길이 파악
 ○ ●  ● ● ○   2. 계산한 가로/세로 길이 X 2 + 4(각 꼭지점)이 brown개수와 같음
 ○ ●  ● ● ○   3. brown 가로/세로 길이는 계산된 가로/세로 길이 + 2(각 꼭지점)
 ○ ○ ○ ○ ○
 */
public class Carpet {
    public int[] solution(int brown, int yellow) {
        // yellow의 약수를 구해서
        //  각 약수 값의 *2 + 4 가 brown와 맞으면 정답
        int[] yellowDiv = IntStream.rangeClosed(1, (int)Math.sqrt(yellow)).filter(i -> (double) yellow /i-(int)(yellow/i)==0.0).toArray();
        for(int div : yellowDiv){
            int div2 = yellow/div;  // 긴쪽이 가로니까 div2부터 리턴
            if(brown == (div+div2)*2 + 4) return new int[]{div2+2, div+2};
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        Carpet capt = new Carpet();
//        System.out.println(Arrays.toString(capt.solution(10, 2)));
//        System.out.println(Arrays.toString(capt.solution(8, 1)));
//        System.out.println(Arrays.toString(capt.solution(24, 24)));
        System.out.println(Arrays.toString(capt.solution(24, 25)));
    }
}
