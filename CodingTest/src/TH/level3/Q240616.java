package TH.dp;

public class Q240616 {
    public int solution(int[][] triangle) {
        // 역방향으로 계산(상향식)
            // 큰 쪽을 선택한 후, 위 칸과 합치기
        for (int i=triangle.length-1; i>0; i--) {
            for (int j=0; j<triangle[i].length-1; j++) {
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
            }
        }
        return triangle[0][0];
    }

    public static void main(String[] args) {
        Q240616 q240616 = new Q240616();
        q240616.solution(new int[][]
                  {{7},
                  {3, 8},
                 {8, 1, 0},
                {2, 7, 4, 4},
               {4, 5, 2, 6, 5}});
    }
}
