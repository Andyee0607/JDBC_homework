package view.impl;

import po.Customer;

public interface CustomerView {

    public void listCustomer();
    public void saveCustomer();
    public void removeCustomer();

    public Customer login();
    public void showCustomer(String customerid);
    public void editCustomer(String customerid);
    public void updateCustomerBycustomerid(String customerid);
}
