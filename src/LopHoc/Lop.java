package LopHoc;

import java.util.Scanner;

import DanhSach.DSCVHT;
import DanhSach.DSNganh;

public class Lop {
	private static Scanner sc = new Scanner(System.in);
	private String maLop;
	private String tenLop;
	private String maNganh;
	private String maCoVan = "Chưa có";

	public Lop(String maLop, String tenLop, String maNganh, String maCoVan) {
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.maNganh = maNganh;
		this.maCoVan = maCoVan;
	}

	public Lop() {
		System.out.println("Nhập mã lớp: ");
		this.maLop = sc.nextLine().trim();
		System.out.print("Nhập tên lớp: ");
		this.tenLop = sc.nextLine();
		// generating maLop;
		DSNganh dsNganh = new DSNganh();
		this.maNganh = dsNganh.suggest();
		DSCVHT dsCVHT = new DSCVHT();
		this.maCoVan = dsCVHT.suggest();
	}

	public String getMaCoVan() {
		return maCoVan;
	}

	public void setMaCoVan(String maCoVan) {
		this.maCoVan = maCoVan;
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

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	@Override
	public String toString() {
		return String.format("%-20s|%-40s|%-20s|%s", this.maLop, this.tenLop, this.maNganh, this.maCoVan);
	}

	public void thongtinLop() {
		DSNganh dsNganh = new DSNganh();
		int position = dsNganh.timKiemNganhTheoMaNganh(this.maNganh);
		Nganh nganh = dsNganh.getNganh(position);
		nganh.thongTinNganh();
		System.out.println("Mã lớp :" + this.maLop);
		System.out.println("Tên lớp :" + this.tenLop);
		System.out.println("Mã cố vấn :" + this.maCoVan);
	}
}