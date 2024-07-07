package TH;
// 문자열 압축
public class Q240707 {
    public int solution(String s) {
        int len = s.length();
        // 가장 짧은 길이를 찾아야 하니 최대값 설정
        int answer = len;
        // 현 문자열 중복 횟수
        int cnt = 1;
        if(len == 1) return 1;  // s의 길이가 1일때 바로 반환
        // 압축 단위 갯수 설정 (1은 리턴했으니까 바로 1부터)
        // 최대 압축 단위는 전체 길이의 절반
        for(int compression_cnt = 1; compression_cnt <= len/2; compression_cnt++){
            String result = "";
            String base = s.substring(0, compression_cnt);
            // 현재 탐색 문자열
                // 첫 반복은 base가 확인했으니 바로 다음 부분부터, 압축 단위만큼 추가
            for(int current_idx = compression_cnt; current_idx <= len; current_idx += compression_cnt){
                int last_idx = Math.min(current_idx + compression_cnt, len); // s 길이는 못 넘김
                // base와 비교할 문자열 (압축가능한지)
                String compare = s.substring(current_idx, last_idx);
                    // base와 같으면 cnt 추가
                if(base.equals(compare)){
                    cnt++;
                    // base와 다르면 result에 저장 (반복이 2회 이상이면 cnt추가)
                } else {
                    if (cnt >= 2) {
                        result += cnt;
                    }
                        result += base;
                        base = compare;
                        cnt = 1;
                    }
                }
            result += base; // 압축 단위만큼 체크하고 남은 문자열 추가
            answer = Math.min(answer, result.length()); // 이전 결과와 이번 압축 단위 결과 비교
            // 문자열의 연산이 자주 이뤄지는경우, String 보단 StringBuilder를 활용하여 부하를 줄이자
            }
        return answer;
    }
    public static void main(String[] args) {
        Q240707 q = new Q240707();
        int answer = q.solution("ababcdcdababcdcd");
        System.out.println(answer);
    }
}
