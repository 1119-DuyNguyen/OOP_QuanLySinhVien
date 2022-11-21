import java.util.Scanner;

public class SceneManager {
	private static DSMon dsMon = new DSMon();
	private static DSNganh dsNganh = new DSNganh();
	private static DSKhoa dsKhoa = new DSKhoa();
	private static DSCVHT dsCVHT = new DSCVHT();
	private static DanhSachSV dsSV = new DanhSachSV();

	private static Scanner sc = new Scanner(System.in);

	public static void showMenu() {
		System.out.println("\n-----------MENU------------");
		System.out.println("1. Thao tác với DSSV.");
		System.out.println("2. Thao tác với DS cố vấn học tập.");
		System.out.println("3. Thao tác với lớp.");
		System.out.println("4. Xem DS Khoa.");
		System.out.println("5. Xem DS Ngành.");
		System.out.println("6. Thao tác với DS Môn.");
		System.out.println("Nhấn phím 0 để thoát!!");
		System.out.println("---------------------------");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean con = true;
		while (con) {
			showMenu();
			System.out.print("Nhập lựa chọn: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				showMenuSV();
				break;
			case 2:
				showMenuCVHT();
				break;
			case 3:
				showMenuLop();
				break;
			case 4:
				showFaculty();
				break;
			case 5:
				showMajor();
				break;
			case 6:
				showSubject();
				break;
			case 0: {
				con = false;
				System.exit(0);
				break;
			}
			default: {
				System.out.println("Vui lòng nhập chính xác lựa chọn!!");
			}
			}
		}
	}

	private static void showMenuLop() {
		// TODO Auto-generated method stub
		System.out.println("\n-----------Lớp------------");
		System.out.println("1. Xem DS lớp");
		System.out.println("2. Thêm 1 lớp");
		System.out.println("3. Thêm n lớp");
		System.out.println("4. Sửa n lớp");
		System.out.println("5. Xoá n lớp");
		System.out.println("6. Quay về trang chủ");
		System.out.println("---------------------------");

		System.out.print("Nhập lựa chọn: ");
		int choiceCV = Integer.parseInt(sc.nextLine());
		switch (choiceCV) {
		case 1:
			System.out.println("Hàm xem");
			break;
		case 2:
			System.out.println("Hàm thêm 1");
			break;
		case 3:
			System.out.println("Hàm thêm n");
			break;
		case 4:
			System.out.println("Hàm sửa");
			break;
		case 5:
			System.out.println("Hàm xoá");
			break;
		case 6:
			showMenu();
			break;
		default:
			System.out.println("Vui lòng nhập chính xác lựa chọn!!");
		}

	}

