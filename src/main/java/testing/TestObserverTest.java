package testing;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

public class TestObserverTest {

    public static void main(String[] args) {

        Single<Integer> source = Single.just(1);

        TestObserver<Integer> observer = new TestObserver<>();

        source.subscribe(observer);

        System.out.println(observer.assertValue(1));
    }
}
