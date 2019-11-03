package operator.slice;

import io.reactivex.Flowable;

public class LastElementTest {
    public static void main(String[] args) {

        Flowable.range(1, 9)
                .lastElement()
                .subscribe(System.out::println);

        Flowable.empty()
                .lastElement()
                .subscribe(System.out::println);
    }
}
