
import java.util.Scanner;

public class Lop {
	private static Scanner sc = new Scanner(System.in);
	String maLop;
	String tenLop;
	int soLuong;

	public Lop() {
		System.out.print("Nhập mã lớp: ");
		this.maLop = sc.nextLine();
		System.out.print("Nhập tên lớp: ");
		this.tenLop = sc.nextLine();
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

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void thongtinLop() {

	}
}