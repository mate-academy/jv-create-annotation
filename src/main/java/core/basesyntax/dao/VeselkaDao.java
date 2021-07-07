package core.basesyntax.dao;

import core.basesyntax.model.RequestVeselka;

import java.util.List;

public interface VeselkaDao {
    void makeVeselkaRequest(RequestVeselka requestVeselka);

    List<RequestVeselka> getAllList();
}
