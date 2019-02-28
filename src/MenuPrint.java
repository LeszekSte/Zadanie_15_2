import javax.sound.sampled.Line;
import java.util.*;


public class MenuPrint {


    Scanner sc = new Scanner(System.in);


    public int choiceMenu(Map orders) {

        int choice = -1;
        Menu m = null;
        Menu[] menus = Menu.values();
        do {
            System.out.println("*************** MENU ******************\n");
            System.out.println(Menu.SORT.getDescripton() + "        - " + Menu.SORT.getChose());
            System.out.println(Menu.ADD_ORDER.getDescripton() + "         - " + Menu.ADD_ORDER.getChose());
            System.out.println(Menu.CHANGE_STATUS.getDescripton() + "  - " + Menu.CHANGE_STATUS.getChose());
            System.out.println(Menu.END_PROGRAM.getDescripton() + "            - " + Menu.END_PROGRAM.getChose());
            try {
                choice = sc.nextInt();
                if ((choice >= Menu.SORT.getChose() && choice <= Menu.CHANGE_STATUS.getChose())) {
                    for (Menu menu : menus) {
                        if (menu.getChose() == choice) {
                            m = menu;
                        }
                    }
                    switch (m) {
                        case SORT:
                            choiceSort(orders);
                            choice = -1;
                            break;
                        case CHANGE_STATUS:
                            changeStatusOrder(orders);
                            choice = -1;
                            break;
                        case ADD_ORDER:
                            choiceSort(orders);
                            choice = -1;
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                infoError();
            } finally {
                sc.nextLine();
            }
        } while (!(choice >= Menu.END_PROGRAM.getChose() && choice <= Menu.CHANGE_STATUS.getChose()));
        return choice;
    }

    private void changeStatusOrder(Map orders) {
        System.out.println("Które chcesz zmienić zmówienie - podaj indeks zamówienia?");
        Set<Integer> integers = orders.keySet();
        System.out.println(integers);
        try {
            int index = sc.nextInt();
            if (checkIndex(index, orders)) ;
            changeStatus(index, orders);
        } catch (InputMismatchException e) {
            infoError();
        } finally {
            sc.nextLine();
        }

    }

    private void changeStatus(int index, Map orders) {
        Order order = (Order) orders.get(index);

        System.out.println("Staus zamówienia" + " " + order.id + " - " + order.getStatus());
        System.out.println("Na jaki status chcesz zmineić zamówienie");
        // System.out.println("*************** MENU ******************\n");

        //     System.out.println(OrderType.COMPLEX.getDescripton() + "                  - " + OrderType.COMPLEX.getPosition());
        System.out.println(OrderType.PREPARED_FOR_SHIPMENT.getDescripton() + "  - " + OrderType.PREPARED_FOR_SHIPMENT.getPosition());
        System.out.println(OrderType.IN_TRANSPORT.getDescripton() + "            - " + OrderType.IN_TRANSPORT.getPosition());
        System.out.println(OrderType.COMPLETED.getDescripton() + "             - " + OrderType.COMPLETED.getPosition());
        System.out.println(OrderType.CANCELED.getDescripton() + "                - " + OrderType.CANCELED.getPosition());


        // order.setStatus( OrderType.valueOf(order.status.name()));

        OrderType m = null;
        OrderType[] orderTypes = OrderType.values();

     //   System.out.println(order.name);
        System.out.println("KKKKKKKKKKKKK");

        try {
            int odp = sc.nextInt();
            for (OrderType stat : orderTypes) {
                if (stat.getPosition() == odp) {
                    m = stat;
                    System.out.println(stat);
                }
            }
          //  MxFast opis1 = MxFast.valueOf(odp);
         //   System.out.println(OrderType.valueOf(m));
          //  OrderType zz = OrderType.valueOf()
            orders.remove(index);
            order = (Order) orders.get(index);
            orders.put(index, new Order(index, "asa", 2.5,m));
        } catch (InputMismatchException e) {
            infoError();
        } finally {
            sc.nextLine();
        }
        System.out.println(orders);;
        System.out.println("Staus zamówienia" + " " + order.id + " - " + order.getStatus());
    }

    private void infoError() {
        System.err.println("Błędna wartość");
    }

    private boolean checkIndex(int index, Map orders) {
        Set ikey = orders.keySet();
        boolean ok = false;
        for (Object o : ikey) {
            if (o.equals(index)) {
                System.out.println(orders.get(o).toString());
                ok = true;
                break;
            } else {
                infoError();
            }
            break;
        }
        return ok;
    }

    private void choiceSort(Map orders) {
        int choice = -1;
        do {
            System.out.println("******* SORTOWANIE - MENU ******************\n");
            System.out.println("Sortowanie wg Nazwy             (rosnąco)   - 1");
            System.out.println("                                (malejąco)  - 2");
            System.out.println("Sortowanie wg Ceny              (rosnąco)   - 3");
            System.out.println("                                (malejąco)  - 4");
            System.out.println("Sortowanie wg Status Zamówienia (rosnąco)   - 5");
            System.out.println("                                (malejąco)  - 6");
            System.out.println("Powrót                                      - 0");
            choice = sc.nextInt();
            sc.nextLine();
        } while (!(choice >= 0 && choice <= 6));
        if (choice != 0) {
            sortOrders(orders, choice);
        }
    }


    private void sortOrders(Map orders, int choice) {
        Comparator<Order> comparator = null;
        switch (choice) {
            case 1:
                comparator = new NameComparator();
                break;
            case 2:
                comparator = new NameComparatorDesc();
                break;
            case 3:
                comparator = new PriceComparator();
                break;
            case 4:
                comparator = new NameComparatorDesc();
                break;
            case 5:
                comparator = new StatusComparator();
                break;
            case 6:
                comparator = new NameComparatorDesc();
        }
        if (comparator != null)

//            Collections.sort(orders, comparator);
            System.out.println(orders);
    }


}

