package operator.flatMap;

import io.reactivex.Flowable;

public class flatMapTest {
    public static void main(String[] args) {

        Flowable<Integer> stream = Flowable.just(1, 2, 3)
                .flatMap(i -> Flowable.just(i, i * 2, i * 3));

        stream.subscribe(System.out::println);
    }
}
