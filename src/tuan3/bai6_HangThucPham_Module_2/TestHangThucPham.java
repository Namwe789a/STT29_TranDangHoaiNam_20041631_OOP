package tuan3.bai6_HangThucPham_Module_2;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TestHangThucPham {

    public static void main(String[] args) {
        menu(); // Gọi hàm menu trong hàm main
    }

    // Hàm menu riêng biệt
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        HangThucPham htp1 = null; // Ban đầu chưa nhập gì cả
        HangThucPham htp2 = null;

        int choice;
        do {
            // Hiển thị menu
            System.out.println("===== MENU =====");
            System.out.println("1. Nhập dữ liệu cứng hàng thực phẩm");
            System.out.println("2. Nhập thông tin hàng thực phẩm từ bàn phím");
            System.out.println("3. Xuất thông tin hàng thực phẩm");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (choice) {
                case 1:
                    // Nhập dữ liệu cứng
                    htp1 = NhapCungHangThucPham(); // Nhập dữ liệu mới
                    System.out.println("Đã nhập dữ liệu cứng hàng thực phẩm.");
                    break;
                case 2:
                    // Nhập thông tin hàng thực phẩm từ bàn phím
                    htp2 = inputHangThucPham(); // Nhập từ bàn phím
                    System.out.println("Đã nhập thông tin hàng thực phẩm từ bàn phím.");
                    break;
                case 3:
                    // Xuất thông tin hàng thực phẩm
                    if (htp1 != null || htp2 != null) {
                        if (htp1 != null) {
                            System.out.println("Thông tin hàng thực phẩm từ dữ liệu cứng:");
                            System.out.println(htp1);
                        }
                        if (htp2 != null) {
                            System.out.println("\nThông tin hàng thực phẩm từ bàn phím:");
                            System.out.println(htp2);
                        }
                    } else {
                        System.out.println("Chưa có thông tin để xuất. Vui lòng nhập trước.");
                    }
                    break;
                case 4:
                    // Thoát chương trình
                    System.out.println("Chương trình kết thúc.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // Hàm nhập dữ liệu cứng
    public static HangThucPham NhapCungHangThucPham() {
        return createHangThucPham("HTP001", "Gạo", 20000, 2023, Calendar.JANUARY, 1, 2024, Calendar.JANUARY, 1);
    }

    // Hàm tạo đối tượng HangThucPham với tham số truyền vào
    public static HangThucPham createHangThucPham(String maHang, String tenHang, double donGia,
                                                  int namSanXuat, int thangSanXuat, int ngaySanXuat,
                                                  int namHetHan, int thangHetHan, int ngayHetHan) {
        Calendar cal = Calendar.getInstance();
        cal.set(namSanXuat, thangSanXuat, ngaySanXuat);
        Date ngaySX = cal.getTime();

        cal.set(namHetHan, thangHetHan, ngayHetHan);
        Date ngayHH = cal.getTime();

        return new HangThucPham(maHang, tenHang, donGia, ngaySX, ngayHH);
    }

    // Hàm nhập thông tin từ bàn phím
    public static HangThucPham inputHangThucPham() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã hàng: ");
        String maHang = scanner.nextLine();

        System.out.print("Nhập tên hàng: ");
        String tenHang = scanner.nextLine();

        System.out.print("Nhập đơn giá: ");
        double donGia = scanner.nextDouble();

        System.out.print("Nhập ngày sản xuất (yyyy-mm-dd): ");
        String[] ngaySXStr = scanner.next().split("-");
        int namSX = Integer.parseInt(ngaySXStr[0]);
        int thangSX = Integer.parseInt(ngaySXStr[1]) - 1; // Calendar month is 0-based
        int ngaySX = Integer.parseInt(ngaySXStr[2]);

        System.out.print("Nhập ngày hết hạn (yyyy-mm-dd): ");
        String[] ngayHHStr = scanner.next().split("-");
        int namHH = Integer.parseInt(ngayHHStr[0]);
        int thangHH = Integer.parseInt(ngayHHStr[1]) - 1;
        int ngayHH = Integer.parseInt(ngayHHStr[2]);

        Calendar cal = Calendar.getInstance();
        cal.set(namSX, thangSX, ngaySX);
        Date ngaySXDate = cal.getTime();

        cal.set(namHH, thangHH, ngayHH);
        Date ngayHHDate = cal.getTime();

        return new HangThucPham(maHang, tenHang, donGia, ngaySXDate, ngayHHDate);
    }
}
