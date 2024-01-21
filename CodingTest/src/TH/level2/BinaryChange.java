package TH.level2;

import java.util.Arrays;

public class BinaryChange {

    public int[] solution(String s) {
        int cntZero = 0, cntChange = 0;
        while(!s.equals("1")){
            int len = s.length();
            s = s.replaceAll("0","");   // 0뺴고
            cntZero += len - s.length();            // 0 개수만큼 더하고
            s = Integer.toBinaryString(s.length());    // 이진화하고
            cntChange++;    // 카운트 추가
        }
        return new int[] {cntChange, cntZero};
    }
    public static void main(String[] args) {
        BinaryChange bC = new BinaryChange();
        System.out.println(Arrays.toString(bC.solution("110010101001")));
    }
}
