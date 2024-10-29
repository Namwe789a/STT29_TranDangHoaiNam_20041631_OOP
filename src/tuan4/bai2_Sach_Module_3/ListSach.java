package tuan4.bai2_Sach_Module_3;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import tuan4.bai1_ChuyenXe_Module3.ChuyenXe;
import tuan4.bai1_ChuyenXe_Module3.NgoaiThanh;
import tuan4.bai1_ChuyenXe_Module3.NoiThanh;

public class ListSach {
	ArrayList<Sach> sach;
	
	public ListSach() {
		sach = new ArrayList<Sach>();
	}
	
	//-------------------------------begin method ----------------------------------
		public void add(Sach sach1) throws Exception {
			if (!sach.contains(sach1))// hiểu dc nhờ hascode equa của lớp sach
				sach.add(sach1);
			else {
				throw new Exception("Mã Sách đã trùng");
			}
		}
		public int timKiemViTri(String maSach) {
			Sach findsach = timKiem(maSach);
			if (findsach != null)
				return sach.indexOf(timKiem(maSach));
			return -1;
		}
		public Sach timKiem(String maSach) {
			for (Sach s : sach) {
				if (s.getMaSach().equalsIgnoreCase(maSach))
					return s;
			}
			return null;
		}
		
		public void xoa(Sach s) {
			sach.remove(s);
		}
		
		//-----------------------------trả về sách Giáo Khoa -----------------
		public ArrayList<Sach> getListSachGiaoKhoa() {
			ArrayList<Sach> DSSachGiaoKhao = new ArrayList<Sach>();
			for (Sach s : sach)
				if (s instanceof Sach_Giao_Khoa)
					DSSachGiaoKhao.add((Sach_Giao_Khoa) s);

			return DSSachGiaoKhao;
		}
		//-----------------------------trả về sách kham khảo -----------------
		 public ArrayList<Sach> getListThamKhao() {
		        ArrayList<Sach> DSSachKhamKhao = new ArrayList<Sach>();
		        for (Sach s : sach) {
		            if (s instanceof Sach_Kham_Khao) {
		            	DSSachKhamKhao.add(s);
		            }
		        }
		        return DSSachKhamKhao;
		    }

	//-------------------------------trả về danh sách sach--------------------
		public ArrayList<Sach> getDS() {
			return sach;
		}
		

	
	// sắp xếp theo số lượng
		   public void sortTheoSoLuong() {
		        Collections.sort(sach, new Comparator<Sach>() {
					@Override
					public int compare(Sach o1, Sach o2) {
						int comp1 = Integer.compare(o1.getSoLuong(), o2.getSoLuong());
						return comp1;
					}  
		        });
		    }
		   
		   
// sắp xép theo đơn giá và ngày nhâp
		   public void sortDonGia() {
		        Collections.sort(sach, new Comparator<Sach>() {

		            @Override
		            public int compare(Sach o1, Sach o2) {
		                // So sánh số lượng
		                int comp1 = Double.compare(o1.getDonGia(), o2.getDonGia());

		                if (comp1 == 0) { // Nếu đơn giá bằng nhau, so sánh tiếp ngày nhập
		                	 return o2.getNgaNhap().compareTo(o1.getNgaNhap()); // So sánh đơn giá ngược (giảm dần)

		                } else {
		                    return comp1;
		                }
		            }
		        });
		    }
}
