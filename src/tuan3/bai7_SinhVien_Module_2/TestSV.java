package tuan3.bai7_SinhVien_Module_2;
import java.util.Scanner;

public class TestSV {
    static Scanner scanner = new Scanner(System.in);

    public static void tuaDe() {
        System.out.println("--------------------------------------------------------");
        System.out.println("------------------Danh Sách Sinh Viên-------------------");
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s", 
                "MSSV", "Họ & Tên", "Giới tính", "Khóa học", "Điểm");
        System.out.println("\n");
    }

    public static void Menu() {
        System.out.println("====== MENU QUẢN LÝ SINH VIÊN ======");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Xóa sinh viên");
        System.out.println("3. Sửa thông tin sinh viên");
        System.out.println("4. Hiển thị danh sách sinh viên");
        System.out.println("5. Sắp xếp sinh viên theo tên (tăng dần)");
        System.out.println("6. Sắp xếp sinh viên theo mã số (giảm dần)");
        System.out.println("7. Nhập cứng");
        System.out.println("8. Tìm kiếm sinh viên theo mã số");
        System.out.println("0. Thoát");
        System.out.print("Nhập lựa chọn: ");
    }

    public static void nhapCung(danhSach ds) {
        SinhVien sv1 = new SinhVien("a1", "Trọng", "nam", 19, 9);
        SinhVien sv2 = new SinhVien("a2", "Thịnh", "nam", 18, 8);
        SinhVien sv3 = new SinhVien("a3", "Hạnh", "nữ", 19, 7);
        
        ds.themSV(sv1);
        ds.themSV(sv2);
        ds.themSV(sv3);
    }

    // Hàm thêm sinh viên
    public static void themSinhVien(danhSach ds) {
        System.out.print("Nhập mã số sinh viên: ");
        String mssv = scanner.nextLine();
        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập giới tính (nam hoặc nữ): ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Nhập khóa học: ");
        int khoa = scanner.nextInt();
        System.out.print("Nhập điểm: ");
        double diem = scanner.nextDouble();
        scanner.nextLine();

        SinhVien sv = new SinhVien(mssv, hoTen, gioiTinh, khoa, diem);
        if (ds.themSV(sv)) {
            System.out.println("Thêm sinh viên thành công!");
        } else {
            System.out.println("Thêm sinh viên thất bại! Mã số sinh viên đã tồn tại hoặc danh sách đầy.");
        }
    }

    // Hàm xóa sinh viên
    public static void xoaSinhVien(danhSach ds) {
        System.out.print("Nhập mã số sinh viên cần xóa: ");
        String mssvXoa = scanner.nextLine();
        if (ds.xoaSV(mssvXoa)) {
            System.out.println("Xóa sinh viên thành công!");
        } else {
            System.out.println("Không tìm thấy sinh viên với mã số: " + mssvXoa);
        }
    }

    // Hàm sửa thông tin sinh viên
    public static void suaSinhVien(danhSach ds) {
        System.out.print("Nhập mã số sinh viên cần sửa: ");
        String mssvSua = scanner.nextLine();
        System.out.println("Nhập mã số sinh viên mới: ");
        String mssvnew = scanner.nextLine();
        System.out.println("Nhập họ tên mới: ");
        String hoTennew = scanner.nextLine();
        System.out.println("Nhập lại giới tính: ");
        String gtnew = scanner.nextLine();
        System.out.println("Nhập khóa học mới: ");
        int khoanew = scanner.nextInt();
        System.out.println("Nhập điểm mới: ");
        double diemnew = scanner.nextDouble();
        scanner.nextLine();

        SinhVien svnew = new SinhVien(mssvnew, hoTennew, gtnew, khoanew, diemnew);

        if (ds.suaSV(mssvSua, svnew)) {
            System.out.println("Sửa thông tin sinh viên thành công!");
        } else {
            System.out.println("Không tìm thấy sinh viên với mã số: " + mssvSua);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên cần thêm vào danh sách(>0): ");
        int kichThuoc = scanner.nextInt();
        danhSach ds = new danhSach(kichThuoc);

        int luaChon;
        do {
            Menu();
            luaChon = scanner.nextInt();
            scanner.nextLine(); 

            switch (luaChon) {
                case 1:
                    themSinhVien(ds);
                    break;
                case 2:
                    xoaSinhVien(ds);
                    break;
                case 3:
                    suaSinhVien(ds);
                    break;
                case 4:
                    tuaDe();
                    System.out.println(ds.inDanhSach());
                    break;
                case 5:
                    ds.sapXepTangTheoHoTen();
                    System.out.println("Danh sách sinh viên sau khi sắp xếp theo tên (tăng dần):");
                    tuaDe();
                    System.out.println(ds.inDanhSach());
                    break;
                case 6:
                    ds.sapXepGiamTheoMa();
                    System.out.println("Danh sách sinh viên sau khi sắp xếp theo mã số (giảm dần):");
                    tuaDe();
                    System.out.println(ds.inDanhSach());
                    break;
                case 7:
                    nhapCung(ds);
                    tuaDe();
                    System.out.println(ds.inDanhSach());
                    break;
                case 8:
                    System.out.print("Nhập mã số sinh viên cần tìm: ");
                    String mssvTimKiem = scanner.nextLine();
                    SinhVien foundStudent = ds.timKiemSV(mssvTimKiem);
                    if (foundStudent != null) {
                        tuaDe();
                        System.out.println(foundStudent.toString());
                    } else {
                        System.out.println("Không tìm thấy sinh viên với mã số: " + mssvTimKiem);
                    }
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
                    break;
            }
        } while (luaChon != 0);

        scanner.close();
    }
}