	private static void showMenuCVHT() {
		// TODO Auto-generated method stub
		System.out.println("\n-----------CỐ VẤN------------");
		System.out.println("1. Xem DS cố vấn học tập");
		System.out.println("2. Thêm 1 cố vấn học tập");
		System.out.println("3. Thêm n cố vấn học tập");
		System.out.println("4. Sửa n cố vấn học tập");
		System.out.println("5. Xoá n cố vấn học tập");
		System.out.println("6. Tìm kiếm cố vấn học tập (theo họ tên)");
		System.out.println("7. Tìm kiếm cố vấn học tập (theo lớp cố vấn)");
		System.out.println("8. Xem lớp quản lý của cố vấn");
		System.out.println("9. Quay về trang chủ");
		System.out.println("---------------------------");

		System.out.print("Nhập lựa chọn: ");
		int choiceCV = Integer.parseInt(sc.nextLine());
		switch (choiceCV) {
		case 1:
			dsCVHT.xemLopQuanLy();
			break;
		case 2:
			dsCVHT.them1PhanTu();
			break;
		case 3: {
			System.out.println("Hàm thêm n");
			System.out.println("nhập số lượng cần thêm");
			int n = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n; ++i) {
				dsCVHT.them1PhanTu();
			}
			break;
		}
		case 4: {
			System.out.println("Hàm sửa");
			System.out.println("nhập số lượng cần sửa");
			int n = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n; ++i) {
				System.out.println("Nhập mã số cần sửa :");
				dsCVHT.suaPhanTu(sc.nextLine());
			}
			break;
		}
		case 5: {
			System.out.println("Hàm xoá");
			System.out.println("nhập số lượng cần sửa");
			int n = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n; ++i) {
				System.out.println("Nhập mã số cần xóa:");
				dsCVHT.xoaPhanTu(sc.nextLine());
			}
			break;
		}
		case 6:
			System.out.println("Hàm tìm theo họ tên");
			System.out.println("Nhập tên muốn tìm: ");
			String inputHoTen = sc.nextLine();
			dsCVHT.timKiemCVTheoHoTen(inputHoTen);
			break;
		case 7:
			System.out.println("Hàm tìm theo mã cố vấn");
			System.out.println("Nhập mã muốn tìm: ");
			String inputMaCV = sc.nextLine();
			dsCVHT.timKiemCVTheoHoTen(inputMaCV);
			break;
		case 8:
			System.out.println("Hàm xem lớp quản lý");
			// lấy hàm của cái case 1 tạm, đm
			dsCVHT.xemLopQuanLy();
			break;
		case 9:
			showMenu();
			break;
		default:
			System.out.println("Vui lòng nhập chính xác lựa chọn!!");
		}
	}

	public static void showMenuSV() {
		System.out.println("\n--------SINH VIÊN---------");
		System.out.println("1. Xem DS sinh viên");
		System.out.println("2. Thêm 1 sinh viên");
		System.out.println("3. Thêm n sinh viên");
		System.out.println("4. Sửa n sinh viên");
		System.out.println("5. Xoá n sinh viên");
		System.out.println("6. Thống kê sinh viên qua môn");
		System.out.println("7. Thống kê sinh viên nợ môn");
		System.out.println("8. Thống kê sinh viên theo khoa");
		System.out.println("9. Tìm kiếm sinh viên (theo họ tên)");
		System.out.println("10. Tìm kiếm sinh viên (theo MSSV)");
		System.out.println("11. Quay về trang chủ");
		System.out.println("---------------------------");

		System.out.print("Nhập lựa chọn: ");
		int choiceSV = Integer.parseInt(sc.nextLine());
		switch (choiceSV) {
		case 1:
			dsSV.xuatDanhSach();
			break;
		case 2:
			dsSV.them1PhanTu();
			break;
		case 3: {
			System.out.println("Hàm thêm n");
			System.out.println("nhập số lượng cần thêm");
			int n = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n; ++i) {
				dsSV.them1PhanTu();
			}
			break;
		}
		case 4: {
			System.out.println("Hàm sửa");
			System.out.println("nhập số lượng cần sửa");
			int n = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n; ++i) {
				System.out.println("Nhập mã số cần sửa :");
				dsSV.suaPhanTu(sc.nextLine());
			}
			break;
		}
		case 5: {
			System.out.println("Hàm xoá");
			System.out.println("nhập số lượng cần sửa");
			int n = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n; ++i) {
				System.out.println("Nhập mã số cần xóa:");
				dsSV.xoaPhanTu(sc.nextLine());
			}
			break;
		}

		case 6:
			System.out.println("Hàm thống kê qua môn");
			break;
		case 7:
			System.out.println("Hàm thống kê nợ môn");
			break;
		case 8:
			System.out.println("Hàm thống kê theo khoa");
			break;
		case 9:
			System.out.println("Hàm tìm kiếm theo tên");

			break;
		case 10:
			System.out.println("Hàm tìm kiếm theo mssv");
			break;
		case 11:
			showMenu();
			break;
		default:
			System.out.println("Vui lòng nhập chính xác lựa chọn!!");
		}

	}

	public static void showFaculty() {
		System.out.println("Hiển thị danh sách khoa");
//		//dsKhoa.xuatDanhSach();
		System.out.println("\n-----------Khoa------------");
		System.out.println("1. Xem DS Khoa");
		System.out.println("2. Them 1 Khoa");
		// System.out.println("3. Them n Khoa ");
		System.out.println("4. Xoa 1 Khoa");
		// System.out.println("5. Xoá n Khoa");
		System.out.println("6. Quay về trang chủ");
		System.out.println("---------------------------");

//		System.out.print("Nhập lựa chọn: ");
//		int choiceKhoa = sc.nextInt();
//		switch (choiceKhoa) {
//		case 1:
//			dsKhoa.xuatDanhSach();
//			break;
//		case 2:
//			dsKhoa.them1PhanTu();
//			break;
//		//case 3: {
//			//System.out.println("Hàm thêm n Khoa");
//			//System.out.println("nhập số lượng cần thêm");
//			//int n = sc.nextInt();
//			//for (int i = 0; i < n; ++i) {
//				//dsKhoa.them1PhanTu();
//			//}
//			break;
//		}
//		case 4: {
//			System.out.println("Hàm xoa 1 khoa");
//			for (int i = 0; i < n; ++i) {
//				System.out.println("Nhập mã số Khoa cần xoa :");
//				dsKhoa.xoaPhanTu();
//			}
//			break;
//		}
//		/*case 5: {
//			System.out.println("Hàm xoá n khoa");
//			System.out.println("nhập số lượng cần xoa");
//			int n = Integer.parseInt(sc.nextLine());
//			for (int i = 0; i < n; ++i) {
//				System.out.println("Nhập mã Khoa cần xóa:");
//				dsKhoa.xoaKPhanTu(sc.nextLine());
//			}
//			break;
//		}*/
//		case 6:
//			showMenu();
//			break;
//		default:
//			System.out.println("Vui lòng nhập chính xác lựa chọn!!");
//		}

	}

	public static void showMajor() {
		System.out.println("Hiển thị danh sách ngành");
		dsNganh.xuatDanhSach();
		System.out.println("\n-----------Nganh------------");
		System.out.println("1. Xem DS nganh");
		System.out.println("2. Thêm 1 nganh vào danh sách");
		System.out.println("3. Thêm n nganh vào danh sách");
		System.out.println("4. Sửa n nganh");
		System.out.println("5. Xoá n nganh");
		System.out.println("6. Quay về trang chủ");
		System.out.println("---------------------------");

		System.out.print("Nhập lựa chọn: ");
//		int choiceCV = sc.nextInt();
//		switch (choiceCV) {
//		case 1:
//			dsNganh.xuatDanhSach();
//			break;
//		case 2:
//			System.out.println("Hàm thêm 1");
//			dsNganh.them1PhanTu();
//			break;
//		case 3:
//			System.out.println("Hàm thêm n");
//			dsNganh.themKPhanTu(choiceCV);
//			break;
//		case 4:
//			System.out.println("Hàm sửa");
//			dsNganh.suaPhanTu(null);
//			break;
//		case 5:
//			System.out.println("Hàm xoá");
//			dsNganh.xoaPhanTu(null);
//			break;
////		case 6:
////			System.out.println("Hàm tìm theo họ tên");
////			break;
////		case 7:
////			System.out.println("Hàm tìm theo mã cố vấn");
////			break;
////		case 8:
////			System.out.println("Hàm xem lớp quản lý");
////			break;
//		case 6:
//			showMenu();
//			break;
//		default:
//			System.out.println("Vui lòng nhập chính xác lựa chọn!!");
//		}
//		;
	}

	public static void showSubject() {
		System.out.println("\n-----------MÔN------------");
		System.out.println("1. Xem DS môn");
		System.out.println("2. Thêm 1 môn");
		System.out.println("3. Thêm n môn");
		System.out.println("4. Sửa n môn");
		System.out.println("5. Xoá n môn");
		System.out.println("6. Quay về trang chủ");
		System.out.println("---------------------------");

		System.out.print("Nhập lựa chọn: ");
		int choiceCV = Integer.parseInt(sc.nextLine());
		switch (choiceCV) {
		case 1:
			System.out.println("Hiển thị danh sách môn");
			dsMon.xuatDanhSach();
			break;
		case 2:
			dsMon.them1PhanTu();
			break;
		case 3: {
			System.out.println("Hàm thêm n");
			System.out.println("nhập số lượng cần thêm");
			int n = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n; ++i) {
				dsMon.them1PhanTu();
			}
			break;
		}
		case 4: {
			System.out.println("Danh sách môn trước khi sửa: ");
			dsMon.xuatDanhSach();
			System.out.println("Hàm sửa");
			System.out.println("Nhập số lượng cần sửa: ");
			int n = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n; ++i) {
				System.out.println("Chọn môn muốn sửa:");
				String input = sc.nextLine();
				dsMon.suaPhanTu(input);
				System.out.println("Danh sách môn mới sau khi sửa: ");
				dsMon.xuatDanhSach();
			}
			break;
		}
		case 5: {
			System.out.println("Danh sách môn trước khi xoá: ");
			dsMon.xuatDanhSach();
			System.out.println("Hàm xoá");
			System.out.println("Nhập số lượng cần xoá: ");
			int n = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n; ++i) {
				System.out.println("Chọn môn muốn xoá:");
				String input = sc.nextLine();
				dsMon.xoaPhanTu(input);
				System.out.println("Danh sách môn mới sau khi xoá: ");
				dsMon.xuatDanhSach();
			}
			break;
		}
		case 6:
			showMenu();
			break;
		default:
			System.out.println("Vui lòng nhập chính xác lựa chọn!!");
		}

	}

	// toàn bộ phần phía trên sẽ là menu chính

