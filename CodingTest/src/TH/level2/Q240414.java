package TH.level2;

public class Q240414 {
    static public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        // 할인 리스트 인덱스
        for(int saleList=0; saleList < discount.length-9; saleList++) {
            int product;
            // 원하는 상품 인덱스
            for(product=0; product < want.length; product++) {
                // 상품 확인
                int check=0;
                for(int discountList = saleList; discountList< saleList+10; discountList++) {
                    if(discount[discountList].equals(want[product])) check++;
                }
                // 원하는 상품 할인 개수 충족하면 패스
                if(check < number[product]) {
                    break;
                }
            }
            // 충족하면 일수 ++
            if(product==want.length) answer ++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[] {3, 2, 2, 2, 1}, new String[] {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    }
}
