package TH.level2;

// 정수 n이 매개변수로 주어집니다.
// 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
// 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
public class TriangleSnail {
    public int[] solution(int n) {
        // 삼각형 방향 지시
        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, -1};
        // 요청한 배열 2차원으로 생성
        int[][] triangle = new int[n][n];
        // 현재 좌표/방향/입력할 숫자 설정
        int x= 0, y = 0, direction = 0, num = 1;
        // 그래프 그리기
        while(true){
            // 값 입력하고
            triangle[y][x] = num++;
            // 다음 방향 설정
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            // 끝에 도달하면 방향 바꿈
            if(nx == n || ny == n || triangle[ny][nx] != 0){
                direction = (direction + 1) % 3;
                nx = x + dx[direction];
                ny = y + dy[direction];
                if(nx == n || ny == n || triangle[ny][nx] != 0)
                    break;
            }
            x = nx;
            y = ny;
        }
        // num++로 설정해놔서 배열 만들 때 -1하기
        int[] answer = new int[num-1];
        int index = 0;
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[index++] = triangle[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        TriangleSnail ts = new TriangleSnail();
        ts.solution(6);
    }
}
