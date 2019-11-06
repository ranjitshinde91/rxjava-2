package operator.time;

import io.reactivex.Observable;
import io.reactivex.schedulers.Timed;

import java.util.concurrent.TimeUnit;

public class TimeIntervalTest {

    public static void main(String[] args) {

        Observable<Timed<Long>> source1 = Observable.interval(100, TimeUnit.MILLISECONDS)
                .timeInterval();

        source1.subscribe(System.out::println,
                        (t) -> System.out.println(t));


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
