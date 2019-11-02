package operator;

import io.reactivex.Flowable;

import java.util.ArrayList;
import java.util.List;

public class CollectTest {
    public static void main(String[] args) {

        Flowable.range(1, 9)
                .collect(ArrayList::new, List::add)
                .subscribe(System.out::println);
    }
}
