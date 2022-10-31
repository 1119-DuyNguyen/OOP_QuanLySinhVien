

public class SinhVien extends Nguoi {
	private String maSV;
	private String lop;

	public SinhVien(String maSV, String hoTen, String lop, String ngaySinh, String diaChi, String soDt,
			String gioiTinh) {
		super(hoTen, ngaySinh, diaChi, soDt, gioiTinh);
		this.maSV = maSV;
		this.lop = lop;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

//	public void nhapThongTin() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("Nhập họ tên học sinh: ");
//		hoTen = scanner.nextLine();
//		System.out.print("Nhập giới tính: ");
//		gioiTinh = scanner.nextLine();
//		System.out.print("Nhập quê quán: ");
//		queQuan = scanner.nextLine();
//	}
//
//	public void hienThiThongTin() {
//		System.out.println("Họ tên: " + hoTen);
//		System.out.println("Giới tính: " + gioiTinh);
//		System.out.println("Quê quán: " + queQuan);
//	}

}