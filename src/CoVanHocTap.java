
import java.util.Scanner;

public class CoVanHocTap extends Nguoi {
	public Scanner sc1 = new Scanner(System.in);
	public String tenCV;
	public String maLop;
	private String maGV;
	private String Khoa;

	public CoVanHocTap() {
		// super();
		System.out.print("Nhập tên cố vấn: ");
		this.tenCV = sc1.nextLine();
		System.out.print("Nhập lớp cố vấn: ");
		this.maLop = sc1.nextLine();

		// none
	}

	public CoVanHocTap(String maGV, String hoTen, String diaChi, String soDt, String Khoa) {
		this.maGV = maGV;
		this.Khoa = Khoa;
	}

	public CoVanHocTap(String tenGV, String maLop) {
		this.tenCV = tenGV;
		this.maLop = maLop;
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

	@Override
	public void xuatThongTin() {
		System.out.println();
		System.out.println("Cố vấn học tập");
//		super.xuatTT();
		System.out.println("Mã giáo viên: " + maGV);
		System.out.println("Khoa dạy: " + Khoa);
	}

	@Override
	public void xemLop() {
		// TODO Auto-generated method stub

	}
}
