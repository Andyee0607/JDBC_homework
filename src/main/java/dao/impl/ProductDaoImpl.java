package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import po.Product;
import po.Product;
import util.DBUtil;

public class ProductDaoImpl implements ProductDao{

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @Override
    public List<Product> listProduct(String productid, String productname) {
        List<Product> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from product where 1=1 ");
        if(productid!=null&&!productid.equals("")) {
            sql.append(" and productid like '%"+productid+"%' ");
        }
        if(productname!=null&&!productname.equals("")) {
            sql.append(" and productname like '%"+productname+"%' ");
        }
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            rs = pst.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.setproductid(rs.getString("productid"));
                product.setproductname(rs.getString("productname"));
                product.setprice(rs.getString("price"));
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return list;
    }

    @Override
    public String saveProduct(String productid) {

        String sql = "insert into product(productid) values(?,'123')";
        try {
            con = DBUtil.getConnection();
            //设置返回自增长列值
            pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, productid);
            pst.executeUpdate();
            //获取自增长列值（一行一列）
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
                productid = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return productid;
    }

    @Override
    public String removeProduct(String productid) {
        String result = "0";
        String delproductSql = "delete from product where productid=?";
        try {
            con = DBUtil.getConnection();
            //开启一个事务
            con.setAutoCommit(false);

            pst = con.prepareStatement(delproductSql);
            pst.setString(1, productid);
            pst.executeUpdate();

            //pst = con.prepareStatement(delBusinessSql);
            //pst.setInt(1, businessId);
            //result = pst.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            result = "0";
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }


    @Override
    public int updateProduct(Product product) {
        int result = 0;
        String sql = "update product setproductid=?,productname=?,price=? where productid=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, product.getproductid());
            pst.setString(2, product.getproductname());
            pst.setString(3, product.getprice());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }


}
