package operator.slice;

import io.reactivex.Flowable;

public class AllTest {
    public static void main(String[] args) {

        Flowable.range(1, 9)
                .all( i-> i <=5)
                .subscribe(System.out::println);

        Flowable.range(1, 9)
                .all( i-> i <= 9)
                .subscribe(System.out::println);


    }
}
