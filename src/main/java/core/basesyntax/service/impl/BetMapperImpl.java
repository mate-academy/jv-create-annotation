package core.basesyntax.service.impl;

import core.basesyntax.model.Bet;
import core.basesyntax.service.Mapper;

public class BetMapperImpl implements Mapper<Bet> {
    @Override
    public Bet parse(String[] data) {
        if (data == null) {
            throw new RuntimeException("Expected to receive data, but got null");
        }
        try {
            int value = Integer.parseInt(data[0]);
            double risk = Double.parseDouble(data[1]);
            return new Bet(value, risk);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Incorrect data");
        }
    }
}
