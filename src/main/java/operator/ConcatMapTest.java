package operator;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;


public class ConcatMapTest {

    public static void main(String[] args) {

        Flowable.just("SUNDAY", "MONDAY")
                .concatMap(day -> loadOrdersFor(day))
                .subscribe(System.out::println);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Flowable<String> loadOrdersFor(String day) {

        switch (day){
            case "SUNDAY":
                return Flowable.interval(90, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map(i -> "Sun -"+i);
            case "MONDAY":
                return Flowable.interval(65, TimeUnit.MILLISECONDS)
                        .take(5)
                        .map(i -> "Mon -"+i);
        }
        return Flowable.empty();

    }
}
