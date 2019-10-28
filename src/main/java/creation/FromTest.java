package creation;


import io.reactivex.Observable;

import java.util.concurrent.Callable;

public class FromTest {

    public static void main(String[] args) {
        Callable<Long> callable = () -> 1l;

        Observable source = Observable.fromCallable(callable);

        source.subscribe(System.out::println);
    }
}
