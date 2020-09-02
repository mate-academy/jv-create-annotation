package core.basesyntax.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class Bet {
    @NonNull
    private int value;
    @NonNull
    private double risk;
    private String userName;
}
