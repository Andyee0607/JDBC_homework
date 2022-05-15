package dao;

import java.util.List;

import po.Customer;

public interface CustomerDao {

    public List<Customer> listCustomer(String customerid,String customername);
    public String saveCustomer(String customername);
    public String removeCustomer(String customerid);

    public int updateCustomer(Customer customer);
}
