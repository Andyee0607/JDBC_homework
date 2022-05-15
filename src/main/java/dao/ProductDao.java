package dao;

import po.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> listProduct(String productid, String productname);
    public String saveProduct(String productid);
    public String removeProduct(String productid);

    public int updateProduct(Product product);
}
