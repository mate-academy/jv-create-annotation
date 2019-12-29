package core.basesyntax.dao;

import core.basesyntax.model.RequestBarvinok;

import java.util.List;

public interface RequestBarvinokDao {
    void makeRequest(RequestBarvinok requestBarvinok);

    List<RequestBarvinok> getAllList();
}
