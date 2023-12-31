package Buja; // syntax error
public class test_1127 {
	/*인코딩 (한글,영문,한자,일본어 -> 기계어)방식 (한글. UTF-8, EUC-KR)
	EUC-KR(완성형,박)에서 UTF-8(조합형,ㅂ+ㅏ+ㄱ)로 넘어갈때 코딩이 깨질수도 있음. 미리바꿔야함.
	window - preference - workspace - utf8 
	window - preference - contenttype - javaclassfile,text에 utf-8 업데이트
	*/
	//ctrl+shift+f : 줄 이탈 있는 경우 자동정렬
	//ctrl+alt+방향키(위,아래) : 코드복사(커서위치줄의 코드를 밑이나 위에 복사)
	//alt+방향키 : 코드 순서 바꾸기
	
// 의상
/* 해결일 :  2023년 12월 31일 18시 20분
   문제점 : hashMap value를 어떻게 뽑아내는 지 고민을 많이 했었다.
           이 문제는 결국 입지 않는 경우도 있기 때문에
           (의류 종류 별 수 + 1)를 곱한 후에
           1개를 빼주면 정답이 된다.
*/

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String,Integer> clothesMap = new HashMap<>();
        
//         for(int i=0;i<clothes.length;i++)  
//             clothesMap.put(clothes[i][0],clothes[i][1]);
        
        		for(String[] cloth : clothes)
                    clothesMap.put(cloth[1], clothesMap.getOrDefault(cloth[1], 0) + 1);
        
        for(String cloth: clothesMap.keySet()){
                if(clothesMap.get(cloth) >0) answer *= (clothesMap.get(cloth)+1);
        }
        
        answer -=1;
        
        return answer;
    }
}

	}
