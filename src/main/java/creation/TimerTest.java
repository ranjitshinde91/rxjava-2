package creation;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class TimerTest {

    public static void main(String[] args) {

        Flowable.timer(1, TimeUnit.SECONDS, Schedulers.trampoline())
                .map(i -> {
                    System.out.println(i + " in Thread : " + Thread.currentThread().getName());
                    return i;
                })
                .subscribe(System.out::println);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
