package Thread;

class Ticket implements Runnable {

    private int i = 100;
    Object object = new Object();
    @Override
    public void run() {
        while (true) {
            //obj持有同步锁
            synchronized (object) {
                if (i > 0) {
                    System.out.println(Thread.currentThread().getName() + "..sale : " + i--);
                }
            }
        }
    }
}


public class ThreadDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        Thread t4 = new Thread(ticket);
        t1.start();
    }

}
