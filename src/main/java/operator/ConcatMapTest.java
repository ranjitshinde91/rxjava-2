package operator;

import customer.Order;
import io.reactivex.Flowable;

public class ConcatMapTest {

    public static void main(String[] args) {

        Flowable.just("SUNDAY", "MONDAY")
                .concatMap(Order::loadOrdersFor)
                .subscribe((i)-> System.out.println(i +" on Thread "+Thread.currentThread().getName()));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
