package operator.slice;

import io.reactivex.Flowable;


public class ElementAtTest {
    public static void main(String[] args) {

        Flowable.range(1, 9)
                .elementAt(2)
                .subscribe(System.out::println,
                        (t) -> System.out.println(t),
                        () -> System.out.println("complete"));

        Flowable.empty()
                .elementAt(2)
                .subscribe(System.out::println,
                        (t) -> System.out.println(t),
                        () -> System.out.println("complete"));
    }
}
