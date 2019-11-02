package operator;

import io.reactivex.Flowable;

public class ReduceTest {
    public static void main(String[] args) {

        Flowable.range(2, 9)
                .reduce(Integer::sum)
                .subscribe(System.out::println);

    }
}
