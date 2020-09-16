package operator;

import io.reactivex.Flowable;
import org.reactivestreams.Publisher;


import static logger.Logger.log;

public class SwitchIfEmptyTest {

    public static void main(String[] args) {

        Flowable.just(1, 2, 3)
                .switchIfEmpty(defaultStream())
                .subscribe(System.out::println);

        Flowable.empty()
                .switchIfEmpty(defaultStream())
                .subscribe(System.out::println);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Publisher<? extends Integer> defaultStream() {
        log("inside defaultStream method call ");
        return Flowable.just(0)
                .doOnSubscribe((s) -> {
                    log("subscribed to default stream");
                });
    }
}
