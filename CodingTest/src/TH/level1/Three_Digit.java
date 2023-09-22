package TH.level1;

public class Three_Digit {
    public int solution(int n) {
        // Integer.parseInt(n, 3)은 문제 의도가 아닌 것 같아서 쓰지 않음
        // 3진법으로 치환
        String answer = "";
        while(n>0){
            answer += n%3;
            n /= 3;
        }

        // 어차피 for문을 앞자리부터 돌릴거라 안 뒤집음
        Long longN = Long.parseLong(answer);
        // for문 돌릴 반복 수(answer의 자리수 저장)
        int idx = String.valueOf(longN).length();

        // 10진법으로 치환
        int m = 0;
        for(int i = 0; i < idx; i++){
            m += longN%10 * (int)(Math.pow(3, i));
            longN /= 10;
        }
        return m;
    }

    public static void main(String[] args) {
        Three_Digit td = new Three_Digit();
        System.out.println(td.solution(125));
    }
}
