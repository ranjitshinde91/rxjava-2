package operator.slice;

import io.reactivex.Flowable;

public class FirstElementTest {
    public static void main(String[] args) {

        Flowable.range(1, 9)
                .firstElement()
                .subscribe(System.out::println);


        Flowable.empty()
                .firstElement()
                .subscribe(System.out::println,
                        (t) -> System.out.println(t),
                        () -> System.out.println("complete"));
    }
}
