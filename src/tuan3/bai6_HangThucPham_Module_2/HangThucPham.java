package tuan3.bai6_HangThucPham_Module_2;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HangThucPham {
    private final String maHang;
    private String tenHang;
    private double donGia;
    private Date ngaySanXuat;
    private Date ngayHetHan; 
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    // Constructor đầy đủ tham số
    public HangThucPham(String maHang, String tenHang, double donGia, Date ngaySanXuat, Date ngayHetHan) {
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để trống.");
        }
        this.maHang = maHang;
        setTenHang(tenHang);
        setDonGia(donGia);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
    }

    // Constructor chỉ có mã hàng
    public HangThucPham(String maHang) {
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để trống.");
        }
        this.maHang = maHang;
        this.tenHang = "Chưa xác định";
        this.donGia = 0;
        this.ngaySanXuat = new Date(); // ngày hiện tại
        this.ngayHetHan = new Date(); // ngày hiện tại
    }

    // Getter và Setter cho tên hàng
    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if (tenHang == null || tenHang.trim().isEmpty()) {
            this.tenHang = "Chưa xác định";
        } else {
            this.tenHang = tenHang;
        }
    }

    // Getter và Setter cho đơn giá
    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia <= 0) {
            this.donGia = 10000; // giá trị mặc định
        } else {
            this.donGia = donGia;
        }
    }

    // Getter và Setter cho ngày sản xuất
    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        if (ngaySanXuat == null) {
            this.ngaySanXuat = new Date(); // ngày hiện tại
        } else {
            this.ngaySanXuat = ngaySanXuat;
        }
    }

    // Getter và Setter cho ngày hết hạn
    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        if (ngayHetHan == null || ngayHetHan.before(this.ngaySanXuat)) {
            this.ngayHetHan = new Date(this.ngaySanXuat.getTime() + (1000 * 60 * 60 * 24)); // 1 ngày sau ngày sản xuất
        } else {
            this.ngayHetHan = ngayHetHan;
        }
    }

    // Phương thức kiểm tra hàng thực phẩm đã hết hạn chưa
    public boolean kiemTraHetHan() {
        Date now = new Date();
        return ngayHetHan.before(now);
    }

    // Phương thức toString trả về chuỗi chứa thông tin hàng thực phẩm
    @Override
    public String toString() {
        return String.format("%-20s: %s\n%-20s: %s\n%-20s: %s\n%-20s: %s\n%-20s: %s\n%-20s: %s",
                "Mã hàng", maHang,
                "Tên hàng", tenHang,
                "Đơn giá", numberFormat.format(donGia),
                "Ngày sản xuất", dateFormat.format(ngaySanXuat),
                "Ngày hết hạn", dateFormat.format(ngayHetHan),
                "Hàng hết hạn", kiemTraHetHan() ? "Có" : "Không");
    }

}
