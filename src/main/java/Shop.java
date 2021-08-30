import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Shop {

    private LongAdder countDay;

    public Shop(LongAdder sumDay) {
        this.countDay = sumDay;
    }

    private static int size = 80;
    private static int[] array = new int[size];

    public void calc() {
        int count = 0;
        int max = 4999;
        int min = 1;
        try {
            for (int i = 0; i < (size); i++) {
                Random random = new Random();
                array[i] = random.nextInt(max) + min;
                count += array[i];
            }
            countDay.add(count);
            System.out.printf("Выручка из магазина %s состовляет %d руб.\n", Thread.currentThread().getName(), count);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
