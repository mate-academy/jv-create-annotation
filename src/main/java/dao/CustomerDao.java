package dao;

import java.util.List;

import models.Customer;

public interface CustomerDao {

    void add(Customer customer);

    List<Customer> getAll();

}
