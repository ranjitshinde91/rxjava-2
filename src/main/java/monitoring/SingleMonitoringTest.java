package monitoring;


import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class SingleMonitoringTest {

    public static void main(String[] args) {

        Single.just(1l)
                .doOnSuccess((value) -> System.out.println("onComplete1 "+ value))
                .doOnSubscribe((d)->System.out.println("doOnSubscribe1 "))
                .doOnDispose(()-> System.out.println("doOnDispose1 ") )
                .doOnTerminate(()-> System.out.println("doOnTerminate1 ") )
                .subscribe(new SingleObserver<Long>(){

                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("onSubscribe2");
                        disposable.dispose();
                    }

                    @Override
                    public void onSuccess(Long aLong) {
                        System.out.println("onSuccess2 "+aLong);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError2");
                    }
                });


        System.out.println("..................");

        Single.error(new RuntimeException("error"))
                .doOnSuccess((value) -> System.out.println("onComplete1 "+ value))
                .doOnSubscribe((d)->System.out.println("doOnSubscribe1 "))
                .doOnDispose(()-> System.out.println("doOnDispose1 ") )
                .doOnError((t)-> System.out.println("doOnError1 ") )
                .doOnTerminate(()-> System.out.println("doOnTerminate1 ") )
                .subscribe(new SingleObserver<Object>(){

                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("onSubscribe2");
                        disposable.dispose();
                    }

                    @Override
                    public void onSuccess(Object aLong) {
                        System.out.println("onSuccess2 "+aLong);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError2");
                    }
                });
    }
}
