package operator.streams;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class AmbTest {

    public static void main(String[] args) {

        final Flowable<String> stream1 = stream(100, 17, "S");
        final Flowable<String> stream2 = stream(200, 10, "F");

        Flowable.ambArray(stream1, stream2)
                .subscribe(System.out::println);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Flowable<String> stream(int initialDelay, int interval, String name) {
        return Flowable.interval(initialDelay, interval, TimeUnit.MILLISECONDS)
                .map(x -> name + x)
                .doOnSubscribe(s -> System.out.println("Subscribed to :" + name))
                .doOnCancel(() -> System.out.println("Canceled to :" + name));

    }
}
