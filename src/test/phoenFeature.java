package test;

public class phoenFeature {
    private String brand;
    private String color;
    private double price;

    public phoenFeature() {
    }

    public phoenFeature(String brand, String color, double price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void PhoneNew(String brand, String color, double price )
    {
        System.out.println(brand+color+price);
    }
}
