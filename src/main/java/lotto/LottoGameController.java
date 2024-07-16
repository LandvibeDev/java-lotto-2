package lotto;

public class LottoGameController {
    private InputView inputView;
    private OutputView outputView;
    public LottoGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }
    public LottoSeller inputLottoSeller(){
        while(true) {
            try {
                outputView.printPriceInputMessage();
                String priceInput = inputView.inputPrice();
                LottoSeller lottoSeller = new LottoSeller(priceInput);
                return lottoSeller;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
    public LottoWinningNumbers inputLottoWinningNumbers(){
        while(true) {
            try {
                outputView.printWinningNumbersInputMessage();
                String[] winningNumbersInput = inputView.inputWinningNumbers();
                LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbersInput);
                return lottoWinningNumbers;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
    public BonusNumber inputBonusNumber(LottoWinningNumbers winningNumbers){
        while(true) {
            try {
                outputView.printBonusNumberInputMessage();
                String bonusInput = inputView.inputBonus();
                BonusNumber bonusNumber = new BonusNumber(winningNumbers, bonusInput);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
    public void run(){
        LottoSeller seller = inputLottoSeller();
        outputView.printBoughtLottos(seller);
        LottoWinningNumbers winningNumbers = inputLottoWinningNumbers();
        BonusNumber bonus = inputBonusNumber(winningNumbers);
        LottoBenefitRateCalculator benefit = new LottoBenefitRateCalculator();
        benefit.setBenefitRate(seller.getPrice(), seller.getLottos(), winningNumbers.getWinningNumbers(), bonus.getBonus());
        outputView.printResult(benefit);
    }

}

