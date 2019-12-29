package dao;

import java.util.List;

import model.Tablet;

public interface TabletDao {
    void add(Tablet tablet);

    List<Tablet> getAll();
}
