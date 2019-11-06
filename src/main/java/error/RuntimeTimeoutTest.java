package error;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class RuntimeTimeoutTest {

    public static void main(String[] args) {

        Observable<String> source1 = Observable.just("first", "second", "third")
                .delay(100, TimeUnit.MILLISECONDS);

        Observable<String> source2 = Observable.<String>empty()
                .delay(200, TimeUnit.MILLISECONDS);

        source1.concatWith(source2)
                .timeout(Observable.timer(110, TimeUnit.MILLISECONDS),
                        s -> {
                            if(s.equals("first")|| s.equals("second")){
                                return  Observable.timer(10, TimeUnit.MILLISECONDS);
                            }
                            else
                                return  Observable.timer(190, TimeUnit.MILLISECONDS);
                })
                .subscribe(System.out::println,
                        (t) -> System.out.println(t));


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
