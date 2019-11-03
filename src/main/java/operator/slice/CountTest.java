package operator.slice;

import io.reactivex.Flowable;

public class CountTest {
    public static void main(String[] args) {

        Flowable.range(1, 9)
                .count()
                .subscribe(System.out::println,
                        (t) -> System.out.println(t));
        Flowable.empty()
                .count()
                .subscribe(System.out::println,
                        (t) -> System.out.println(t));
    }
}
