package TH.level2;


import java.util.ArrayList;
import java.util.Arrays;
public class BackBIgNum2 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        ArrayList<String> asdas = new ArrayList<>();
        for(int i = numbers.length-2; i >= 0; i--){
            for(int sub = i+1; sub < numbers.length; sub++){
                if(numbers[i] < numbers[sub]) { // 뒷 값이 더 클 때
                    answer[i] = numbers[sub];
                    break;
                }else {                         // 뒷 값이 같거나 작을 때
                    if (answer[sub] == -1) {    // 뒷 값의 뒤보다 큰 값이 없다
                        answer[i] = -1;
                        break;
                    } else if(numbers[i] < answer[sub]){
                        answer[i] = answer[sub];
                        break;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        BackBIgNum2 bbn = new BackBIgNum2();
        System.out.println(Arrays.toString(bbn.solution(new int[] {9, 1, 5, 3, 6, 2})));
        System.out.println(Arrays.toString(bbn.solution(new int[] {2, 3, 3, 5})));
    }
}
