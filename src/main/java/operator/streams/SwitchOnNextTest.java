package operator.streams;

import io.reactivex.Flowable;

import java.util.Random;

import static io.reactivex.Flowable.*;
import static java.util.concurrent.TimeUnit.*;

public class SwitchOnNextTest {

    public static void main(String[] args) {

        Random random = new Random();

        Flowable<Long> alice = interval(1, MILLISECONDS);
        Flowable<Long> bob   = interval(2, MILLISECONDS);
        Flowable<Long> jane  = interval(3, MILLISECONDS);

        Flowable<Flowable<String>> source =
                just(
                        alice.map(w -> "Alice :" + w),
                        bob.map(w -> "Bob :" + w),
                        jane.map(w -> "Jane :" + w)

                )
                .flatMap(innerObs -> just(innerObs)
                        .delay(random.nextInt(10), SECONDS));

        Flowable.switchOnNext(source)
          .subscribe(System.out::println);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
