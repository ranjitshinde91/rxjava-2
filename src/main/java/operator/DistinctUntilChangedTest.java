package operator;

import customer.Tweet;
import io.reactivex.Flowable;
public class DistinctUntilChangedTest {
    public static void main(String[] args) {

        Flowable.just(1, 2, 2, 3, 2, 1, 3, 2, 9)
                .distinctUntilChanged()
                .subscribe(System.out::println);

        Flowable.just(new Tweet(1),
                new Tweet(1),
                new Tweet(2),
                new Tweet(2),
                new Tweet(3),
                new Tweet(2),
                new Tweet(1),
                new Tweet(3),
                new Tweet(2),
                new Tweet(9))
                .distinctUntilChanged(Tweet::getId)
                .subscribe(System.out::println);
    }



}

