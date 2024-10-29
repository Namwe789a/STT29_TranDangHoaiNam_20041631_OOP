package tuan4.bai2_Sach_Module_3;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Sach_Giao_Khoa extends Sach {
	
	private boolean tinhTrang;

	
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public Sach_Giao_Khoa() {
		super();
		this.loaiSach = "Sách Giáo Khoa";
	}

 
	public Sach_Giao_Khoa(String maSach, LocalDate ngaNhap, double donGia, int soLuong, String nhaXuatBan,
			 boolean tinhTrang) {
		super(maSach, ngaNhap, donGia, soLuong, nhaXuatBan, "Sách Giáo Khoa");
		this.tinhTrang = tinhTrang;
	}


	@Override
	public double thanhTien() {
	    try {
	        if (tinhTrang) { // Nếu tinhTrang là true (tức là sách mới)
	            return soLuong * donGia; // Tính giá sách mới
	        } else { // Nếu tinhTrang là false (tức là sách cũ)
	            return soLuong * donGia * 0.5; // Tính giá sách cũ với 50% giá
	        }
	    } catch (Exception e) {
	        System.out.println("Lỗi khi tính thành tiền sách giáo khoa: " + e.getMessage());
	        return 0;
	    }
	}

	
	
	// Kiểm tra tình trạng sách, nếu true thì xuất "Mới", nếu false thì xuất "Cũ"
   
	@Override
	public String toString() {
		 String trangThaiSach = tinhTrang ? "Mới" : "Cũ";
		 return String.format(
		            "%s|%-15s|%-20.2f", // Điều chỉnh kích thước cột nếu cần thiết
		            super.toString(), 
		            
		           trangThaiSach,
		           thanhTien()
		        );
	}
}
