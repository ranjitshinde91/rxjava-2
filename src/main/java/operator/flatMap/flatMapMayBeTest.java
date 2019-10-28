package operator.flatMap;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

public class flatMapMayBeTest {
    public static void main(String[] args) {

        Flowable.just(1, 2, 3)
                .flatMapMaybe(i-> Maybe.empty())
                .subscribe(System.out::println);

        Flowable.just(1, 2, 3)
                .flatMapMaybe(i-> Maybe.just(i*2))
                .subscribe(System.out::println);
    }
}
