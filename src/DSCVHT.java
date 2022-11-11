import java.util.Scanner;

public class DSCVHT implements DanhSach {
	static CoVanHocTap dsCVHT[];
	Scanner scanner = new Scanner(System.in);

	CoVanHocTap timkiemCoVanHocTap(String maCV) {
		return null;
	}

	public static CoVanHocTap[] getDsCVHT() {
		return dsCVHT;
	}

	public static void setDsCVHT(CoVanHocTap[] dsCVHT) {
		DSCVHT.dsCVHT = dsCVHT;
	}

	public void nhapDS() {
		System.out.println("Moi nhap so phan tu mang:");
		int n = Integer.parseInt(scanner.nextLine());
		dsCVHT = new CoVanHocTap[n];
		for (int i = 0; i < dsCVHT.length; i++) {
			dsCVHT[i] = new CoVanHocTap();
			dsCVHT[i].nhapThongTin();
		}
	}

	public void xuatDS() {
		for (CoVanHocTap i : dsCVHT)
			i.xuatThongTin();
	}

	public static void main(String[] args) {
		DSCVHT ob = new DSCVHT();
		ob.nhapDS();
		ob.xuatDS();
	}

	@Override
	public void them1PhanTu() {
		// TODO Auto-generated method stub

	}

	@Override
	public void themKPhanTu(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void xoaPhanTu(String maSo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void xoaKPhanTu(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void xuatDanhSach() {
		// TODO Auto-generated method stub

	}

	@Override
	public void suaPhanTu(String maSo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub

	}

}
