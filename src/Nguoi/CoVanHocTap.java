package Nguoi;

import DanhSach.DSLop;

public class CoVanHocTap extends Nguoi implements ActionMemberClassroom {
	private String maCVHT;
	private String maLop[];
	private static int createdMaCVHT = 0;// thêm cả ở class cvht

	public CoVanHocTap(String hoTen, String diaChi, String soDt, String gioiTinh, String maCVHT, String[] maLop) {
		super(hoTen, diaChi, soDt, gioiTinh);
		this.maCVHT = maCVHT;
		this.maLop = maLop;
	}

	public CoVanHocTap() {
		super();

//		System.out.print("Nhập lớp cố vấn: ");
//		this.maLop = sc.nextLine();
		this.maCVHT = Integer.toString(createdMaCVHT++);
		// none
	}

	public String getMaGV() {
		return maCVHT;
	}

	public void xuatThongTin() {
		System.out.println();
		System.out.println("Cố vấn học tập");
//		super.xuatTT();
		System.out.println("Mã cố vấn: " + maCVHT);
		System.out.println("Lớp dạy: ");

	}

	@Override
	public void xemLop(DSLop ds) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String parentString = super.toString();
		String maLopString = String.join(",", maLop);
		return String.format("%s|%-10s|%s", parentString, this.maCVHT, maLopString);
	}
}
