package LopHoc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import DanhSach.DSKhoa;

public class Nganh {
	private String maNganh;
	private String tenNganh;
	private String maKhoa;
	private String ngayThanhLap;
	private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public Nganh() {

		System.out.print("Nhập tên ngành: ");
		Scanner scanner = new Scanner(System.in);
		Date date = new Date();
		this.ngayThanhLap = dateFormat.format(date);
		while (true) {
			String regexLetter = "\\p{L}+";
			this.tenNganh = scanner.nextLine();
			if (this.tenNganh.matches(regexLetter))
				break;
			else {
				System.out.println("Nhập không hợp lệ ");
			}
		}
		// generating maNganh;
		String hashMaNganhString = "";
		boolean isSpace = true;
		for (int i = 0; i < this.tenNganh.length(); i++) {
			char letter = this.tenNganh.charAt(i);
			if (letter == ' ') {
				isSpace = true;
				continue;
			} else {
				if (isSpace == true) {

					hashMaNganhString += Character.toUpperCase(letter);
					isSpace = false;
				}

			}
		}
		hashMaNganhString += new SimpleDateFormat("ddMMyyyyHHmmss").format(date);
		this.maNganh = hashMaNganhString;
		DSKhoa dsKhoa = new DSKhoa();
		this.maKhoa = dsKhoa.suggestMa();
	}

	public Nganh(String maNganh, String tenNganh, String maKhoa, String ngayThanhLap) {
		this.maNganh = maNganh;
		this.tenNganh = tenNganh;
		this.maKhoa = maKhoa;
		this.ngayThanhLap = ngayThanhLap;
	}

	public String getMaNganh() {
		return maNganh;
	}

	public void setMaNganh(String maNganh) {
		this.maNganh = maNganh;
	}

	public String getTenNganh() {
		return tenNganh;
	}

	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%-20s|%-20s|%-20s|%s", this.maNganh, this.tenNganh, this.maKhoa, this.ngayThanhLap);
	}

	public void thongTinNganh() {
		DSKhoa dsKhoa = new DSKhoa();
		int position = dsKhoa.timKiemKhoaTheoMaKhoa(maKhoa);
		Khoa khoa = dsKhoa.getKhoa(position);
		khoa.xuatThongTin();
		xuatThongTin();
	}

	public void xuatThongTin() {
		System.out.println("Mã ngành: " + this.maNganh);
		System.out.println("Tên ngành: " + this.tenNganh);
		System.out.println("Ngày ngành thành lập :" + this.ngayThanhLap);
	}
}
