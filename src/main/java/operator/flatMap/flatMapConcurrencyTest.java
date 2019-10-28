package operator.flatMap;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;


public class flatMapConcurrencyTest {

    public static void main(String[] args) {

        Flowable.just("SUNDAY", "MONDAY")
                .flatMap(day -> loadOrdersFor(day), 1)
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
