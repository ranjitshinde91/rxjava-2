package operator.slice;

import io.reactivex.Flowable;

public class TakeWhileTest {
    public static void main(String[] args) {

        Flowable.range(1, 9)
                .takeWhile( i-> i<5)
                .subscribe(System.out::println);
    }
}
