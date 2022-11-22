
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DSMon extends DanhSach implements suggestDS<Mon> {
	private String[] stringTenMon = { "hệ điều hành", "cơ sở dữ liệu", "đại số tuyến tính", "giải tích số" };
	private String[] stringMaMon = { "HDH", "CSDL", "DSTT", "GTS" };
	private Mon[] dsMon = new Mon[20];
	private static final String urlFile = "data/Mon.txt";
	private int size = 4;

	public DSMon() {
//		System.out.println("%-20");

		File file = new File("data/Mon.txt");
		if (!file.exists()) {
			try {
				// khởi tạo mẫu
				file.createNewFile();
				for (int i = 0; i < stringTenMon.length; i++) {
					if (dsMon[i] == null)
						dsMon[i] = new Mon(stringMaMon[i], stringTenMon[i]);
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
				if (i + 1 > dsMon.length) {
					dsMon = Arrays.copyOf(dsMon, (i + 1) * 2);
				}

				dsMon[i++] = new Mon(data[0], data[1]);
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
			for (Mon n : dsMon) {
				if (n != null)
					writer.write(n + "\n");

			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int timKiemMHTheoMaSo(String MaMH) {

		for (int i = 0; i < size; ++i) {
			System.out.println(dsMon[i].getMaMH().length());
			if (dsMon[i].getMaMH().equals(MaMH)) {

				System.out.println(dsMon[i].getMaMH());
				// sắp xếp lại thứ tự mảng
				return i;
			}

		}
		return -1;
	}

	@Override
	public void them1PhanTu() {
		boolean isRebuild = false;
		int length = dsMon.length;
		while (size + 1 >= length) {
			length += 1;
			isRebuild = true;
		}
		if (isRebuild) {
			dsMon = Arrays.copyOf(dsMon, length);
		}
		dsMon[size++] = new Mon();

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
	public void xoaPhanTu(String MaMH) {
		System.out.println(MaMH.length());
		// TODO Auto-generated method stub
		int index = timKiemMHTheoMaSo(MaMH);
		if (index >= 0) {
			for (int j = index + 1; j < dsMon.length; ++j) {
				dsMon[j - 1] = dsMon[j];
			}
			dsMon[--size] = null;
		} else
			System.out.println(MaMH + " không tồn tại!");

		ghiFile();

	}

	@Override
	public void xoaKPhanTu(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void xuatDanhSach() {
		// TODO Auto-generated method stub
		System.out.printf("%-20s|%-20s\n", "Mã môn", "Tên môn");
		for (Mon n : dsMon) {
			if (n != null)
				System.out.println(n);

		}
	}

	@Override
	public void suaPhanTu(String maMH) {
		// TODO Auto-generated method stub
		int index = timKiemMHTheoMaSo(maMH);
		if (index >= 0) {
			dsMon[index] = new Mon();
		} else
			System.out.println(maMH + " không tồn tại!");

		ghiFile();

	}

	@Override
	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub

	}

	@Override
	public Mon suggest() {
		// TODO Auto-generated method stub
		System.out.println("Danh sách môn hợp lệ");

		for (int i = 0; i < size; ++i) {
			System.out.println(i + ". " + dsMon[i]);
		}
		System.out.println(size + "." + "Quay lại");
		System.out.println("Chọn môn để nhập");
		while (true) {
			int choice = Integer.parseInt(sc.nextLine());
			if (choice > 0 && choice < size) {
				return dsMon[choice];
			} else if (choice == size) {
				return null;
			} else {
				System.out.println("Nhập sai lựa chọn");
			}
		}

	}

}
