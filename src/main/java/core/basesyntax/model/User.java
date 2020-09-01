package core.basesyntax.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class User {
    @NonNull
    private String login;
    @NonNull
    private String password;
    @NonNull
    private int age;
    private List<Bet> bets = new ArrayList<>();
}
