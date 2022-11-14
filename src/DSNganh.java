import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DSNganh implements DanhSach {

//	private String[] stringTenNganh = {"kỹ thuật phần mềm", "kế toán" };
//	private String[] stringMaNganh = { "KTPM", "KT" };
	private String[] stringTenNganh = { "kỹ thuật phần mềm", "Công nghệ thông tin" };
	private String[] stringMaNganh = { "KTPM", "CNTT" };
	private Nganh[] dsNganh = new Nganh[2];
	private static final String urlFile = "data/nganh.txt";

	public DSNganh() {
//		System.out.println("%-20");

		File file = new File("data/nganh.txt");
		if (!file.exists()) {
			try {
				// khởi tạo mẫu
				file.createNewFile();
				for (int i = 0; i < stringTenNganh.length; i++) {
					if (dsNganh[i] == null)
						dsNganh[i] = new Nganh(stringMaNganh[i], stringTenNganh[i]);
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
			dsNganh[i++] = new Nganh(data[0], data[1]);
			line = bufferreader.readLine();
		}
		bufferreader.close();
	}

	public void ghiFile() throws IOException {
		FileWriter fw = new FileWriter(urlFile);

		BufferedWriter writer = new BufferedWriter(fw);
		for (Nganh n : dsNganh) {
			if (n != null)
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
		System.out.printf("%-20s|%-20s\n", "Mã ngành", "Tên Ngành");
		for (Nganh n : dsNganh) {
			System.out.println(n);

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
