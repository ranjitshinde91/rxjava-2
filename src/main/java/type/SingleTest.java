package type;


import io.reactivex.Single;

public class SingleTest {

    public static void main(String[] args) {
        Single.just(1)
                .subscribe(System.out::println,
                        (t) -> System.out.println(t));

        Single.error(new RuntimeException("error"))
                .subscribe(System.out::println,
                        (t) -> System.out.println(t));
    }
}
