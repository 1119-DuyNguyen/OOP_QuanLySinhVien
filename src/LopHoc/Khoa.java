package LopHoc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Khoa {
	private String maKhoa;

	private String tenKhoa;
	private String ngayThanhLap;
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public Khoa() {

		Date date = new Date();
		this.ngayThanhLap = dateFormat.format(date);
	}

	public Khoa(String maKhoa, String tenKhoa, String ngayThanhLap) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
		this.ngayThanhLap = ngayThanhLap;
	}

	public String getMaKhoa() {
		return maKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
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
}
