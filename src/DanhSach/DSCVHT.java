package DanhSach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import Nguoi.CoVanHocTap;

public class DSCVHT extends DanhSach {

	private CoVanHocTap[] dsCVHT = new CoVanHocTap[2];

	private static final String urlFile = "data/CVHT.txt";
	{

	}

	public DSCVHT() {
//		System.out.println("%-20");

		File file = new File("data/CVHT.txt");
		if (!file.exists()) {
			String[] tenCV = { "A", "B" };
			String[] lopCV = { "DKP1211", "DKP1212" };
			String[] lopCV2 = { "DKP1213", "DKP1214" };
			try {
				// khởi tạo mẫu
				file.createNewFile();
//public CoVanHocTap(String hoTen, String diaChi, String soDt, String gioiTinh, String maCVHT, String[] maLop) {
				dsCVHT[0] = new CoVanHocTap("Duy 1", "273 An Dương Vương – Phường 3 – Quận 5", "123456789", "Nam",
						"100", lopCV);
				dsCVHT[1] = new CoVanHocTap("Duy 2", "273 An Dương Vương – Phường 3 – Quận 5", "123456789", "Nam",
						"101", lopCV2);
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
				String[] maLopString = null;
				for (int index = 0; index < data.length; ++index) {
					data[index] = data[index].trim();
					if (data[index].contains(",")) {
						maLopString = data[index].split(",");
					}

				}
				dsCVHT[i++] = new CoVanHocTap("Duy 1", "273 An Dương Vương – Phường 3 – Quận 5", "123456789", "Nam",
						"0", maLopString);
				line = bufferreader.readLine();
			}
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

	public void xuatDS() {
		for (CoVanHocTap i : dsCVHT)
			i.xuatThongTin();
	}

	public int timKiemCVTheoMaSo(String maSo) {

		for (int i = 0; i < dsCVHT.length; ++i) {

			if (dsCVHT[i].getMaGV().equals(maSo)) {
				// sắp xếp lại thứ tự mảng
				return i;
			}

		}
		return -1;
	}

	public void timKiemCVTheoHoTen(String maSo) {

		for (int i = 0; i < dsCVHT.length; ++i) {

			if (dsCVHT[i].getHoTen().equals(maSo)) {
				// sắp xếp lại thứ tự mảng
				System.out.println(dsCVHT[i]);
			}

		}
	}

	public void timKiemCVTheoMaCV(String maSo) {

		for (int i = 0; i < dsCVHT.length; ++i) {

			if (dsCVHT[i].getMaGV().equals(maSo)) {
				// sắp xếp lại thứ tự mảng
				System.out.println(dsCVHT[i]);
			}

		}
	}

	@Override
	public void them1PhanTu() {
		boolean isRebuild = false;
		int length = dsCVHT.length;
		while (size + 1 >= length) {
			length += 1;
			isRebuild = true;
		}
		if (isRebuild) {
			dsCVHT = Arrays.copyOf(dsCVHT, length);
		}
		dsCVHT[size++] = new CoVanHocTap();
		// TODO Auto-generated method stub

	}

	@Override
	public void themNPhanTu(int n) {
		// TODO Auto-generated method stub

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
	public void xoaNPhanTu(int n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void xuatDanhSach() {
		// TODO Auto-generated method stub

	}

	@Override
	public void suaPhanTu(String maSo) {
		// TODO Auto-generated method stub
		int index = timKiemCVTheoMaSo(maSo);
		if (index >= 0) {
			dsCVHT[index] = new CoVanHocTap();
		} else
			System.out.println(maSo + " không tồn tại!");
	}

	@Override
	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub

	}

	public void xemLopQuanLy() {
//		for (int i = 0; i < tenCV.length; i++) {
//			System.out.println("Ten Co Van: " + tenCV[i]);
//			System.out.println("Ma lop day: " + lopCV[i]);
//		}
	}
}