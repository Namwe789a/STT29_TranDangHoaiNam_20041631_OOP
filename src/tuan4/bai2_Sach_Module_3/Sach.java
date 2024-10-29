package tuan4.bai2_Sach_Module_3;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public abstract class Sach {
	protected String maSach;
	protected LocalDate ngaNhap;
	protected double donGia;
	protected int soLuong;
	protected String nhaXuatBan;
	protected String loaiSach; // Thêm thuộc tính phân loại
	abstract double thanhTien();
	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	  NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public LocalDate getNgaNhap() {
		return ngaNhap;
	}
	public void setNgaNhap(LocalDate ngaNhap) {
		this.ngaNhap = ngaNhap;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getNhaXuatBan() {
		return nhaXuatBan;
	}
	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	

	
	
	
	public String getLoaiSach() {
		return loaiSach;
	}
	public void setLoaiSach(String loaiSach) {
		this.loaiSach = loaiSach;
	}
	
	
	public Sach(String maSach, LocalDate ngaNhap, double donGia, int soLuong, String nhaXuatBan, String loaiSach) {
		super();
		this.maSach = maSach;
		this.ngaNhap = ngaNhap;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.nhaXuatBan = nhaXuatBan;
		this.loaiSach = loaiSach;
	}
	public Sach() {
		super();
	}
	 
	  

	  @Override
	public int hashCode() {
		return Objects.hash(maSach);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}
	@Override
	  public String toString() {
	      return String.format(
	          "%-10s|%-15s|%-10.2f|%-10d|%-20s|%-15s", // Kích thước cột cho các trường
	          maSach,                          // Mã sách
	          ngaNhap.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), // Ngày nhập
	          donGia,                          // Đơn giá
	          soLuong,                         // Số lượng
	          nhaXuatBan,                      // Nhà xuất bản
	          getLoaiSach()                    // Loại sách
	      );
	  }

	
	
	


	
	
	
}
