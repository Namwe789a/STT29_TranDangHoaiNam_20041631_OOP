package tuan2.bai3_QuanLyXe_Module_2;

import java.util.Scanner;

public class VehicleTaxApp {
    static Scanner scanner = new Scanner(System.in);

    public static Vehicle[] createVehicle() {
        int numOfVehicles = inputInt("Nhập số lượng xe: ");
        Vehicle[] vehicles = new Vehicle[numOfVehicles];

        for (int i = 0; i < vehicles.length; i++) {
            System.out.println("Nhập thông tin cho xe " + (i + 1) + ":");
            String type = inputString("Nhập loại xe: ");
            double value = inputDouble("Nhập trị giá xe: ");
            int capacity = inputInt("Nhập dung tích xy-lanh (cc): ");
            vehicles[i] = new Vehicle(value, capacity, type);
        }

        return vehicles;
    }

    public static void displayVehicles(Vehicle[] vehicles) {
        if (vehicles != null && vehicles.length > 0) {
            Vehicle.printHeader(); // In tiêu đề
            for (int i = 0; i < vehicles.length; i++) {
                System.out.printf("Xe %d: %s%n", (i + 1), vehicles[i]);
            }
        } else {
            System.out.println("Chưa có xe nào được tạo. Vui lòng chọn 1 để nhập thông tin xe trước.");
        }
    }
    public static void main(String[] args) {
        Vehicle[] vehicles = null;
        int choice;

        do {
            choice = menu();
            switch (choice) {
                case 1:
                    vehicles = createVehicle();
                    break;
                case 2:
                    displayVehicles(vehicles);
                    break;
                case 3:
                    System.out.print("Đã kết thúc chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }

    public static int menu() {
        System.out.println("\n\t********************************");
        System.out.println("\t** Chương Trình Quản lý Thuế Xe **");
        System.out.println("\t1. Nhập thông tin và tạo các đối tượng xe");
        System.out.println("\t2. Xuất bảng kê khai tiền thuế trước bạ của các xe");
        System.out.println("\t3. Thoát");
        System.out.print("\t********************************\nChọn: ");
        return inputInt("");
    }

    public static int inputInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Vui lòng nhập số nguyên.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    public static double inputDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Vui lòng nhập số thực.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }

    public static String inputString(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}
