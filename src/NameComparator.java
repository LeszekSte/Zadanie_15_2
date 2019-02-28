import java.util.Comparator;

public class NameComparator implements Comparator<Order> {


    @Override
    public int compare(Order o1, Order o2) {
        return o1.getName().compareTo(o2.getName());
    }

    public int compareDescending(Order o1, Order o2) {
        return -(o1.getName().compareTo(o2.getName()));
    }
}
