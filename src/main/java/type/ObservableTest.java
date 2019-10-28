package type;


import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class ObservableTest {

    public static void main(String[] args) throws InterruptedException {

        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS, Schedulers.computation());

        source.subscribe(it -> System.out.println(it +":"+ Thread.currentThread().getName()));
        source.subscribe(it -> System.out.println(it +":"+ Thread.currentThread().getName()));

        Thread.sleep(10000);
    }
}
