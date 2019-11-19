package monitoring;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObservableMonitoringTest {

    public static void main(String[] args) {

        Observable.just(1l, 2l)
                .doOnSubscribe((s) -> System.out.println("doOnSubscribe " + s.isDisposed()))
                .doOnComplete(() -> System.out.println("completed "))
                .doOnTerminate(() -> System.out.println("doOnTerminate "))
                .doAfterTerminate(() -> System.out.println("after doAfterTerminate "))
                .doOnNext((i) -> System.out.println("onNext " + i))
                .doOnError((t) -> System.out.println("on Error " + t))
                .doOnLifecycle((s) -> System.out.println("doOnSubscribe2"),
                        () -> System.out.println("doOnDispose2 "))
                .subscribe(new Observer<Long>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("doOnSubscribe3");
                    }

                    @Override
                    public void onNext(Long integer) {
                        System.out.println("onNext2 " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("onError2 ");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete2 ");
                    }
                });

        Observable.just(1l, 2l)
                .doOnSubscribe((s) -> System.out.println("doOnSubscribe " + s.isDisposed()))
                .doOnDispose(() -> System.out.println("doOnDispose "))
                .subscribe(new Observer<Long>() {

                    Disposable disposable ;
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("doOnSubscribe3");
                        disposable=d;
                    }

                    @Override
                    public void onNext(Long integer) {
                        System.out.println("onNext2 " + integer);
                         disposable.dispose();
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("onError2 ");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete2 ");
                    }
                });
    }
}
