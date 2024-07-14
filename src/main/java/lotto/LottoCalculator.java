package lotto;
import game.Application;
import game.UserService;
import java.util.List;


public class LottoCalculator {

    public int[] matchingWinningNumber(int[]winningNumber, int bonusNumber, List<Lotto> lottos) {
        int[] matchingResult = new int[5];

        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            int count = 0;
            boolean matchingBonusNumber = false;
            List<Integer> numbers = lotto.getNumber();

            for (int j = 0; j < numbers.size(); j++) {
                int number = numbers.get(j);

                for (int k = 0; k < winningNumber.length; k++) {
                    if (number == winningNumber[k]) {
                        count++;
                    }
                }

                if (number == bonusNumber) {
                    matchingBonusNumber = true;
                }
            }

            // 6개 일치
            if (count == 6) {
                matchingResult[0]++;
                continue;
            }

            // 5개 + 보너스
            if (count == 5 && matchingBonusNumber) {
                matchingResult[1]++;
                continue;
            }

            // 5개 일치
            if (count == 5) {
                matchingResult[2]++;
                continue;
            }

            // 4개 일치
            if (count == 4) {
                matchingResult[3]++;
                continue;
            }

            // 3개 일치
            if (count == 3) {
                matchingResult[4]++;
            }
        }

        return matchingResult;
    }

    public int calculateTotalPrizeMoney(int[]matchingResult){
        int totalPrizeMoney=0;
        if(matchingResult[4]!=0){ //3개 일치 오천원
            for(int i=0;i<matchingResult[4];i++){
                totalPrizeMoney+=5000;
            }

        }
        if(matchingResult[3]!=0){ //4개 일치 오만원
            for(int i=0;i<matchingResult[3];i++){
                totalPrizeMoney+=50000;
            }

        }
        if(matchingResult[2]!=0){ //5개 일치 백오십마넌 00000
            for(int i=0;i<matchingResult[2];i++){
                totalPrizeMoney+=1500000;
            }

        }
        if(matchingResult[1]!=0){ //5개 일치 + 보너스 30000000 3천
            for(int i=0;i<matchingResult[1];i++){
                totalPrizeMoney+=30000000;
            }
        }
        if(matchingResult[0]!=0){ //6개 일치 20억 09갸
            for(int i=0;i<matchingResult[0];i++){
                totalPrizeMoney+=2000000000;
            }
        }

        return totalPrizeMoney;
    }

    public double calculateProfitRate(int lottoQuantity, int totalPrizeMoney) {
        double cost = lottoQuantity*1000.0;
        double profitRate =  (totalPrizeMoney-cost)/cost*100.0;

        return profitRate;
    }



}
