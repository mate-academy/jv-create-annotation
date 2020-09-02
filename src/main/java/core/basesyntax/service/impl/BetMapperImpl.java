package core.basesyntax.service.impl;

import core.basesyntax.model.Bet;
import core.basesyntax.service.Mapper;

public class BetMapperImpl implements Mapper<Bet> {
    @Override
    public Bet parse(String[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Expected to receive data, but got null");
        }
        int value = Integer.parseInt(data[0]);
        double risk = Double.parseDouble(data[1]);
        return new Bet(value, risk);
    }
}
