package operator.streams;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class ZipTest {

    public static void main(String[] args) {

        Flowable<Long> source1 = Flowable.interval(1, TimeUnit.SECONDS);

        Flowable<Long> source2 = Flowable.interval(1, TimeUnit.SECONDS);

        Flowable.zip(source1.timestamp(),
                    source2.timestamp(),
                    (r, g) -> r.time() - g.time())
                .subscribe(System.out::println);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
