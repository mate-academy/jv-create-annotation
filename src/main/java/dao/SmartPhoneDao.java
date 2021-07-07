package dao;

import java.util.List;

import model.SmartPhone;

public interface SmartPhoneDao {
    void add(SmartPhone smartPhone);

    List<SmartPhone> getAll();
}
