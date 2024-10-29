package tuan3.bai7_SinhVien_Module_2;

import java.util.Arrays;
import java.util.Scanner;

class SinhVien {
    
	public String mssv, hoTen;
	public String gioiTinh;
	public int khoa;
	public double diem;
	
	public SinhVien(String mssv, String hoTen, String gioiTinh, int khoa, double diem) {
		super();
		if(mssv == null || mssv.isEmpty()) throw new IllegalArgumentException("Mã số sinh viên không được để trống!!");
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.khoa = khoa;
		this.diem = diem;
	}

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		if(!(mssv == null || mssv.isEmpty()))
		this.mssv = mssv;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public int getKhoa() {
		return khoa;
	}

	public void setKhoa(int khoa) {
		this.khoa = khoa;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	@Override
	public String toString() {
		return String.format("|%-10s|%-10s|%-10s|%-10d|%-10.1f", 
				mssv, hoTen, gioiTinh, khoa, diem);
	}
	
 // Hàm tách tên (phần cuối cùng trong fullName)
    public String getFirstName() {
        String[] parts = hoTen.split(" ");
        return parts[parts.length - 1]; // Tên là phần cuối cùng
    }
  
   
}
