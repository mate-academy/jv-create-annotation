package core.basesyntax;

import java.util.Objects;

public class Bet {
    private final Integer id;
    private Integer value;
    private Double risk;

    public Bet(Integer value, Double risk) {
        this.id = hashCode();
        this.value = value;
        this.risk = risk;
    }

    public Integer getId() {
        return id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Double getRisk() {
        return risk;
    }

    public void setRisk(Double risk) {
        this.risk = risk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bet bet = (Bet) o;
        return Objects.equals(id, bet.id)
                && Objects.equals(value, bet.value)
                && Objects.equals(risk, bet.risk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, risk);
    }
}
