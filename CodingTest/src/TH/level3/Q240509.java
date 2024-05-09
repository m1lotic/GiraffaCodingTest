package TH.stack_queue.queue;
//  이중우선순위큐

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Q240509 {
    static final boolean DELETE_MAX = true;
    static final boolean DELETE_MIN = false;

    public static int[] solution(String[] operations) {
        Queue<Integer> valQueue = new LinkedList<>();
        // 스트림 탐색일 땐 break와 같은 순회 탈출이 불가능해서 for문으로 대체
        for (String op : operations) {
//          삭제하는 명령인지 우선 확인 후 대상이 최대값인지 최소값인지 판단하여 boolean 값에 저장
            if ('D' == op.charAt(0)) {
                boolean deleteCheck = "D 1".equals(op) ? DELETE_MAX : DELETE_MIN;
                // 실제 데이터 큐가 빈 큐인지 확인 비었으면 연산 무시
                if (!valQueue.isEmpty()) {
                    // 명령어에 따라 데이터 제거
                    // 스트림 연산은 Optional<Integer> 형식으로 반환되기 때문에 예외처리
                    int deleteData = deleteCheck
                            ? valQueue.stream().max(Comparator.comparingInt(val -> val)).orElseThrow(QueueDataError::new)
                            : valQueue.stream().min(Comparator.comparingInt(val -> val)).orElseThrow(QueueDataError::new);
                    valQueue.remove(deleteData);
                }
                // 실제 큐에 담기는 값들
            } else valQueue.add(Integer.parseInt(op.split(" ")[1]));
        }

        // 데이터 큐가 비었으면 0,0 반환
        if (valQueue.isEmpty()) return new int[]{0, 0};
        int maxData = valQueue.stream().max(Comparator.comparingInt(x -> x))
                .orElseThrow(QueueDataError::new);
        int minData = valQueue.stream().min(Comparator.comparingInt(x -> x))
                .orElseThrow(QueueDataError::new);
        return new int[]{maxData, minData};
    }

    // 임시 예외처리
    public static class QueueDataError extends RuntimeException {
        public QueueDataError() {
            super("데이터 큐에서 값이 추출되지 않습니다.");
        }
    }

    public static void main(String[] args) {
//        int[] answer = solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        int[] answer = solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
    }
}
