package DanhSach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import LopHoc.Lop;

public class DSLop extends DanhSach implements suggestDS {
	private Lop[] dsLop = new Lop[20];
	private static final String urlFile = "data/Lop.txt";
	private int size = 4;
	private static String formatHeader = String.format("%-20s|%-40s|%-20s|%s", "Mã Lớp", "Tên lớp", "Mã ngành",
			"mã cố vấn");

	public DSLop() {
		khoiTaoFile();

	}

	public int timKiemLopTheoMaLop(String MaLop) {

		for (int i = 0; i < size; ++i) {
			System.out.println(dsLop[i].getMaLop().length());
			if (dsLop[i].getMaLop().equals(MaLop)) {

				System.out.println(dsLop[i].getMaLop());
				// sắp xếp lại thứ tự mảng
				return i;
			}

		}
		return -1;
	}

	@Override
	public void them1PhanTu() {
		if (size + 1 > dsLop.length)
			dsLop = Arrays.copyOf(dsLop, (size + 1) * 2);

		dsLop[size] = new Lop();
		System.out.println("Lớp đã nhập là :");
		System.out.println(formatHeader);
		System.out.println(dsLop[size++]);
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
			if (size + 1 > dsLop.length)
				dsLop = Arrays.copyOf(dsLop, (size + 1) * 2);
			System.out.println("Nhập phần tử thứ " + Integer.toString(i + 1));
			dsLop[size++] = new Lop();
		}
		System.out.println("Thông tin đã nhập là :");
		System.out.println(formatHeader);
		while (beforeAdd < size) {
			System.out.println(dsLop[beforeAdd++]);
		}
	}

	@Override
	public void xoaPhanTu(String MaMH) {
		System.out.println(MaMH.length());
		// TODO Auto-generated method stub
		int index = timKiemLopTheoMaLop(MaMH);
		if (index >= 0) {
			for (int j = index + 1; j < dsLop.length; ++j) {
				dsLop[j - 1] = dsLop[j];
			}
			dsLop[--size] = null;
		} else
			System.out.println(MaMH + " không tồn tại!");

		ghiFile();

	}

	@Override
	public void xuatDanhSach() {
		// TODO Auto-generated method stub
		System.out.println(formatHeader);
		for (Lop n : dsLop) {
			if (n != null)
				System.out.println(n);

		}
	}

	public void xuatDSTheoMaCoVan(String maCV) {
		System.out.println(formatHeader);
		boolean isMatch = false;
		for (int i = 0; i < dsLop.length; ++i) {
			if (dsLop[i] == null) {
				continue;
			}
			if (dsLop[i].getMaCoVan().equals(maCV)) {

				isMatch = true;
				System.out.println(dsLop[i]);
			}
		}
		if (!isMatch) {
			System.out.println("Không có lớp quản lý");
		}
	}

	public void xuatDSTheoMaLop(String maLop) {
		boolean isMatch = false;
		for (int i = 0; i < size; ++i) {
			if (dsLop[i] == null) {
				continue;
			}
			if (this.dsLop[i].getMaLop().equals(maLop)) {

				isMatch = true;
				dsLop[i].thongtinLop();
				break;
			}
		}
		if (!isMatch) {
			System.out.println("Không tìm thấy lớp học phù hợp");
		}
	}

	@Override
	public void suaPhanTu(String maMH) {
		// TODO Auto-generated method stub
		int index = timKiemLopTheoMaLop(maMH);
		if (index >= 0) {
			dsLop[index] = new Lop();
		} else
			System.out.println(maMH + " không tồn tại!");

		ghiFile();

	}

	@Override
	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub
		dsLop = new Lop[n];
		size = 0;
		themNPhanTu(n);
	}

	@Override
	public String suggest() {
		// TODO Auto-generated method stub
		System.out.println("\n--------DANH SÁCH LỚP---------");
		System.out.println(formatHeader);
		for (int i = 0; i < size; ++i) {
			System.out.println(i + ". " + dsLop[i]);
		}
		System.out.println("\n--------------------------");
		System.out.println("Nhập lựa chọn:");
		while (true) {
			int choice = Integer.parseInt(sc.nextLine());
			if (choice >= 0 && choice < size) {
				return dsLop[choice].getMaLop();
			} else {
				System.out.println("Lựa chọn không hợp lệ ! Vui lòng nhập lại");
			}
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
				for (int index = 0; index < data.length; ++index) {
					data[index] = data[index].trim();
				}
				if (i + 1 > dsLop.length) {
					dsLop = Arrays.copyOf(dsLop, (i + 1) * 2);
				}

				dsLop[i++] = new Lop(data[0], data[1], data[2], data[3]);
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
			for (Lop n : dsLop) {
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

		File file = new File("data/Lop.txt");
		if (!file.exists()) {
			try {
				// khởi tạo mẫu
				file.createNewFile();
				String[] tenLop = { "Kỹ thuật phần mềm lớp 1", "Kỹ thuật phần mềm lớp 2" };
				String[] maLop = { "DKP1211", "DKP1212" };
				for (int i = 0; i < tenLop.length; i++) {
					if (dsLop[i] == null)
						dsLop[i] = new Lop(maLop[i], tenLop[i], "CNTT26112022183352", "Nguyễn Thanh Duy");
				}
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

	public Lop[] getDsLop() {
		return dsLop;
	}

	public void setDsLop(Lop[] dsLop) {
		this.dsLop = dsLop;
	}
}
