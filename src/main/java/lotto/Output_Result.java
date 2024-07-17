package lotto;

public class Output_Result {
//결과를 출력하는 함수.
    static void output(int[] lotto_count){
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - "+lotto_count[2]+"개");
        System.out.println("4개 일치 (50,000원) - "+lotto_count[3]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+lotto_count[4]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+lotto_count[5]+"개");
        System.out.println("6개 일치, 보너스 볼 일치 (2,000,000,000원) - "+lotto_count[6]+"개");
    }

}
