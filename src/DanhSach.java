import java.util.Scanner;

public abstract class DanhSach {
	protected int size = 0;
	protected static Scanner sc = new Scanner(System.in);

	public abstract void them1PhanTu();

	public abstract void themNPhanTu(int n);

	public abstract void xoaPhanTu(String maSo);

	public abstract void xoaKPhanTu(int k);

	public abstract void suaPhanTu(String maSo);

	public abstract void nhapNPhanTu(int n);

	public abstract void xuatDanhSach();

	public abstract void docFile();

	public abstract void ghiFile();

}
