import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SceneManager {
//	public static ArrayList<Diem> Diem1 = new ArrayList<>();
//	public static ArrayList<DangKiMonHoc> DK1 = new ArrayList<>();
//	public static ArrayList<CoVanHocTap> GV1 = new ArrayList<>();
//	public static ArrayList<DanhSachSV> SV1 = new ArrayList<>();
//	public static ArrayList<MonHoc> taoMon = new ArrayList<>();
//	public static Scanner sc = new Scanner(System.in);
//	public static Scanner sc1 = new Scanner(System.in);
//	public static DanhSachSV danhSachSV = new DanhSachSV();
//	public static CoVanHocTap gv1 = new CoVanHocTap();
//	public static Diem diem1 = new Diem();
//	public static MonHoc m1 = new MonHoc();

	public static void showMenu() {
		System.out.println("\n-----------MENU------------");
		System.out.println("1. Thao tác với DSSV.");
		System.out.println("2. Thao tác với DS cố vấn học tập.");
		System.out.println("3. Xem DS Khoa.");
		System.out.println("4. Xem DS Ngành.");
		System.out.println("5. Xem DS Môn.");
		System.out.println("Nhấn phím 0 để thoát!!");
		System.out.println("---------------------------");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean con = true;
		while (con) {
			showMenu();
			System.out.print("Nhập lựa chọn: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				showMenuSV();
				break;
			case 2:
				showMenuTeacher();
			case 3:
				showFaculty();
				break;
			case 4:
				showMajor();
				break;
			case 5:
				showSubject();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				con = false;
			}
			if (con) {
				clearConsole();
			}
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
		int choiceSV = sc.nextInt();
		switch (choiceSV) {
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

	public static void showMenuTeacher() {
		System.out.println("\n-----------CỐ VẤN------------");
		System.out.println("1. Xem DS cố vấn học tập");
		System.out.println("2. Thêm 1 cố vấn học tập");
		System.out.println("3. Thêm n cố vấn học tập");
		System.out.println("4. Sửa n cố vấn học tập");
		System.out.println("5. Xoá n cố vấn học tập");
		System.out.println("6. Tìm kiếm cố vấn học tập (theo họ tên)");;
		System.out.println("7. Tìm kiếm cố vấn học tập (theo mã cố vấn)");;
		System.out.println("8. Xem lớp quản lý của cố vấn");
		System.out.println("9. Quay về trang chủ");
		System.out.println("---------------------------");

		System.out.print("Nhập lựa chọn: ");
		int choiceCV = sc.nextInt();
		switch (choiceCV) {
		case 1:
			showMenuSV();
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
			System.out.println("Hàm tìm theo họ tên");
			break;
		case 7:
			System.out.println("Hàm tìm theo mã cố vấn");
			break;
		case 8:
			System.out.println("Hàm xem lớp quản lý");
			break;
		case 9:
			showMenu();
			break;
		default:
			System.out.println("Vui lòng nhập chính xác lựa chọn!!");
		}

	}
	
	public static void showFaculty() {
		System.out.println("Hiển thị danh sách khoa");
	}
	
	public static void showMajor() {
		System.out.println("Hiển thị danh sách ngành");
	}
	
	public static void showSubject() {
		System.out.println("Hiển thị danh sách môn");
	}

	
	//toàn bộ phần phía trên sẽ là menu chính
	
	
	
	public static void AddNewStudentorGiaoVien() {
		System.out.println("1.Thêm SV");
		System.out.println("2.Thêm GV");
		System.out.print("Nhập lựa chọn: ");
		int choice2 = sc.nextInt();
		if (choice2 == 1) {
			danhSachSV.add();
			SV1.add(danhSachSV);
		} else {
			gv1.nhapTT();
			GV1.add(gv1);
		}
	}

	public static void suaSV() {
		String maSV = danhSachSV.nhapMaSV();
		danhSachSV.edit(maSV);
	}

	public static void xoaSV() {
		String maSV = danhSachSV.nhapMaSV();
		danhSachSV.delete(maSV);
	}

	public static void ShowProfileGiaoVien() {
		String header = String.format("%-12s%-12s%-15s%-15s%-15s%-15s%-15s", "Mã GV", "Họ Tên", "Giới tính",
				"Ngày sinh", "Địa chỉ", "SĐT", "Khoa");
		System.out.println(header);
		for (CoVanHocTap gv1 : GV1) {
			String row = String.format("%-12s%-12s%-15S%-15s%-15s%-15s%-15s", gv1.getMaGV(), gv1.getHoTen(),
					gv1.getGioiTinh(), gv1.getNgaySinh(), gv1.getDiaChi(), gv1.getSoDt(), gv1.getKhoa());
			System.out.println(row);
		}
	}

	public static void InsertMark() {
		for (int i = 0; i < 1; i++) {
			diem1.nhapTT();
			Diem1.add(diem1);
		}
	}

	public static void nhapDiem() {
		m1.nhapTTMon();
		taoMon.add(m1);
	}

	public static void DangKiMonHoc() {
		boolean check = true;
		while (check) {
			System.out.print("Đăng kí học (Y/N): ");
			String option = sc1.nextLine();
			if (Objects.equals(option, "Y") || Objects.equals(option, "y")) {
				DangKiMonHoc dk1 = new DangKiMonHoc();
				dk1.DKi();
				DK1.add(dk1);
			} else {
				check = false;
			}
		}
	}

	public static void inTTDangKi() {
		System.out.print("Nhập mã SV: ");
		String masv1 = sc1.nextLine();
		String header3 = String.format("%-12s%-12s%-15s", "TênMH", "Số TC", "Tên Giảng Viên");
		System.out.println(header3);
		for (DangKiMonHoc dk1 : DK1) {
			if (masv1.equals(dk1.maSV)) {
				String row = String.format("%-12s%-12s%-15s", show(dk1.maMH), show1(dk1.maMH), show2(dk1.maGV));
				System.out.println(row);
			}
		}
	}

	public static String show(String MaMH) {
		for (HocPhan m1 : taoMon) {
			if (MaMH.equals(m1.getMaMH())) {
				return m1.tenMh;
			}
		}
		return null;
	}

	public static int show1(String MaMH) {
		for (HocPhan m1 : taoMon) {
			if (MaMH.equals(m1.getMaMH())) {
				return m1.soTC;
			}
		}
		return 0;
	}

	public static String show2(String MaGV) {
		for (CoVanHocTap gv1 : GV1) {
			if ((MaGV.equals(gv1.getMaGV()))) {
				return gv1.getHoTen();
			}
		}
		return null;
	}

	public static void CheckbyIDStudent() {
		System.out.print("Nhập mã SV: ");
		String MaSv = sc1.nextLine();
		String header = String.format("%-12s%-12s%-15s%-15s%-10s", "Mã SV", "MaMH", "TênMH", "Điểm", "Tình Trạng");
		System.out.println(header);
		for (Diem diem1 : Diem1) {
			if (MaSv.equals(diem1.getMaSv())) {
				for (int i = 0; i < diem1.Mon.length; i++) {
					String row = String.format("%-12s%-12s%-15S%-15.2f%-10s", diem1.getMaSv(), diem1.Mon[i].maMH,
							diem1.Mon[i].tenMh, diem1.Mon[i].getDiem(), diem1.Mon[i].getTinhTrang());
					System.out.println(row);
				}
			}
		}
	}

	public static void CheckbyIDSubject() {
		System.out.print("Nhập mã MH: ");
		String MaMH = sc1.nextLine();
		String header2 = String.format("%-12s%-12s%-15s%-15s%-10s", "Mã SV", "MaMH", "TênMH", "Điểm", "Tình Trạng");
		System.out.println(header2);
		for (Diem diem1 : Diem1) {
			for (int i = 0; i < diem1.Mon.length; i++) {
				if (MaMH.equals(diem1.Mon[i].maMH)) {
					String row = String.format("%-12s%-12s%-15S%-15f%-10s", diem1.getMaSv(), diem1.Mon[i].maMH,
							diem1.Mon[i].tenMh, diem1.Mon[i].getDiem(), diem1.Mon[i].getTinhTrang());
					System.out.println(row);
				}
			}
		}
	}

	public static void ListPassorFail() {
		System.out.print("Nhập mã MH: ");
		String Ma = sc1.nextLine();
		System.out.println("1.Trượt");
		System.out.println("2.Qua");
		System.out.print("Nhập lựa chọn: ");
		int chon = sc.nextInt();
		String header3 = String.format("%-12s%-12s%-15s%-15s", "Mã SV", "MaMH", "TênMH", "Điểm");
		System.out.println(header3);
		if (chon == 1) {
			for (Diem diem1 : Diem1) {
				for (int i = 0; i < diem1.Mon.length; i++) {
					if ("Thi Lại".equals(diem1.Mon[i].getTinhTrang()) && Ma.equals(diem1.Mon[i].getMaMH())) {
						String row = String.format("%-12s%-12s%-15S%-15f", diem1.getMaSv(), diem1.Mon[i].getMaMH(),
								diem1.Mon[i].getTenMh(), diem1.Mon[i].getDiem());
						System.out.println(row);
					}
				}
			}
		} else {
			for (Diem diem1 : Diem1) {
				for (int i = 0; i < diem1.Mon.length; i++) {
					if ("Qua Môn".equals(diem1.Mon[i].getTinhTrang()) && Ma.equals(diem1.Mon[i].getMaMH())) {
						String row = String.format("%-12s%-12s%-15S%-15f", diem1.getMaSv(), diem1.Mon[i].getMaMH(),
								diem1.Mon[i].getTenMh(), diem1.Mon[i].getDiem());
						System.out.println(row);
					}
				}
			}
		}
	}

	public static void CheckHocBong() {
		for (Diem diem1 : Diem1) {
			if (diem1.GPA() > 7.5) {
				for (SinhVien sinhVien : danhSachSV.getArrSinhVien()) {
					if (diem1.getMaSv().equals(sinhVien.getMaSV())) {
						danhSachSV.show();
						System.out.println("GPA: " + diem1.GPA());
					}
				}
			} else {
				System.out.println("Null!!");
			}
		}
	}

	public final static void clearConsole() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}

}
