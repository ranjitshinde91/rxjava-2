package operator.streams;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class MergeTest {

    public static void main(String[] args) {

        Flowable<String> source1 = Flowable.interval(1, TimeUnit.SECONDS)
                .map(i -> "Source1 "+i);

        Flowable<String> source2 = Flowable.interval(60, TimeUnit.MILLISECONDS)                       .map(i -> "Source2 "+i);

        source1.mergeWith(source2)
                .subscribe(System.out::println);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
