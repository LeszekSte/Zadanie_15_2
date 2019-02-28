import java.util.*;

public class ChangeStatusOrders {

    MenuPrint menuPrint = new MenuPrint();
    Scanner sc = new Scanner(System.in);

    void addOrder(Map orders) {
        TreeSet<Integer> indeks = new TreeSet<>(orders.keySet());
        int id = indeks.last() + 1;
        System.out.println("Wprowadź nowe zamówienie");
        boolean ok = false;
        do {
            System.out.println("Podaj nazwę produktu");
            String name = sc.nextLine();
            double price = addPrice();
            System.out.println("Czy dane sa poprawne ? (T/N)");
            if (sc.nextLine().toUpperCase().equals("T")) {
                orders.put(id, new Order(id, name, price, OrderType.COMPLETED));
                System.out.println("Zamówienie o indeksie " + id + "   zostało wprowadzone  - " + orders.get(id));
                ok = true;
            }
        } while (!ok);
    }

    private double addPrice() {
        double price = 0;
        do {
            System.out.println("Podaj cenę netto zł");
            try {
                price = sc.nextDouble();
            } catch (InputMismatchException e) {
                menuPrint.infoError();

            } finally {
                sc.nextLine();
            }
        } while (price <= 0);
        return price;
    }

}
