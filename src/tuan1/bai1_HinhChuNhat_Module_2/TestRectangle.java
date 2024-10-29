package tuan1.bai1_HinhChuNhat_Module_2;

import java.util.Scanner;

public class TestRectangle {
	
	
	static String tieuDe() {
		return String.format("%-10s %-10s %-12s %-12s", "chieu Dai", "chieu Rong", "Chu Vi", "Dien Tich");
	}
	public static void main(String[] args) {
		Rectangle h1 = new Rectangle();
//		h1.setChieuDai(3);
//		h1.setChieuRong(5);
//		System.out.println("Chu Vi La:" + h1.getChuVi());
//		System.out.println("Chu Vi La:" + h1.getDienTich());
//		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("nhap tu ban phim");
		System.out.println("nhap Dai");
		double d = sc.nextDouble();
		h1.setChieuDai(d);
		System.out.println("nhap rong");
		double r = sc.nextDouble();
		h1.setChieuRong(r);
		System.out.println(tieuDe());
		System.out.println( h1);
		
	}
}
