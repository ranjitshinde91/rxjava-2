package operator.slice;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class TakeUntilTest {
    public static void main(String[] args) {

        Flowable.range(1, 9)
                .takeUntil( i-> i==5)
                .subscribe(System.out::println);


    }
}
