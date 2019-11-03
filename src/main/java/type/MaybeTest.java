package type;


import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;

public class MaybeTest {

    public static void main(String[] args) {

        final MaybeObserver maybeObserver = new MaybeObserver<Long>() {

            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onSuccess(Long aLong) {
                System.out.println("onSuccess");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        Maybe.just(1l)
                .subscribe(maybeObserver);

        Maybe.empty()
                .subscribe(maybeObserver);

        Maybe.error(new RuntimeException("error"))
                .subscribe(maybeObserver);

    }
}
