package error;

import io.reactivex.Observable;
import io.reactivex.Single;

public class ExceptionInOperatorTest {

    public static void main(String[] args) {

        Observable.just(1, 0, 2)
                .map(i -> 10/i)
        .subscribe(System.out::println,
                        (t) -> System.out.println(t));

        //This should be Preferred
        Observable.just(1, 0, 2)
                .flatMapSingle(i -> {
                    if(i ==0)
                        return Single.error(new ArithmeticException("/ by zero"));
                    else
                        return Single.just(10/i);
                })
                .subscribe(System.out::println,
                        (t) -> System.out.println(t));

    }
}
