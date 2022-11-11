
import java.util.Scanner;

public class CoVanHocTap extends Nguoi {
	public Scanner sc1 = new Scanner(System.in);
	private String[] tenCV = { "A", "B" };
	private String[] maLop = { "DKP1211", "DKP1212" };
	private String maGV;
	private String Khoa;

	public CoVanHocTap() {
		super("Khoa", "Khoa", "Khoa");
		// none
	}

	CoVanHocTap(String maGV, String hoTen, String diaChi, String soDt, String Khoa) {
		super(hoTen, soDt, diaChi);
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
	public void nhapThongTin() {
//		super.nhapTT();
		System.out.print("Nhập mã GV: ");
		this.maGV = sc1.nextLine();
		System.out.print("Nhập Khoa: ");
		this.Khoa = sc1.nextLine();
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
}
