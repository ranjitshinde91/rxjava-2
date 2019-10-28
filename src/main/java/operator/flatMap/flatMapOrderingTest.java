package operator.flatMap;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

import static io.reactivex.Flowable.timer;

public class flatMapOrderingTest {

    public static void main(String[] args) {
        Flowable.just("Lorem", "ipsum", "dolor", "sit", "amet", "elit", "a", "ab")
                .flatMap(word-> timer(word.length(), TimeUnit.SECONDS).map(x -> word))
                .subscribe(System.out::println);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
