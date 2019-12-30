package core.basesyntax.dao;

import core.basesyntax.model.RequestVeselka;

import java.util.List;

public interface VeselkaDao {
    void makeRequest(RequestVeselka requestVeselka);

    List<RequestVeselka> getAllList();
}
