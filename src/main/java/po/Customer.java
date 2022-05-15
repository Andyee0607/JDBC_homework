package po;

public class Customer {


    private String customerid;
    private String customername;
    private String buyid;

    public static void buyid(float buyid) {
    }

    @Override
    public String toString() {
        return "\n客户编号："+this.customerid+
                "\n客户名称："+this.customername+
                "\n购买货品编号："+this.buyid;
    }


    public String getcustomerid() {
        return customerid;
    }
    public static void setcustomerid(String customerid) {
        customerid = customerid;
    }
    public String getcustomername() {
        return customername;
    }
    public static void setcustomername(String customername) {
        customername = customername;
    }
    public String getbuyid() {
        return buyid;
    }
    public void setbuyid(String buyid) {
        buyid = buyid;
    }

}
