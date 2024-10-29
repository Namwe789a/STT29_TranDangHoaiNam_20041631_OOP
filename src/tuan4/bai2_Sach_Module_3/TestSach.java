package tuan4.bai2_Sach_Module_3;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TestSach {
    static ListSach sach = new ListSach();
    static Scanner scanner = new Scanner(System.in);

    // Hàm hiển thị menu
    static void Menu() {
        System.out.println("\t****************************************");
        System.out.println("\t**   Chương trình quản lí chuyến xe   **");
        System.out.println("\t* 1. Nhập cứng                         *");
        System.out.println("\t* 2. Thêm sách từ bàn phím             *");
        System.out.println("\t* 3. Xuất                              *");
        System.out.println("\t* 4. Thoát                             *");
        System.out.println("\t****************************************");
    }

    // Hàm in tiêu đề bảng
    public static void inTieuDe() {
        System.out.printf("%-10s|%-15s|%-10s|%-10s|%-20s|%-15s|%-25s|%-20s \n", 
                          "Mã Sách", "Ngày Nhập", "Đơn Giá", "Số Lượng", "Nhà Xuất Bản", "Loại Sách", "Thuế/Tình Trạng", "Thành Tiền");
    }

    // Hàm nhập cứng dữ liệu
    static void nhapCung() throws Exception {
        try {
            // Khởi tạo đối tượng Sach_Kham_Khao
            Sach sachkhamkhao = new Sach_Kham_Khao(
                "SACH001",                        // maSach
                LocalDate.of(2023, 9, 13),        // ngaNhap
                150000.0,                         // donGia
                10,                               // soLuong
                "NXB Giáo Dục",                   // nhaXuatBan
                0.01                              // thue
            );
            
            // Khởi tạo đối tượng Sach_Giao_Khoa
            Sach sachgiaokhoa1 = new Sach_Giao_Khoa(
                "SGK001",                         // maSach
                LocalDate.of(2023, 9, 13),        // ngaNhap
                50000.0,                          // donGia
                20,                               // soLuong
                "NXB Giáo Dục",                   // nhaXuatBan
                true                            // tinhTrang
            );
            Sach sachgiaokhoa2 = new Sach_Giao_Khoa(
                "SGK002",                         // maSach
                LocalDate.of(2023, 9, 13),        // ngaNhap
                50000.0,                          // donGia
                15,                               // soLuong
                "NXB Giáo Dục",                   // nhaXuatBan
                false                           // tinhTrang
            );

            // Thêm cả hai sách vào danh sách 'sach'
            sach.add(sachkhamkhao);
            sach.add(sachgiaokhoa1);
            sach.add(sachgiaokhoa2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Hàm nhập sách từ bàn phím
    static void nhapSachTuBanPhim() throws Exception {
        System.out.println("Chọn loại sách (1. Sách Giáo Khoa, 2. Sách Tham Khảo): ");
        int loaiSach = scanner.nextInt();
        scanner.nextLine(); // Xử lý dòng mới sau khi nhập số

        System.out.print("Nhập mã sách: ");
        String maSach = scanner.nextLine();

       
      
        System.out.print("Nhập ngày nhập (dd/MM/yyyy): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngayNhap = LocalDate.parse(scanner.nextLine(), formatter);

        System.out.print("Nhập đơn giá: ");
        double donGia = scanner.nextDouble();

        System.out.print("Nhập số lượng: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); // Xử lý dòng mới

        System.out.print("Nhập nhà xuất bản: ");
        String nhaXuatBan = scanner.nextLine();

        if (loaiSach == 1) { // Sách giáo khoa
            System.out.print("Nhập tình trạng sách (1. Mới, 2. Cũ): ");
            int tinhTrangInput = scanner.nextInt();
            scanner.nextLine(); // Xử lý dòng mới

            boolean tinhTrang = tinhTrangInput == 1; // Nếu người dùng nhập 1 thì là "Mới" (true), nếu nhập 2 thì là "Cũ" (false)

            Sach sachGiaoKhoa = new Sach_Giao_Khoa(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, tinhTrang);
            sach.add(sachGiaoKhoa);

        } else if (loaiSach == 2) { // Sách tham khảo
            System.out.print("Nhập thuế: ");
            double thue = scanner.nextDouble();

            Sach sachThamKhao = new Sach_Kham_Khao(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, thue);
            sach.add(sachThamKhao);
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }


    // Hàm xuất danh sách sách
    static void xuat(ListSach sach) {
        inTieuDe();
        for (Sach s : sach.getDS()) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Exception {
        int chon = -1;
        do {
            Menu();
            System.out.println("Nhập lựa chọn: ");

            chon = new Scanner(System.in).nextInt();
            switch (chon) {
                case 1:
                    nhapCung();
                    break;
                case 2:
                    nhapSachTuBanPhim();
                    break;
                case 3:
                    xuat(sach);
                    break;
                case 4:
                    // Xuất danh sách sách tham khảo
                    ArrayList<Sach> thamKhaoList = sach.getListThamKhao();
                    inTieuDe();
                    for (Sach s : thamKhaoList) {
                        System.out.println(s.toString());
                    }
                    break;
                case 5:
                    // Xuất danh sách sách tham khảo
                    
                    inTieuDe();
                    sach.sortTheoSoLuong();
                    xuat(sach);
                    break;
                case 6:
                    // Xuất danh sách sách tham khảo
                    
                    
                    sach.sortDonGia();
                    xuat(sach);
                    break;
                default:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình");
            }
        } while (chon != 4);
    }
}
