package core.basesyntax.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString(of = {"value", "risk"})
public class Bet {
    private int value;
    private double risk;
}
