package DanhSach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import Nguoi.CoVanHocTap;

public class DSCVHT extends DanhSach {

	private CoVanHocTap[] dsCVHT = new CoVanHocTap[2];
	private static String formatHeader = String.format("%-20s|%-20s|%-5s|%-10s|%-40s", "Mã cố vấn", "Họ và Tên", "GT",
			"SĐT", "Địa chỉ");
	private static final String urlFile = "data/CVHT.txt";

	public DSCVHT() {
//		System.out.println("%-20");
		khoiTaoFile();
	}

	public void docFile() {
		FileReader fReader;
		try {
			fReader = new FileReader(urlFile);

			BufferedReader bufferreader = new BufferedReader(fReader);
			// File file = new File("resources/commands.txt");

			String line = bufferreader.readLine();
			int i = 0;
			while (line != null) {
				String data[] = line.split("\\|");
				for (int index = 0; index < data.length; ++index) {
					data[index] = data[index].trim();
				}
				if (i + 1 > dsCVHT.length) {

					dsCVHT = Arrays.copyOf(dsCVHT, (i + 1) * 2);
				}
				dsCVHT[i++] = new CoVanHocTap(data[0], data[1], data[2], data[3], data[4]);
				line = bufferreader.readLine();
			}
			size = i;
			bufferreader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ghiFile() {
		FileWriter fw;
		try {
			fw = new FileWriter(urlFile);

			BufferedWriter writer = new BufferedWriter(fw);
			for (CoVanHocTap n : dsCVHT) {
				if (n != null)
					writer.write(n + "\n");

			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int timKiemCVTheoMaSo(String maSo) {

		for (int i = 0; i < dsCVHT.length; ++i) {

			if (dsCVHT[i].getMaCVHT().equals(maSo)) {
				// sắp xếp lại thứ tự mảng
				return i;
			}

		}
		return -1;
	}

	@Override
	public void them1PhanTu() {
		if (size + 1 > dsCVHT.length)
			dsCVHT = Arrays.copyOf(dsCVHT, (size + 1) * 2);

		dsCVHT[size] = new CoVanHocTap();
		// đã fix
		System.out.println("Cố vấn đã nhập là :");
		System.out.println(formatHeader);
		System.out.println(dsCVHT[size++]);
		ghiFile();

	}

	@Override
	public void themNPhanTu(int n) {
		// TODO Auto-generated method stub
		int beforeAdd;
		if (size == 0) {
			beforeAdd = 0;
		} else
			beforeAdd = size;

		for (int i = 0; i < n; ++i) {
			if (size + 1 > dsCVHT.length)
				dsCVHT = Arrays.copyOf(dsCVHT, (size + 1) * 2);
			System.out.println("Nhập phần tử thứ " + Integer.toString(i + 1));
			dsCVHT[size++] = new CoVanHocTap();
		}
		System.out.println("Thông tin đã nhập là :");
		System.out.println(formatHeader);
		while (beforeAdd < size) {
			System.out.println(dsCVHT[beforeAdd++]);
		}
		ghiFile();
	}

	@Override
	public void xoaPhanTu(String maSo) {
		// TODO Auto-generated method stub
		int index = timKiemCVTheoMaSo(maSo);
		if (index >= 0) {
			for (int j = index + 1; j < dsCVHT.length; ++j) {
				dsCVHT[j - 1] = dsCVHT[j];
			}
			dsCVHT[--size] = null;
		} else
			System.out.println(maSo + " không tồn tại!");

	}

	@Override
	public void xuatDanhSach() {

		System.out.println(formatHeader);
		for (CoVanHocTap n : dsCVHT) {
			if (n != null)
				System.out.println(n);

		}
	}

	@Override
	public void suaPhanTu(String maSo) {
		// TODO Auto-generated method stub
		int index = timKiemCVTheoMaSo(maSo);
		if (index >= 0) {
			System.out.println("Thông tin cố vấn trước khi sửa:");
			System.out.println(formatHeader);
			dsCVHT[index].xuatThongTin();
			dsCVHT[index].suaThongTin();

			ghiFile();
		} else
			System.out.println("Không tồn tại mã số " + maSo);
	}

	@Override
	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub
		dsCVHT = new CoVanHocTap[n];
		size = 0;
		themNPhanTu(n);
	}

	@Override
	public void khoiTaoFile() {
		File file = new File("data/CVHT.txt");
		if (!file.exists()) {
			try {
				// khởi tạo mẫu
				file.createNewFile();
				dsCVHT[0] = new CoVanHocTap("0", "Nguyễn Thanh Duy", "Nam", "123456789",
						"273 An Dương Vương – Phường 3 – Quận 5");
				dsCVHT[1] = new CoVanHocTap("1", "Võ Khương Duy", "Nam", "123456789",
						"273 An Dương Vương – Phường 3 – Quận 5");
				ghiFile();
				this.size = 2;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			// ghiFile();
			docFile();

		}
	}

	public void xemLopQuanLy() {
		System.out.print("Nhập mã cố vấn cần xem lớp :");
		String maCVInputString = sc.nextLine();
		int index = timKiemCVTheoMaSo(maCVInputString);
		if (index >= 0) {
			dsCVHT[index].xemLop();
		} else
			System.out.println(maCVInputString + " không tồn tại!");
	}

	public String suggest() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("\n--------DANH SÁCH CVHT---------");
		System.out.println(formatHeader);
		for (int i = 0; i < size; ++i) {
			System.out.println(i + ". " + dsCVHT[i]);
		}
		// System.out.println(size + "." + "Quay lại");
		System.out.println("\n--------------------------");
		System.out.print("Nhập lựa chọn:");
		while (true) {
			int choice = Integer.parseInt(sc.nextLine());
			if (choice >= 0 && choice < size) {
				return dsCVHT[choice].getMaCVHT();
			} else {
				System.out.println("Lựa chọn không hợp lệ ! Vui lòng nhập lại");
			}
		}
	}

}
