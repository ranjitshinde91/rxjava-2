package customer;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class Order {
    public static Flowable<String> loadOrdersFor(String day) {
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
