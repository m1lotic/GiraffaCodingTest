package TH.level2;

public class JadenCase2 {
    public String solution(String s) {
        String answer = "";

        boolean isFirst = true;
        for(String str : s.toLowerCase().split("")){
            // 첫번째 값은 대문자
            answer += isFirst ? str.toUpperCase() : str;
            // 첫번째 값인지 판단
            isFirst = " ".equals(str) ? true : false;
        }
        return answer;
    }
    public static void main(String[] args) {
        JadenCase2 jCase = new JadenCase2();
        System.out.println(jCase.solution(" 3people unFollowed me ")+"||");
        System.out.println(jCase.solution("for the last week")+"||");
    }
}
