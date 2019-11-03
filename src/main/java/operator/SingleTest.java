package operator;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

public class SingleTest {
    public static void main(String[] args) {

        Flowable.just(1, 2, 3)
                .singleElement()
                .subscribe(System.out::println,
                        (t) -> System.out.println(t));

        Maybe<Object> single = Flowable.empty()
                .singleElement();

        single.subscribe(System.out::println,
                (t) -> System.out.println(t),
                () -> System.out.println("complete"));

        Flowable.just(1)
                .singleElement()
                .subscribe(System.out::println,
                        (t) -> System.out.println(t));
    }
}
