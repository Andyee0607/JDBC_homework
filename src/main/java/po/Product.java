package po;

public class Product {


    private String productid;
    private String productname;
    private String price;

    @Override
    public String toString() {
        return "\n商品编号："+this.productid+
                "\n商品名称："+this.productname+
                "\n商品价格："+this.price;
    }


    public String getproductid() {
        return productid;
    }
    public void setproductid(String productid) {
        this.productid = productid;
    }
    public String getproductname() {
        return productname;
    }
    public void setproductname(String productname) {
        this.productname = productname;
    }
    public String getprice() {
        return price;
    }
    public void setprice(String price) {
        this.price = price;
    }

}
