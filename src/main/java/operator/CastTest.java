package operator;

import io.reactivex.Flowable;

public class CastTest {
    public static void main(String[] args) {

        Flowable.just("a", "b", "c")
                .cast(String.class)
                .subscribe(System.out::println);
    }
}
