package tuan5.phongHoc_Md4;
import java.util.ArrayList;

public interface IQuanLyPhongHoc {
	abstract void them(PhongHoc phong) throws Exception;
	PhongHoc timKiemPhongHoc(String maPhong);
	int timKiemViTri(String maPhong);
	void xoa(String Phong);
    void sua(PhongHoc phong);
    ArrayList<PhongHoc> getDSPhongDatChuan();
    void sortTheoDayNha();
    void sortTheoDienTich();
    void sortTheoBongDen();
    ArrayList<PhongHoc> DSPhongCoSoMayCo60();
    void setDSPhong(ArrayList<PhongHoc> dsPhong);
    int getSoLuongPhong();
    void sortTheo3ThuocTinh();
    int demSoDayNha();
    ArrayList<PhongHoc> getDSPhong();
	
}	