package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AgentDao;
import po.Agent;
import util.DBUtil;

public class AgentDaoImpl implements AgentDao{

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public List<Agent> listAgent(String agentid, String agentname) {
        List<Agent> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from agent where 1=1 ");
        if(agentid!=null&&!agentid.equals("")) {
            sql.append(" and agentid like '%"+agentid+"%' ");
        }
        if(agentname!=null&&!agentname.equals("")) {
            sql.append(" and agentname like '%"+agentname+"%' ");
        }
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql.toString());
            rs = pst.executeQuery();
            while(rs.next()) {
                Agent agent = new Agent();
                Agent.setagentid(rs.getString("agentid"));
                Agent.setagentname(rs.getString("agentname"));
                agent.setsellid(rs.getString("sellid"));
                list.add(agent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return list;
    }

    @Override
    public String saveAgent(String agentid) {

        String sql = "insert into agent(agentid) values(?,'123')";
        try {
            con = DBUtil.getConnection();
            //设置返回自增长列值
            pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, agentid);
            pst.executeUpdate();
            //获取自增长列值（一行一列）
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
                agentid = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pst, con);
        }
        return agentid;
    }

    @Override
    public String removeAgent(String agentid) {
        String result = "0";
        String delproductSql = "delete from agent where agentid=?";
        try {
            con = DBUtil.getConnection();
            //开启一个事务
            con.setAutoCommit(false);

            pst = con.prepareStatement(delproductSql);
            pst.setString(1, agentid);
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
    public int updateAgent(Agent agent) {
        int result = 0;
        String sql = "update product setagentid=?,agentname=?,sellid=? where agentid=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, agent.getagentid());
            pst.setString(2, agent.getagentname());
            pst.setString(3, agent.getsellid());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pst, con);
        }
        return result;
    }


}
