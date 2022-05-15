package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CustomerDao;
import po.Customer;
import po.Customer;
import util.DBUtil;

public class CustomerDaoImpl implements CustomerDao{

     Connection con = null;
     PreparedStatement pst = null;
     ResultSet rs = null;

    @Override
    public List<Customer> listCustomer(String customerid, String customername) {
        List<Customer> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from agent where 1=1 ");
        if(customerid!=null&&!customerid.equals("")) {
            sql.append(" and customerid like '%"+customerid+"%' ");
        }
        if(customername!=null&&!customername.equals("")) {
            sql.append(" and customername like '%"+customername+"%' ");
        }
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            rs = pst.executeQuery();
            while(rs.next()) {
                Customer customer = new Customer();
                Customer.setcustomerid(rs.getString("customerid"));
                Customer.setcustomername(rs.getString("customername"));
                Customer.buyid(rs.getFloat("buyid"));
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return list;
    }

    @Override
    public String saveCustomer(String customerid) {

        String sql = "insert into customer(customerid) values(?,'123')";
        try {
            con = DBUtil.getConnection();
            //设置返回自增长列值
            pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, customerid);
            pst.executeUpdate();
            //获取自增长列值（一行一列）
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
                customerid = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return customerid;
    }

    @Override
    public String removeCustomer(String customerid) {
        String result = "0";
        String delproductSql = "delete from customer where acustomerid=?";
        try {
            con = DBUtil.getConnection();
            //开启一个事务
            con.setAutoCommit(false);

            pst = con.prepareStatement(delproductSql);
            pst.setString(1, customerid);
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
    public int updateCustomer(Customer customer) {
        int result = 0;
        String sql = "update product setcustomerid=?,customername=?,buyid=? where customerid=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, customer.getcustomerid());
            pst.setString(2, customer.getcustomername());
            pst.setString(3, customer.getbuyid());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }


}
