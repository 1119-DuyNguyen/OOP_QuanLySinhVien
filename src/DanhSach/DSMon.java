package DanhSach;

import java.util.Arrays;
import java.util.Scanner;

import Mon.Mon;

public class DSMon extends DanhSach {
	private Mon[] dsMon = new Mon[1];
	private static String formatHeader = String.format("%-20s|%s", "Tên Môn", "Điểm");

	public DSMon() {

	}

	public DSMon(Mon[] dsMon) {
		super();
		if (dsMon != null) {
			this.dsMon = dsMon;
			size = dsMon.length;
		}

	}

	public void docFile() {

	}

	public Mon[] getDsMon() {
		return dsMon;
	}

	public void setDsMon(Mon[] dsMon) {
		this.dsMon = dsMon;
	}

	public void ghiFile() {

	}

	public void them1PhanTu() {
		if (size + 1 > dsMon.length)
			dsMon = Arrays.copyOf(dsMon, (size + 1) * 2);

		dsMon[size++] = new Mon();
		System.out.println("Môn đã nhập là :");
		System.out.println(formatHeader);
		dsMon[size - 1].xuatThongTin();

	}

	public void themNPhanTu(int n) {
		// TODO Auto-generated method stub
		int beforeAdd;
		if (size == 0) {
			beforeAdd = 0;
		} else
			beforeAdd = size;

		for (int i = 0; i < n; ++i) {
			if (size + 1 > dsMon.length)
				dsMon = Arrays.copyOf(dsMon, (size + 1) * 2);
			System.out.println("Nhập phần tử thứ " + Integer.toString(i + 1));
			dsMon[size++] = new Mon();
		}
		System.out.println("Thông tin đã nhập là :");
		System.out.println(formatHeader);
		while (beforeAdd < size) {
			dsMon[beforeAdd++].xuatThongTin();
		}

	}

	public void xoaPhanTu(int index) {
		if (index >= 0) {
			for (int j = index + 1; j < dsMon.length; ++j) {
				dsMon[j - 1] = dsMon[j];
			}
			dsMon[--size] = null;
		} else
			System.out.println(index + " không hợp lệ!");

	}

	public void xuatDanhSach() {
		// TODO Auto-generated method stub
		System.out.println(formatHeader);
		for (Mon n : dsMon) {
			if (n != null)
				n.xuatThongTin();

		}
	}

	public void suaPhanTu(int index) {
		// TODO Auto-generated method stub
		if (index >= 0) {
			System.out.println("Thông tin môn trước khi sửa:");
			System.out.println(formatHeader);
			dsMon[index].xuatThongTin();
			dsMon[index].suaThongTin();
		} else
			System.out.println(index + " không hợp lệ!");

	}

	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub
		dsMon = new Mon[n];
		size = 0;
		themNPhanTu(n);
	}

	public int suggest() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("\n--------DANH SÁCH MÔN CỦA SINH VIÊN---------");
		System.out.println(formatHeader);
		for (int i = 0; i < size; ++i) {
			System.out.println(i + ". " + dsMon[i]);
		}
		System.out.println("\n--------------------------");
		System.out.print("Nhập lựa chọn:");
		while (true) {
			int choice = Integer.parseInt(sc.nextLine());
			if (choice >= 0 && choice < size) {
				return choice;
			} else {
				System.out.println("Lựa chọn không hợp lệ ! Vui lòng nhập lại");
			}
		}

	}

	@Override
	public void xoaPhanTu(String maSo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void suaPhanTu(String maSo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void khoiTaoFile() {
		// TODO Auto-generated method stub

	}

}
