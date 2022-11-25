package Mon;

import java.util.Scanner;

public class Mon {
	private static Scanner sc = new Scanner(System.in);
	private String tenMH;
	private Diem diem;

	// private String maMH;
	public Mon() {
//		System.out.print("Nhập mã môn: ");
//		this.maMH = sc.nextLine();
		System.out.print("Nhập tên môn: ");
		this.tenMH = sc.nextLine();
		diem.nhapDiem();
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
		return String.format("%-20s|%s", this.tenMH, this.diem);
		// return String.format("%-20s|%-20s|%s", this.maMH, this.tenMH, this.diem);
	}
}
