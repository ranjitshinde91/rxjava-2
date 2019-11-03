package operator.slice;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class TakeLastTest {
    public static void main(String[] args) {

        Flowable.range(1, 9)
                .takeLast(2)
                .subscribe(System.out::println);


        Flowable.range(1, 900)
                .takeLast(1, TimeUnit.MICROSECONDS)
                .map(i -> {
                    System.out.println(i + " running on Thread : " + Thread.currentThread().getName());
                    return i;
                })
                .subscribe(System.out::println);
    }
}
