package core.basesyntax.model;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class Bet {
    @NonNull
    private int value;
    @NonNull
    private double risk;
    @Setter
    private String userName;
}
