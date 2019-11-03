package creation;


import io.reactivex.Flowable;

public class DeferTest {

    public static void main(String[] args) {

        Producer producer = new Producer();

        Flowable<String> value           = producer.valueObservable();
        Flowable<String> deferedValue    = producer.deferValueObservable();

        producer.setValue("Some Value");

        value.subscribe(System.out::println);
        deferedValue.subscribe(System.out::println);
    }
}

class Producer {
    private String value = "DEFAULT";

    public void setValue(String value) {
        this.value = value;
    }

    public Flowable<String> valueObservable() {
        return Flowable.just(value);
    }

    public Flowable<String> deferValueObservable() {
        return Flowable.defer(() -> Flowable.just(value));
    }
}
