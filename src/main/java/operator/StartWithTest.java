package operator;

import io.reactivex.Flowable;

public class StartWithTest {
    public static void main(String[] args) {

        Flowable.just(2, 3)
                .startWith(0)
                .startWith(Flowable.just(1))
                .subscribe(System.out::println);
    }
}
