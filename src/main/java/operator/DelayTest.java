package operator;

import io.reactivex.Flowable;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static io.reactivex.Flowable.timer;
import static logger.Logger.log;

public class DelayTest {
    public static void main(String[] args) {

        Flowable.just(1, 2, 3, 4)
                .delay(1, TimeUnit.SECONDS)
                .subscribe((i)->log("emitting1  "+i));

        Flowable.just("Lorem", "ipsum", "dolor", "sit", "amet", "elit", "a", "ab")
                .delay(i -> timer(i.length(), TimeUnit.SECONDS))
                .subscribe((i)->log("emitting2  "+i));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
