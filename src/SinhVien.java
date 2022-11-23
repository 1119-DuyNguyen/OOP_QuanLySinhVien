public class SinhVien extends Nguoi {
	private String maSV;
	private Lop lop;
	private Nganh nganh;
	private DSLop dsLop = new DSLop();
	private DSNganh dsNganh = new DSNganh();
	private static int currentMaSV = 0;// thêm cả ở class cvht

	public SinhVien() {
		super();
		lop = new Lop();
		lop = dsLop.suggest();
		nganh = new Nganh();
		nganh = dsNganh.suggest();

		this.maSV = Integer.toString(currentMaSV++);
	}

//	public SinhVien(String maSinhVien, Lop lop) {
//		this.maSinhVien = maSinhVien;
//		this.lop = Lop;
//
//	}
//
	public SinhVien(String maSV, String hoTen, String diaChi, String soDt, String gioiTinh) {
		super(hoTen, diaChi, soDt, gioiTinh);
		this.maSV = Integer.toString(currentMaSV++);
		lop = new Lop();
		lop = dsLop.suggest();
		nganh = new Nganh();
		nganh = dsNganh.suggest();
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}

	public Nganh getNganh() {
		return nganh;
	}

	public void setNganh(Nganh nganh) {
		this.nganh = nganh;
	}

	public void DanhSachMH() {

	}

	public String timMonHoc(String maMH) {
		return maMH;

	}

	// to string sẽ xuất thông tin cơ bản
	@Override
	public String toString() {
		String formatString = String.format("%-4s| %s |%-20s |%-20s |%-20s", maSV, super.toString(), lop.getTenLop(),
				nganh.getTenNganh());
		return formatString;
	}

	public void XuatThongTinCaNhan() {
		// System.out.println(this);
		// System.out.println("Lop cua ban la:" + this.lop);

	}

	@Override
	public void xuatThongTin() {
//		System.out.println();
//		System.out.println("Cố vấn học tập");
////		super.xuatTT();
//		System.out.println("Mã giáo viên: " + maGV);
//		System.out.println("Khoa dạy: " + Khoa);
		System.out.println(this);

	}

	@Override
	public void xemLop() {
		String formatString = String.format("%-4s|%-20s |%-20s |%-20s |%-20s", maSV, this.getHoTen(), lop.getTenLop(),
				nganh.getTenNganh());
		System.out.println(formatString);
	}
}
