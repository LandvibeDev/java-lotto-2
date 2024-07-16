package game;

import controller.LottoController;
import service.LottoCalculator;
import service.LottoGenerator;
import view.UserView;

public class Application {
    public static void main(String[] args) {
        UserView userView = new UserView();
        LottoCalculator lottoCalculator = new LottoCalculator();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoController lottoController = new LottoController(userView, lottoCalculator, lottoGenerator);

        lottoController.run();
    }
}
