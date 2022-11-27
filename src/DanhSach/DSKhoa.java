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

import LopHoc.Khoa;

public class DSKhoa extends DanhSach implements suggestMaDS {

	static Khoa[] dsKhoa = new Khoa[1];
	private static String formatHeader = String.format("%-20s|%-20s|%s", "Mã khoa", "Tên khoa", "Ngày thành lập");

	private static final String urlFile = "data/khoa.txt";

	public DSKhoa() {
		khoiTaoFile();
	}

	public Khoa getKhoa(int index) {
		return dsKhoa[index];
	}

	public int timKiemKhoaTheoMaKhoa(String maKhoa) {

		for (int i = 0; i < dsKhoa.length; ++i) {

			if (dsKhoa[i].getMaKhoa().equals(maKhoa)) {

				return i;
			}

		}
		return -1;
	}

	@Override
	public void them1PhanTu() {

		if (size + 1 > dsKhoa.length)
			dsKhoa = Arrays.copyOf(dsKhoa, (size + 1) * 2);

		dsKhoa[size] = new Khoa();
		System.out.println("Khoa đã nhập là :");
		System.out.println(formatHeader);
		System.out.println(dsKhoa[size++]);
		ghiFile();

		// TODO Auto-generated method stub

	}

	@Override
	public void themNPhanTu(int n) {
		int beforeAdd;
		if (size == 0) {
			beforeAdd = 0;
		} else
			beforeAdd = size;

		for (int i = 0; i < n; ++i) {
			if (size + 1 > dsKhoa.length)
				dsKhoa = Arrays.copyOf(dsKhoa, (size + 1) * 2);
			System.out.println("Nhập phần tử thứ " + Integer.toString(i + 1));
			dsKhoa[size++] = new Khoa();
		}
		System.out.println("Thông tin đã nhập là :");
		System.out.println(formatHeader);
		while (beforeAdd < size) {
			System.out.println(dsKhoa[beforeAdd++]);
		}
		ghiFile();
	}

	@Override
	public void xoaPhanTu(String maKhoa) {
		// TODO Auto-generated method stub
		int index = timKiemKhoaTheoMaKhoa(maKhoa);
		if (index >= 0 && index < size) {
			for (int j = index + 1; j < dsKhoa.length; ++j) {
				dsKhoa[j - 1] = dsKhoa[j];
			}
			dsKhoa[--size] = null;
		} else
			System.out.println(maKhoa + " không tồn tại!");

		ghiFile();

	}

	@Override
	public void xuatDanhSach() {
		// TODO Auto-generated method stub
		System.out.println(formatHeader);
		for (Khoa khoa : dsKhoa) {
			if (khoa != null)
				System.out.println(khoa);

		}
	}

	@Override
	public void suaPhanTu(String maKhoa) {
		// TODO Auto-generated method stub
		// int index = timKiemSVTheoMaSo(maSV, false);
		int index = timKiemKhoaTheoMaKhoa(maKhoa);
		if (index >= 0 && index < size) {
			dsKhoa[index] = new Khoa();
		} else
			System.out.println(maKhoa + " không tồn tại!");
	}

	@Override
	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub
		dsKhoa = new Khoa[n];
		size = 0;
		themNPhanTu(n);
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

//			for (String d : data) {
//				System.out.println(d);
//			}
				for (int index = 0; index < data.length; ++index) {
					data[index] = data[index].trim();
				}
				if (i + 1 > dsKhoa.length) {
					dsKhoa = Arrays.copyOf(dsKhoa, (i + 1) * 2);
				}

				dsKhoa[i++] = new Khoa(data[0], data[1], data[2]);

				line = bufferreader.readLine();
			}
			this.size = i;
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
			for (Khoa n : dsKhoa) {
				if (n != null)
					writer.write(n + "\n");

			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void khoiTaoFile() {
		// TODO Auto-generated method stub
		File file = new File("data/Khoa.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				String[] stringTenKhoa = { "Công Nghệ thông tin" };
				String[] stringMaKhoa = { "CNTT" };
				for (int i = 0; i < dsKhoa.length; i++) {
					if (dsKhoa[i] == null) {
						dsKhoa[i] = new Khoa(stringMaKhoa[i] + "26112022183352", stringTenKhoa[i],
								"26/11/2022 18:33:52");

					}
				}
				ghiFile();
				this.size = stringTenKhoa.length;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// ghiFile();
		else
			docFile();
	}

	public String suggestMa() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("\n--------DANH SÁCH KHOA---------");
		System.out.println(formatHeader);
		for (int i = 0; i < size; ++i) {
			System.out.println(i + ". " + dsKhoa[i]);
		}
		// System.out.println(size + "." + "Quay lại");
		System.out.println("\n--------------------------");
		System.out.print("Nhập lựa chọn:");
		while (true) {
			int choice = Integer.parseInt(sc.nextLine());
			if (choice >= 0 && choice < size) {
				return dsKhoa[choice].getMaKhoa();
			} else {
				System.out.println("Lựa chọn không hợp lệ ! Vui lòng nhập lại");
			}
		}
	}
}
