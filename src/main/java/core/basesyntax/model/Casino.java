package core.basesyntax.model;

public class Casino {
    private String name;
    private boolean adult;

    public Casino(String name, boolean adult) {
        this.name = name;
        this.adult = adult;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }
}
