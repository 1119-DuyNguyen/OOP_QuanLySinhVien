package LopHoc;

public class Nganh extends Khoa {
	private String maNganh;
	private String tenNganh;

	public String getMaNganh() {
		return maNganh;
	}

	public void setMaNganh(String maNganh) {
		this.maNganh = maNganh;
	}

	public NienKhoa getNienKhoa() {
		return nienKhoa;
	}

	public void setNienKhoa(NienKhoa nienKhoa) {
		this.nienKhoa = nienKhoa;
	}

	private NienKhoa nienKhoa;

	public Nganh(String maNganh, String tenNganh, NienKhoa nienKhoa) {
		super();
		this.maNganh = maNganh;
		this.tenNganh = tenNganh;
		this.nienKhoa = nienKhoa;
	}

	public Nganh() {
		super();
	}

	public Nganh(String maNganh, String tenNganh) {
		super();
		this.maNganh = maNganh;
		this.tenNganh = tenNganh;
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
		return String.format("%-20s|%-20s|%s", this.maNganh, this.tenNganh, this.nienKhoa);
	}
}
