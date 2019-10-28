package type;


import io.reactivex.Completable;

public class CompletableTest {

    public static void main(String[] args) {
        Completable.complete()
                .doOnComplete(() -> System.out.println("Complete"))
                .subscribe(System.out::println);

        System.out.println(".....................");

        Completable.error(new RuntimeException("error"))
                .doOnError((e) -> System.out.println("Error"))
                .subscribe(System.out::println, System.out::println);

    }

}
