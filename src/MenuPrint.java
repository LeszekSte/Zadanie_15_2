import javax.sound.sampled.Line;
import java.util.*;


public class MenuPrint {


    Scanner sc = new Scanner(System.in);


    public int choiceMenu(Map orders) {
        ChangeStatusOrders chanStOrd = new ChangeStatusOrders();
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
                            chanStOrd.addOrder(orders);
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
        OrderType status = order.getStatus();
        System.out.println("Staus zamówienia" + " " + order.id + " - " + status);
        String opis = status.getDescripton();
        String newStatus = kindOfStatus(status);
        boolean ok = false;

        if (!status.equals(OrderType.COMPLETED)) {
            System.out.println("(T/N) -  Czy chcesz znienić status zamówienie z " + opis +
                    " na " + newStatus);
             ok = true;
        }

        if (status.ordinal() < 2) {
            System.out.println("A  - " + OrderType.CANCELED.getDescripton() + " Zamówienia ");
            ok = true;
        }
        String odp1= null;

        if (!ok) {
            odp1 = sc.nextLine().toUpperCase();
        }
        if (odp1.equals("A")) {
            orders.remove(index);
            System.out.println("Zamówienie skasowane");
        } else if (odp1.equals("T")) {
            orders.remove(index);
            order.setStatus(OrderType.valueOf(newStatus));
            orders.put(index, order);
        }
        if(!odp1.equals("A"))
        System.out.println(" -----------Staus zamówienia" + " " + order.id + " - " + order.getStatus());
    }

    private String kindOfStatus(OrderType status) {
        switch (status) {
            case COMPLEX:
                return OrderType.PREPARED_FOR_SHIPMENT.getDescripton();
            case PREPARED_FOR_SHIPMENT:
                return OrderType.IN_TRANSPORT.getDescripton();
            case IN_TRANSPORT:
                return OrderType.COMPLETED.getDescripton();
        }
        return null;
    }

    public void infoError() {
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
            //  sc.nextLine();
        } while (!(choice >= 0 && choice <= 6));
        if (choice != 0) {
            sortOrders(orders, choice);
        }
    }


    private void sortOrders(Map orders, int choice) {

        List<Order> list = new ArrayList<>();
        Set<Integer> indeks = new TreeSet<>(orders.keySet());
        Order orr;
        for (Integer indek : indeks) {
            list.add((Order) orders.get(indek));
        }
        Comparator comparator = null;
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
                comparator = new PriceComparatorDesc();
                break;
            case 5:
                comparator = new StatusComparator();
                break;
            case 6:
                comparator = new StatusComparatorDesc();

        }
        if (comparator != null) {
            Collections.sort(list, comparator);
            System.out.println(list);
        }
    }


}

