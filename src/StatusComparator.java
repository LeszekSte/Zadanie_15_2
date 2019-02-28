import java.util.Comparator;

public class StatusComparator implements Comparator<Order> {

//    public int compare(Order o1, Order o2) {
//        return Double.compare(o1.getPrice(),o2.getPrice() );
//    }


    @Override
    public int compare(Order o1, Order o2) {
//        (int) Integer.compare(o1.status.getPosition()-o2.status.getPosition());
        return 0;
    }
}
