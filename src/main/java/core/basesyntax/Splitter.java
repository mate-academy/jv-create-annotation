package core.basesyntax;

public class Splitter {
    public String[] split(String str) {
        String[] split = str.split(" ");
        if (split.length != 2) {
            throw new RuntimeException("Wrong input format!");
        }
        return split;
    }
}
