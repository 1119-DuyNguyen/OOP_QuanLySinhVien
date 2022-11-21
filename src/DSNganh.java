import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSNganh implements DanhSach {

//	private String[] stringTenNganh = {"kỹ thuật phần mềm", "kế toán" };
//	private String[] stringMaNganh = { "KTPM", "KT" };
	private String[] stringTenNganh = { "kỹ thuật phần mềm", "Công nghệ thông tin" };
	private String[] stringMaNganh = { "KTPM", "CNTT" };
	private Nganh[] dsNganh = new Nganh[2];
	private static final String urlFile = "data/nganh.txt";
	private int size = 0; // phần tử thực tế của array//tao theem
	private Scanner sc = new Scanner(System.in);// tao them

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
			// xóa khoảng trắng
			for (int index = 0; index < data.length; ++index) {
				data[index] = data[index].trim();
			}
			if (i + 1 > dsNganh.length) {
				dsNganh = Arrays.copyOf(dsNganh, (i + 1) * 2);
			}

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

	public int timKiemNganhTheoMaNganh(String maNganh) {

		for (int i = 0; i < dsNganh.length; ++i) {

			if (dsNganh[i].getMaNganh().equals(maNganh)) {
				// sắp xếp lại thứ tự mảng
				return i;
			}

		}
		return -1;
	}

	@Override
	public void them1PhanTu() {
		// TODO Auto-generated method stub
		boolean isRebuild = false;
		int length = dsNganh.length;
		while (size + 1 >= length) {
			length *= 2;
			isRebuild = true;
		}
		if (isRebuild) {
			dsNganh = Arrays.copyOf(dsNganh, length + 1);
		}
		dsNganh[size++] = new Nganh();
		// TODO Auto-generated method stub
	}

	@Override
	public void themKPhanTu(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void xoaPhanTu(String maSo) {
		// TODO Auto-generated method stub
		// sắp xếp lại thứ tự mảng
		String string;
		System.out.print("Nhập mã Nganh muốn xóa:");
		string = sc.nextLine();
		int index = timKiemNganhTheoMaNganh(string);
		if (index >= 0) {
			for (int j = index + 1; j < dsNganh.length; ++j) {
				dsNganh[j - 1] = dsNganh[j];
			}
			dsNganh[--size] = null;
		} else
			System.out.println(string + " không tồn tại!");

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
		// TODO Auto-generated method stub
		String string;// 1,2
		String string2;// option1
		String string3;// option2
		String string4;// option2
		// nhập tên muốn tìm để thay(2 option)
		// phần này là phần option:
		System.out.println("\n-----------SỬA Nganh------------");
		System.out.println("1. Sửa tên Nganh");
		System.out.println("2. Nhập Nganh mới");
		System.out.println("---------------------------");
		System.out.print("Nhập lựa chọn: ");
		int choiceCV = sc.nextInt();
		switch (choiceCV) {
		case 1:
			// chỉ sửa tên Nganh, quy trình lấy string ở trên rồi tìm, nếu tìm
			// thấy thì thay cái tên đó bằng string2
			System.out.println("Hàm sửa tên Nganh");
			System.out.println("Nhập mã Nganh bạn muốn tìm để sửa:");
			string = sc.nextLine();
			System.out.println("Nhập tên Nganh mới:");
			string2 = sc.nextLine();
			int index = timKiemNganhTheoMaNganh(string);
			if (index >= 0) {
				dsNganh[index].setTenNganh(string2);
				System.out.println(
						"đã được thay đổi tên Nganh" + dsNganh[index].getTenNganh() + "bằng ten Nganh" + string2);
			} else
				System.out.println(string + " không tồn tại!");
			System.out.println("Hãy nhập tên Nganh mới");
			break;
		case 2:
			System.out.println("Hàm nhập mới Nganh");
			System.out.println("Nhập mã Nganh bạn muốn tìm để thay đổi:");
			string = sc.nextLine();
			// nhập tên và mã Nganh mới
			System.out.println("Hãy nhập tên Nganh mới");
			string3 = sc.nextLine();// tên mới
			System.out.println("Hãy nhập mã Nganh mới");
			string4 = sc.nextLine();// mã mới
			// thay đổi dữ liệu
			int index2 = timKiemNganhTheoMaNganh(string);
			if (index2 >= 0) {
				dsNganh[index2] = null;
				dsNganh[index2] = new Nganh();
				dsNganh[index2].setTenNganh(string3);
				dsNganh[index2].setMaNganh(string4);
				System.out.println("thông tin Nganh" + dsNganh[index2].getTenNganh() + "đã được thay đổi bằng Nganh"
						+ string3);
			} else
				System.out.println(string + " không tồn tại!");
			break;
		default:
			System.out.println("Vui lòng nhập chính xác lựa chọn!!");
		}
	}

	@Override
	public void nhapNPhanTu(int n) {
		// TODO Auto-generated method stub

	}
}
