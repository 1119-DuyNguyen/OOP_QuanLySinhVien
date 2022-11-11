import java.util.Scanner;

public class SinhVien {
	private static final Lop Lop = null;
	private String maSinhVien;
	private Lop lop;

	public SinhVien() {

	}

	public SinhVien(String maSinhVien, Lop lop) {
		this.maSinhVien = maSinhVien;
		this.lop = Lop;

	}

	public SinhVien(String maSV, String hoTen, String lop2, String ngaySinh, String diaChi, String soDt,
			String gioiTinh) {
		// TODO Auto-generated constructor stub
	}

	public void CapNhatThongTin(Scanner scan) {
		System.out.println("Nhap ma sinh vien: ");
		this.maSinhVien = scan.nextLine();
	}

	public void DanhSachMH() {

	}

	public String timMonHoc(String maMH) {
		return maMH;

	}

	public void XuatThongTinCaNhan() {
		System.out.println("MSSV cua ban la:" + this.maSinhVien);
		System.out.println("Lop cua ban la:" + this.lop);

	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}

}
