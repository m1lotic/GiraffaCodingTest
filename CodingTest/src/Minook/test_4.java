package Minook;

public class test_4 {

	public static void main(String[] args) {
		

	}
	
	
	
	//1. 그리워하는 사람의 이름을 담은 문자열 배열 name, 
//	각 사람별 그리움 점수를 담은 정수 배열 yearning, 
//	각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열 photo가 매개변수로 주어질 때, 
//	사진들의 추억 점수를 photo에 주어진 순서대로 배열에 담아 return하는 solution 함수
//	
//	 public int[] solution1(String[] name, int[] yearning, String[][] photo) {
//	        
			//photo의 행개수 만큼 answer가 크기를 갖는다.
//	        int row = photo.length;
//	        int[] answer = new int[row];
	
			//for-each문을 사용하는 대신 포인터의 역할을 할 cnt 변수 초기화
//	        int cnt = 0;
        
			//2차원 배열 photo를 행별 1차원 배열로 요소를 갖도록 함
//	        for(String pt[] : photo){
//	            for(String j : pt){ // 행별 1차원 배열 pt[]의 요소를 갖는 j
//	                for(int i=0; i<name.length; i++){
//	                if(j.equals(name[i])){
//	                 answer[cnt] += yearning[i];   
//	                    }
//	                }
//	            }
//	            cnt ++;
//	        }
//	          return answer;   
//	    }
	
	//2. 정수 n, m과 다시 페인트를 칠하기로 정한 구역들의 번호가 담긴 정수 배열 section이 매개변수로 주어질 때 롤러로 페인트칠해야 하는 최소 횟수를 return 하는 solution 함수를 작성해 주세요.
//    public int solution(int n, int m, int[] section) {
//        int start = section[0];
//        int end = section[0] + (m-1);
//        int res = 1;
//            
//        for(int i : section){
//            if(i>=start && i<=end)
//                continue;
//            else{
//                start = i;
//                end = i + (m-1);
//                res++;
//            }
//            
//        }
//        return res;
//    }
	
	//3.1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열배열 keymap과 입력하려는 문자열들이 담긴 문자열 배열 targets가 주어질 때, 
	//각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return 하는 solution 함수를 완성해 주세요.
//    public int[] solution(String[] keymap, String[] targets) {
//        int[] answer = new int[targets.length];
//        int cnt = 0;
//        
//        for(String s : keymap){
//            
//           ArrayList<String> sList = new ArrayList<>(); 
//            int aCnt = 0;
//            
//            for(int i = 0; i<s.length(); i++){
//                sList.add(s.substring(i,i+1));
//            }
//            
//            for(int j = 0; j<targets[cnt].length(); j++){
//                for(int k = 0; k<sList.size(); k++){
//                if(targets[cnt].substring(j,j+1))
//                    break;
//                }
//            }
//                answer[cnt] = aCnt; 
//                
//            cnt++; 
//        }
//        
//        return answer;
//    
//    }
	
	//4.문자열로 이루어진 배열 cards1, cards2와 원하는 단어 배열 goal이 매개변수로 주어질 때, 
	//cards1과 cards2에 적힌 단어들로 goal를 만들 있다면 "Yes"를, 만들 수 없다면 "No"를 return하는 solution 함수를 완성해주세요.
//    public String solution(String[] cards1, String[] cards2, String[] goal) {
//        
//        int cardIdx1 = 0;
//        int cardIdx1Max = cards1.length;
//        int cardIdx2 = 0;
//        int cardIdx2Max = cards2.length;
//
//        for (int i = 0; i < goal.length; i++) {
//            String curStr = goal[i];
//            if (cardIdx1 < cardIdx1Max && curStr.equals(cards1[cardIdx1])) {
//                cardIdx1++;
//            } else if (cardIdx2 < cardIdx2Max && curStr.equals(cards2[cardIdx2])) {
//                cardIdx2++;
//            } else {
//                return "No";
//            }
//        }
//
//        return "Yes";
//    }
	
	//5. 네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다. 
	// 다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.
	// 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
	
    public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
        String x;

      for(int i = 0 ; i < n ; i++){
          x = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i])); // 2진수 - 10진수 변형, 최대 16까지.
          x = x.substring(x.length() - n); 
          x = x.replaceAll("1", "#");
          x = x.replaceAll("0", " ");
          answer[i] = x;
      }

      return answer;
  }
    
    //6. 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다. 
    // 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 이때의 지갑 크기는 4000(=80 x 50)입니다.
    // 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다. 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
    class Solution {
        public int solution(int[][] sizes) {
        int answer = 0;
        int max_w=0;
        int max_h=0;
        for(int i=0;i<sizes.length;i++){
            int w=Math.max(sizes[i][0],sizes[i][1]);
            int h=Math.min(sizes[i][0],sizes[i][1]);
            max_w=Math.max(max_w,w);
            max_h=Math.max(max_h,h);
        }
        answer=max_w*max_h;
        return answer;
        }
}
}
