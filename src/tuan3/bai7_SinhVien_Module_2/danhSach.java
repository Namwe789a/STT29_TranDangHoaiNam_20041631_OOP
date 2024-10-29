	package tuan3.bai7_SinhVien_Module_2;




import java.util.Arrays;
import java.util.Comparator;

public class danhSach {
	public SinhVien[] danhSach;
	public int soLuong;
	
	public danhSach(int kichThuoc) {
		danhSach = new SinhVien[kichThuoc];
		soLuong = 0;
	}
	
	// thêm sinh viên vào danh sách
	public boolean themSV(SinhVien sv) {
		if(soLuong < danhSach.length) {
			for(int i=0; i<soLuong; i++) {
				if(danhSach[i].getMssv() == sv.getMssv()) {
					return false;
			}
			}
			danhSach[soLuong] = sv;
			soLuong++;
			return true;
		} else 
			moRong(); 
        	danhSach[soLuong] = sv;
        	soLuong++;
        	return true;
	}
	public void moRong() {
		SinhVien[] temp = new SinhVien[danhSach.length *2];
		for(int i=0; i<soLuong; i++) {
			temp[i]=danhSach[i];
		}
		danhSach = temp;
	}
	// xóa sinh viên ra khỏi danh sách
	public boolean xoaSV(String mssv) {
		for(int i=0; i<soLuong; i++) {
			if(danhSach[i].getMssv().equals(mssv)) {
				danhSach[i]=danhSach[soLuong-1];
				danhSach[soLuong-1]=null;
				soLuong--;
				return true;
		}
	}
		return false;
	}
	// sửa thông tin của sinh viên theo mã số sv
		public boolean suaSV(String mssv ,SinhVien mssvnew) {
			for(int i=0; i<soLuong; i++) {
				if(danhSach[i].getMssv().equals(mssv)) {
					danhSach[i] = mssvnew;
					return true;
				}
			} return false;
		}
		
		
		
	// tính tổng điểm
		public double tinhTongDiem() {
			double tong=0.0;
			for(int i=0; i<soLuong; i++) {
				tong+=danhSach[i].getDiem();
				}
			return tong;
		}
		// in danh sách sinh viên
		public String inDanhSach() {
			StringBuilder str = new StringBuilder();
			for(int i=0; i<soLuong; i++) {
				str.append(danhSach[i].toString()).append("\n");
			}
			return str.toString();
		}
//		public String inDanhSach() {
//			String str = " ";
//			for(int i=0; i<soLuong; i++) {
//				str += danhSach.toString();
//			}
//			return str;
//		}
		// tìm kiếm sinh viên theo mã số sinh viên
		public SinhVien timKiemSV(String mssv) {
		    for (int i = 0; i < soLuong; i++) {
		        if (danhSach[i].getMssv().equals(mssv)) {
		            return danhSach[i]; // trả về sinh viên nếu tìm thấy
		        }
		    }
		    return null; // trả về null nếu không tìm thấy sinh viên
		}
		
		// sắp xếp tăng dần theo họ tên sinh viên
		public void sapXepTangTheoHoTen() {
			Arrays.sort(danhSach, 0, soLuong, new Comparator<SinhVien>() {
				public int compare(SinhVien sv1, SinhVien sv2) {
					return sv1.getHoTen().compareTo(sv2.getHoTen());
				}
			});
		}
		// sắp xếp tăng dần theo mã số sinh viên
		public void sapXepTangTheoMa() {
			Arrays.sort(danhSach, 0, soLuong, new Comparator<SinhVien>() {
				public int compare(SinhVien sv1, SinhVien sv2) {
					return sv1.getMssv().compareTo(sv2.getMssv());
				}
			});
		}
		// sắp xếp giảm dần theo mã số sinh viên
				public void sapXepGiamTheoMa() {
					Arrays.sort(danhSach, 0, soLuong, new Comparator<SinhVien>() {
						public int compare(SinhVien sv1, SinhVien sv2) {
							return sv2.getMssv().compareTo(sv1.getMssv());						}
					});
				}
				
				
				
				abstract class SortByFirstName implements Comparator<SinhVien> {
				    public int compare(SinhVien a, SinhVien b) {
				        return a.getFirstName().compareTo(b.getFirstName());
				    }
				}
		
}
