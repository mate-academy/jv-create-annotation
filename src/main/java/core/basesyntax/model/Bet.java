package core.basesyntax.model;

public class Bet {
    private Integer value;
    private Double risk;

    public Bet(Integer bet, Double risk) {
        this.value = bet;
        this.risk = risk;
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
    public String toString() {
        return "Bet{" +
                "value=" + value +
                ", risk=" + risk +
                '}';
    }
}
