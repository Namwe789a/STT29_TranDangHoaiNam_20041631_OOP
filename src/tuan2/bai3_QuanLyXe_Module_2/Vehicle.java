package tuan2.bai3_QuanLyXe_Module_2;

public class Vehicle {
    // Attributes
    private double value;        // Trị giá xe
    private int cylinderCapacity; // Dung tích xy-lanh
    private String type;         // Loại xe (ví dụ: Ô tô, Xe máy, v.v.)

    // Constructor
    public Vehicle(double value, int cylinderCapacity, String type) {
        this.value = value;
        this.cylinderCapacity = cylinderCapacity;
        this.type = type;
    }

    // Getter and Setter for value
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    // Getter and Setter for cylinderCapacity
    public int getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(int cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    // Getter and Setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Method to calculate tax based on cylinder capacity
    public double calculateTax() {
        if (cylinderCapacity < 100) {
            return value * 0.01;
        } else if (cylinderCapacity <= 200) {
            return value * 0.03;
        } else {
            return value * 0.05;
        }
    }

    // Method to display vehicle information
    @Override
    public String toString() {
        return String.format("%-15s %-20.2f %-25d %-20.2f", type, value, cylinderCapacity, calculateTax());
    }

    // Static method to print the header
    public static void printHeader() {
        System.out.printf("%-15s %-20s %-25s %-20s%n", "Loại xe", "Trị giá", "Dung tích xy-lanh", "Thuế trước bạ");
        System.out.println("-----------------------------------------------------------------------------");
    }

}
