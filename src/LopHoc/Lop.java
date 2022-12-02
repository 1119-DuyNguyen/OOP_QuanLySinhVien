package LopHoc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import DanhSach.DSCVHT;
import DanhSach.DSNganh;

public class Lop {
	private static Scanner sc = new Scanner(System.in);
	private String maLop;
	private String tenLop;
	private String maNganh;
	private String maCoVan = "Chưa có";

	public Lop(String maLop, String tenLop, String maNganh, String maCoVan) {
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.maNganh = maNganh;
		this.maCoVan = maCoVan;
	}

	public Lop() {
		System.out.print("Nhập tên lớp: ");
		while (true) {
			this.tenLop = sc.nextLine();
			String regexLetter = "\\p{L}+";
			if (this.tenLop.matches(regexLetter))
				break;
			else {
				System.out.println("Nhập không hợp lệ ");
			}
		}
		System.out.print("Lớp thứ mấy: ");
		String regexNum = "\\d+";
		String numClassroom;
		while (true) {
			numClassroom = sc.nextLine();
			if (numClassroom.matches(regexNum))
				break;
			else {
				System.out.println("Nhập không hợp lệ ");
			}
		}

		DSNganh dsNganh = new DSNganh();
		this.maNganh = dsNganh.suggestMa();
		DSCVHT dsCVHT = new DSCVHT();
		this.maCoVan = dsCVHT.suggest();
		// generating maLop;
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		String hashMaLopString = "";
		boolean isSpace = true;
		for (int i = 0; i < this.tenLop.length(); i++) {
			char letter = this.tenLop.charAt(i);
			if (letter == ' ') {
				isSpace = true;
				continue;
			} else {
				if (isSpace == true) {

					hashMaLopString += Character.toUpperCase(letter);
					isSpace = false;
				}

			}
		}
		hashMaLopString += df.format(new Date());
		this.maLop = hashMaLopString + numClassroom;

	}

	public String getMaCoVan() {
		return maCoVan;
	}

	public void setMaCoVan(String maCoVan) {
		this.maCoVan = maCoVan;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	@Override
	public String toString() {
		return String.format("%-20s|%-40s|%-20s|%s", this.maLop, this.tenLop, this.maNganh, this.maCoVan);
	}

	public void thongtinLop() {
		// lấy thông tin của ngành ra
		DSNganh dsNganh = new DSNganh();
		int position = dsNganh.timKiemNganhTheoMaNganh(this.maNganh);
		// tìm kiếm vị trị của ngành và gán
		Nganh nganh = dsNganh.getNganh(position);
		// trả về vị trí của ngành
		nganh.thongTinNganh();
		// in ra
		System.out.println("Mã lớp :" + this.maLop);
		System.out.println("Tên lớp :" + this.tenLop);
		System.out.println("Mã cố vấn :" + this.maCoVan);
	}
}