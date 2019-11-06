package error;

import io.reactivex.Observable;

public class OnErrorResumeNextTest {

    public static void main(String[] args) {

        Observable.just(1, 0, 2)
                .map(i -> 10 / i)
                .onExceptionResumeNext(Observable.just(0))
                .subscribe(System.out::println,
                        (t) -> System.out.println(t));
    }
}
