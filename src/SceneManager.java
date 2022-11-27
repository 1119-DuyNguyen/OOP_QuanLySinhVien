import java.util.Scanner;

import DanhSach.DSCVHT;
import DanhSach.DSKhoa;
import DanhSach.DSLop;
import DanhSach.DSMon;
import DanhSach.DSNganh;
import DanhSach.DanhSachSV;
import Nguoi.SinhVien;

public class SceneManager {
//	private static DSMon dsMon = new DSMon();
	private static DSNganh dsNganh = new DSNganh();
	private static DSKhoa dsKhoa = new DSKhoa();
	private static DSCVHT dsCVHT = new DSCVHT();
	private static DanhSachSV dsSV = new DanhSachSV();
	private static DSLop dsLop = new DSLop();
	private static Scanner sc = new Scanner(System.in);

	public static void showMenu() {
		System.out.println("\n-----------MENU------------");
		System.out.println("1. Thao tác với DSSV.");
		System.out.println("2. Thao tác với DS cố vấn học tập.");
		System.out.println("3. Thao tác với lớp.");
		System.out.println("4. Thao tác với môn và điểm sinh viên.");
		System.out.println("5. Thao tác DS Khoa.");
		System.out.println("6. Thao tác DS Ngành.");
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
				while (showMenuSV()) {
				}
				break;
			case 2:
				while (showMenuCVHT()) {
				}
				break;
			case 3:

				while (showMenuLop()) {
				}
				;
				break;
			case 4:
				while (showMenuMon()) {
				}

				break;
			case 5:
				while (showMenuKhoa()) {

				}

				break;
			case 6:
				while (showMenuNganh()) {
				}

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

	private static boolean showMenuLop() {
		// TODO Auto-generated method stub
		System.out.println("\n-----------LỚP------------");
		System.out.println("0. Quay về trang chủ");
		System.out.println("1. Xem DS lớp");
		System.out.println("2. Thêm 1 lớp");
		System.out.println("3. Thêm n lớp");
		System.out.println("4. Sửa theo mã lớp");
		System.out.println("5. Xoá theo mã lớp");
		System.out.println("6. Nhập n phần tử mới đầu tiên");
		System.out.println("---------------------------");

		System.out.print("Nhập lựa chọn: ");
		int choiceCV = Integer.parseInt(sc.nextLine());
		switch (choiceCV) {
		case 0:
			return false;
		case 1:
			dsLop.xuatDanhSach();
			break;
		case 2:
			dsLop.them1PhanTu();
			break;
		case 3: {
			System.out.println("Nhập số lượng cần thêm");
			int n = Integer.parseInt(sc.nextLine());
			dsLop.themNPhanTu(n);
			break;
		}
		case 4: {
			System.out.println("Nhập mã lớp muốn sửa:");
			dsLop.suaPhanTu(sc.nextLine());
			break;
		}
		case 5: {
			System.out.print("Nhập mã lớp muốn xóa:");
			dsLop.xoaPhanTu(sc.nextLine());
			break;
		}
		case 6:
			System.out.println("Nhập n : ");
			int n = Integer.parseInt(sc.nextLine());
			dsLop.nhapNPhanTu(n);
			break;
		default:
			System.out.println("Vui lòng nhập chính xác lựa chọn!!");

		}
		return true;

	}

	private static boolean showMenuCVHT() {
		// TODO Auto-generated method stub
		System.out.println("\n-----------CỐ VẤN------------");
		System.out.println("0. Quay về trang chủ");
		System.out.println("1. Xem DS cố vấn học tập");
		System.out.println("2. Thêm 1 cố vấn học tập");
		System.out.println("3. Thêm n cố vấn học tập");
		System.out.println("4. Sửa theo mã cố vấn học tập");
		System.out.println("5. Xoá theo mã cố vấn học tập");
		System.out.println("6. Xem lớp quản lý của cố vấn");
		System.out.println("7. Nhập n phần tử mới đầu tiên");
		System.out.println("---------------------------");

		System.out.print("Nhập lựa chọn: ");
		int choiceCV = Integer.parseInt(sc.nextLine());
		switch (choiceCV) {
		case 0:
			return false;
		case 1:
			dsCVHT.xuatDanhSach();
			break;
		case 2:
			dsCVHT.them1PhanTu();
			break;
		case 3: {
			System.out.println("Nhập số lượng cần thêm");
			int n = Integer.parseInt(sc.nextLine());
			dsCVHT.themNPhanTu(n);
			break;
		}
		case 4: {

			System.out.println("Nhập mã số cố vấn cần sửa");
			dsCVHT.suaPhanTu(sc.nextLine());
			break;
		}
		case 5: {
			System.out.println("Nhập mã số cố vấn cần xóa");
			dsCVHT.xoaPhanTu(sc.nextLine());
			break;
		}

		case 6:
			dsCVHT.xemLopQuanLy();
			break;
		case 7:
			System.out.println("Nhập n : ");
			int n = Integer.parseInt(sc.nextLine());
			dsCVHT.nhapNPhanTu(n);
		default:
			System.out.println("Vui lòng nhập chính xác lựa chọn!!");
		}
		return true;
	}

	public static boolean showMenuSV() {
		System.out.println("\n--------SINH VIÊN---------");
		System.out.println("0. Quay về trang chủ");
		System.out.println("1. Xem DS sinh viên");
		System.out.println("2. Thêm 1 sinh viên");
		System.out.println("3. Thêm n sinh viên");
		System.out.println("4. Sửa theo mã sinh viên");
		System.out.println("5. Xoá theo mã sinh viên");
		System.out.println("6. Thống kê sinh viên đủ điều kiện học bổng");
		System.out.println("7. Thống kê những sinh viên nợ môn");
		System.out.println("8. Thống kê sinh viên theo lớp");
		System.out.println("9. Tìm kiếm sinh viên (theo họ tên)");
		System.out.println("10. Tìm kiếm sinh viên (theo MSSV)");
		System.out.println("11. nhập mới n sinh viên đầu tiên");
		System.out.println("12. Xem lớp sinh viên");
		System.out.println("13. Nhập môn và điểm cho sinh viên");
		System.out.println("---------------------------");

		System.out.print("Nhập lựa chọn: ");
		int choiceSV = Integer.parseInt(sc.nextLine());
		switch (choiceSV) {
		case 0:
			return false;
		case 1:
			dsSV.xuatDanhSach();
			break;
		case 2:
			dsSV.them1PhanTu();
			break;
		case 3: {
			System.out.println("nhập số lượng cần thêm");
			int n = Integer.parseInt(sc.nextLine());
			dsSV.themNPhanTu(n);
			break;
		}
		case 4: {
			System.out.println("Nhập mã số sinh viên cần sửa");
			dsSV.suaPhanTu(sc.nextLine());

			break;
		}
		case 5: {
			System.out.println("Nhập mã số sinh viên cần xóa");
			dsSV.xoaPhanTu(sc.nextLine());

			break;
		}

		case 6:
			System.out.println("Thống kê đủ điều kiện học bổng");
			dsSV.thongKeDuDieuKienHocBong();
			break;
		case 7:
			System.out.println("Thống kê nợ môn");
			dsSV.thongKeSVNoMon();
			break;
		case 8:
			System.out.println("Hàm thống kê theo lớp");
			dsSV.thongKeSVTheoLop();
			break;
		case 9: {
			boolean isApproximately = showMenuSearch();
			System.out.println("Nhập tên cần tìm : ");
			if (isApproximately) {
				dsSV.timKiemSVTheoHoTen(sc.nextLine(), isApproximately);
			} else {
				int position = dsSV.timKiemSVTheoHoTen(sc.nextLine(), isApproximately);
				if (position == -1) {
					System.out.println("Không tìm thấy sinh viên");
				} else {
					System.out.println("Sinh viên cần tìm là :");
					dsSV.xuatKQTimKiem(position);
				}
			}
		}
			break;
		case 10: {
			System.out.println("Nhập mã số cần tìm:");
			boolean isApproximately = showMenuSearch();
			if (isApproximately) {
				dsSV.timKiemSVTheoHoTen(sc.nextLine(), isApproximately);
			} else {
				int position = dsSV.timKiemSVTheoMaSo(sc.nextLine(), isApproximately);
				if (position == -1) {
					System.out.println("Không tìm thấy sinh viên");
				} else {
					dsSV.xuatKQTimKiem(position);
				}
			}

		}
			break;

		case 11:
			System.out.println("nhập số lượng cần nhập mới");
			int n = Integer.parseInt(sc.nextLine());
			dsSV.nhapNPhanTu(n);

			break;
		case 12:
			System.out.println("Nhập mã số cần xem lớp:");
			int position = dsSV.timKiemSVTheoMaSo(sc.nextLine(), false);
			if (position == -1) {
				System.out.println("Không tìm thấy sinh viên");
			} else {
				SinhVien sVien = dsSV.getSV(position);
				sVien.xemLop();
			}
			break;
		case 13: {
			while (showMenuMon()) {
			}
		}
			break;
		default:
			System.out.println("Vui lòng nhập chính xác lựa chọn!!");
		}
		return true;
	}

	public static boolean showMenuKhoa() {
		System.out.println("\n-----------KHOA------------");
		System.out.println("0. Quay về trang chủ");
		System.out.println("1. Xem danh sách Khoa");
		System.out.println("2. Thêm 1 Khoa");
		System.out.println("3. Thêm n Khoa");
		System.out.println("4. Sửa theo mã Khoa");
		System.out.println("5. Xoá theo mã Khoa");
		System.out.println("6. Nhập n phần tử mới đầu tiên");
		System.out.println("---------------------------");

		System.out.print("Nhập lựa chọn: ");
		int choiceCV = Integer.parseInt(sc.nextLine());
		switch (choiceCV) {
		case 0:
			return false;
		case 1:
			dsKhoa.xuatDanhSach();
			break;
		case 2:
			dsKhoa.them1PhanTu();
			break;
		case 3: {
			System.out.print("Nhập số lượng cần thêm");
			int n = Integer.parseInt(sc.nextLine());
			dsKhoa.themNPhanTu(n);
			break;
		}
		case 4: {
			System.out.print("Nhập mã khoa muốn sửa:");
			dsKhoa.suaPhanTu(sc.nextLine());
			break;
		}
		case 5: {
			System.out.print("Nhập mã khoa muốn xóa:");
			dsKhoa.xoaPhanTu(sc.nextLine());
			break;
		}
		case 6:
			System.out.print("Nhập n: ");
			int n = Integer.parseInt(sc.nextLine());
			dsKhoa.nhapNPhanTu(n);

			break;
		default:
			System.out.println("Vui lòng nhập chính xác lựa chọn!!");

		}
		return true;

	}

	public static boolean showMenuNganh() {
		System.out.println("\n-----------NGÀNH------------");
		System.out.println("0. Quay về trang chủ");
		System.out.println("1. Xem danh sách Ngành");
		System.out.println("2. Thêm 1 Ngành");
		System.out.println("3. Thêm n Ngành");
		System.out.println("4. Sửa theo mã Ngành");
		System.out.println("5. Xoá theo mã Ngành");
		System.out.println("6. Nhập n phần tử mới đầu tiên");
		System.out.println("---------------------------");

		System.out.print("Nhập lựa chọn: ");
		int choiceCV = Integer.parseInt(sc.nextLine());
		switch (choiceCV) {
		case 0:
			return false;
		case 1:
			System.out.println("Hiển thị danh sách ngành");
			dsNganh.xuatDanhSach();
			break;
		case 2:
			dsNganh.them1PhanTu();
			break;
		case 3: {
			System.out.println("nhập số lượng cần thêm");
			int n = Integer.parseInt(sc.nextLine());
			dsNganh.themNPhanTu(n);
			break;
		}
		case 4: {
			System.out.println("Nhập mã ngành muốn sửa:");
			dsNganh.suaPhanTu(sc.nextLine());
			break;
		}
		case 5: {
			System.out.print("Nhập mã ngành muốn xóa:");
			dsNganh.xoaPhanTu(sc.nextLine());
			break;
		}
		case 6:
			System.out.println("Nhập số lượng cần thêm");
			int n = Integer.parseInt(sc.nextLine());
			dsNganh.nhapNPhanTu(n);
			break;
		default:
			System.out.println("Vui lòng nhập chính xác lựa chọn!!");
		}
		return true;
	}

	public static boolean showMenuMon() {

		System.out.println("Nhập mã sinh viên cần thao tác: ");
		int position = dsSV.timKiemSVTheoMaSo(sc.nextLine(), false);
		if (position == -1) {
			System.out.println("Không tìm thấy sinh viên");
			return false;
		}

		while (true) {
			SinhVien sVien = dsSV.getSV(position);
			System.out.println("\n\nThông tin sinh viên được thao tác : ");
			dsSV.xuatKQ1SV(position);
			DSMon dsMon = sVien.getNhungMonHoc();
			// SinhVien sinhVien = dsSV[position];
			System.out.println("\n-----------MÔN VÀ ĐIỂM------------");
			System.out.println("0. Quay về trang chủ");
			System.out.println("1. Xem DS môn");
			System.out.println("2. Thêm 1 môn");
			System.out.println("3. Thêm n môn");
			System.out.println("4. Sửa theo mã môn");
			System.out.println("5. Xoá theo mã môn");
			System.out.println("6. Thêm mới n môn");
			System.out.println("7. Thao tác với sinh viên khác");
			System.out.println("---------------------------");

			System.out.print("Nhập lựa chọn: ");
			int choiceCV = Integer.parseInt(sc.nextLine());
			switch (choiceCV) {
			case 0:
				return false;
			case 1:
				dsMon.xuatDanhSach();
				break;
			case 2:
				dsMon.them1PhanTu();
				break;
			case 3: {
				System.out.println("nhập số lượng cần thêm");
				int n = Integer.parseInt(sc.nextLine());
				dsMon.themNPhanTu(n);
				break;
			}
			case 4: {
				int index = dsMon.suggest();
				dsMon.suaPhanTu(index);
				System.out.println("Danh sách môn sau khi sửa: ");
				dsMon.xuatDanhSach();
				break;
			}
			case 5: {
				int index = dsMon.suggest();
				dsMon.xoaPhanTu(index);
				System.out.println("Danh sách môn sau khi xoá: ");
				dsMon.xuatDanhSach();
			}
				break;

			case 6:
				System.out.print("nhập n phần tử mới đầu tiên :");
				int n = Integer.parseInt(sc.nextLine());
				dsMon.nhapNPhanTu(n);
				break;
			case 7:
				return true;
			default:
				System.out.println("Vui lòng nhập chính xác lựa chọn!!");
			}
			dsSV.setMonSV(position, dsMon);
		}

	}

	// nếu là true thì tìm kiếm gần đúng, false tìm kiếm chính xác
	public static boolean showMenuSearch() {
		System.out.println("\n-----------Tìm kiếm------------");
		System.out.println("1. Tìm kiếm chính xác");
		System.out.println("2. Tìm kiếm gần đúng");
		System.out.println("---------------------------");

		System.out.print("Nhập lựa chọn: ");
		do {
			int choiceCV = Integer.parseInt(sc.nextLine());
			switch (choiceCV) {
			case 1:
				return false;
			case 2:
				return true;
			default:
				System.out.println("Vui lòng nhập chính xác lựa chọn!!");
			}

		} while (true);

	}

}
