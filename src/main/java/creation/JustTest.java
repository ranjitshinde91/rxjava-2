package creation;


import io.reactivex.Observable;

public class JustTest {

    public static void main(String[] args) {

        Observable source = Observable.just(1, 2);
        source.subscribe(System.out::println);
    }
}
