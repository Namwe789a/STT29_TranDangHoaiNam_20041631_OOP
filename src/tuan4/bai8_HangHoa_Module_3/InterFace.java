package tuan4.bai8_HangHoa_Module_3;

import java.util.ArrayList;

public interface InterFace {
	 void addHang(HangHoa hang) throws Exception;
	    HangHoa timKiem(String maHang);
	    void xoaHang(String maHang);
	    ArrayList<HangHoa> getListHangThucPham();
	    ArrayList<HangHoa> getListHangDienMay();
	    ArrayList<HangHoa> getListHangSanhSu();
	    ArrayList<HangHoa> getListHang();
	    void sortTheoSoLuong();
	    void sortDonGia();
	
}
