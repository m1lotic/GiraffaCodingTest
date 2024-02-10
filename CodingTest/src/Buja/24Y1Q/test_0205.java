package Buja; // syntax error
public class test_0205 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
// 혼자서 하는 틱택토
/* 해결일 : 2월 10일 오후 8시 54분
   문제점 : 문제 특성상 완전 탐색으로 모든 예외의 경우를 다 찾아서
           모든 예외가 아닌 경우에만 1을 리턴할 수 있도록 했다
           큰 범위부터 작은 범위로 리턴을 줘서 최대한 탐색횟수를 줄이도록 처리했다.
           어차피 경우의 수는 9! 밖에 되지 않기 때문이다.
           더 나은 방안이 있지는 않아보였다.
           가로, 세로는 찾았는데, 대각선 조건을 놓쳐서 시간이 걸렸다.(대각선도 되어야 함)
           코드가 반복이 너무많아서 반복 정렬은 할 수 있지 않을까 싶다.
*/

class Solution {
    public int solution(String[] board) {
        int answer = 1;
        
        // O, X 몇개인지 세기
        int o_cnt = 0;
        int x_cnt = 0;
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)=='O'){
                    o_cnt++;
                }
                else if(board[i].charAt(j)=='X'){
                    x_cnt++;
                }
            }
        }
        
        // x의 개수가 많을 수 없음(x: 후공)
        if(o_cnt < x_cnt) return 0;
        
        // o의 개수가 2개 이상 차이 날 수 없음(선->후->선->후)
        // x의 개수의 경우 위에서 검토했으므로 제외
        if(o_cnt - x_cnt > 1 ) return 0;
        
        // 게임이 끝났는데('OOO' || 'XXX' 가 됐는데) 계속 진행한 경우(O를 더 긋던지, x를 더 긋던지)
        // [가로]
        for(int i=0;i<board.length;i++){
            if(board[i].equals("OOO")){
                if(o_cnt -1 < x_cnt) return 0;
            }
            if(board[i].equals("XXX")){
                if(o_cnt > x_cnt) return 0;
            }
        }
        
        // [세로]
        for(int i=0;i<board.length;i++){
            if(board[0].charAt(i)=='O'){
                if(board[1].charAt(i)=='O'){
                    if(board[2].charAt(i)=='O'){
                        if(o_cnt -1 < x_cnt) return 0;
                    }
                }
            }
        }
        
        // [대각선]
        for(int i=0;i<board.length;i++){
            if(board[0].charAt(0)=='O'){
                if(board[1].charAt(1)=='O'){
                    if(board[2].charAt(2)=='O'){
                        if(o_cnt -1 < x_cnt) return 0;
                    }
                }
            }
        }
        
        for(int i=0;i<board.length;i++){
            if(board[0].charAt(2)=='O'){
                if(board[1].charAt(1)=='O'){
                    if(board[2].charAt(0)=='O'){
                        if(o_cnt -1 < x_cnt) return 0;
                    }
                }
            }
        }
        
        // [대각선(X)]
        for(int i=0;i<board.length;i++){
            if(board[0].charAt(0)=='X'){
                if(board[1].charAt(1)=='X'){
                    if(board[2].charAt(2)=='X'){
                         if(o_cnt > x_cnt) return 0;
                    }
                }
            }
        }
        
        for(int i=0;i<board.length;i++){
            if(board[0].charAt(2)=='X'){
                if(board[1].charAt(1)=='X'){
                    if(board[2].charAt(0)=='X'){
                         if(o_cnt > x_cnt) return 0;
                    }
                }
            }
        }
        
        return answer;
    }
}





// ChatGPT 코드 리팩토링
class Solution {
    public int solution(String[] board) {
        int o_cnt = 0;
        int x_cnt = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') {
                    o_cnt++;
                } else if (board[i].charAt(j) == 'X') {
                    x_cnt++;
                }
            }
        }

        if (o_cnt < x_cnt || o_cnt - x_cnt > 1) {
            return 0;
        }

        if (checkWinningCondition(board, 'O') && o_cnt - 1 < x_cnt) {
            return 0;
        }

        if (checkWinningCondition(board, 'X') && o_cnt > x_cnt) {
            return 0;
        }

        return 1;
    }

    private boolean checkWinningCondition(String[] board, char player) {
        for (int i = 0; i < board.length; i++) {
            if (board[i].equals(new String(new char[] { player, player, player }))) {
                return true; // Check horizontal winning condition
            }

            if (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) {
                return true; // Check vertical winning condition
            }
        }

        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) {
            return true; // Check diagonal winning condition
        }

        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) {
            return true; // Check reverse diagonal winning condition
        }

        return false;
    }
}
	
