package operator.streams;

import io.reactivex.Observable;

public class ConcatWithTest {

    public static void main(String[] args) {

        Observable source1 = Observable.create(emitter -> {
            System.out.println("staring source 1");
            emitter.onNext(1);
            emitter.onComplete();
        });

        Observable source2 = Observable.create(emitter -> {
            System.out.println("staring source 2");
            emitter.onNext(2);
            emitter.onComplete();
        });

        Observable stream = source1.concatWith(source2);

        stream.subscribe(System.out::println);

        stream.take(1).subscribe(System.out::println);

    }
}
