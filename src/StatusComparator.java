import java.util.Comparator;

public class StatusComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        int a1 = OrderType.valueOf(String.valueOf(o1.getStatus())).ordinal();
        int a2 = OrderType.valueOf(String.valueOf(o2.getStatus())).ordinal();

        return Integer.compare(a1, a2);
    }
}