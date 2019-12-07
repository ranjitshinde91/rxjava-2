package testing;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class VirtualTimeTest {

    public static void main(String[] args) {

        TestScheduler testScheduler = new TestScheduler();

        Observable<String> fast = Observable.interval(10, MILLISECONDS, testScheduler)
                .map(x -> "F" + x)
                .take(3);

        Observable<String> slow = Observable.interval(50, MILLISECONDS, testScheduler)
                .map(x -> "S" + x);

        TestObserver<String> testObserver = Observable.concat(fast, slow)
                .test();

        System.out.println("subscribed");

        testScheduler.advanceTimeBy(25, MILLISECONDS);

        testObserver.assertValues("F0", "F1");

        testScheduler.advanceTimeBy(75, MILLISECONDS);
        testObserver.assertValues("F0", "F1", "F2", "S0");

        testScheduler.advanceTimeTo(230, MILLISECONDS);
        testObserver.assertValues("F0", "F1", "F2", "S0", "S1", "S2", "S3");

    }
}
