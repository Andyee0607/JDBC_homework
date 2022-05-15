package view;

import java.util.List;
import java.util.Scanner;

import po.Agent;
import po.Customer;
import po.Product;
import dao.impl.AgentDaoImpl;
import dao.impl.CustomerDaoImpl;
import dao.impl.ProductDaoImpl;

import view.impl.AgentView;
import view.impl.CustomerView;
import view.impl.ProductView;


public class Entry {

    private Object AgentView;
    private Object String;

    public void work() {
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("|\t\t\t 京东后台管理系统  \t\t\t|");
        System.out.println("---------------------------------------------------------");

        //AgentView agentView = new AgentView() ;
        //}

        //商家登录
        //Agent agent = AgentView.login();

        Entry entry = new Entry();

        System.out.println("\n===== 一级菜单 1.查看代理商=2.查看客户=3.查看商品=====");

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        if (a == 1) {
            int menu = 0;
            while (menu != 5) {
                //输出一级菜单
                System.out.println("\n======= 二级菜单（代理商管理）1.查看代理商信息=2.新增代理商=3.删除代理商=4.修改代理商信息=5.退出=======");
                System.out.println("请输入你的选择：");
                menu = scanner.nextInt();
                AgentDaoImpl agent = new AgentDaoImpl();
                Agent ag = new Agent();
                String agentid = "";
                String agentname = "";

                switch (menu) {
                    case 1:

                        agent.listAgent(agentid, agentname);
                        break;
                    case 2:
                        agent.saveAgent(agentid);
                        break;
                    case 3:
                        agent.removeAgent(agentid);
                        break;
                    case 4:
                        agent.updateAgent(ag);
                        break;
                    case 5:
                        System.out.println("------------------------欢迎下次光临京东后台管理系统-----------------------");
                        break;
                    default:
                        System.out.println("没有这个选项！\n");
                        break;
                }
            }
        } else if (a == 2) {
            int menu = 0;
            while (menu != 5) {
                System.out.println("\n======= 二级菜单（代理商管理）1.查看客户信息=2.新增客户=3.删除客户=4.修改客户信息=5.退出=======");
                System.out.println("请输入你的选择：");
                menu = scanner.nextInt();
                CustomerDaoImpl customer = new CustomerDaoImpl();
                Customer cu = new Customer();
                String customerid = "";
                String customername = "";

                switch (menu) {
                    case 1:

                        customer.listCustomer(customerid, customername);
                        break;
                    case 2:
                        customer.saveCustomer(customerid);
                        break;
                    case 3:
                        customer.removeCustomer(customerid);
                        break;
                    case 4:
                        customer.updateCustomer(cu);
                        break;
                    case 5:
                        System.out.println("------------------------欢迎下次光临京东后台管理系统-----------------------");
                        break;
                    default:
                        System.out.println("没有这个选项！\n");
                        break;
                }

            }


        }
        else if (a == 3) {
            int menu = 0;
            while (menu != 5) {
                System.out.println("\n======= 二级菜单（代理商管理）1.查看商品信息=2.新增商品=3.删除商品=4.修改商品信息=5.退出=======");
                System.out.println("请输入你的选择：");
                menu = scanner.nextInt();
                ProductDaoImpl product = new ProductDaoImpl();
                Product pr = new Product();
                String productid = "";
                String productname = "";

                switch (menu) {
                    case 1:

                        product.listProduct(productid, productname);
                        break;
                    case 2:
                        product.saveProduct(productid);
                        break;
                    case 3:
                        product.removeProduct(productid);
                        break;
                    case 4:
                        product.updateProduct(pr);
                        break;
                    case 5:
                        System.out.println("------------------------欢迎下次光临京东后台管理系统-----------------------");
                        break;
                    default:
                        System.out.println("没有这个选项！\n");
                        break;
                }

            }


        }
        else{
            System.out.println("请输入正确选项！");
        }
    }

    public static void main(String[] args) {
        new Entry().work();
    }
}