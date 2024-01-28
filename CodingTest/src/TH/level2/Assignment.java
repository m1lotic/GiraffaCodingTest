package TH.stack_queue.stack;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

// 과제를 받은 루는 다음과 같은 순서대로 과제를 하려고 계획을 세웠습니다.
//
// 과제는 시작하기로 한 시각이 되면 시작합니다.
// 새로운 과제를 시작할 시각이 되었을 때, 기존에 진행 중이던 과제가 있다면 진행 중이던 과제를 멈추고 새로운 과제를 시작합니다.
// 진행중이던 과제를 끝냈을 때, 잠시 멈춘 과제가 있다면, 멈춰둔 과제를 이어서 진행합니다.
// 만약, 과제를 끝낸 시각에 새로 시작해야 되는 과제와 잠시 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행합니다.
// 멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작합니다.
// 과제 계획을 담은 이차원 문자열 배열 plans가 매개변수로 주어질 때,
// 과제를 끝낸 순서대로 이름을 배열에 담아 return 하는 solution 함수를 완성해주세요.
public class Assignment {

    class Plan {
        String name;
        int currentTime;
        int duration;
        public Plan(String[] plan) {
            this.name = plan[0];
            this.currentTime = calculate(plan[1]);
            this.duration = Integer.parseInt(plan[2]);
        }
        public int calculate(String time){
            String[] times = time.split(":");
            return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        }
    }
    public String[] solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();
        // Plan 클래스 리스트 생성
        List<Plan> planList = Arrays.stream(plans).map(Plan::new)
                // 시간 순으로 정렬
                .sorted(Comparator.comparing((plan)->plan.currentTime)).toList();
        Stack<Plan> processing = new Stack<>();
        for(int index = 0; index < planList.size(); index++){
            Plan current = planList.get(index);
            //우선적으로는 마지막 타임이었다면, 그냥 답에 추가해주면 된다.
            if (index == plans.length - 1) {
                answer.add(current.name);
            } else {
                Plan next = planList.get(index+1);
                int remainTime = next.currentTime - current.currentTime;
                // 일단 스택에 추가
                processing.push(current);
                // processing에 대해서 순회하고 remain이 0이 라면, 정답에 추가함.
                while (!processing.isEmpty() && remainTime > 0) {
                    Plan nowProcessing = processing.pop(); //최근에 진행했던 공부를 불러옴.
                    int played = Math.min(remainTime, nowProcessing.duration); //진행한 공부 시간

                    //처리가 가능한 공부인 경우 정답에 추가.
                    if (played == nowProcessing.duration) {
                        answer.add(nowProcessing.name);
                    } else { //아닌 경우는 다시 processing 대기열에 공부시간을 차감하여 추가함.
                        nowProcessing.duration -= played;
                        processing.add(nowProcessing);
                    }
                    remainTime -= played;
                }
            }
        }
        while (!processing.isEmpty()) {
            answer.add(processing.pop().name);
        }
        return answer.toArray(String[]::new);
    }

    public static void main(String[] args) {
        Assignment as = new Assignment();
        Arrays.stream(as.solution(
                new String[][]{{"korean", "12:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}}
        )).forEach(System.out::println);
        Arrays.stream(as.solution(
                new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}}
        )).forEach(System.out::println);
    }
}
