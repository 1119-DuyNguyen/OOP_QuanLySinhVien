
package DanhSach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import LopHoc.Nganh;

public class DSNganh extends DanhSach implements suggestDS {

	private Nganh[] dsNganh = new Nganh[3];
	private static final String urlFile = "data/nganh.txt";
	private static String formatHeader = String.format("%-20s|%-20s|%-20s|%s", "Mã ngành", "Tên ngành", "Mã khoa",
			"Ngày thành lập");

	public DSNganh() {
		khoiTaoFile();
	}

	public int timKiemNganhTheoMaNganh(String maNganh) {

		for (int i = 0; i < dsNganh.length; ++i) {

			if (dsNganh[i].getMaNganh().equals(maNganh)) {

				return i;
			}

		}
		return -1;
	}

	@Override
	public void them1PhanTu() {

		if (size + 1 > dsNganh.length)
			dsNganh = Arrays.copyOf(dsNganh, (size + 1) * 2);

		dsNganh[size] = new Nganh();
		System.out.println("Ngành đã nhập là :");
		System.out.println(formatHeader);
		System.out.println(dsNganh[size++]);
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
			if (size + 1 > dsNganh.length)
				dsNganh = Arrays.copyOf(dsNganh, (size + 1) * 2);
			System.out.println("Nhập phần tử thứ " + Integer.toString(i + 1));
			dsNganh[size++] = new Nganh();
		}
		System.out.println("Thông tin đã nhập là :");
		System.out.println(formatHeader);
		while (beforeAdd < size) {
			System.out.println(dsNganh[beforeAdd++]);
		}
		ghiFile();
	}

	@Override
	public void xoaPhanTu(String maSo) {
		// TODO Auto-generated method stub
		// sắp xếp lại thứ tự mảng

		int index = timKiemNganhTheoMaNganh(maSo);
		if (index >= 0) {
			for (int j = index + 1; j < dsNganh.length; ++j) {
				dsNganh[j - 1] = dsNganh[j];
			}
			dsNganh[--size] = null;
		} else
			System.out.println(maSo + " không tồn tại!");

	}

	@Override
	public void xuatDanhSach() {
		// TODO Auto-generated method stub
		System.out.println(formatHeader);
		for (Nganh n : dsNganh) {
			if (n != null)
				System.out.println(n);

		}

	}

	@Override
	public void suaPhanTu(String maSo) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		int index = timKiemNganhTheoMaNganh(maSo);
		if (index >= 0 && index < size) {
			dsNganh[index] = new Nganh();
		} else
			System.out.println(maSo + " không tồn tại!");
	}

	@Override
	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub
		dsNganh = new Nganh[n];
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
				for (int index = 0; index < data.length; ++index) {
					data[index] = data[index].trim();
				}
				if (i + 1 > dsNganh.length) {
					dsNganh = Arrays.copyOf(dsNganh, (i + 1) * 2);
				}

				dsNganh[i++] = new Nganh(data[0], data[1], data[2], data[3]);
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
			for (Nganh n : dsNganh) {
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
	public String suggest() {
		// TODO Auto-generated method stub
		System.out.println("\n--------DANH SÁCH NGÀNH---------");
		System.out.println(formatHeader);
		for (int i = 0; i < size; ++i) {
			System.out.println(i + ". " + dsNganh[i]);
		}
		System.out.println("\n--------------------------");
		System.out.print("Nhập lựa chọn: ");
		while (true) {
			int choice = Integer.parseInt(sc.nextLine());
			if (choice >= 0 && choice < size) {
				return dsNganh[choice].getMaNganh();
			} else {
				System.out.println("Lựa chọn không hợp lệ ! Vui lòng nhập lại");
			}
		}
	}

	@Override
	public void khoiTaoFile() {
		String[] stringTenNganh = { "kỹ thuật phần mềm", "Công nghệ thông tin", "Quản trị kinh doanh" };
		String[] stringMaNganh = { "KTPM", "CNTT", "QTKD" };

		File file = new File("data/nganh.txt");
		if (!file.exists()) {
			try {
				// khởi tạo mẫu
				file.createNewFile();
				// NienKhoa nienKhoa = new NienKhoa(2021, 2022, "Chính quy");
				for (int i = 0; i < stringTenNganh.length; i++) {
					if (dsNganh[i] == null)
						dsNganh[i] = new Nganh(stringMaNganh[i] + "26112022183352", stringTenNganh[i],
								"CNTT26112022183352", "26/11/2022 18:33:52");
				}
				ghiFile();
				this.size = stringTenNganh.length;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			docFile();

	}

	public Nganh getNganh(int index) {
		return dsNganh[index];
	}
}
