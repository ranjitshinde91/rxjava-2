package error;

import io.reactivex.Observable;

public class OnErrorReturnTest {

    public static void main(String[] args) {

        Observable.just(1, 0, 2)
                .map(i -> 10/i)
                .onErrorReturn((t)-> 0)
                .subscribe(System.out::println,
                        (t) -> System.out.println(t));

        Observable.just(1, 0, 2)
                .map(i -> 10/i)
                .onErrorReturnItem(0)
                .subscribe(System.out::println,
                        (t) -> System.out.println(t));
    }
}
