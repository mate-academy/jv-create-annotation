package core.basesyntax.dao;

import core.basesyntax.model.RequestBarvinok;

import java.util.List;

public interface BarvinokDao {
    void makeBarvinokRequest(RequestBarvinok requestBarvinok);

    List<RequestBarvinok> getAllList();
}
