package core.basesyntax.model;

import java.time.LocalDate;

public class Order {
    private String nameOfProduct;
    private int quantity;
    private LocalDate date;

    public Order(String nameOfProduct, int quantity, LocalDate date) {
        this.nameOfProduct = nameOfProduct;
        this.quantity = quantity;
        this.date = date;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{"
                + "nameOfProduct='" + nameOfProduct + '\''
                + ", quantity=" + quantity
                + ", date=" + date
                + '}';
    }
}
