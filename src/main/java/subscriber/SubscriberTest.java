package subscriber;


import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SubscriberTest {

    public static void main(String[] args) {

        Subscriber<Long> subscriber = new Subscriber<Long>() {
            Subscription subscriber;

            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onSubscribe");
                subscriber = s;
                s.request(1);
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println("onNext");
                subscriber.cancel();
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        final Flowable<Long> source = Flowable.just(1l, 2l);

        source.subscribe(subscriber);
    }
}
