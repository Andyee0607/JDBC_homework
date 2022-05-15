package dao;

import po.Agent;

import java.util.List;

public interface AgentDao {

    public List<Agent> listAgent(String agentid, String agentname);
    public String saveAgent(String agentname);
    public String removeAgent(String agentid);

    public int updateAgent(Agent agent);
}
