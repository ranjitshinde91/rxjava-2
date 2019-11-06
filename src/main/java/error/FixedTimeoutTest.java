package error;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class FixedTimeoutTest {

    public static void main(String[] args) {

        Observable<String> source1 = Observable.just("first")
                .delay(100, TimeUnit.MILLISECONDS);

        Observable<String> source2 = Observable.<String>empty()
                .delay(200, TimeUnit.MILLISECONDS);

        source1.concatWith(source2)
        .timeout(190, TimeUnit.MILLISECONDS)
        .subscribe(System.out::println,
                        (t) -> System.out.println(t));


        source1.concatWith(source2)
                .timeout(Observable.timer(100, TimeUnit.MILLISECONDS),
                        s -> {
                            System.out.println(s);
                   return  Observable.timer(100, TimeUnit.MILLISECONDS);
                })
                .subscribe(System.out::println,
                        (t) -> System.out.println(t));


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
