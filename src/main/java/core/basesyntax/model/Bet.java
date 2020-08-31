package core.basesyntax.model;

import static core.basesyntax.controller.ControllerHandler.INVALID_INPUT_ARGS_MESSAGE;
import static core.basesyntax.controller.ControllerHandler.inputCheckFailed;

import java.util.NoSuchElementException;
import java.util.Objects;

public class Bet {
    private static final int VALUE_INDEX = 0;
    private static final int RISK_INDEX = 1;
    private static final String BET_DATA_SCAN_REGEX = " - ";
    private final int id;
    private final int value;
    private final double risk;

    public Bet(int value, double risk) {
        this.value = value;
        this.risk = risk;
        id = Objects.hash(risk, value);
    }

    public static Bet parseBet(String input) {
        int value = 0;
        double risk = 0;
        try {
            String[] betData = input.split(BET_DATA_SCAN_REGEX);
            value = Integer.parseInt(betData[VALUE_INDEX]);
            risk = Double.parseDouble(betData[RISK_INDEX]);
        } catch (NumberFormatException exception) {
            inputCheckFailed(INVALID_INPUT_ARGS_MESSAGE, exception);
        }
        return new Bet(value, risk);
    }

    public static void checkPresence(Bet bet) {
        if (bet == null) {
            throw new NoSuchElementException("No such element found");
        }
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public double getRisk() {
        return risk;
    }

    @Override
    public String toString() {
        return "Bet { "
                + "id = " + id
                + ", value = " + value
                + ", risk = " + risk
                + " }";
    }
}
