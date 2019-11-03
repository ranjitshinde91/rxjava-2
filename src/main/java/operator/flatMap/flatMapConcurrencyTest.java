package operator.flatMap;

import customer.Order;
import io.reactivex.Flowable;


public class flatMapConcurrencyTest {

    public static void main(String[] args) {

        Flowable.just("SUNDAY", "MONDAY")
                .flatMap(Order::loadOrdersFor, 2)
                .subscribe((i)-> System.out.println(i +" on Thread "+Thread.currentThread().getName()));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
