package blocking;

import io.reactivex.Flowable;

public class BlockingObservableTest {
    public static void main(String[] args) {

        Flowable.just(1, 2, 3)
                .blockingSubscribe(System.out::println);
    }
}

