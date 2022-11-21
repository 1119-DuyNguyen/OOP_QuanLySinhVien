import java.util.Scanner;

public class MonHoc {
	private static Scanner sc = new Scanner(System.in);
	private String maMH;
	private String tenMH;
	private float diem;

	public MonHoc() {
		System.out.print("Nhập mã môn: ");
		this.maMH = sc.nextLine();
		System.out.print("Nhập tên môn: ");
		this.tenMH = sc.nextLine();
	}

	public MonHoc(String maMh, String tenMH) {
		this.maMH = maMh;
		this.tenMH = tenMH;
	}

	public MonHoc(String maMH, String tenMH, float diem) {
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.diem = diem;
	}

	public float setDiem(float diem) {
		return this.diem = diem;
	}

	public String getMaMH() {
		return maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public float getDiem() {
		return diem;
	}

	public MonHoc(String maMH, String tenMH, int soTinChi, int namHoc, int hocKi) {

		this.maMH = maMH;
		this.tenMH = tenMH;

	}

	public void nhap() {

	}

	public void xuat() {
		// System.out.print(toString());
	}

	public void setTenMon(String string) {
		// TODO Auto-generated method stub

	}

	public void setMaMon(String string) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%-20s|%-20s", this.maMH, this.tenMH);
	}
}
