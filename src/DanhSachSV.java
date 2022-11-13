
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSV implements DanhSach {
	// private static SinhVien sVien[] = new SinhVien[100];
	public static Scanner scanner = new Scanner(System.in);

	private int size = 0; // phần tử thực tế của array
	private SinhVien dsSV[] = new SinhVien[20];

	public DanhSachSV() {
		//
	}

	public void add() {
//		String maSV = nhapMaSV();
//		String hoTen = nhapHoTen();
//		String lop = nhapLop();
//		String ngaySinh = nhapNgaySinh();
//		String diaChi = nhapDiaChi();
//		String soDt = nhapSoDt();
//		String gioiTinh = nhapGioiTinh();
//		SinhVien sinhVien = new SinhVien(maSV, hoTen, lop, ngaySinh, diaChi, soDt, gioiTinh);
//		try {
//			arrSinhVien.add(sinhVien);
//		} catch (NullPointerException e) {
//			System.out.println("Đang có 1 lỗi gì đấy");
//		}

	}

	public int timKiemSVTheoHoTen(String hoTen) {
		for (int i = 0; i < dsSV.length; ++i) {

			if (dsSV[i].getHoTen().equals(hoTen)) {
				return i;
			}

		}
		return -1;
	}

	public SinhVien getSV(int index) {
		return dsSV[index];
	}

	public int timKiemSVTheoMaSo(String maSo) {

		for (int i = 0; i < dsSV.length; ++i) {

			if (dsSV[i].getMaSV().equals(maSo)) {
				// sắp xếp lại thứ tự mảng
				return i;
			}

		}
		return -1;
	}

	@Override
	public void them1PhanTu() {
		boolean isRebuild = false;
		int length = dsSV.length;
		while (size + 1 >= length) {
			length *= 2;
			isRebuild = true;
		}
		if (isRebuild) {
			dsSV = Arrays.copyOf(dsSV, length * 2);
		}
		dsSV[size++] = new SinhVien();
		// TODO Auto-generated method stub
	}

	@Override
	public void themKPhanTu(int k) {
		// TODO Auto-generated method stub
//		boolean isRebuild = false;
//		int length = dsSV.length;
//		while (size + k >= length) {
//			length *= 2;
//			isRebuild = true;
//		}
//		if (isRebuild) {
//			dsSV = Arrays.copyOf(dsSV, length * 2);
//		}
	}

	@Override
	public void xoaPhanTu(String maSo) {
		// TODO Auto-generated method stub

		// sắp xếp lại thứ tự mảng
		int index = timKiemSVTheoMaSo(maSo);
		if (index >= 0) {
			for (int j = index + 1; j < dsSV.length; ++j) {
				dsSV[j - 1] = dsSV[j];
			}
			dsSV[--size] = null;
		} else
			System.out.println(maSo + " không tồn tại!");
	}

	@Override
	public void xoaKPhanTu(int k) {

		// TODO Auto-generated method stub
		// System.out.println("Bạn muốn xóa bao nhiêu phần tử ? \n ");
		// int n = new Scanner(System.in).nextInt();
//		for (int i = 0; i < k; ++i) {
//			int oriSize = size;
//			System.out.println("Nhập mã số cần xóa :\n");
//			String maSV = new Scanner(System.in).nextLine();
//			xoaPhanTu(maSV);
//			if (size != oriSize) {
//				// có bug
//				System.out.println("nhập sai vui lòng nhập lại \n");
//
//			}
//		}
	}

	@Override
	public void xuatDanhSach() {
		// TODO Auto-generated method stub

	}

	@Override
	public void suaPhanTu(String maSo) {
		// menu ra 8 thong tin rồi sửa nào thì set đó
		// TODO Auto-generated method stub
		int index = timKiemSVTheoMaSo(maSo);
		if (index >= 0) {
			dsSV[index] = new SinhVien();
		} else
			System.out.println(maSo + " không tồn tại!");
		///
	}

	@Override
	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub

	}

}
