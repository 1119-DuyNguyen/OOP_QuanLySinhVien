
import java.util.Scanner;

public class CoVanHocTap extends Nguoi {
	public Scanner sc1 = new Scanner(System.in);
	private String[] tenCV = { "A", "B" };
	private String[] maLop = { "DKP1211", "DKP1212" };
	private String maGV;
	private String Khoa;

	public CoVanHocTap() {
		super();
		// none
	}

	CoVanHocTap(String maGV, String hoTen, String diaChi, String soDt, String Khoa) {
		this.maGV = maGV;
		this.Khoa = Khoa;
	}

	public void setKhoa(String khoa) {
		Khoa = khoa;
	}

	public String getKhoa() {
		return Khoa;
	}

	public String getMaGV() {
		return maGV;
	}

	public void xemLopQuanLy() {
		Lop[] lop = new Lop[2];
		for (int i = 0; i < lop.length; i++) {
			lop[i].setMaLop(maLop[i]);
			System.out.println("Ten Co Van: " + tenCV[i]);
			System.out.println("Ma lop day: " + maLop[i]);
		}
	}

	@Override
	public void xuatThongTin() {
		System.out.println();
		System.out.println("Cố vấn học tập");
//		super.xuatTT();
		System.out.println("Mã giáo viên: " + maGV);
		System.out.println("Khoa dạy: " + Khoa);
		xemLopQuanLy();
	}

	@Override
	public void xemLop() {
		// TODO Auto-generated method stub

	}
}
