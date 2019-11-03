package concurrency;


import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import static logger.Logger.log;

public class ObserveOnTest {

    public static void main(String[] args) {

        log("Starting");

        Flowable.just(1, 2, 3, 4, 5, 6)
                .map(it -> {
                    log(it.toString());
                    return it;
                })
                .observeOn(Schedulers.computation())
                .subscribe((it)->log(it.toString()));

        log("complete");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
