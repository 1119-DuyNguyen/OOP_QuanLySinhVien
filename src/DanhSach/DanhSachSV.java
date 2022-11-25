package DanhSach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import Mon.Mon;
import Nguoi.SinhVien;

public class DanhSachSV extends DanhSach {
	// private static SinhVien sVien[] = new SinhVien[100];

	private SinhVien dsSV[] = new SinhVien[20];
	private static final String urlFile = "data/SinhVien.txt";

	public DanhSachSV() {
//		System.out.println("%-20");

		File file = new File("data/SinhVien.txt");
		if (!file.exists()) {
			try {
				// khởi tạo mẫu
				file.createNewFile();
				Mon mon[] = new Mon[2];
				mon[0] = new Mon("Cơ sở dữ liệu", 3f);
				mon[1] = new Mon("OOP", 10f);
				dsSV[0] = new SinhVien("Duy SV1", "273 An Dương Vương – Phường 3 – Quận 5", "123456789", "Nam", "100",
						"DKP1211", mon);
				dsSV[1] = new SinhVien("Duy SV2", "273 An Dương Vương – Phường 3 – Quận 5", "123456789", "Nam", "101",
						"DKP1211", mon);
				ghiFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			// ghiFile();
			docFile();

		}

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
				// xóa khoảng trắng
				for (int index = 0; index < data.length; ++index) {
					data[index] = data[index].trim();
				}
				if (i + 1 > dsSV.length) {
					dsSV = Arrays.copyOf(dsSV, (i + 1) * 2);
				}

				// dsSV[i++] = new SinhVien(data[0], data[1]);
				line = bufferreader.readLine();
			}
			bufferreader.close();
			size = i;
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
			for (SinhVien n : dsSV) {
				if (n != null)
					writer.write(n + "\n");

			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int timKiemSVTheoMaSo(String maSV) {

		for (int i = 0; i < size; ++i) {
			System.out.println(dsSV[i].getMaSV().length());
			if (dsSV[i].getMaSV().equals(maSV)) {

				System.out.println(dsSV[i].getMaSV());
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
			length += 1;
			isRebuild = true;
		}
		if (isRebuild) {
			dsSV = Arrays.copyOf(dsSV, length);
		}
		dsSV[size++] = new SinhVien();

		ghiFile();

		// TODO Auto-generated method stub

	}

	@Override
	public void themNPhanTu(int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; ++i) {
			this.them1PhanTu();
		}
	}

	@Override
	public void xoaPhanTu(String maSV) {
		System.out.println(maSV.length());
		// TODO Auto-generated method stub
		int index = timKiemSVTheoMaSo(maSV);
		if (index >= 0) {
			for (int j = index + 1; j < dsSV.length; ++j) {
				dsSV[j - 1] = dsSV[j];
			}
			dsSV[--size] = null;
		} else
			System.out.println(maSV + " không tồn tại!");

		ghiFile();

	}

	@Override
	public void xoaNPhanTu(int n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void xuatDanhSach() {
		// TODO Auto-generated method stub
		System.out.printf("%-20s|%-20s\n", "Mã môn", "Tên môn");
		for (SinhVien n : dsSV) {
			if (n != null)
				System.out.println(n);

		}
	}

	@Override
	public void suaPhanTu(String maSV) {
		// TODO Auto-generated method stub
		int index = timKiemSVTheoMaSo(maSV);
		if (index >= 0) {
			dsSV[index] = new SinhVien();
		} else
			System.out.println(maSV + " không tồn tại!");

		ghiFile();

	}

	@Override
	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub

	}
}
