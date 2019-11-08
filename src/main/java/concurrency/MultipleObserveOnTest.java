package concurrency;


import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import static logger.Logger.log;

public class MultipleObserveOnTest {

    public static void main(String[] args) {

        log("Starting");

        Flowable.just(1, 2, 3, 4, 5, 6)
                .observeOn(Schedulers.io())
                .map(it -> {
                    Thread.sleep(50);
                    log(it.toString());
                    return it;
                })
                .observeOn(Schedulers.computation())
                .map(it -> {
                    Thread.sleep(100);
                    log(it.toString());
                    return it;
                })
                .subscribe((it)->log(it.toString()));

        log("complete");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
