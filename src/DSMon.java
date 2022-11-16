import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DSMon implements DanhSach {
	private String[] stringTenMon = { "hệ điều hành", "cơ sở dữ liệu", "đại số tuyến tính", "giải tích số" };
	private String[] stringMaMon = { "HDH", "CSDL", "DSTT", "GTS" };
	private MonHoc[] dsMonHoc = new MonHoc[4];
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
					if (dsMonHoc[i] == null)
						dsMonHoc[i] = new MonHoc(stringMaMon[i], stringTenMon[i]);
				}
				ghiFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				// ghiFile();
				docFile();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void docFile() throws IOException {
		FileReader fReader = new FileReader(urlFile);
		BufferedReader bufferreader = new BufferedReader(fReader);
		// File file = new File("resources/commands.txt");

		String line = bufferreader.readLine();
		int i = 0;
		while (line != null) {
			String data[] = line.split("\\|");
//			for (String d : data) {
//				System.out.println(d);
//			}
			dsMonHoc[i++] = new MonHoc(data[0], data[1]);
			line = bufferreader.readLine();
		}
		bufferreader.close();
	}

	public void ghiFile() throws IOException {
		FileWriter fw = new FileWriter(urlFile);

		BufferedWriter writer = new BufferedWriter(fw);
		for (MonHoc n : dsMonHoc) {
			if (n != null)
				writer.write(n + "\n");

		}
		writer.close();

	}

	public int timKiemMHTheoMaSo(String maMH) {

		for (int i = 0; i < size; ++i) {

			if (dsMonHoc[i].getMaMH().equals(maMH)) {
				System.out.println(dsMonHoc[i].maMH);
				// sắp xếp lại thứ tự mảng
				return i;
			}

		}
		return -1;
	}

	@Override
	public void them1PhanTu() {
		boolean isRebuild = false;
		int length = dsMonHoc.length;
		while (size + 1 >= length) {
			length += 1;
			isRebuild = true;
		}
		if (isRebuild) {
			dsMonHoc = Arrays.copyOf(dsMonHoc, length);
		}
		dsMonHoc[size++] = new MonHoc();
		// TODO Auto-generated method stub

	}

	@Override
	public void themKPhanTu(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void xoaPhanTu(String maMH) {
		// TODO Auto-generated method stub
		int index = timKiemMHTheoMaSo(maMH);
		if (index >= 0) {
			for (int j = index + 1; j < dsMonHoc.length; ++j) {
				dsMonHoc[j - 1] = dsMonHoc[j];
			}
			dsMonHoc[--size] = null;
		} else
			System.out.println(maMH + " không tồn tại!");
		System.out.println(index);
	}

	@Override
	public void xoaKPhanTu(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void xuatDanhSach() {
		// TODO Auto-generated method stub
		System.out.printf("%-20s|%-20s\n", "Mã môn", "Tên môn");
		for (MonHoc n : dsMonHoc) {
			System.out.println(n);

		}
	}

	@Override
	public void suaPhanTu(String maMH) {
		// TODO Auto-generated method stub
		int index = timKiemMHTheoMaSo(maMH);
		if (index >= 0) {
			dsMonHoc[index] = new MonHoc();
		} else
			System.out.println(maMH + " không tồn tại!");
	}

	@Override
	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub

	}

}
