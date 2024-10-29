package tuan1.bai2_QuanLySinhVien_Module_2;

public class QuanLySinhVien {
	private int mssv;
	private String hoTen;
	private float diemLT;
	private float diemTH;
	
	
	public int getMssv() {
		return mssv;
	}
	public void setMssv(int mssv) {
		this.mssv = mssv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		if(hoTen.equals("")) {
			System.out.println("Loi");
		}
		else {
			this.hoTen = hoTen;
		}
		
	}
	public float getDiemLT() {
		return diemLT;
	}
	public void setDiemLT(float diemLT) {
		if(diemLT< 0 || diemLT >10 ) {
			System.out.println("Loi");
		}
		else {
			this.diemLT = diemLT;
		}
	}
	public float getDiemTH() {
		return diemTH;
	}
	public void setDiemTH(float diemTH) {
		if(diemTH< 0 || diemTH >10 ) {
			System.out.println("Loi");
		}
		else {
			this.diemTH = diemTH;
		}
	}
	public QuanLySinhVien(int mssv, String hoTen, float diemLT, float diemTH) {
		super();
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}
	public QuanLySinhVien() {
		this.hoTen = "";  // Initialize string field to empty string
        this.mssv = 0;  // Initialize numeric field to 0
        this.diemLT = 0.0f;  // Initialize float fields to 0.0
        if(diemTH< 0 || diemTH >10 ) {
			System.out.println("Loi");
		}
		else {
			this.diemTH = diemTH;
		}
	}
	
	public float getDiemTB() {
		return (getDiemLT()+getDiemTH())/2;
		
	}
	@Override
	public String toString() {
		 return String.format("MSSV: %-10d | Họ Tên: %-20s | Diem LT: %-5.2f | Diem TH: %-5.2f | Diem TB: %-5.2f",
                 mssv, hoTen, diemLT, diemTH, getDiemTB());
	}
	
	
	
	
	
}
