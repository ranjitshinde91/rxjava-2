package type;


import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

public class FlowableTest {

    public static void main(String[] args) throws InterruptedException {

        Flowable<Long> source = Flowable.interval(1, TimeUnit.SECONDS, Schedulers.computation());

        source.subscribe(new Subscriber<Long>() {

            Subscription subscription = null;

            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onSubscribe : " + s.toString() + ":" + Thread.currentThread().getName());
                s.request(1);
                subscription = s;
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println("onNext " + aLong + ":" + Thread.currentThread().getName());
                subscription.request(1);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError" + t);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });

        System.out.println("Flowable");

        Thread.sleep(10000);

    }
}
