import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DSKhoa implements DanhSach {
//	private String[] stringTenKhoa = { "Công nghệ thông tin",
//			"Toán" };
//	private String[] stringMaKhoa = { "CNTT", "Toan"};
	private String[] stringTenKhoa = { "Công nghệ thông tin" };
	private String[] stringMaKhoa = { "CNTT" };
	Khoa[] dsKhoa = new Khoa[1];

	private static final String urlFile = "data/khoa.txt";

	public DSKhoa() {
		File file = new File("data/Khoa.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				for (int i = 0; i < dsKhoa.length; i++) {
					if (dsKhoa[i] == null) {
						dsKhoa[i] = new Khoa(stringMaKhoa[i], stringTenKhoa[i]);

					}
				}
				ghiFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			// ghiFile();
			docFile();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			dsKhoa[i++] = new Khoa(data[0], data[1]);
			line = bufferreader.readLine();
		}
		bufferreader.close();
	}

	public void ghiFile() throws IOException {
		FileWriter fw = new FileWriter(urlFile);

		BufferedWriter writer = new BufferedWriter(fw);
		for (Khoa n : dsKhoa) {
			writer.write(n + "\n");

		}
		writer.close();

	}

	@Override
	public void them1PhanTu() {
		// TODO Auto-generated method stub

	}

	@Override
	public void themKPhanTu(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void xoaPhanTu(String maSo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void xoaKPhanTu(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void xuatDanhSach() {
		// TODO Auto-generated method stub
		System.out.printf("%-20s|%-20s\n", "Mã Khoa", "Tên Khoa");
		for (Khoa k : dsKhoa) {
			if (k != null)
				System.out.println(k);

		}
	}

	@Override
	public void suaPhanTu(String maSo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub

	}
}
