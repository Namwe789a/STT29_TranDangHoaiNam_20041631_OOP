package tuan4.bai8_HangHoa_Module_3;


import java.time.LocalDate;

public class HangThucPham extends HangHoa {
    private LocalDate ngaySanXuat;
    protected LocalDate ngayHetHan;
    private String nhaCungCap;

    // Constructor
    public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia, 
                        String nhaCungCap, String ngaySanXuat, String ngayHetHan) {
        super(maHang, tenHang, soLuongTon, donGia, "Thực phẩm"); // Loại hàng
        this.nhaCungCap = nhaCungCap;

        // Chuyển đổi từ String sang LocalDate
        this.ngaySanXuat = LocalDate.parse(ngaySanXuat);
        this.ngayHetHan = LocalDate.parse(ngayHetHan);
        
        // Kiểm tra ngày hết hạn phải sau hoặc bằng ngày sản xuất
        if (this.ngayHetHan.isBefore(this.ngaySanXuat)) {
            throw new IllegalArgumentException("Ngày hết hạn phải sau hoặc bằng ngày sản xuất.");
        }
    }

    // Getter và Setter
    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public double tinhVAT() {
        return tinhGiaBan() * 0.05; // Tính VAT cho hàng thực phẩm
    }

    @Override
    public String danhGiaMucDoBanBuon() {
        if (soLuongTon > 0 && ngayHetHan.isBefore(LocalDate.now())) {
            return "Khó bán";
        }
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        return String.format("%-10s|%-15s|%-10d|%-10.2f|%-20s|%-15s|%-15s|%-15s",
                maHang, tenHang, soLuongTon, donGia, nhaCungCap, ngaySanXuat, ngayHetHan, "Thực phẩm");
    }


}


