package core.basesyntax;

public class Splitter {
    public String[] split(String str) {
        if (str.equals("quit")) {
            System.exit(0);
        }
        String[] split = str.split(" ");
        if (split.length != 2) {
            throw new RuntimeException("Wrong input format!");
        }
        return split;
    }
}
