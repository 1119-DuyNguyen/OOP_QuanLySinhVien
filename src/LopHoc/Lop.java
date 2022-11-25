package LopHoc;

import java.util.Scanner;

public class Lop {
	private static Scanner sc = new Scanner(System.in);
	private String maLop;
	private String tenLop;
	private String maSV[] = {};
	private String maNganh;
	private String maCoVan;
	private int soLuong;

	public Lop() {
		System.out.print("Nhập mã lớp: ");
		this.maLop = sc.nextLine();
		System.out.print("Nhập tên lớp: ");
		this.tenLop = sc.nextLine();

	}

	public Lop(String maLop, String tenLop) {
		this.maLop = maLop;
		this.tenLop = tenLop;
	}

	public Lop(String maLop) {
		this.maLop = maLop;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public String getTenLop() {
		return tenLop;
	}

	@Override
	public String toString() {
		return String.format("%-10s|%-20s|%-10d", this.maLop, this.tenLop, this.soLuong);
	}

	public void thongtinLop() {

	}
}