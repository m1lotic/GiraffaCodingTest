package TH.level2;

import java.util.Stack;

public class SpinBracket {
/*    public int solution(String s) {
        int answer = 0;
        Stack<Character> bracket;
        for(int x = 0; x < s.length(); x++){   // x만큼 회전 ( x는 s길이-1 )
            bracket = new Stack<>();
            for(int spin = x; spin < x+s.length(); spin++){
                int idx = spin % s.length();
                if(bracket.empty()) {
                    bracket.push(s.charAt(idx));
                    continue;
                }
                switch(s.charAt(idx)){ // 회전한 괄호 스택에 넣기 + 괄호를 직접 움직이지말고 index로 이동하니까 charAt
                    // 닫힌 부분이면 이전이 열려있나 확인
                    case ')':
                        if(bracket.peek().equals('(')) bracket.pop();
                        break;
                    case ']':
                        if(bracket.peek().equals('[')) bracket.pop();
                        break;
                    case '}':
                        if(bracket.peek().equals('{')) bracket.pop();
                        break;
                    default:    // 열린 부분은 push
                        bracket.push(s.charAt(idx));
                        break;
                }
            }
            if(bracket.empty()) answer++;
        }
        return answer;
    }*/

    public static void main(String[] args) {
     /*   SpinBracket sb = new SpinBracket();
        System.out.println(sb.solution("[](){}"));
        System.out.println("****************");
        System.out.println(sb.solution("}}}"));
        System.out.println("****************");
        System.out.println(sb.solution("[)(]"));*/
    }
}
