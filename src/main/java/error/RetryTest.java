package error;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

public class RetryTest {

    public static void main(String[] args) {

        Flowable.create((s) -> {
            System.out.println("starting.........");
            while (!s.isCancelled()) {
                if (Math.random() > 0.3) {
                    s.onNext(1);
                } else {
                    s.onError(new RuntimeException("Error"));
                }
            }
        }, BackpressureStrategy.BUFFER)
                .retry(2)
                .subscribe(System.out::println,
                        (t) -> System.out.println(t));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
