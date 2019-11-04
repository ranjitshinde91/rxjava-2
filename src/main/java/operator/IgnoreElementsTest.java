package operator;

import io.reactivex.Flowable;

public class IgnoreElementsTest {
    public static void main(String[] args) {

        Flowable.just(1, 2, 3)
                .ignoreElements()
                .subscribe(()->System.out.println("complete"),
                        (t)->System.out.println(t));

        Flowable.error(new RuntimeException("Error"))
                .ignoreElements()
                .subscribe(()->System.out.println("complete"),
                        (t)->System.out.println(t));
    }
}
