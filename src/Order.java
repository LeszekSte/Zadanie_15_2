import java.util.Objects;

public class Order {
    int id;
    String name;
    double price;
    OrderType status;

    public Order(int id, String name, double price, OrderType status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderType getStatus() {
        return status;
    }

    public void setStatus(OrderType status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                Double.compare(order.price, price) == 0 &&
                Objects.equals(name, order.name) &&
                status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                "}\n";
    }

}
