package view.impl;

import po.Agent;

public interface AgentView {

    public void listAgent();
    public void saveAgent();
    public void removeAgent();

    public Agent login();
    public void showAgent(String agentid);
    public void editAgent(String agentid);
    public void updateAgentByagentid(String agentid);
}
