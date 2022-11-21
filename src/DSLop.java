import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DSLop implements DanhSach {
	private String[] tenLop = { "KTPM1", "KTPM2" };
	private String[] maLop = { "DKP1211", "DKP1212" };

	private Lop[] dsLop = new Lop[20];
	private static final String urlFile = "data/Lop.txt";
	private int size = 4;

	public DSLop() {
//		System.out.println("%-20");

		File file = new File("data/Mon.txt");
		if (!file.exists()) {
			try {
				// khởi tạo mẫu
				file.createNewFile();
				for (int i = 0; i < tenLop.length; i++) {
					if (dsLop[i] == null)
						dsLop[i] = new Lop(maLop[i], tenLop[i]);
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
			// xóa khoảng trắng
			for (int index = 0; index < data.length; ++index) {
				data[index] = data[index].trim();
			}
			if (i + 1 > dsLop.length) {
				dsLop = Arrays.copyOf(dsLop, (i + 1) * 2);
			}

			dsLop[i++] = new Lop(data[0], data[1]);
			line = bufferreader.readLine();
		}
		bufferreader.close();
		size = i;

	}

	public void ghiFile() throws IOException {
		FileWriter fw = new FileWriter(urlFile);

		BufferedWriter writer = new BufferedWriter(fw);
		for (Lop n : dsLop) {
			if (n != null)
				writer.write(n + "\n");

		}
		writer.close();

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
		boolean isRebuild = false;
		int length = dsLop.length;
		while (size + 1 >= length) {
			length += 1;
			isRebuild = true;
		}
		if (isRebuild) {
			dsLop = Arrays.copyOf(dsLop, length);
		}
		dsLop[size++] = new Lop();
		try {
			ghiFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void themKPhanTu(int k) {
		// TODO Auto-generated method stub

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
		try {
			ghiFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void xoaKPhanTu(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void xuatDanhSach() {
		// TODO Auto-generated method stub
		System.out.printf("%-20s|%-20s\n", "Mã môn", "Tên môn");
		for (Lop n : dsLop) {
			if (n != null)
				System.out.println(n);

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
		try {
			ghiFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub

	}
}
