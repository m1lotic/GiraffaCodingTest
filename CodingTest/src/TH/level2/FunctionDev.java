package TH.level2;

import java.util.*;

public class FunctionDev {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int idx = 0; idx < progresses.length; idx++){
            int progessing = 100 - progresses[idx]; // 남은 진도
                    // 남은진도/속도에서 나머지가 있다면 +1일을 해주고 아니면 그대로
            int result = progessing%speeds[idx] > 0 ? progessing/speeds[idx]+1 : progessing/speeds[idx];
            // 판별식을 썼는데 그냥 Math.ceil(progessing/speeds[idx])로 올림하면 되는거였음;
            queue.add(result);
        }
        int numberOfProgress = 1, pre_progress = 0;
        while(queue.size()>1){
            pre_progress = Math.max(pre_progress, queue.poll());    // 먼저 꺼낸 작업 중 제일 큰 값
            int progress = queue.peek();        // 현재 꺼낸 작업
            // 먼저 꺼낸 기능보다 작업이 길거나 마지막 작업이라면
            if(pre_progress < progress){
                answer.add(numberOfProgress);     // 현재 작업을 포함해서 저장
                numberOfProgress = 1;       // 저장했으니 카운터 초기화
            } else numberOfProgress++;     // 작업 카운터 증가

            if(queue.size() == 1){      // 마지막 값을 저장할땐 판별이 필요없으니 그대로 저장
                answer.add(numberOfProgress);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
    // 5일, 10일, 1일, 1일, 20일, 1일
    // 1               3         2
    public int[] solution1(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        int day = -1, result = 1;
        for(int idx = 0; idx < progresses.length; idx++){
            int this_day =  (int)Math.ceil((100 - progresses[idx])/(double)speeds[idx]); // 남은 진도, 나누기 쓸 떄 한쪽 double만드는거 까먹지 말기
            System.out.printf("day = %d / this_day = %d\n",day, this_day);
            // Math.ceil(progessing/speeds[idx])로 올림
            if(day < this_day){       // 다음 작업이 더 크면 지금까지의 작업 갯수 저장+초기화
                day = this_day;
                if(idx==0) continue;    // 첫칸 비교는 의미없는 값이니 버림
                queue.add(result); result = 1;
            }else{
                result++;
            }
        }
        queue.add(result);    // 마지막은 판별할 필요 없음 -> 그대로 저장
        // 저장한 작업 개수 배열 answer로 이동
        int[] answer = new int[queue.size()];
        int idx = 0;
        while(!queue.isEmpty()){
            answer[idx++] = queue.poll();
        }
        return answer;
    }
    public static void main(String[] args) {
        FunctionDev fD = new FunctionDev();
        System.out.println(Arrays.toString(fD.solution1(
                new int[] {96,94},
                new int[] {3,3}
        )));
    }

}
