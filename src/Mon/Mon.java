package Mon;

import java.util.Scanner;

public class Mon {
	private static Scanner sc = new Scanner(System.in);
	private String tenMH;
	private Diem diem = new Diem(-1f);

	public Mon() {
		System.out.print("Nhập tên môn: ");
		this.tenMH = sc.nextLine();
		diem.nhapDiem();
	}

	public float getDiem() {
		return diem.getDiemHe10();
	}

	public Mon(String tenMH, float diem) {

		this.tenMH = tenMH;
		this.diem = new Diem(diem);
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMon(String string) {
		// TODO Auto-generated method stub

	}

	public void setMaMon(String string) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%-20s#%s", this.tenMH, this.diem);
		// return String.format("%-20s|%-20s|%s", this.maMH, this.tenMH, this.diem);
	}

	public void xuatThongTin() {
		// TODO Auto-generated method stub
		String monToString = String.format("%-20s|%s", this.tenMH, this.diem);
		System.out.println(monToString);
	}

	public void suaThongTin() {
		System.out.println("\n-----------Sửa thông tin-----------");
		System.out.println("0. Quay lại");
		System.out.println("1. Sửa tên môn");
		System.out.println("2. Sửa điểm");
		System.out.println("---------------------------");
		int chon = 0;
		do {
			System.out.print("Nhap lua chon: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 0:
				break;
			case 1:
				System.out.print("Nhập tên môn: ");
				setTenMon(sc.nextLine());
				break;
			case 2:
				System.out.print("Nhập điểm: ");
				diem.nhapDiem();
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ ! Hãy chọn lại");
				break;
			}
		} while (chon > 2 && chon < 0);
	}
}
