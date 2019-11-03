package operator.streams;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class ConcatTest {

    public static void main(String[] args) {

        Flowable<String> source1 = Flowable.just(1, 2)
                .map(i -> "Source1 "+i);

        Flowable<String> source2 = Flowable.interval(60, TimeUnit.MILLISECONDS)                       .map(i -> "Source2 "+i);

        Flowable.concat(source1, source2)
                .subscribe(System.out::println);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
