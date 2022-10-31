

import java.util.Scanner;

public class GiaoVien extends Nguoi {
	public Scanner sc1 = new Scanner(System.in);
	private String maGV;
	private String Khoa;

	public GiaoVien() {
		super("Khoa", "Khoa", "Khoa", "maGV", "Khoa");
		// none
	}

	public GiaoVien(String maGV, String hoTen, String ngaySinh, String diaChi, String gioiTinh, String soDt,
			String Khoa) {
		super(hoTen, ngaySinh, diaChi, soDt, gioiTinh);
		this.maGV = maGV;
		this.Khoa = Khoa;
	}

	public void setKhoa(String khoa) {
		Khoa = khoa;
	}

	public String getKhoa() {
		return Khoa;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}

	public String getMaGV() {
		return maGV;
	}

	@Override
	void nhapTT() {
		System.out.print("Nhập mã GV: ");
		this.maGV = sc1.nextLine();
		System.out.print("Nhập Khoa: ");
		this.Khoa = sc1.nextLine();
		super.nhapTT();
	}
}
