package model;

public class SmartPhone {
    private String model;
    private float price;

    public SmartPhone(String model, float price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SmartPhone{"
                + "model='" + model + '\''
                + ", price=" + price
                + '}';
    }
}
