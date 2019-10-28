package operator;

import io.reactivex.Flowable;

public class MapTest {
    public static void main(String[] args) {

        Flowable.just(1, 2, 3)
                .map(i-> i*2)
                .subscribe(System.out::println);
    }
}
