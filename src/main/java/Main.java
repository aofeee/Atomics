import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        LongAdder countDay = new LongAdder();

        Shop shop1 = new Shop(countDay);
        Shop shop2 = new Shop(countDay);
        Shop shop3 = new Shop(countDay);

        Thread thread1 = new Thread(null, shop1::calc, "Магазин 1");
        Thread thread2 = new Thread(null, shop1::calc, "Магазин 2");
        Thread thread3 = new Thread(null, shop1::calc, "Магазин 3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.printf("Итоговая сумма составляет %d руб.", countDay.sum());



    }
}
