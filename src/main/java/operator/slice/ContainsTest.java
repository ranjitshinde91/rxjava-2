package operator.slice;

import io.reactivex.Flowable;

public class ContainsTest {
    public static void main(String[] args) {

        Flowable.range(1, 9)
                .contains(5)
                .subscribe(System.out::println);

        Flowable.range(1, 9)
                .contains(10)
                .subscribe(System.out::println);

    }
}
