package creation;


import io.reactivex.Observable;

public class RangeTest {

    public static void main(String[] args) {

        Observable source = Observable.range(1, 3);
        source.subscribe(System.out::println);
    }
}
