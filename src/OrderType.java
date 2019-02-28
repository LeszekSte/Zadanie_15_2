public enum OrderType {
    ORDERED("Złożone",0),
    PREPARED_FOR_SHIPMENT("Przygotowane do wysyłki",1),
    IN_TRANSPORT("W transporcie",2),
    COMPLETED("Zrealizowane",3),
    CANCELED("Anulowane",4);

    private final String descripton;

    public int getPosition() {
        return position;
    }

    private final int position;

    public String getDescripton() {
        return descripton;
    }

    OrderType(String description, int position) {
        this.descripton = description;
        this.position= position;
    }

    public void printOrderType() {
        System.out.println(descripton);
    }

    public int compare(OrderType status) {

        return 0;

   }
//    public int compare(OrderType o1, OrderType o2) {
//        return -(o1.getStatus().compare(o2.getStatus()));
//    }

}

