package lotto;

public class InstanceManager {
    private final ConsoleInput consoleInput;
    private final LottoMachine lottoMachine;
    private final WinningResult winningResult;

    public InstanceManager() {
        this.consoleInput = new ConsoleInput();
        this.lottoMachine = new LottoMachine();
        this.winningResult = new WinningResult();
    }

    public LottoGame lottoGame() {
        return new LottoGame(consoleInput, lottoMachine, winningResult);
    }
}
