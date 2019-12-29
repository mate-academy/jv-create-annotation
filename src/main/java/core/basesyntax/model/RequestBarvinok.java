package core.basesyntax.model;

public class RequestBarvinok {
    private String name;
    private int id;

    public RequestBarvinok(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RequestBarvinok{"
                + "name='" + name + '\''
                + ", id=" + id
                + '}';
    }
}
