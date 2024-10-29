package tuan1.bai1_HinhChuNhat_Module_2;

public class Rectangle {
	private double chieuRong;
	private double chieuDai;
	private double dienTich;
	public double getChieuRong() {
		return chieuRong;
	}	
	public void setChieuRong(double r) {
		if (r <=0) {
			System.out.print("Loi rong");
		}else {
		 this.chieuRong = r;	
		}
	}
	public double getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(double d) {
		if (d>0) {
			this.chieuDai = d;
		}else {
			System.out.print("Loi dai");
		}
		
	}
	
	
	public Rectangle() {
		super();
	}
	public Rectangle(double r, double d) {
		if (r <=0) {
			System.out.print("Loi rong");
		}else {
		 this.chieuRong = r;	
		}
		if (d>0) {
			this.chieuDai = d;
		}else {
			System.out.print("Loi dai");
		}
	}
	
	public double getChuVi() {
		return (getChieuDai()+getChieuRong())*2;
		
	}
	public double getDienTich() {
		return getChieuDai()*getChieuRong();
		
		
	}

	
	@Override
	public String toString() {
		return String.format("%-10.2f %-10.2f %-12.2f %-12.2f%n", getChieuDai(), getChieuRong(), getChuVi(), getDienTich());
	}
	
	
	
	
	
	
	
}
