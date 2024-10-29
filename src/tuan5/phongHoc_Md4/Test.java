package tuan5.phongHoc_Md4;


import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	static QuanLyPhongHoc ds = new QuanLyPhongHoc();
	static PhongHoc phongHoc;
	static Scanner sc = new Scanner(System.in);

	static String tieuDe() {
		return String.format("%-10s %-10s %-10s %-10s %-10s", "Ma Phong", "Day Nha", "So Bong Den", "Dien Tich",
				"So May");

	}

	static void Menu() {
		System.out.println("\t************************************");
		System.out.println("\t1. Nhập dữ liệu mẫu");
		System.out.println("\t2. Thêm phòng học");
		System.out.println("\t3. Xóa phòng học");
		System.out.println("\t4. Sửa phòng học");
		System.out.println("\t5. Xuất danh sách phòng học");
		System.out.println("\t6. Xuất danh sách phòng học đạt chuẩn");
		System.out.println("\t7. Sắp xếp theo diện tích");
		System.out.println("\t8. Sắp xếp theo số bóng đèn");
		System.out.println("\t9. Sắp xếp theo tên dãy nhà");
		System.out.println("\t10. Xuất phòng máy tính có số máy > 60");
		System.out.println("\t11. Sắp xếp theo 3 tiêu chí");
		System.out.println("\t12. Đếm số dãy nhà");
		System.out.println("\t13. Xuất tổng số phòng học");
		System.out.println("\t14. Thoát");
		System.out.println("\t************************************");
		System.out.print("\tChọn: ");
	}

	static void menuChung() {
		System.out.println("\t************************************");
		System.out.println("\t Mời nhập thông tin cần sửa");
		System.out.println("\t1. Dãy nhà");
		System.out.println("\t2. Số bóng đèn");
		System.out.println("\t3. Diện tích");
	}

	static void menuSuaPLT() {
		menuChung();
		System.out.println("\t4. Máy chiếu");
		System.out.println("\t5. Thoát");
		System.out.println("\t************************************");
		System.out.print("\tChọn: ");
	}

	static void menuSuaPMT() {
		menuChung();
		System.out.println("\t4. Số máy");
		System.out.println("\t************************************");
		System.out.print("\tChọn: ");
	}

	static void menuSuaPTN() {
		menuChung();
		System.out.println("\t4. Bồn rửa tay");
		System.out.println("\t************************************");
		System.out.print("\tChọn: ");
	}

	static void nhapCung() throws Exception {
		PhongHoc p1 = new PhongMayTinh("A1", "A", 10, 100, 50);
		PhongHoc p2 = new PhongMayTinh("A2", "A", 10, 100, 50);
		PhongHoc p3 = new PhongLyThuyet("B1", "B", 10, 100, false);
		PhongHoc p4 = new PhongLyThuyet("B2", "B", 10, 100, true);
		PhongHoc p5 = new PhongThiNghiem("C1", "C", 10, 100, true);
		PhongHoc p6 = new PhongThiNghiem("C2", "C", 10, 100, false);
		ds.them(p1);
		ds.them(p2);
		ds.them(p3);
		ds.them(p4);
		ds.them(p5);
		ds.them(p6);
		System.out.println("Nhập thành công");
	}

	static PhongHoc themPhongHoc() {
		String dayNha;
		int soBongDen;
		double dienTich;
		String maPhong;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã phòng: ");
		maPhong = sc.nextLine();
		if (ds.timKiemPhongHoc(maPhong) != null) {
			System.out.println("Phòng đã tồn tại");
			return null;
		} else {
			System.out.println("Nhập dãy nhà: ");
			dayNha = sc.nextLine();
			System.out.println("Nhập số bóng đèn: ");
			soBongDen = sc.nextInt();
			System.out.println("Nhập diện tích: ");
			dienTich = sc.nextDouble();
			System.out.println("Nhap 1 neuy la phong ly thuyet " + "Nhap 2 neu la phong may tinh "
					+ "Nhap 3 neu la phong thi nghiem");
			int luaChon = sc.nextInt();
			if (luaChon == 1) {
				boolean mayChieu;
				System.out.println("Phong co may chiue hay k (y/n): ");
				String coMC = sc.next();
				while (!coMC.equalsIgnoreCase("y") && !coMC.equalsIgnoreCase("n")) {
					System.out.println("Nhap lai: ");
					coMC = sc.next();
				}
				mayChieu = coMC.equalsIgnoreCase("y") ? true : false;
				phongHoc = new PhongLyThuyet(maPhong, dayNha, soBongDen, dienTich, mayChieu);

			} else if (luaChon == 2) {
				int soMay;
				System.out.println("Nhap so may: ");
				soMay = sc.nextInt();
				phongHoc = new PhongMayTinh(maPhong, dayNha, soBongDen, dienTich, soMay);
			} else if (luaChon == 3) {
				boolean bonRuaTay;
				System.out.println("Phong co bon rua tay hay k (y/n): ");
				String coBRT = sc.next();
				while (!coBRT.equalsIgnoreCase("y") && !coBRT.equalsIgnoreCase("n")) {
					System.out.println("vui long nhap dung yeu cau: ");
					coBRT = sc.next();
				}
				bonRuaTay = coBRT.equalsIgnoreCase("y") ? true : false;
				phongHoc = new PhongThiNghiem(maPhong, dayNha, soBongDen, dienTich, bonRuaTay);
			}
		}
		return phongHoc;
	}

	static void xuat() {
		System.out.println(tieuDe());
		for (PhongHoc phong : ds.getDSPhong()) {
			System.out.println(phong);
		}

	}

	static void xoaPhong() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma phong can xoa: ");
		String maPhong = sc.nextLine();
		if (ds.timKiemPhongHoc(maPhong) != null) {
			ds.xoa(maPhong);
			System.out.println("Xoa thanh cong");
		} else {
			System.out.println("Khong tim thay phong");
		}
	}

	static void suaChung(int chon, PhongHoc phs) {
		switch (chon) {
		case 1:
			System.out.println("Nhap day nha moi: ");
			String dayNha = new Scanner(System.in).nextLine();
			phs.setDayNha(dayNha);
			break;
		case 2:
			System.out.println("Nhap so bong den moi: ");
			int soBongDen = new Scanner(System.in).nextInt();
			phs.setSoBongDen(soBongDen);
			break;
		case 3:
			System.out.println("Nhap dien tich moi: ");
			double dienTich = new Scanner(System.in).nextDouble();
			phs.setDienTich(dienTich);
			break;
		}

	}

	static void suaPhong() {
		int chon = -1, cnt = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma phong can sua: ");
		String maPhong = sc.nextLine();
		PhongHoc phs = ds.timKiemPhongHoc(maPhong);
		if (phs == null) {
			System.out.println("Khong tim thay phong");
		} else {
			if (phs instanceof PhongLyThuyet) {
				do {
					menuSuaPTN();
					chon = sc.nextInt();
					if (chon != 5) {
						suaChung(chon, phs);
						if (chon == 4) {
							System.out.println("Nhap bon rua tay moi: ");
							boolean bonRuaTay = sc.nextBoolean();
							((PhongThiNghiem) phs).setBonRua(bonRuaTay);
						}
					}
				} while (chon != 5);
			} else if (phs instanceof PhongMayTinh) {
				do {
					menuSuaPMT();
					chon = sc.nextInt();
					if (chon != 5) {
						suaChung(chon, phs);
						if (chon == 4) {
							System.out.println("Nhap so may moi: ");
							int soMay = sc.nextInt();
							((PhongMayTinh) phs).setSoMay(soMay);
						}
					}
				} while (chon != 5);
			} else {
				do {
					menuSuaPLT();
					chon = sc.nextInt();
					if (chon != 5) {
						suaChung(chon, phs);
						if (chon == 4) {
							System.out.println("Nhap may chieu moi: ");
							boolean mayChieu = sc.nextBoolean();
							((PhongLyThuyet) phs).setMayChieu(mayChieu);
						}
					}
				} while (chon != 5);
			}

		}
	}

	static void themMem() throws Exception {
		PhongHoc ph = themPhongHoc();
		if (ph != null) {
			ds.them(ph);
			System.out.println("Them thanh cong");
		}
	}

	static void xuatPhongDatChuan() {
		System.out.println(tieuDe());
		for (PhongHoc phong : ds.getDSPhongDatChuan()) {
			System.out.println(phong);
		}
	}

	static void sortTheoTenDayNha() {
		ds.sortTheoDayNha();
		System.out.println("Sap xep thanh cong");
	}

	static void sortTheoDienTich() {
		ds.sortTheoDienTich();
		System.out.println("Sap xep thanh cong");
	}

	static void sortTheoSoBongDen() {
		ds.sortTheoBongDen();
		System.out.println("Sap xep thanh cong");
	}

	static void xuatPhongMayTinh60() {
		if (ds.DSPhongCoSoMayCo60().size() == 0) {
			System.out.println("Khong co phong nao co so may > 60");
		} else {
			System.out.println(tieuDe());
			for (PhongHoc phong : ds.DSPhongCoSoMayCo60()) {
				System.out.println(phong);
			}
		}
	}

	static void xuatTongSoPhongHoc() {
		System.out.println("Tong so phong hoc la: " + ds.getSoLuongPhong());
	}

	static void demSoDayNha() {
		System.out.println("So day nha la: " + ds.demSoDayNha());
	}

	static void sortTheo3ThuocTinh() {
		ds.sortTheo3ThuocTinh();
		System.out.println("Sap xep thanh cong");
	}

	public static void main(String[] args) {
        try {
            int chon;
            do {
                Menu();
                chon = sc.nextInt();
                sc.nextLine();  // Clear newline character after int input
                switch (chon) {
                    case 1:
                        nhapCung();
                        break;
                    case 2:
                        themMem();
                        break;
                    case 3:
                        xoaPhong();
                        break;
                    case 4:
                        suaPhong();
                        break;
                    case 5:
                        xuat();
                        break;
                    case 6:
                        xuatPhongDatChuan();
                        break;
                    case 7:
                        sortTheoDienTich();
                        break;
                    case 8:
                        sortTheoSoBongDen();
                        break;
                    case 9:
                        sortTheoTenDayNha();
                        break;
                    case 10:
                        xuatPhongMayTinh60();
                        break;
                    case 11:
                        sortTheo3ThuocTinh();
                        break;
                    case 12:
                        demSoDayNha();
                        break;
                    case 13:
                        xuatTongSoPhongHoc();
                        break;
                    case 14:
                        System.out.println("Thoát chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                        break;
                }
            } while (chon != 14);
        } catch (ArithmeticException e) {
            System.out.println("Lỗi toán học: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("Lỗi chỉ số mảng: " + e1.getMessage());
        } catch (Exception e2) {
            System.out.println("Lỗi không xác định: " + e2.getMessage());
        } finally {
            sc.close();  // Ensure the scanner is closed when the program exits
        }
    }
}