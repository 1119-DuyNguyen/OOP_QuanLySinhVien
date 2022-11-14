public class MonHoc {
	public String maMH;
	public String tenMH;

	public MonHoc(String maMH, String tenMH) {
		this.maMH = maMH;
		this.tenMH = tenMH;
	}

	public String getMaMH() {
		return maMH;
	}

	public String getTenMH() {
		return tenMH;
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