//	public static void AddNewStudentorGiaoVien() {
//		System.out.println("1.Thêm SV");
//		System.out.println("2.Thêm GV");
//		System.out.print("Nhập lựa chọn: ");
//		int choice2 = Integer.parseInt(sc.nextLine());
//		if (choice2 == 1) {
//			danhSachSV.add();
//			SV1.add(danhSachSV);
//		} else {
//			gv1.nhapTT();
//			GV1.add(gv1);
//		}
//	}

//	public static void suaSV() {
//		String maSV = danhSachSV.nhapMaSV();
//		danhSachSV.edit(maSV);
//	}
//
//	public static void xoaSV() {
//		String maSV = danhSachSV.nhapMaSV();
//		danhSachSV.delete(maSV);
//	}
//
//	public static void ShowProfileGiaoVien() {
//		String header = String.format("%-12s%-12s%-15s%-15s%-15s%-15s%-15s", "Mã GV", "Họ Tên", "Giới tính",
//				"Ngày sinh", "Địa chỉ", "SĐT", "Khoa");
//		System.out.println(header);
//		for (CoVanHocTap gv1 : GV1) {
//			String row = String.format("%-12s%-12s%-15S%-15s%-15s%-15s%-15s", gv1.getMaGV(), gv1.getHoTen(),
//					gv1.getGioiTinh(), gv1.getNgaySinh(), gv1.getDiaChi(), gv1.getSoDt(), gv1.getKhoa());
//			System.out.println(row);
//		}
//	}
//
//	public static void InsertMark() {
//		for (int i = 0; i < 1; i++) {
//			diem1.nhapTT();
//			Diem1.add(diem1);
//		}
//	}
//
//	public static void nhapDiem() {
//		m1.nhapTTMon();
//		taoMon.add(m1);
//	}
//
//	public static void DangKiMonHoc() {
//		boolean check = true;
//		while (check) {
//			System.out.print("Đăng kí học (Y/N): ");
//			String option = sc1.nextLine();
//			if (Objects.equals(option, "Y") || Objects.equals(option, "y")) {
//				DangKiMonHoc dk1 = new DangKiMonHoc();
//				dk1.DKi();
//				DK1.add(dk1);
//			} else {
//				check = false;
//			}
//		}
//	}
//
//	public static void inTTDangKi() {
//		System.out.print("Nhập mã SV: ");
//		String masv1 = sc1.nextLine();
//		String header3 = String.format("%-12s%-12s%-15s", "TênMH", "Số TC", "Tên Giảng Viên");
//		System.out.println(header3);
//		for (DangKiMonHoc dk1 : DK1) {
//			if (masv1.equals(dk1.maSV)) {
//				String row = String.format("%-12s%-12s%-15s", show(dk1.maMH), show1(dk1.maMH), show2(dk1.maGV));
//				System.out.println(row);
//			}
//		}
//	}
//
//	public static String show(String MaMH) {
//		for (HocPhan m1 : taoMon) {
//			if (MaMH.equals(m1.getMaMH())) {
//				return m1.tenMh;
//			}
//		}
//		return null;
//	}
//
//	public static int show1(String MaMH) {
//		for (HocPhan m1 : taoMon) {
//			if (MaMH.equals(m1.getMaMH())) {
//				return m1.soTC;
//			}
//		}
//		return 0;
//	}
//
//	public static String show2(String MaGV) {
//		for (CoVanHocTap gv1 : GV1) {
//			if ((MaGV.equals(gv1.getMaGV()))) {
//				return gv1.getHoTen();
//			}
//		}
//		return null;
//	}
//
//	public static void CheckbyIDStudent() {
//		System.out.print("Nhập mã SV: ");
//		String MaSv = sc1.nextLine();
//		String header = String.format("%-12s%-12s%-15s%-15s%-10s", "Mã SV", "MaMH", "TênMH", "Điểm", "Tình Trạng");
//		System.out.println(header);
//		for (Diem diem1 : Diem1) {
//			if (MaSv.equals(diem1.getMaSv())) {
//				for (int i = 0; i < diem1.Mon.length; i++) {
//					String row = String.format("%-12s%-12s%-15S%-15.2f%-10s", diem1.getMaSv(), diem1.Mon[i].maMH,
//							diem1.Mon[i].tenMh, diem1.Mon[i].getDiem(), diem1.Mon[i].getTinhTrang());
//					System.out.println(row);
//				}
//			}
//		}
//	}
//
//	public static void CheckbyIDSubject() {
//		System.out.print("Nhập mã MH: ");
//		String MaMH = sc1.nextLine();
//		String header2 = String.format("%-12s%-12s%-15s%-15s%-10s", "Mã SV", "MaMH", "TênMH", "Điểm", "Tình Trạng");
//		System.out.println(header2);
//		for (Diem diem1 : Diem1) {
//			for (int i = 0; i < diem1.Mon.length; i++) {
//				if (MaMH.equals(diem1.Mon[i].maMH)) {
//					String row = String.format("%-12s%-12s%-15S%-15f%-10s", diem1.getMaSv(), diem1.Mon[i].maMH,
//							diem1.Mon[i].tenMh, diem1.Mon[i].getDiem(), diem1.Mon[i].getTinhTrang());
//					System.out.println(row);
//				}
//			}
//		}
//	}
//
//	public static void ListPassorFail() {
//		System.out.print("Nhập mã MH: ");
//		String Ma = sc1.nextLine();
//		System.out.println("1.Trượt");
//		System.out.println("2.Qua");
//		System.out.print("Nhập lựa chọn: ");
//		int chon = Integer.parseInt(sc.nextLine());
//		String header3 = String.format("%-12s%-12s%-15s%-15s", "Mã SV", "MaMH", "TênMH", "Điểm");
//		System.out.println(header3);
//		if (chon == 1) {
//			for (Diem diem1 : Diem1) {
//				for (int i = 0; i < diem1.Mon.length; i++) {
//					if ("Thi Lại".equals(diem1.Mon[i].getTinhTrang()) && Ma.equals(diem1.Mon[i].getMaMH())) {
//						String row = String.format("%-12s%-12s%-15S%-15f", diem1.getMaSv(), diem1.Mon[i].getMaMH(),
//								diem1.Mon[i].getTenMh(), diem1.Mon[i].getDiem());
//						System.out.println(row);
//					}
//				}
//			}
//		} else {
//			for (Diem diem1 : Diem1) {
//				for (int i = 0; i < diem1.Mon.length; i++) {
//					if ("Qua Môn".equals(diem1.Mon[i].getTinhTrang()) && Ma.equals(diem1.Mon[i].getMaMH())) {
//						String row = String.format("%-12s%-12s%-15S%-15f", diem1.getMaSv(), diem1.Mon[i].getMaMH(),
//								diem1.Mon[i].getTenMh(), diem1.Mon[i].getDiem());
//						System.out.println(row);
//					}
//				}
//			}
//		}
//	}
//
//	public static void CheckHocBong() {
//		for (Diem diem1 : Diem1) {
//			if (diem1.GPA() > 7.5) {
//				for (SinhVien sinhVien : danhSachSV.getArrSinhVien()) {
//					if (diem1.getMaSv().equals(sinhVien.getMaSV())) {
//						danhSachSV.show();
//						System.out.println("GPA: " + diem1.GPA());
//					}
//				}
//			} else {
//				System.out.println("Null!!");
//			}
//		}
//	}

	public final static void clearConsole() {
		for (int i = 0; i < 30; ++i)
			System.out.println();
	}

}
