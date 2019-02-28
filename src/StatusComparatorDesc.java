import java.util.Comparator;

public class StatusComparatorDesc implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
       //  o2.status.ordinal();
        int a1 = OrderType.valueOf(String.valueOf(o1.getStatus())).getPosition();
        int a2 = OrderType.valueOf(String.valueOf(o2.getStatus())).getPosition();

        return  - Integer.compare(a1, a2);
    }
}