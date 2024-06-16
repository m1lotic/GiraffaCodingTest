package TH.level2;

public class Q240616 {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String[] oneTwoFour = {"4", "1", "2"};
        while(n > 0){
            // StringBuilder메소드
            answer.insert(0, oneTwoFour[n % 3]);
                // String 사용시
                // answer = oneTwoFour[n % 3] + answer;
            // 진법에 0이 없어서 n-1을 해줘야함
            n = (n-1) / 3;
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Q240616 n124 = new Q240616();
        System.out.println(n124.solution(9));
    }
}
// 1   1
// 2   2
// 3   4
// ------
// (3*1)+1  11
// (3*1)+2  12
// (3*1)+3  14
// ------
// (3*2)+1  21
// (3*2)+2  22
// (3*2)+3  24
// ------
// (3*3)+1 41 -> 10
// (3*3)+2 42 -> 11
// (3*3)+3 44 -> 12
// ------
// (3^2*1)+(3*1)+1  111 -> 13
// (3^2*1)+(3*1)+2  112 -> 14
// (3^2*1)+(3*1)+3  114 -> 15


// 12 % 3 -> 0
    // 4 % 3 -> 1
    // 1 % 3 -> 1
// 13 % 3 -> 1
    // 4 % 3 -> 1
    // 1 % 3 -> 1
// 14 % 3 -> 2
    // 4 % 3 -> 1
    // 1 % 3 -> 1

// 8 % 3 -> 2
    // 2 % 3 -> 2
// 9 % 3 -> 0
    // 3 % 3 -> 0
    // 1 % 3 -> 1
