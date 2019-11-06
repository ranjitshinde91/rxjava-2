package operator.time;

import io.reactivex.Flowable;

public class TimestampTest {
    public static void main(String[] args) {

        Flowable.just(1, 2, 3)
                .timestamp()
                .subscribe(System.out::println);
    }
}
