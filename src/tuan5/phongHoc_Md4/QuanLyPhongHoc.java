package tuan5.phongHoc_Md4;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class QuanLyPhongHoc implements IQuanLyPhongHoc {
	private ArrayList<PhongHoc> dsPhong;

	public QuanLyPhongHoc() {
		dsPhong = new ArrayList<PhongHoc>();
	}

	@Override
	public void them(PhongHoc phong) throws Exception {
		if (dsPhong.contains(phong) == false)
			dsPhong.add(phong);
		else
			throw new Exception("Phòng đã tồn tại");

	}

	@Override
	public PhongHoc timKiemPhongHoc(String maPhong) {
		for (PhongHoc phong : dsPhong) {
			if (phong.getMaPhong().equalsIgnoreCase(maPhong))
				return phong;
		}
		return null;
	}

	@Override
	public int timKiemViTri(String maPhong) {
		PhongHoc find = timKiemPhongHoc(maPhong);
		if (find != null)
			return dsPhong.indexOf(find);
		return -1;
	}

	@Override
	public void xoa(String Phong) {
		dsPhong.remove(Phong);
	}

	@Override
	public void sua(PhongHoc phong) {
		int vt = dsPhong.indexOf(phong);
		if (vt > -1)
			dsPhong.set(vt, phong);
	}

	@Override
	public ArrayList<PhongHoc> getDSPhongDatChuan() {
		ArrayList<PhongHoc> temp = new ArrayList<PhongHoc>();
		for (PhongHoc phong : dsPhong) {
			if (phong.datChuan())
				temp.add(phong);
		}
		return temp;
	}

	@Override
	public void sortTheoDayNha() {
		dsPhong.sort((o1, o2) -> o1.getDayNha().compareTo(o2.getDayNha()));
	}

	@Override
	public void sortTheoDienTich() {

		dsPhong.sort((o1, o2) -> Double.compare(o1.getDienTich(), o2.getDienTich()));
	}

	@Override
	public void sortTheoBongDen() {
		dsPhong.sort((o1, o2) -> Integer.compare(o1.getSoBongDen(), o2.getSoBongDen()));
	}

	@Override
	public ArrayList<PhongHoc> DSPhongCoSoMayCo60() {
		ArrayList<PhongHoc> temp = new ArrayList<PhongHoc>();
		for (PhongHoc phong : dsPhong) {
			if (phong instanceof PhongMayTinh && ((PhongMayTinh) phong).getSoMay() == 60)
				temp.add(phong);
		}
		return temp;
	}
	

	@Override
	public void setDSPhong(ArrayList<PhongHoc> dsPhong) {
		dsPhong = dsPhong;

	}

	@Override
	public int getSoLuongPhong() {
		
		return dsPhong.size();
	}

	@Override
	public void sortTheo3ThuocTinh() {
		dsPhong.sort((o1, o2) -> {
			if (o1.getDayNha().compareTo(o2.getDayNha()) == 0) {
				if (Double.compare(o1.getDienTich(), o2.getDienTich()) == 0) {
					return Integer.compare(o1.getSoBongDen(), o2.getSoBongDen());
				}
				return Double.compare(o1.getDienTich(), o2.getDienTich());
			}
			return o1.getDayNha().compareTo(o2.getDayNha());
		});

	}

	@Override
	public int demSoDayNha() {
		HashMap<String, PhongHoc> temp = new HashMap<String, PhongHoc>();
		for (PhongHoc phong : dsPhong) {
			temp.put(phong.getDayNha(), phong);
		}
		return temp.size();
	}

	@Override
	public ArrayList<PhongHoc> getDSPhong() {
		return dsPhong;
	}

}