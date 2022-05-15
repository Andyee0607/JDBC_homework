package view.impl;

import po.Product;

public interface ProductView {

    public void listProduct();
    public void saveProduct();
    public void removeProduct();

    public Product login();
    public void showProduct(String productid);
    public void editProduct(String productid);
    public void updateProductByproductid(String productid);
}
