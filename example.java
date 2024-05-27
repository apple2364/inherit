//通过继承Thread类实现多线程
//使用synchronized静态方法解决线程安全问题
class MyThread extends Thread{
    public static int ticket=100;
    public static synchronized void show(){
        if(ticket>0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                 
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":卖票，票号:"+ticket);
            ticket--;
        }
    }
    public void run() {
        while(true) {
            show();
        }
    }
}
public class Main{
    public static void main(String [] args) {
    MyThread mt1=new MyThread();
    MyThread mt2=new MyThread();
    MyThread mt3=new MyThread();
    mt1.setName("窗口1");
    mt2.setName("窗口2");
    mt3.setName("窗口3");
     
    mt1.start();
    mt2.start();
    mt3.start();
    }
}
