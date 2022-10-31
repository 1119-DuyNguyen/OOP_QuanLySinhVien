

public class Diem extends MonHoc {
	String maSv;
	MonHoc[] Mon;
	int soMon;

	public Diem() {
	}

	public Diem(String maMH, String maSv, String tenMH, int soTC, float Diem, String tinhTrang) {
		super(maMH, tenMH, soTC, Diem, tinhTrang);
		this.maSv = maSv;
		Mon = new MonHoc[soMon];
	}

	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}

	public String getMaSv() {
		return maSv;
	}

	@Override
	public void setMaMH(String maMH) {
		super.setMaMH(maMH);
	}

	@Override
	public String getMaMH() {
		return super.getMaMH();
	}

	@Override
	public void setTenMH(String tenMh) {
		super.setTenMH(tenMh);
	}

	@Override
	public String getTenMh() {
		return super.getTenMh();
	}

	@Override
	public int getSoTC() {
		return super.getSoTC();
	}

	@Override
	public void setSoTC(int soTC) {
		super.setSoTC(soTC);
	}

	@Override
	void nhapTT() {
		System.out.print("Nhập mã SV: ");
		this.maSv = sc2.nextLine();
		System.out.print("Nhập số môn đã ĐK: ");
		this.soMon = sc1.nextInt();
		Mon = new MonHoc[soMon];
		for (int i = 0; i < Mon.length; i++) {
			Mon[i] = new MonHoc();
			Mon[i].nhapTT();
		}
	}

	float GPA() {
		float sum1 = 0, sum2 = 0;
		for (int i = 0; i < Mon.length; i++) {
			sum1 += (Mon[i].Diem * Mon[i].soTC);
			sum2 += Mon[i].soTC;
		}
		return sum1 / sum2;
	}
	/*
	 * void inTT(){
	 * System.out.println("-----------------------------------------------");
	 * System.out.println("Mã SV: "+getMaSv());
	 * System.out.println("Mã MH: "+getMaMH());
	 * System.out.println("Tên MH: "+getTenMh());
	 * System.out.println("Số TC "+getSoTC());
	 * System.out.println("Điểm: "+getDiem());
	 * System.out.println("Tình Trạng: "+getTinhTrang());
	 * System.out.println("-----------------------------------------------"); }
	 */
}
