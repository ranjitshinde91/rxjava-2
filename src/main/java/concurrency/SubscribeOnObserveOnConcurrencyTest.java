package concurrency;


import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import static logger.Logger.log;

public class SubscribeOnObserveOnConcurrencyTest {

    public static void main(String[] args) {

        log("Starting");

        Flowable.just("Bread", "Butter", "Milk", "Tomato", "Cheese")
                .doOnNext((it) -> log(it))
                .subscribeOn(Schedulers.computation())
                .flatMap(prod -> purchase(prod))
                .observeOn(Schedulers.single())
                .subscribe(it -> log(it));

        log("complete");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Flowable<String> purchase(String prod) {
        return Flowable.just(prod)
                .doOnNext((it) -> log("purchasing : " + it))
                .subscribeOn(Schedulers.io());
    }
}
