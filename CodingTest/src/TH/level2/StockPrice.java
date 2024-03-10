package TH.stack_queue.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int idx = 0;
        // 큐 생성
        Queue<Integer> stock = new LinkedList<>();
            // 주식 큐에 넣기
        Arrays.stream(prices).forEach(stock::add);

        while(!stock.isEmpty()){
            int currentShare = stock.poll();
            int countTime = 0;
            for(int price : stock){
                countTime++;
                if(currentShare > price || countTime >= stock.size()) {
                    answer[idx++] = countTime;
                    break;
                }
            }
        }
        // 마지막은 무조건 0초
        answer[prices.length-1] = 0;
        return answer;
    }
    public static void main(String[] args) {
        StockPrice sp = new StockPrice();
        sp.solution(new int[]{1, 2, 3, 2, 3});
    }
}
