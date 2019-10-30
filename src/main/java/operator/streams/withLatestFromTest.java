package operator.streams;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class withLatestFromTest {

    public static void main(String[] args) {

        Flowable<String> source1 = Flowable.interval(2, TimeUnit.SECONDS)
                .map(x -> "S :"+x);

        Flowable<String> source2 = Flowable.interval(1, TimeUnit.SECONDS)
                .map(x -> "F :"+x);

        source1.withLatestFrom(source2,
                    (r, g) -> r +" - "+ g)
                .subscribe(System.out::println);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
