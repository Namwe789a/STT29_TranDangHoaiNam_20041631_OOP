package tuan5.phongHoc_Md4;

import java.util.Objects;

public abstract class PhongHoc {
	protected String maPhong;
	protected String dayNha;
	protected int soBongDen;
	protected double dienTich;
	abstract boolean datChuan();
	public PhongHoc(String maPhong, String dayNha, int soBongDen, double dienTich) {
		super();
		this.maPhong = maPhong;
		this.dayNha = dayNha;
		this.soBongDen = soBongDen;
		this.dienTich = dienTich;
	}
	public PhongHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getDayNha() {
		return dayNha;
	}
	public void setDayNha(String dayNha) {
		this.dayNha = dayNha;
	}
	public int getSoBongDen() {
		return soBongDen;
	}
	public void setSoBongDen(int soBongDen) {
		this.soBongDen = soBongDen;
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongHoc other = (PhongHoc) obj;
		return Objects.equals(maPhong, other.maPhong);
	}
	
	protected boolean  duSang() {
		return (getDienTich()/getSoBongDen() <= 10) ? true : false;
	}
	
	@Override
	public String toString() {
		return String.format("|%-10s|%-10s|%-10d|%-10.1f", maPhong, dayNha, soBongDen, dienTich);
	}
}