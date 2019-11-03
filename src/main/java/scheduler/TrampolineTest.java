package scheduler;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import static logger.Logger.*;
public class TrampolineTest {
    public static void main(String[] args) {

        Scheduler scheduler     = Schedulers.trampoline();

        Scheduler.Worker worker = scheduler.createWorker();

        log("main start");
        worker.schedule(()->{
            log("Outer Start");
            sleepFor(1, TimeUnit.SECONDS);
            worker.schedule(()->{
                log("middle start");
                sleepFor(1, TimeUnit.SECONDS);
                worker.schedule(()->{
                    log("inner start");
                    sleepFor(1, TimeUnit.SECONDS);
                    log("inner end");
                });
                log("middle end");
            });
            log("outer end.");
        });
        log("main end");
    }

    private static void sleepFor(int time, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
