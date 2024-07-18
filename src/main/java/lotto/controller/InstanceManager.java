package lotto.controller;

import lotto.model.LottoMachineModel;
import lotto.model.WinningResultModel;
import lotto.view.ConsoleInput;
import lotto.view.LottoGame;

public class InstanceManager {
    private final ConsoleInput consoleInput;
    private final LottoMachineModel lottoMachine;
    private final WinningResultModel winningResult;

    public InstanceManager() {
        this.consoleInput = new ConsoleInput();
        this.lottoMachine = new LottoMachineModel();
        this.winningResult = new WinningResultModel();
    }

    public LottoGame lottoGame() {
        return new LottoGame(consoleInput, lottoMachine, winningResult);
    }
}
