package operator;

import io.reactivex.Flowable;

public class FilterTest {
    public static void main(String[] args) {

        Flowable.just(1, 2, 3, 4)
                .filter( i -> i %2 ==0)
                .subscribe(System.out::println);
    }
}
