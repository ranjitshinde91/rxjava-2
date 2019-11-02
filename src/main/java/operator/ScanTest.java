package operator;

import io.reactivex.Flowable;

public class ScanTest {
    public static void main(String[] args) {

        Flowable.range(2, 9)
                .scan((accumulator, value) -> {
                    System.out.println("value :"+value+" accumulator: "+accumulator);
                    return value + accumulator;
                })
                .subscribe(System.out::println);

        Flowable.range(2, 9)
                .scan(1, Integer::sum)
                .subscribe(System.out::println);
    }
}
