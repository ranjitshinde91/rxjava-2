package concurrency;


import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class SubscribeOnTest {

    public static void main(String[] args) {

        Flowable.just(1, 2, 3, 4, 5, 6)
                .map(it -> {
                    System.out.println("1" + it + ": "+Thread.currentThread().getName());
                    return it;
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.io())
                .map(it -> {
                    System.out.println("2" +it + ": "+Thread.currentThread().getName());
                    return it;
                })
        .subscribe();

        System.out.println("complete");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
