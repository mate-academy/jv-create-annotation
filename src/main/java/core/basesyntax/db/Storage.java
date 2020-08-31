package core.basesyntax.db;

import java.util.ArrayList;
import java.util.List;

public class Storage<T> {
    private List<T> modelsStorage;

    public Storage() {
        this.modelsStorage = new ArrayList<>();
    }

    public List<T> getModelsStorage() {
        return modelsStorage;
    }
}
