
public class Lop {
	String maLop;
	String tenLop;
	int soLuong;

	public Lop() {
		super();
	}

	public Lop(String[] maLop, String tenLop, int soLuong) {
		super();
		this.tenLop = tenLop;
		this.soLuong = soLuong;
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