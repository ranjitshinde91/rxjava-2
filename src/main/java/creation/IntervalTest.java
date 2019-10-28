package creation;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class IntervalTest {

    public static void main(String[] args) {

        Flowable.interval(1, TimeUnit.SECONDS, Schedulers.trampoline())
                .map(i -> {
                    System.out.println(i + " in Thread : " + Thread.currentThread().getName());
                    return i;
                })
                .subscribe(System.out::println);
    }
}
