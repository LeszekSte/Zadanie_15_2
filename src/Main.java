import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Menu[] values = Menu.values();
        Menu me = Menu.ADD_ORDER;
////        System.out.println(me +" " +me.getDescripton());
//
//        System.out.println(Arrays.toString(values));
//        for (Menu value : values) {
//            System.out.println(value + " "+ value.getDescripton() );
//        }
        InputData inputData = new InputData();
      //  List<Order> orders = new ArrayList<Order>(inputData.readData());
        Map<Integer,Order> orders = inputData.readData();

        System.out.println(orders.size());
        Set<Map.Entry<Integer, Order>> entries = orders.entrySet();


        System.out.println(entries);
        MenuPrint menuPrint = new MenuPrint();
     menuPrint.choiceMenu(orders);


        //   Collections.sort(orders);
        System.out.println();
    }
}
