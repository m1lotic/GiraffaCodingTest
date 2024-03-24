package TH.level2;

// 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
// 예를 들어 2와 7의 최소공배수는 14가 됩니다.
// 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
// n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class NLeastCommonMultiple {
    public int solution(int[] arr) {
        // 배열에 1개일 때 바로 리턴
        if(arr.length == 1) return arr[0];
        // 유클리드 호제법
        //  = (a * b) / (최대 공약수) -> 최소 공배수
        //  N개의 최대 공약수 = arr[0] -> arr[n]까지 순차적으로 최소 공배수 구하기
        Queue<Integer> lcmQueue = new LinkedList<>(Arrays.stream(arr).boxed().toList());
//        Queue<Integer> lcmQueue = new LinkedList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        int lcm = lcmQueue.poll();
        while(!lcmQueue.isEmpty()){
            int gcd = getGCD(lcm, lcmQueue.peek());
            lcm = ( lcm * lcmQueue.poll()) / gcd;
        }
        return lcm;
    }

    // 최대 공약수 계산
    // 나머지가 0이 될 때까지 num1 % num2 반복
    // 그 결과 값이 되는 나머지가 최대 공약수
    private int getGCD(int num1, int num2){
        if(num1 % num2 == 0){
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }

    public static void main(String[] args) {
        NLeastCommonMultiple mlcm = new NLeastCommonMultiple();
        mlcm.solution(new int[] {2,6,8,14});
    }
}
