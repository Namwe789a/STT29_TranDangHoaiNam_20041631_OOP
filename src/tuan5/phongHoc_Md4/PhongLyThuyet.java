package tuan5.phongHoc_Md4;

public class PhongLyThuyet extends PhongHoc {
	private boolean mayChieu;

	public PhongLyThuyet(String maPhong, String dayNha, int soBongDen, double dienTich, boolean mayChieu) {
		super(maPhong, dayNha, soBongDen, dienTich);
		this.mayChieu = mayChieu;
	}

	public PhongLyThuyet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isMayChieu() {
		return mayChieu;
	}

	public void setMayChieu(boolean mayChieu) {
		this.mayChieu = mayChieu;
	}

	public PhongLyThuyet(String maPhong, String dayNha, int soBongDen, double dienTich) {
		super(maPhong, dayNha, soBongDen, dienTich);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean datChuan() {
		// TODO Auto-generated method stub
		return isMayChieu() && duSang() ? true : false;
	}
	
	@Override
	public String toString() {
		String mc = mayChieu ? "có" : "không";
		return super.toString() + String.format("%20s", mc);
	}

}