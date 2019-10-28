package operator.flatMap;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class flatMapSingleTest {
    public static void main(String[] args) {

        Flowable.just(1, 2, 3)
                .flatMapSingle(i-> Single.just(i*2))
                .subscribe(System.out::println);
    }
}
