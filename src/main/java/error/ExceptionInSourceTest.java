package error;

import io.reactivex.Observable;

public class ExceptionInSourceTest {

    public static void main(String[] args) {

        Observable.create((s) -> {
            int a = 1 / 0;
        })

        .subscribe(System.out::println,
                        (t) -> System.out.println(t));

        Observable.create((s) -> {
            try{
                int a = 1 / 0;
            }
            catch (Exception e){
                s.onError(e);
            }
        }).subscribe(System.out::println,
                        (t) -> System.out.println(t));

        //This should be Preferred
        Observable.fromCallable(() -> 1 / 0)
        .subscribe(System.out::println,
                        (t) -> System.out.println(t));
    }
}
