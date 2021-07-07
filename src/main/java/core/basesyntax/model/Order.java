package core.basesyntax.model;

public class Order {
    private String nameOfProduct;
    private int quantity;

    public Order(String nameOfProduct, int quantity) {
        this.nameOfProduct = nameOfProduct;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "Order{"
                + "nameOfProduct='" + nameOfProduct + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
