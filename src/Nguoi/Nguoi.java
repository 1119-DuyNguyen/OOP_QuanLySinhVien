package Nguoi;

import java.util.Scanner;

public class Nguoi {
	protected static Scanner sc = new Scanner(System.in);
	private String hoTen;
	private String gioiTinh;
	private String soDt;
	private String diaChi;

	public Nguoi(String hoTen, String diaChi, String soDt, String gioiTinh) {
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDt = soDt;
		this.gioiTinh = gioiTinh;
	}

	public Nguoi() {
		System.out.print("Nhập họ tên: ");
		this.hoTen = sc.nextLine();
		System.out.print("Nhập địa chỉ: ");
		this.diaChi = sc.nextLine();
		System.out.print("Nhập giới tính: ");
		this.gioiTinh = sc.nextLine();
		System.out.print("Nhập SĐT: ");
		this.soDt = sc.nextLine();
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getHoTen() {
		return hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public String getSoDt() {
		return soDt;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public void setSoDt(String soDt) {
		this.soDt = soDt;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		return String.format("%-20s |%-5s |%-10s |%-20s ", this.hoTen, this.gioiTinh, this.soDt, this.diaChi);
	}

//	public void nhapThongTin() {
//	};
//
//	public void xuatThongTin() {
//	};
}