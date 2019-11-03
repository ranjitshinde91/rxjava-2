package operator;

import io.reactivex.Flowable;
import io.reactivex.flowables.GroupedFlowable;

public class GroupByTest {
    public static void main(String[] args) {

        Flowable<GroupedFlowable<Integer, Integer>> groupedObservable = Flowable.just(
                1, 2, 3, 4, 2, 3, 1 ,4, 5, 2)
                .groupBy(i -> i);

        groupedObservable
                .subscribe((groupedStream)-> {
                    System.out.println("groupKey :"+ groupedStream.getKey());
                    groupedStream.subscribe(System.out::println);
                });

    }
}
