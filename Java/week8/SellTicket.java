package week8;

public class SellTicket {
    //定义一个买票的类
    //数据
    static int ticketNum = 10000;
    int a = 5;

    //功能
    public void sell(){
        this.ticketNum --;
        System.out.println("当前的票还有"+ this.ticketNum + "张。");
        System.out.println(a);
    }
    public static void main(String[] args) {
        //通过定义的类产生售票点的对象，然后卖票，观察票的售卖情况
        SellTicket sellTicket1 = new SellTicket();
        SellTicket sellTicket2 = new SellTicket();
        SellTicket sellTicket3 = new SellTicket();
        SellTicket sellTicket4 = new SellTicket();
        SellTicket sellTicket5 = new SellTicket();

        sellTicket1.sell();
        sellTicket2.sell();
        sellTicket3.sell();
        sellTicket4.sell();
        sellTicket5.sell();

        System.out.println(sellTicket5.a);
    }
}
