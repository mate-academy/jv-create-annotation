package core.basesyntax.model;

public class Robot {
    private double version;
    private String name;

    public Robot(double version, String name) {
        this.version = version;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[v:" + version + " n:" + name + "]";
    }
}
