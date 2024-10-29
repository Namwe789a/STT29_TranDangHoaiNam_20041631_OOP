package tuan4.bai2_Sach_Module_3;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Sach_Kham_Khao extends Sach {
    private double thue;

    public Sach_Kham_Khao() {
        super();
        this.loaiSach = "Sách Khám Khảo";
    }



    public Sach_Kham_Khao(String maSach, LocalDate ngaNhap, double donGia, int soLuong, String nhaXuatBan,
			double thue) {
		super(maSach, ngaNhap, donGia, soLuong, nhaXuatBan, "Sách Kham Khảo");
		this.thue = thue;
	}



	public double getThue() {
		return thue;
	}



	public void setThue(double thue) {
		this.thue = thue;
	}




	@Override
	public String toString() {
	    return String.format(
	        "%s|%-15.2f|%-30.2f", // Điều chỉnh kích thước cột cho phần thêm của sách Khám Khảo
	        super.toString(),     // Gọi `toString()` từ lớp cha (`Sach`)
	        getThue(),            // Thuế
	        thanhTien()           // Thành tiền
	    );
	}



	@Override
	double thanhTien() {
		 try {
	            return soLuong * donGia + thue;
	        } catch (Exception e) {
	            System.out.println("Lỗi khi tính thành tiền sách tham khảo: " + e.getMessage());
	            return 0;
	        }
	}


    
}