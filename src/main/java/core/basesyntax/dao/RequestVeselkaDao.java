package core.basesyntax.dao;

import core.basesyntax.model.RequestVeselka;

import java.util.List;

public interface RequestVeselkaDao {
    void makeRequest(RequestVeselka requestVeselka);

    List<RequestVeselka> getAllList();
}
