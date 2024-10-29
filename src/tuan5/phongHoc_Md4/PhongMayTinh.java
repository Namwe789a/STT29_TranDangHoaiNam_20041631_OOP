package tuan5.phongHoc_Md4;


public class PhongMayTinh extends PhongHoc {
	private int soMay;
	private final double CHUANPM = 1.5;

	@Override
	boolean datChuan() {
		// TODO Auto-generated method stub
		return (getDienTich() / getSoMay()) <= CHUANPM ? true : false;
	}

	public PhongMayTinh(String maPhong, String dayNha, int soBongDen, double dienTich, int soMay) {
		super(maPhong, dayNha, soBongDen, dienTich);
		this.soMay = soMay;
	}

	public PhongMayTinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongMayTinh(String maPhong, String dayNha, int soBongDen, double dienTich) {
		super(maPhong, dayNha, soBongDen, dienTich);
		// TODO Auto-generated constructor stub
	}

	public int getSoMay() {
		return soMay;
	}

	public void setSoMay(int soMay) {
		this.soMay = soMay;
	}

	public double getCHUANPM() {
		return CHUANPM;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + String.format("%-2d", getSoMay()) + " May";
	}

}