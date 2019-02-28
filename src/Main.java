import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
     //   Menu[] values = Menu.values();
     //   Menu me = Menu.ADD_ORDER;

        InputData inputData = new InputData();
        Map<Integer, Order> orders = inputData.readData();

        System.out.println(orders.size());
        Set<Map.Entry<Integer, Order>> entries = orders.entrySet();
        System.out.println(entries);
        MenuPrint menuPrint = new MenuPrint();
        menuPrint.choiceMenu(orders);


        System.out.println();
    }
}
