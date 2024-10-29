package tuan1.bai2_QuanLySinhVien_Module_2;

import java.util.Scanner;

public class TestQuanLySinhVien {
	
	public static QuanLySinhVien nhapMen() {
	     
		   // Create instance using default constructor and input data
		        Scanner sc = new Scanner(System.in);
		        
		        QuanLySinhVien sv3 = new QuanLySinhVien();
		        
		        System.out.println("Nhập thông tin cho sinh viên thứ ba:");
		        
		        System.out.print("Nhập MSSV: ");
		        int mssv = sc.nextInt();
		        sv3.setMssv(mssv);
		        
		        System.out.print("Nhập Họ Tên: ");
		        sc.nextLine(); // Consume newline left-over
		        String hoTen = sc.nextLine();
		        sv3.setHoTen(hoTen);
		        
		        System.out.print("Nhập Diem LT: ");
		        float diemLT = sc.nextFloat();
		        sv3.setDiemLT(diemLT);
		        
		        System.out.print("Nhập Diem TH: ");
		        float diemTH = sc.nextFloat();
		        sv3.setDiemTH(diemTH);
		        return sv3;
		        
	}
	
	public static void  nhapCung() {
		 QuanLySinhVien sv1 = new QuanLySinhVien(1001, "Nguyen Van A", 0, 9);
	     QuanLySinhVien sv2 = new QuanLySinhVien(1002, "Dang Hoang Long", 0.5f, 8.5f);
		System.out.println(sv1);
		System.out.println(sv2);
	}
	
	 public static void main(String[] args) {
		
	      
	      
		 System.out.println("\nDanh Sách Sinh Viên:");
		  System.out.println(nhapMen());
		 
	     nhapCung();
	        // Output the formatted table
	        
	      

	        
	    
	        
	}
}
