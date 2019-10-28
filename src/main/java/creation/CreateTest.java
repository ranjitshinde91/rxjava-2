package creation;


import io.reactivex.Observable;

public class CreateTest {

    public static void main(String[] args) {

        Observable source = Observable.create(emitter -> {
            System.out.println("emitting");
            emitter.onNext(1);
            emitter.onComplete();
        });

        source.subscribe(System.out::println);
        source.subscribe(System.out::println);
    }
}
