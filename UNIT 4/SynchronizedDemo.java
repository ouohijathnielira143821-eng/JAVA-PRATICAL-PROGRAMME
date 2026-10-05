class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }
}

class MyThread extends Thread {
    Table t;
    int n;

    MyThread(Table t, int n) {
        this.t = t;
        this.n = n;
    }

    public void run() {
        t.printTable(n);
    }
}

public class SynchronizedDemo {
    public static void main(String[] args) {
        Table obj = new Table();

        MyThread t1 = new MyThread(obj, 2);
        MyThread t2 = new MyThread(obj, 5);

        t1.start();
        t2.start();
    }
}