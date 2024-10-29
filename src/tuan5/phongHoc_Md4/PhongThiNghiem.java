package tuan5.phongHoc_Md4;



public class PhongThiNghiem extends PhongHoc {
	private boolean bonRua;

	public boolean isBonRua() {
		return bonRua;
	}

	public void setBonRua(boolean bonRua) {
		this.bonRua = bonRua;
	}

	public PhongThiNghiem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongThiNghiem(String maPhong, String dayNha, int soBongDen, double dienTich) {
		super(maPhong, dayNha, soBongDen, dienTich);
		// TODO Auto-generated constructor stub
	}

	public PhongThiNghiem(String maPhong, String dayNha, int soBongDen, double dienTich, boolean bonRua) {
		super(maPhong, dayNha, soBongDen, dienTich);
		this.bonRua = bonRua;
	}

	@Override
	boolean datChuan() {
		// TODO Auto-generated method stub
		return isBonRua() && duSang() ? true : false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String brt = bonRua ? "có" : "không";
		return super.toString() + String.format("%20s", brt);
	}
}