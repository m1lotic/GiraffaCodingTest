package TH.greedy;
//문제 설명
//조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
//ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
//
//조이스틱을 각 방향으로 움직이면 아래와 같습니다.
//
//▲ - 다음 알파벳
//▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
//◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
//▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
//예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.
//
//- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
//- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
//- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
//따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.

public class JoyStick {
    // 정방향 탐색에서 연속된 A의 끝을 확인하는 인덱스
    private static int findingEndPoint (String name, int idx){
        while(idx < name.length() && name.charAt(idx) == 'A') idx++;
        return idx;
    }
    
    public int solution(String name) {
        // 상-하 변경 값 계산                // Z로 만드는데 1회 필요
        int upDownCost =  name.chars().map(ch -> Math.min(ch-'A', 'Z'-ch+1)).sum();

        // front : 탐색된 인덱스
        int front = 0;
        // end : front가 A를 만났다면 연속된 A가 끝난 뒤의 인덱스
        int end = findingEndPoint(name, front);

        // 좌-우 변경 값 계산
        int leftRightCost = 0;

        while(end < name.length()){
            // front == end일 경우 (A를 만나지 않은 경우) 정방향 탐색으로 남은 거리
            // else, 역방향 진행 시의 거리 (연속된 A 이후 ~ 마지막 인덱스의 거리)
            int backDistance = name.length() - end;

            // 코스트 = A를 만나지 않았다면 그냥 name 길이
//                    or  A를 만났다면 A 이전까지의 정방향 탐색
//                        + 역방향 탐색 시 남은 거리
//                        +
//                             정방향 처리 후, 역방향으로 갈지
//                             역방향 처리 후, 정방향으로 갈지 탐색
            int verCost = front + backDistance + Math.min(front, backDistance);

            // 첫회차거나 현재 탐색 거리가 가장 짧을 때, verCost로 변경
            if(leftRightCost == 0 || leftRightCost > verCost) leftRightCost = verCost;

            // end까지 탐색했으므로 front(탐색 완료된 인덱스) 변경
            front = end;
            // 다음 인덱스 탐색 (A가 나오면 그 끝까지)
            end = findingEndPoint(name, end+1);
        }
        // 상하 값 + 좌우 값
        return upDownCost + Math.min(leftRightCost, front);
    }


    public static void main(String[] args) {
        JoyStick joyStick = new JoyStick();
        System.out.println(joyStick.solution("JAN"));
        System.out.println(joyStick.solution("BCAAAAAAZK"));
    }

}
