package TH.level1;

import java.util.Arrays;

public class KimWest {
    public String solution(String[] seoul) {
        return "김서방은 "+Arrays.asList(seoul).indexOf("Kim")+"에 있다";
    }
    public static void main(String[] args) {
        KimWest kw = new KimWest();
        System.out.println(kw.solution(new String[]{"Jane","Kim"}));
    }
}
