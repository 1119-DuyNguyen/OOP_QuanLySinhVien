
import java.util.Scanner;

public class MonHoc {
	public String maMH;
	public String tenMH;
	public int SoTinChi;
	public int namHoc;
	public int HocKi;

	public String getMaMH() {
		return maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public int getSoTinChi() {
		return SoTinChi;
	}

	public int getNamHoc() {
		return namHoc;
	}

	public int getHocKi() {
		return HocKi;
	}

	public MonHoc(String maMH, String tenMH, int soTinChi, int namHoc, int hocKi) {

		this.maMH = maMH;
		this.tenMH = tenMH;
		SoTinChi = soTinChi;
		this.namHoc = namHoc;
		HocKi = hocKi;
	}

	public void nhap() {

	}

	public void xuat() {
		// System.out.print(toString());
	}

	public class DanhSachMH {
		private int n;
		static MonHoc ds[];

		public int getN() {
			return n;
		}

		public void setN(int n) {
			this.n = n;
		}

		public static MonHoc[] getDs() {
			return ds;
		}

		public static void setDs(MonHoc[] ds) {
			DanhSachMH.ds = ds;
		}

		public void NhapDS() {
			System.out.println("Moi Nhap So Mon:");
			Scanner sc = new Scanner(System.in);
			n = Integer.parseInt(sc.nextLine());
			ds = new MonHoc[n];
			for (int i = 0; i < ds.length; i++) {
				ds[i] = new MonHoc(maMH, tenMH, SoTinChi, namHoc, HocKi);
				ds[i].nhap();
			}
		}

		public void xuatDS() {
			for (MonHoc i : ds)
				i.xuat();
		}

		public void timMonHoc(String maMH) {
			for (MonHoc i : ds) {
				if (maMH.equals(i.getMaMH())) {
					i.xuat();
				}
			}
		}

	}

	public void setTenMon(String string) {
		// TODO Auto-generated method stub

	}

	public void setMaMon(String string) {
		// TODO Auto-generated method stub

	}
}
