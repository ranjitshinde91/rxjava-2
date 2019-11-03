package operator.slice;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class TakeTest {
    public static void main(String[] args) {

        Flowable.range(1, 9)
                .take(2)
                .subscribe(System.out::println);


        Flowable.range(1, 900)
                .take(1, TimeUnit.MILLISECONDS)
                .map(i -> {
                    System.out.println(i + " running on Thread : " + Thread.currentThread().getName());
                    return i;
                })
                .subscribe(System.out::println);
    }
}
