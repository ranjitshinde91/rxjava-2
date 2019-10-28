package operator.flatMap;

import io.reactivex.Flowable;

import java.util.ArrayList;
import java.util.List;


public class flatMapIterableTest {
    public static void main(String[] args) {

        Flowable.just(1, 2, 3)
                .flatMapIterable(i-> {
                    List<Integer>list = new ArrayList<>();
                    list.add(i);
                    list.add(i*2);
                    return list;
                })
                .subscribe(System.out::println);
    }
}
