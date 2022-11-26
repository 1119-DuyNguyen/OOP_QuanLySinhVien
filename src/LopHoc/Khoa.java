package LopHoc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Khoa {
	private String maKhoa;

	private String tenKhoa;
	private String ngayThanhLap;
	private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public Khoa() {
		System.out.println("Nhập tên khoa: ");
		Scanner scanner = new Scanner(System.in);
		this.tenKhoa = scanner.nextLine();
		Date date = new Date();
		this.ngayThanhLap = dateFormat.format(date);
		// generating maKhoa;
		String hashMaKhoaString = "";
		boolean isSpace = true;
		for (int i = 0; i < this.tenKhoa.length(); i++) {
			char letter = this.tenKhoa.charAt(i);
			if (letter == ' ') {
				isSpace = true;
				continue;
			} else {
				if (isSpace == true) {

					hashMaKhoaString += Character.toUpperCase(letter);
					isSpace = false;
				}

			}
		}
		hashMaKhoaString += new SimpleDateFormat("ddMMyyyyHHmmss").format(date);
		this.maKhoa = hashMaKhoaString;
	}

	public Khoa(String maKhoa, String tenKhoa, String ngayThanhLap) {

		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
		this.ngayThanhLap = ngayThanhLap;
	}

	public String getMaKhoa() {
		return maKhoa;
	}

	public String getTenKhoa() {
		return tenKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}

	public String getNgayThanhLap() {
		return ngayThanhLap;
	}

	public void setNgayThanhLap(String ngayThanhLap) {
		this.ngayThanhLap = ngayThanhLap;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%-20s|%-20s|%s", this.maKhoa, this.tenKhoa, this.ngayThanhLap);
	}

	public void xuatThongTin() {
		System.out.println("Mã khoa: " + this.maKhoa);
		System.out.println("Tên khoa: " + this.tenKhoa);
		System.out.println("Ngày khoa thành lập :" + this.ngayThanhLap);
	}

}
