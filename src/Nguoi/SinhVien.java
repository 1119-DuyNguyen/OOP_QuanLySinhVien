package Nguoi;

import DanhSach.DSLop;
import Mon.Mon;

public class SinhVien extends Nguoi implements ActionMemberClassroom {
	private String maSV;
	private String maLop;
	private Mon nhungMonHoc[] = new Mon[2];
	private static int currentMaSV = 0;// thêm cả ở class cvht

	public SinhVien() {
		super();

		this.maSV = Integer.toString(currentMaSV++);
	}

	public SinhVien(String hoTen, String diaChi, String soDt, String gioiTinh, String maSV, String maLop,
			Mon[] nhungMonHoc) {
		super(hoTen, diaChi, soDt, gioiTinh);
		this.maSV = maSV;
		this.maLop = maLop;
		this.nhungMonHoc = nhungMonHoc;
	}

	public SinhVien(String maSV, String hoTen, String diaChi, String soDt, String gioiTinh) {
		super(hoTen, diaChi, soDt, gioiTinh);
		this.maSV = Integer.toString(currentMaSV++);

	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public void DanhSachMH() {

	}

	public String timMonHoc(String maMH) {
		return maMH;

	}

	// to string sẽ xuất thông tin cơ bản
	@Override
	public String toString() {

		String joinMonString[] = new String[nhungMonHoc.length];
		for (int i = 0; i < nhungMonHoc.length; ++i) {
			joinMonString[i] = nhungMonHoc[i].toString();
		}

		String formatString = String.format("%-4s|%s|%-20s|%s", maSV, super.toString(), maLop,
				String.join(",", joinMonString));
		return formatString;
	}

	public void XuatThongTinCaNhan() {
		// System.out.println(this);
		// System.out.println("Lop cua ban la:" + this.lop);

	}

	public void xuatThongTin() {
//		System.out.println();
//		System.out.println("Cố vấn học tập");
////		super.xuatTT();
//		System.out.println("Mã giáo viên: " + maGV);
//		System.out.println("Khoa dạy: " + Khoa);
		System.out.println(this);

	}

	public void xemLop() {
//		String formatString = String.format("%-4s|%-20s |%-20s |%-20s |%-20s", maSV, this.getHoTen(), maLop.getTenLop(),
//				maNganh.getTenNganh());
		System.out.println("xem Lop");
	}

	@Override
	public void xemLop(DSLop ds) {
		// TODO Auto-generated method stub

	}
}
