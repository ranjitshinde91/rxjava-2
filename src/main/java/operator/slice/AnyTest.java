package operator.slice;

import io.reactivex.Flowable;

public class AnyTest {
    public static void main(String[] args) {

        Flowable.range(1, 9)
                .any(i -> i==5)
                .subscribe(System.out::println);

        Flowable.range(1, 9)
                .any(i -> i==10)
                .subscribe(System.out::println);

    }
}
