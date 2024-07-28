package TH.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class Q240728 {
    int num;
    // 지도 탐험
    void mapsCheck(char[][] arr, int i, int j){
        // char형 숫자 int로 변환
        num += Character.getNumericValue(arr[i][j]);
        arr[i][j] = 'X';
        // 지도 바깥 확인
        if(i+1 != arr.length && arr[i+1][j] != 'X') mapsCheck(arr, i+1, j);
        if(j+1 != arr[0].length && arr[i][j+1] != 'X') mapsCheck(arr, i, j+1);
        // 외딴섬 확인
        if(i != 0 && arr[i-1][j] != 'X') mapsCheck(arr, i-1, j);
        if(j != 0 && arr[i][j-1] != 'X') mapsCheck(arr, i, j-1);
    }

    public int[] solution(String[] maps) {
        ArrayList<Integer> sum = new ArrayList<>();
        // 문자열 좌표로 나누기
        char[][] mapsArr = new char[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                mapsArr[i][j] = maps[i].charAt(j);
            }
        }
        // 지도 탐험
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                // 현재 좌표가 섬 내부일 때 다음 지도 탐험
                if(mapsArr[i][j] != 'X')
                    mapsCheck(mapsArr, i, j);
                // 전체 좌표 값 추가 후 변수 초기화
                if(num != 0){
                    sum.add(num);
                    num = 0;
                }
            }
        }
        // 섬 갯수만큼 배열 생성
        int[] answer = new int[sum.size() == 0 ? 1 : sum.size()];
        // 없으면 -1 반환, 있으면 배열에 기재
        if(sum.size() == 0)
            answer[0] = -1;
        else
            for(int i = 0; i < answer.length; i++)
                answer[i] = sum.get(i);
        // 정렬
        Arrays.sort(answer);

        return answer;
    }
    public static void main(String[] args) {
        Q240728 q = new Q240728();
        q.solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"});
    }
}
