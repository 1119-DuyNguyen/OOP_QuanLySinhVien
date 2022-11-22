import java.util.Scanner;

public class Diem extends Mon {
	public Diem(String maMH, String tenMH, int soTinChi, int namHoc, int hocKi) {
		super(maMH, tenMH, soTinChi, namHoc, hocKi);
	}

	public static float ketQuaHe10;
	public float ketQuaHe4;

	public float getKetQuaHe10() {
		return ketQuaHe10;
	}

	public void setKetQuaHe10(float ketQuaHe10) {
		Diem.ketQuaHe10 = ketQuaHe10;
	}

	public float getKetQuaHe4() {
		return ketQuaHe4;
	}

	public void setKetQuaHe4(float ketQuaHe4) {
		this.ketQuaHe4 = ketQuaHe4;
	}

	Scanner sc = new Scanner(System.in);

	public boolean quaMon(float ketQuaHe10, float ketQuaHe4) {
		System.out.println("Moi nhap Diem:");
		ketQuaHe4 = sc.nextFloat();
		ketQuaHe10 = sc.nextFloat();
		if (ketQuaHe10 >= 4 || ketQuaHe4 >= 1)
			return true;

		return false;
	}
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
