class MyThread extends Thread {
    public void run() {
        System.out.println("Thread Name: " + getName());
        System.out.println("Thread Priority: " + getPriority());
    }
}

public class ThreadNamePriority {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();

        t1.setName("MyFirstThread");
        t1.setPriority(8);

        t1.start();
    }
}