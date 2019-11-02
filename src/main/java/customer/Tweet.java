package customer;

public class Tweet{

    private final int id;

    public Tweet(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                '}';
    }
}
