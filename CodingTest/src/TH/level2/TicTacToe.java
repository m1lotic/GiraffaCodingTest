package TH.level2;

import java.util.ArrayList;
import java.util.List;

// 혼자서 하는 틱택토
// 1. "O"와 "X"의 개수 : 같거나 O가 +1
// 2. "O" == "X", 완성 못 시키는 경우 or X 승리
// 3. "O"+1 == "X", 완성 못 시키는 경우 or O 승리
public class TicTacToe {
    public int solution(String[] board) {
        TicTac ticTac = new TicTac(board);
        if (ticTac.O == ticTac.X || ticTac.O == ticTac.X + 1) {
            int cnt = 0;
            for (List<Integer> OX : ticTac.location) {
                if (OX.contains(1)) {
                    if (OX.contains(4) && OX.contains(7))   // 아래
                        ticTac.bingo[cnt]++;
                    else if (OX.contains(2) && OX.contains(3))  // ->
                        ticTac.bingo[cnt]++;
                    else if (OX.contains(5) && OX.contains(9))  // 대각선
                        ticTac.bingo[cnt]++;
                }
                if (OX.contains(2)) {
                    if (OX.contains(5) && OX.contains(8))   // 아래
                        ticTac.bingo[cnt]++;
                }
                if (OX.contains(3)) {
                    if (OX.contains(6) && OX.contains(9))   // 아래
                        ticTac.bingo[cnt]++;
                    else if (OX.contains(5) && OX.contains(7))  // 대각선
                        ticTac.bingo[cnt]++;
                }
                if (OX.contains(4)) {
                    if (OX.contains(5) && OX.contains(6))  // ->
                        ticTac.bingo[cnt]++;
                }
                if (OX.contains(7)) {
                    if (OX.contains(8) && OX.contains(9))  // ->
                        ticTac.bingo[cnt]++;
                }
                cnt++;
            }
            // 둘다 빙고가 있는 경우
            if (ticTac.bingo[0] > 0 && ticTac.bingo[1] > 0)
                return 0;

            // 선공이 이겼는데 후공이 둔 경우
            if (ticTac.bingo[0] > 0 && ticTac.O == ticTac.X)
                return 0;

            // 후공이 이겼는데 선공이 둔 경우
            if (ticTac.bingo[1] > 0 && ticTac.O > ticTac.X)
                return 0;
            return 1;
        }
        return 0;
    }

    class TicTac {
        int O;
        int X;
        int[] bingo;
        List<List<Integer>> location;

        private TicTac(String[] board) {
            this.O = 0;
            this.X = 0;
            this.bingo = new int[2];
            ArrayList<Integer> locationO = new ArrayList<>();
            ArrayList<Integer> locationX = new ArrayList<>();
            location = new ArrayList<>();

            int cnt = 1;
            for (String row : board) {
                for (String element : row.split("")) {
                    if ("O".equals(element)) {
                        this.O++;
                        locationO.add(cnt);
                    } else if ("X".equals(element)) {
                        this.X++;
                        locationX.add(cnt);
                    }
                    cnt++;
                }
            }
            this.location.add(locationO);
            this.location.add(locationX);
        }
    }
    public static void main (String[]args){
        TicTacToe ttt = new TicTacToe();
        System.out.println(
            ttt.solution(new String[]{
                    "O.X", ".O.", "..X"
            })
        );
        System.out.println(
            ttt.solution(new String[]{
                    "OOO", "...", "XXX"
            })
        );
        System.out.println(
            ttt.solution(new String[]{
                "...", ".X.", "..."
            })
        );
        System.out.println(
            ttt.solution(new String[]{
                    "...", "...", "..."
            })
        );
    }
}