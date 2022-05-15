package po;

public class Agent {


    String agentid;
    String agentname;
    String sellid;

    @Override
    public String toString() {
        return "\n代理商编号："+agentid+
                "\n代理商名称："+agentname+
                "\n售卖货品编号："+sellid;
    }


    public String getagentid() {
        return agentid;
    }
    public static void setagentid(String agentid) {
        agentid = agentid;
    }
    public String getagentname() {
        return agentname;
    }
    public static void setagentname(String agentname) {
        agentname = agentname;
    }
    public String getsellid() {
        return sellid;
    }
    public void setsellid(String sellid) {
        sellid = sellid;
    }

}
