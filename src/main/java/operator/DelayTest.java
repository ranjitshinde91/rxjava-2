package operator;

import io.reactivex.Flowable;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static io.reactivex.Flowable.timer;

public class DelayTest {
    public static void main(String[] args) {

        Flowable.just(1, 2, 3, 4)
                .delay(1, TimeUnit.SECONDS)
                .subscribe((i)->System.out.println("emitting1  "+i+" at "+ Instant.now()));

        Flowable.just("Lorem", "ipsum", "dolor", "sit", "amet", "elit", "a", "ab")
                .delay(i -> timer(i.length(), TimeUnit.SECONDS))
                .subscribe((i)->System.out.println("emitting2  "+i+" at "+ Instant.now()));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
